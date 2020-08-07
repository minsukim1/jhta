package kr.co.jhta.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.jhta.service.ProductService;
import kr.co.jhta.vo.Product;

/*
 * @ResponseBody
 * 		- 요청핸들러 메소드가 반환하는 값(객체, Map, 콜렉션)을 특정 타입의 컨텐츠로
 * 		    변환해서 응답메세지의 body에 담아보낼 때 사용하는 어노테이션이다.
 * 		- 요청핸들러 메소드 혹은 반환타입에 부착할 수 있다.
 * 		- 응답컨텐츠의 타입은 보통 JSON 형식의 데이터를 제공한다.
 * 		- JSON 형식의 데이터를 제공하기 위해서는 
 */
@Controller
@RequestMapping("/json")
public class JSONController {

	@Autowired
	ProductService productService;
	
	@GetMapping("/home.do")
	public String home() {
		return "json/home";
	}
	
	// 모든 상품정보를 json형식의 텍스트로 제공하는 요청핸들러 메소드
	@GetMapping("/products.do")
	@ResponseBody
	public List<Product> getAllProducts() {
		List<Product> products = productService.getAllProducts();
		return products;
	}
	
	@GetMapping("/product.do")
	public @ResponseBody Product getProduct(@RequestParam("no") int productNo) {
		Product product = productService.getProductDetail(productNo);
		return product;
	}
	
}
