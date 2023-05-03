<%@ include file="common/header.jsp" %>
<%@ include file="common/navigation.jsp" %>
		<div class="container">
			<h1>Enter Todo Details</h1>
			<form:form method="post" modelAttribute="todo">
				<fieldset class="mb-3">
					<form:label path="description">Description</form:label>
					<form:input type="text" path="description" required="required"></form:input>
					<form:errors type="text" path="description" cssClass="text-warning"></form:errors>				
				</fieldset>
				
				<fieldset class="mb-3">
					<form:label path="targetDate">targetDate</form:label>
					<form:input type="text" path="targetDate" required="required"></form:input>
					<form:errors type="text" path="targetDate" cssClass="text-warning"></form:errors>				
				</fieldset>
				<form:input type="hidden" path="id" ></form:input>
				<form:input type="hidden" path="done" ></form:input>
				<form:input type="hidden" path="username" ></form:input>
				<input type="submit" class="btn btn-success">
			</form:form>
		</div>
<%@ include file="common/footer.jsp" %>
<script type="text/javascript">
	$('#targetDate').datepicker({
	    format: 'yyyy-mm-dd',
	});
</script>



