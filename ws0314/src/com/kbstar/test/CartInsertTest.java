package com.kbstar.test;

import com.kbstar.dto.Cart;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.CartCRUDServiceImpl;

public class CartInsertTest {

	public static void main(String[] args) {
		//insert test
		CRUDService<String, Cart> cartService = new CartCRUDServiceImpl();
		Cart cart = new Cart("테서터", "ddong77", 27);
		
		try {
			cartService.register(cart);
			System.out.println("입력성공");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
