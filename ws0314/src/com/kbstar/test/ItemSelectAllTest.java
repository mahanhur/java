package com.kbstar.test;

import java.util.List;

import com.kbstar.dto.Item;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.ItemCRUDServiceImpl;

public class ItemSelectAllTest {

	public static void main(String[] args) throws Exception {
		// selectAll test
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

		CRUDService<String, Item> itemService = new ItemCRUDServiceImpl();
		List<Item> list = null;
		try {
			list = itemService.get();
			for (Item data : list) {
				System.out.println(data);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
//			throw e;
		}
	}
}
