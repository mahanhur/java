package com.kbstar.test;

import java.util.List;

import com.kbstar.dto.Cart;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.CartCRUDServiceImpl;

public class CartSelectAllTest {

	public static void main(String[] args) {

		//selectAll test
		CRUDService<String, Cart> cartService = new CartCRUDServiceImpl();
		List<Cart> list = null;
		try {
			list = cartService.get();
			if(list.size() == 0) {
				System.out.println("데이터가 없습니다.");
			} else {
				for(Cart u:list)
					System.out.println(u);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
