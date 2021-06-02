<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ include file="..\includes\header.jsp"%>

<form id="registerForm" action="/Itea_shop_test_Spring/register" method="post">
<div id = "table">
<table>
		<tr>
			<td width = "280px">
				<table>
					<tr>
						<td align='center'>${utilites.getErrorText()}</td>
					</tr>
				</table>
			</td>

			<td width = "180px">
				<div class="field">
						<label> Login </label>
						<div class="input">
							<input type='text' name='Login' placeholder="name@adress"
								<c:choose>
										<c:when test = "${login != null && login.length() != 0 && utilites.isLoginCorrect(login) == true 
													  && userDAO.isUnique(login) == true}"> 
											value = '${login}' 
										</c:when> 
										</c:choose>
								title="Enter your login" value=''>
						</div>
					</div>
					<div class="field">
						<label> Password </label>
						<div class="input">
							<input type='password' name='Password' required="required"
								placeholder="a-z,A-Z,0-9 min 8 symbols"
								<c:choose>
										<c:when test = "${password != null && password.length() != 0 && utilites.isPasswordCorrect(password) == true}"> 
											value = '${password}' 
										</c:when> 
										</c:choose>>
						</div>
					</div>
					<div class="field">
						<label> Re_Password </label>
						<div class="input">
							<input type='password' name='Re_Password' required="required"
								placeholder="Retype your password"
								<c:choose>
										<c:when test = "${re_password != null && re_password.length() != 0 && utilites.isRe_PasswordCorrect(password, re_password) == true}"> 
											value = '${re_password}' 
										</c:when> 
										</c:choose>>
						</div>
					</div>
					<div class="field">
						<label> Name </label>
						<div class="input">
							<input type='text' name='Name' required="required"
								placeholder="Your name"
								<c:choose>
										<c:when test = "${name != null && name.length() != 0}"> 
											value = '${name}' 
										</c:when> 
									</c:choose>>
						</div>
					</div>
					<div class="field">
						<label> Region </label>
						<div class="input">
							<select name='Region'>
								<option value='1'
									<c:if test = "${region != null && region eq '1'}"> selected </c:if>>
									Kyiv</option>
								<option value='2'
									<c:if test = "${region != null && region eq '2'}"> selected </c:if>>
									Dnepr</option>
								<option value='3'
									<c:if test = "${region != null && region eq '3'}"> selected </c:if>>
									Other</option>
						</div>
					</div>

					<div class="field">
						<label> Gender </label>
						<div class="radio">
							<input type='radio' name='Gender' value='M'
								<c:if test = "${gender != null && gender eq 'M'}"> checked </c:if>>
							M <input type='radio' name='Gender' value='F'
								<c:if test = "${gender!=null && gender eq 'F'}"> checked </c:if>>
							F
						</div>
					</div>

					<div class="field">
						<label> Comment </label>
						<div class="input">
							<input type="textarea" placeholder="Your comment here"
								name='Comment' column='10' row='5'
								<c:choose>
							<c:when test = "${comment != null && comment.length() != 0}"> 
								value = '${comment}' 
							</c:when> 
						</c:choose>>
						</div>
					</div>

					<div class="submit">
						<label> Agree </label> <label id="remember"><input
							type='checkbox' name='Agree'></label>
						<button type="submit" name='register' value='Register'>Register</button>
					</div>
			</td>
		</tr>
	</table>
</div>
	</form>


<%@ include file="..\includes\footer.jsp"%>