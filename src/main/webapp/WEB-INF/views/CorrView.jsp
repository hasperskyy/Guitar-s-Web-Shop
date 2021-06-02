<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ include file="../includes/header.jsp"%>

<form id="correctForm" action="/Itea_shop_test_Spring/corr"
	method="post">
	<div id="table">
		<table>
			<tr>
				<td width = "280px">
					<div class="field">
						<table>
							<tr>
								<td align='center'>${utilites.getErrorText()}</td>
							</tr>
						</table>
				</td>
				<td width="180px">
					<div class="field">
						<br> <label> Login: ${userS.getLogin()} </label> <br> <br>
					</div>
					<div class="field">
						<label> Password </label>
						<div class="input">
							<input type='password' name='Password' required="required"
								placeholder="a-z,A-Z,0-9 min 8 symbols"
								<c:choose>
										<c:when test = "${password != null && password.length() != 0 && controller.isPasswordCorrect(password) == true}"> 
											value = '${password}' 
										</c:when>
										<c:otherwise>
										 	value = '${userS.getPassword()}'
										</c:otherwise>
									</c:choose>>
						</div>
					</div>
					<div class="field">
						<label> Re_Password </label>
						<div class="input">
							<input type='password' name='Re_password' required="required"
								placeholder="Retype your password"
								<c:choose>
										<c:when test = "${re_password != null && re_password.length() != 0 && controller.isRe_PasswordCorrect(password, re_password) == true}"> 
											value = '${re_password}' 
										</c:when>
										<c:otherwise>
										 	value = '${userS.getPassword()}'
										</c:otherwise> 
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
										<c:otherwise>
										 	value = '${userS.getName()}'
										</c:otherwise>
									</c:choose>>
						</div>
					</div>
					<div class="field">
						<label> Region </label>
						<div class="input">
							<select name='Region'>
								<option value='1'
									<c:choose>
										<c:when test = "${region != null && region eq '1'}"> selected 
										</c:when>
										<c:when test = "${userS.getRegion() eq 'KJV'}"> selected 
										</c:when>
									</c:choose>>
									Kyiv</option>
								<option value='2'
									<c:choose>
										<c:when test = "${region != null && region eq '2'}"> selected 
										</c:when>
										<c:when test = "${userS.getRegion() eq 'DNP'}"> selected 
										</c:when>
									</c:choose>>
									Dnepr</option>
								<option value='3'
									<c:choose>
										<c:when test = "${region != null && region eq '3'}"> selected 
										</c:when>
										<c:when test = "${userS.getRegion() eq 'OTH'}"> selected 
										</c:when>
									</c:choose>>
									Other</option>
						</div>
					</div>

					<div class="field">
						<label> Gender </label>
						<div class="radio">
							<input type='radio' name='Gender' value='M'
								<c:choose>
								<c:when test = "${gender != null && gender eq 'M'}"> checked 
								</c:when>
								<c:when test = "${userS.getGender() == '1'}"> checked 
								</c:when>
								</c:choose>>
							M <input type='radio' name='Gender' value='F'
								<c:choose>
								<c:when test = "${gender != null && gender eq 'F'}"> checked 
								</c:when>
								<c:when test = "${userS.getGender() == '0'}"> checked 
								</c:when>
								</c:choose>>
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
							<c:otherwise>
								value = '${userS.getComment()}'
							</c:otherwise>
						</c:choose>>
						</div>
					</div>

					<div class="submit">
						<label> Agree </label> <label id="remember"><input
							type='checkbox' name='Agree'></label>
						<button type="submit" name='correct' value='Correct'>Correct</button>
					</div>
				</td>


			</tr>
		</table>
	</div>
</form>

<%@ include file="../includes/footer.jsp"%>