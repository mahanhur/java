package com.kbstar.test;

import com.kbstar.dto.Cust;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.CustCRUDServiceImpl;

public class CustInsertTest {

	public static void main(String[] args) {
		//insert test
//		CRUDService<String, Cust> crudService = new CustCRUDServiceImpl();
//		Cust cust = new Cust("id55", "pwd55", "허감자", 55);
//		
//		try {
//			crudService.register(cust);
//			System.out.println("입력성공");
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}

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
//		
//		try {
//			crudService.get("id78");
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
		
		//selectAll test
		CRUDService<String, Cust> crudService = new CustCRUDServiceImpl();
		
		try {
			crudService.get();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
}
