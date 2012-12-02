package com.laplaz.reginfo;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.laplaz.kern.ablauf.EreignisSpeichern;
import com.laplaz.kern.ablauf.ZeitpunktEingrenzen;
import com.laplaz.kern.modell.Ereignis;
import com.laplaz.kern.modell.Treffpunkt;
import com.laplaz.kern.modell.Zeitraum;

@Controller
@RequestMapping("/")
@SessionAttributes("formBean")
public class FormController {
	
	private static final Logger logger = LoggerFactory.getLogger(FormController.class);
	
	@Autowired
	private ZeitpunktEingrenzen zeitpunktEingrenzen;
	
	@Autowired
	private EreignisSpeichern ereignisSpeichern;

	// Invoked on every request

	@ModelAttribute
	public void ajaxAttribute(WebRequest request, Model model) {
		model.addAttribute("ajaxRequest", AjaxUtils.isAjaxRequest(request));
	}

	// Invoked initially to create the "form" attribute
	// Once created the "form" attribute comes from the HTTP session (see @SessionAttributes)

	@ModelAttribute("formBean")
	public FormBean createFormBean() {
		return new FormBean();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String form() {
		return "form";
	}

	@RequestMapping(method=RequestMethod.POST)
	public String processSubmit(@Valid FormBean formBean, BindingResult result, 
								@ModelAttribute("ajaxRequest") boolean ajaxRequest, 
								Model model, RedirectAttributes redirectAttrs) {
		if (result.hasErrors()) {
			return "form";
		}
		
		logger.info("Ereignis angelegt: " + formBean);
		
		try {
			String bezeichnung = formBean.getBezeichnung();
			String zeitpunkt = formBean.getZeitpunkt();
			String treffpunktEingabe = formBean.getTreffpunkt();
			Zeitraum zeitraum = zeitpunktEingrenzen.pruefen(zeitpunkt);
			Treffpunkt treffpunkt = new Treffpunkt(treffpunktEingabe);
			Ereignis ereignis = new Ereignis(bezeichnung, zeitraum, treffpunkt);
			zeitraum.getEreignisse().add(ereignis);
			treffpunkt.getEreignisse().add(ereignis);
			ereignisSpeichern.speichern(ereignis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Typically you would save to a db and clear the "form" attribute from the session 
		// via SessionStatus.setCompleted(). For the demo we leave it in the session.
		String message = "Form submitted successfully.  Bound " + formBean;
		// Success response handling
		if (ajaxRequest) {
			// prepare model for rendering success message in this request
			model.addAttribute("message", message);
			return null;
		} else {
			// store a success message for rendering on the next request after redirect
			// redirect back to the form to render the success message along with newly bound values
			redirectAttrs.addFlashAttribute("message", message);
			return "redirect:/";			
		}
	}
	
}
