<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<c:if test="${!ajaxRequest}">
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Ereignis erfassen</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/formate.css" />">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/smartphone.css" />">	
	<script type="text/javascript" src="<c:url value="/resources/jquery/1.6/jquery.js" />"></script>
</head>
<body>
</c:if>
	<div id="formsContent">
		<form:form id="form" method="post" modelAttribute="formBean" cssClass="cleanform">
			<div class="header">
		  		<h2>Form</h2>
		  		<c:if test="${not empty message}">
					<div id="message" class="success">${message}</div>	
		  		</c:if>
		  		<s:bind path="*">
		  			<c:if test="${status.error}">
				  		<div id="message" class="error">Form has errors</div>
		  			</c:if>
		  		</s:bind>
			</div>
		  	<fieldset>
		  		<legend>Ereignis</legend>
		  		<form:label path="bezeichnung">
		  			Bezeichnung <form:errors path="bezeichnung" cssClass="error" />
		 		</form:label>
		  		<form:input path="bezeichnung" />

		  		<form:label path="zeitpunkt">
		  			Zeitpunkt <form:errors path="zeitpunkt" cssClass="error" />
		 		</form:label>
		  		<form:input path="zeitpunkt" />

		  		<form:label path="treffpunkt">
		  			Treffpunkt <form:errors path="treffpunkt" cssClass="error" />
		 		</form:label>
		  		<form:input path="treffpunkt" />

		  	</fieldset>
	
			<p><button type="submit">Submit</button></p>
		</form:form>
		<script type="text/javascript">
			$(document).ready(function() {
				$("#form").submit(function() {  
					$.post($(this).attr("action"), $(this).serialize(), function(html) {
						$("#formsContent").replaceWith(html);
						$('html, body').animate({ scrollTop: $("#message").offset().top }, 500);
					});
					return false;  
				});			
			});
		</script>
	</div>
	<div id="ereignisse">

	<c:forEach var="ereignis" items="${ereignisse}">
	<div id="ereignis">
       ${ereignis.bezeichnung}<br>
       ${ereignis.zeitpunkt.bezeichnung}<br>
       ${ereignis.treffpunkt.bezeichnung}
       </div>
       <p/>
    </c:forEach>

	</div>
<c:if test="${!ajaxRequest}">
</body>
</html>
</c:if>