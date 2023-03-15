package com.kbstar.test;

import com.kbstar.dto.Cart;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.CartCRUDServiceImpl;

public class CartUpdateTest {

	public static void main(String[] args) {

		// update test
		CRUDService<String, Cart> cartService = new CartCRUDServiceImpl();
		Cart cart = new Cart("2022314864100", "허멍헌", "ddong2", 2, null);

		try {
			cartService.modify(cart);
			System.out.println("수정성공");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
