package com.laplaz.reginfo;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.laplaz.kern.ablauf.EreignisSpeichern;
import com.laplaz.kern.ablauf.EreignisseSuchen;
import com.laplaz.kern.ablauf.TreffpunktZuordnen;
import com.laplaz.kern.ablauf.ZeitpunktEingrenzen;
import com.laplaz.kern.modell.Ereignis;
import com.laplaz.kern.modell.Treffpunkt;
import com.laplaz.kern.modell.Zeitpunkt;

@Controller
@RequestMapping("/")
@SessionAttributes("formBean")
public class FormController {

	private static final Logger logger = LoggerFactory
			.getLogger(FormController.class);

	@Autowired
	private ZeitpunktEingrenzen zeitpunktEingrenzen;

	@Autowired
	private EreignisSpeichern ereignisSpeichern;

	@Autowired
	private EreignisseSuchen ereignisseSuchen;

	@Autowired
	private TreffpunktZuordnen treffpunktZuordnen;

	// Invoked on every request

	@ModelAttribute
	public void ajaxAttribute(WebRequest request, Model model) {
		model.addAttribute("ajaxRequest", AjaxUtils.isAjaxRequest(request));
	}

	// Invoked initially to create the "form" attribute
	// Once created the "form" attribute comes from the HTTP session (see
	// @SessionAttributes)

	@ModelAttribute("formBean")
	public FormBean createFormBean() {
		return new FormBean();
	}

	@RequestMapping(method = RequestMethod.GET)
	@Transactional
	public ModelAndView form() {
		String viewName = "form";
		ModelAndView mav = new ModelAndView();
		
		List<Ereignis> ereignisse = ereignisseSuchen.beginnen();
		mav.addObject("ereignisse", ereignisse);
		
		mav.setViewName(viewName);
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST)
	@Transactional
	public String processSubmit(@Valid FormBean formBean, BindingResult result,
			@ModelAttribute("ajaxRequest") boolean ajaxRequest, Model model,
			RedirectAttributes redirectAttrs) throws Exception {
		if (result.hasErrors()) {
			return "form";
		}

		logger.info("Ereignis angelegt: " + formBean);

		String bezeichnung = formBean.getBezeichnung();
		String zeitpunktEingabe = formBean.getZeitpunkt();
		String treffpunktEingabe = formBean.getTreffpunkt();

		Zeitpunkt zeitpunkt = zeitpunktEingrenzen.pruefen(zeitpunktEingabe);
		Treffpunkt treffpunkt = treffpunktZuordnen.lesen(treffpunktEingabe);
		
		Ereignis ereignis = new Ereignis(bezeichnung, zeitpunkt, treffpunkt);
		ereignisSpeichern.speichern(ereignis);

		// Typically you would save to a db and clear the "form" attribute from
		// the session
		// via SessionStatus.setCompleted(). For the demo we leave it in the
		// session.
		String message = "Form submitted successfully.  Bound " + formBean;
		// Success response handling
		if (ajaxRequest) {
			// prepare model for rendering success message in this request
			model.addAttribute("message", message);
			return null;
		} else {
			// store a success message for rendering on the next request after
			// redirect
			// redirect back to the form to render the success message along
			// with newly bound values
			redirectAttrs.addFlashAttribute("message", message);
			return "redirect:/";
		}
	}

}
