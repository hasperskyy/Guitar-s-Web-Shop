package ua.itea.servlets;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping ("/main")
public class MainServletController {

	@RequestMapping (method = RequestMethod.GET)
	public String returnString (HttpSession session, ModelMap model) {
		return "MainView";
	}
	
	
}
