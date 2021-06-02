package ua.itea.servlets;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import ua.itea.MySQL.MySQLUserDAO;

@Controller
@RequestMapping("/login")
public class LoginServletController {

	@RequestMapping(method = RequestMethod.GET)
	public String returnString(@RequestParam(required = false, name = "Logout") String logOut, HttpSession session,
			ModelMap model) {

		if (session.getAttribute("userS") != null && logOut == null) {
			return "LoginedView";
		} else
			session.setAttribute("userS", null);
			return "LoginView";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String returnString2(@RequestParam(required = false, name = "Logout") String logOut,
			@RequestParam ("Login") String login, @RequestParam ("Password") String password,
			HttpSession session,
			ModelMap model) {

		boolean showForm = true;
		boolean isError = false;
		String message2 = "<div style = \"color:red\"> \"Acess denided\" </div>  ";
		
		if (logOut != null) {
			session.invalidate();
			session = mySession();
			showForm = true;
		} else {
			if (login != null && password != null) {
				if (new MySQLUserDAO().getAuth(login, password)!=null) {
					showForm = false;
					session.setAttribute("userS", new MySQLUserDAO().getAuth(login, password));
					return "LoginedView";
				} else {
					isError = true;
					System.out.println(message2);
				}
			}
		}

		if (showForm) {
			returnString(message2, session, model);
		}
		return "LoginView";
	}
	
	
	public static HttpSession mySession() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		return attr.getRequest().getSession(true);
	}
}