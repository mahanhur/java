package com.kbstar.test;

import com.kbstar.dto.Cart;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.CartCRUDServiceImpl;

public class CartSelectTest {

	public static void main(String[] args) {
		//select test
		CRUDService<String, Cart> cartService = new CartCRUDServiceImpl();
		Cart cart = null;
		try {
			cart = cartService.get("2022314864100");
			System.out.println(cart);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
