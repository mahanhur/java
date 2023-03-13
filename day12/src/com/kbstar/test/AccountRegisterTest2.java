package com.kbstar.test;

import com.kbstar.dto.AccountDTO;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.AccountService;

public class AccountRegisterTest2 {
	public static void main(String[] arg) throws Exception {
		CRUDService<String, AccountDTO> accService = new AccountService();

		AccountDTO acc1 = new AccountDTO("1234", 10000, "james");
		AccountDTO acc2 = new AccountDTO("2345", 20000, "james2");
		AccountDTO acc3 = new AccountDTO("4567", 55000, "james3");
		try {
			accService.register(acc1);
			accService.register(acc2);
			accService.register(acc3);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// register test
//			try {
//				accService.register(acc1);
//			} catch (Exception e1) {
//			}

		// delete test
		try {
			accService.remove("7654");
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
		}

		// getall test

	}
}
