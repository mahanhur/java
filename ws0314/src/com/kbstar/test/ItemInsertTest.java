package com.kbstar.test;

import java.util.List;

import com.kbstar.dto.Cust;
import com.kbstar.dto.Item;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.CustCRUDServiceImpl;
import com.kbstar.service.ItemCRUDServiceImpl;

public class ItemInsertTest {

	public static void main(String[] args) {
		//insert test
		CRUDService<String, Item> itemService = new ItemCRUDServiceImpl();
		Item item = new Item("ddong1", 500, 0.1);
		
		try {
			itemService.register(item);
			System.out.println("입력성공");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		//update test
//		CRUDService<String, Cust> crudService = new CustCRUDServiceImpl();
//		Cust cust = new Cust("id30", "pwd033", "멍천", 31);
//		
//		try {
//			crudService.modify(cust);
//			System.out.println("입력성공");
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
		
		//remove test
//		CRUDService<String, Cust> crudService = new CustCRUDServiceImpl();
//		
//		try {
//			crudService.remove("id90");
//			System.out.println("입력성공");
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}

		//select test
//		CRUDService<String, Cust> crudService = new CustCRUDServiceImpl();
//		Cust cust = null;
//		try {
//			cust = crudService.get("id78");
//			System.out.println(cust);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
		
		//selectAll test
//		CRUDService<String, Cust> crudService = new CustCRUDServiceImpl();
//		List<Cust> list = null;
//		try {
//			list = crudService.get();
//			if(list.size()==0) {
//				System.out.println("데이터가 없습니다.");
//			} else {
//				for(Cust u:list)
//					System.out.println(u);
//			}
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}

	}
}
