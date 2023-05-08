<%@ include file="common/header.jsp" %>
<%@ include file="common/navigation.jsp" %>
		<div class="container">
			<h1>Login</h1>
			<pre>${errorMsg }</pre>
			<form method="post">
				Name : <input type="text" name="name">
				Password : <input type="password" name="password">
				<input type="submit">
			</form>
		</div>
<%@ include file="common/footer.jsp" %>