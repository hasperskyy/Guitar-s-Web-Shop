package ua.itea.servlets;

import java.util.TreeSet;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.itea.DAO.FactoryDAO;
import ua.itea.DAO.ProductDAO;
import ua.itea.models.Product;

@Controller
@RequestMapping("/products")
public class ProductServletController {
	@RequestMapping(method = RequestMethod.GET)
	public String returnString(@RequestParam(required = false, name = "Category") String category, 
								HttpSession session, ModelMap model) {

		FactoryDAO factory = FactoryDAO.getFactoryDAO(1);
		ProductDAO productDAO = factory.getProductDAO();
		TreeSet<Product> productSet;
		int productCategory;

		if (category != null) {
			productCategory = Integer.parseInt(category);
			productSet = productDAO.getProductbyCategory(productCategory);
		} else 
			productSet = productDAO.getProductList();
			model.addAttribute("productSet", productSet);	
			
		return "ProductsView";
	}

}
