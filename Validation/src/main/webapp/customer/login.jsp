<%@ include file="../includes/header.jsp"%>
<%@ include file="../includes/cust_navbar.jsp"%>
<div class="container">
	<!-- you should only use this style '${pageContext.request.contextPath}' if your project have sub directories -->
	<form action="${pageContext.request.contextPath}/LoginController"
		method="post">
		<div class="mb-3">
			<label for="username" class="form-label">Username</label> <input
				type="text" name="username" value="${username}"
				class="form-control ${empty username_err ? '' : 'is-invalid'}"
				id="username">
			<div class="invalid-feedback">
				<c:out value="${username_err}" />
			</div>
		</div>
		<div class="mb-3">
			<label for="password" class="form-label">Password</label> <input
				type="password" name="password" value="${password}"
				class="form-control ${empty password_err ? '' : 'is-invalid'}"
				id="password">
			<div class="invalid-feedback">
				<c:out value="${password_err}" />
			</div>
		</div>
		<div class="mb-3 form-check">
			<input type="checkbox" class="form-check-input" id="exampleCheck1">
			<label class="form-check-label" for="exampleCheck1">Check me
				out</label>
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
</div>
<%@ include file="../includes/footer.jsp"%>