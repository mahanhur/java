package com.kbstar.test;

import java.security.Provider.Service;
import java.util.List;

import com.kbstar.dto.Cart;
import com.kbstar.dto.Cust;
import com.kbstar.frame.CRUDService;
import com.kbstar.frame.ShopService;
import com.kbstar.service.CartCRUDServiceImpl;
import com.kbstar.service.ShopServiceImpl;

public class MyCartSelectAllTest {

	public static void main(String[] args) {

		//selectAll test
		ShopService<Cust, Cart> service = new ShopServiceImpl();
		List<Cart> list = null;
		try {
			list = service.MyCart("낑깡");
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
