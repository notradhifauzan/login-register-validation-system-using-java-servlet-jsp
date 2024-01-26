<%@ include file="../includes/header.jsp"%>
<%@ include file="../includes/cust_navbar.jsp"%>
<div class="container">
	<!-- you should only use this style '${pageContext.request.contextPath}' if your project have sub directories -->
	<form action="${pageContext.request.contextPath}/RegisterController"
		method="post" class="mt-3 mb-3">
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
			<label for="email" class="form-label">Email</label> <input
				type="email" name="email" value="${email}"
				class="form-control ${empty email_err ? '' : 'is-invalid'}"
				id="email">
			<div class="invalid-feedback">
				<c:out value="${email_err}" />
			</div>
		</div>
		
		<div class="mb-3">
			<label for="phone" class="form-label">Phone</label> <input
				type="text" name="phone" value="${phone}"
				class="form-control ${empty phone_err ? '' : 'is-invalid'}"
				id="phone">
			<div class="invalid-feedback">
				<c:out value="${phone_err}" />
			</div>
		</div>
		
		<div class="mb-3">
			<label for="address" class="form-label">Address</label>
			<textarea name="address" id="address" rows="3" cols="3" class="form-control ${empty address_err ? '' : 'is-invalid' }"><c:out value="${address}" /></textarea> 
			<div class="invalid-feedback">
				<c:out value="${address_err}" />
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
		
		<div class="mb-3">
			<label for="confirm_password" class="form-label">Confirm Password</label> <input
				type="password" name="confirm_password" value="${confirm_password}"
				class="form-control ${empty confirm_password_err ? '' : 'is-invalid'}"
				id="confirm_password">
			<div class="invalid-feedback">
				<c:out value="${confirm_password_err}" />
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