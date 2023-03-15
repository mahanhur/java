package com.kbstar.test;

import com.kbstar.dto.Cart;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.CartCRUDServiceImpl;

public class CartDeleteTest {

	public static void main(String[] args) {
		// remove test
		CRUDService<String, Cart> cartService = new CartCRUDServiceImpl();

		try {
			cartService.remove("2023314783100");
			System.out.println("삭제성공");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
