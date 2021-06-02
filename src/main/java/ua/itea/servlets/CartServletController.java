package ua.itea.servlets;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import ua.itea.DAO.FactoryDAO;
import ua.itea.models.Product;

@Controller
@RequestMapping("/cart")
public class CartServletController {

	@RequestMapping(method = RequestMethod.GET)
	public String getString(HttpSession session, ModelMap model) {
		model.addAttribute("productList", session.getAttribute("cart"));
		return "CartView";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(method = RequestMethod.POST)
	public String getString2(@RequestParam(required = false, name = "productToBuy") String productToBuy,
			@RequestParam(required = false, value = "numberOfProduct") String numberOfProduct,
			@RequestParam(required = false, value = "plusProduct") String plusProduct,
			@RequestParam(required = false, value = "minusProduct") String minusProduct,
			@RequestParam(required = false, value = "removeProduct") String removeProduct,
			@RequestParam(required = false, value = "clearCart") String clearCart, HttpSession session,
			ModelMap model) {

		if (productToBuy != null || plusProduct != null || minusProduct != null || removeProduct != null
				|| clearCart != null) {

			System.out.println("Работа корзины");
			session = mySession();
			FactoryDAO factory = FactoryDAO.getFactoryDAO(1);
			Map<Product, Integer> products;
			int generalQuantity;

			if (productToBuy != null) {
				System.out.println("покупка продукта");
				Integer numberPr = Integer.parseInt(numberOfProduct);
				int pBuy = Integer.parseInt(productToBuy);
				Product product = factory.getProductDAO().getProductById(pBuy);
				if (session.getAttribute("cart") != null) {
					products = (Map<Product, Integer>) session.getAttribute("cart");
					generalQuantity = (int) session.getAttribute("generalQuantity");
					generalQuantity += numberPr;
					if (products.containsKey(product)) {
						numberPr += products.get(product);
						products.replace(product, numberPr);
					} else {
						products.put(product, numberPr);
					}
				} else {
					products = new HashMap<Product, Integer>();
					products.put(product, numberPr);
					generalQuantity = numberPr;
				}
				System.out.println("продукт куплен");
				session.setAttribute("cart", products);
				session.setAttribute("generalQuantity", generalQuantity);
				System.out.println("Cart+");
				System.out.println(products);
			}

			if (minusProduct != null) {
				System.out.println("уменьшение количества продукта");
				int minProduct = Integer.parseInt(minusProduct);
				Product product = factory.getProductDAO().getProductById(minProduct);
				if (session.getAttribute("cart") != null) {
					products = (Map<Product, Integer>) session.getAttribute("cart");
					generalQuantity = (int) session.getAttribute("generalQuantity");
					generalQuantity--;
					if (products.containsKey(product) && products.get(product) > 1) {
						Integer numberPr = products.get(product);
						products.replace(product, --numberPr);
					} else {
						if (products.containsKey(product) && products.get(product) == 1) {
							if (generalQuantity > 1)
								products.remove(product);
							else
								products.clear();
							products = null;
						}
					}
					session.setAttribute("cart", products);
					session.setAttribute("generalQuantity", generalQuantity);
					System.out.println("продукт уменьшен");
					System.out.println("Cart-");
					System.out.println(products);
				}
			}

			if (plusProduct != null) {
				int plsProduct = Integer.parseInt(plusProduct);
				Product product = factory.getProductDAO().getProductById(plsProduct);
				if (session.getAttribute("cart") != null) {
					products = (Map<Product, Integer>) session.getAttribute("cart");
					generalQuantity = (int) session.getAttribute("generalQuantity");
					generalQuantity++;
					if (products.containsKey(product)) {
						Integer numberPr = products.get(product);
						products.replace(product, ++numberPr);
					}
					session.setAttribute("cart", products);
					session.setAttribute("generalQuantity", generalQuantity);
					System.out.println("Cart+");
					System.out.println(products);
				}
			}

			if (removeProduct != null) {
				int rmvProduct = Integer.parseInt(removeProduct);
				Product product = factory.getProductDAO().getProductById(rmvProduct);
				if (session.getAttribute("cart") != null) {
					products = (Map<Product, Integer>) session.getAttribute("cart");
					generalQuantity = (int) session.getAttribute("generalQuantity");
					if (products.containsKey(product)) {
						Integer numberPr = products.get(product);
						generalQuantity -= numberPr;
						products.remove(product);
						if (products.isEmpty()) 
							products = null;
						
					}
					session.setAttribute("cart", products);
					session.setAttribute("generalQuantity", generalQuantity);
					System.out.println("CartRemPr");
					System.out.println(products);
				}
			}

			if (clearCart != null && session.getAttribute("cart") != null) {
				products = (Map<Product, Integer>) session.getAttribute("cart");
				generalQuantity = 0;
				products.clear();
				products = null;
				session.setAttribute("cart", products);
				session.setAttribute("generalQuantity", generalQuantity);
				System.out.println("ClaerCart");
				System.out.println(products);
			}
		}
		return "CartView";
	}

	public static HttpSession mySession() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		return attr.getRequest().getSession(true);
	}
}