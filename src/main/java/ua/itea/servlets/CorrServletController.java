package ua.itea.servlets;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.itea.DAO.FactoryDAO;
import ua.itea.DAO.UserDAO;
import ua.itea.controllers.Utilites;
import ua.itea.models.User;

@Controller
@RequestMapping("/corr")
public class CorrServletController {

	@RequestMapping (method = RequestMethod.GET)
	public String getString (ModelMap model, HttpSession session) {
		return "CorrView";
	}
	
	@RequestMapping (method = RequestMethod.POST)
	public String returnString2 (@RequestParam (required = false, name = "Password")String password,
			@RequestParam (required = false, name = "Re_password") String re_password,
			@RequestParam (required = false, name = "Name") String name,
			@RequestParam (required = false, name = "Region") String region,
			@RequestParam (required = false, name = "Gender") String gender,
			@RequestParam (required = false, name = "Comment") String comment,
			@RequestParam (required = false, name = "Agree") String agree,
			HttpSession session, ModelMap model) {
		
		Utilites utilites = new Utilites();
		FactoryDAO factory = FactoryDAO.getFactoryDAO(1);
		UserDAO userDAO = factory.getUserDAO();
		boolean showForm = true;
		boolean isError = false;
		int genderInt = 0;
		
		model.addAttribute("password", password);
		model.addAttribute("re_password", re_password);
		model.addAttribute("name", name);
		model.addAttribute("gender", gender);
		model.addAttribute("region", region);
		model.addAttribute("comment", comment);
		model.addAttribute("agree", agree);
		
		if (password == null && re_password == null && name == null && region == null && gender == null
				&& comment == null && agree == null) {
		}

		else {

			if (password != null && password.length() == 0) {
				isError = true;
				utilites.setErrorText("Password is empty <br>");
			} else {
				if (!utilites.isPasswordCorrect(password)) {
					isError = true;
					utilites.setErrorText("Password is not Correct <br>");
				}
			}

			if (re_password != null && re_password.length() == 0) {
				isError = true;
				utilites.setErrorText("Re_Password is empty <br>");
			} else {
				if (!utilites.isRe_PasswordCorrect(password, re_password)) {
					isError = true;
					utilites.setErrorText("Password and Re_password doesn`t equals <br>");
				}
			}

			if (name != null && name.length() == 0) {
				isError = true;
				utilites.setErrorText("Name is empty <br>");
			}

			if (region != null && region.length() == 0) {
				isError = true;
				utilites.setErrorText("Region is empty <br>");
			} else {
				if (region.equals("1"))
					region = "KJV";
				else {
					if (region.equals("2"))
						region = "DNP";
					else
						region = "OTH";
				}

			}

			if (gender == null) {
				isError = true;
				utilites.setErrorText("Gender is empty <br>");
			} else {
				if (gender.equals("M"))
					genderInt = 1;
				else
					genderInt = 0;
			}

			if (comment != null && comment.length() == 0) {
				isError = true;
				utilites.setErrorText("Comment is empty <br>");
			}

			if (agree == null) {
				isError = true;
				utilites.setErrorText("Agree is empty <br>");
			}

			if (!isError) {
				showForm = false;
				User userOld = (User) session.getAttribute("userS");
				userDAO.updateUser(userOld.getLogin(), password, name, region, genderInt, comment);
				session.setAttribute("userS", userDAO.getAuth(userOld.getLogin(), password));
				return "CorrectedView";
			}
			
			model.addAttribute("utilites", utilites);
			System.out.println(utilites.getErrorText());
		}

		if (showForm) {
			return "CorrView";
		}

		return "CorrView";
	}
}