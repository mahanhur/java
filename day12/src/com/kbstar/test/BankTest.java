package com.kbstar.test;

import com.kbstar.dto.AccountDTO;
import com.kbstar.dto.TransactionDTO;
import com.kbstar.dto.UserDTO;
import com.kbstar.frame.bankservice;
import com.kbstar.service.BankServiceImpl;

public class BankTest {

	public static void main(String[] args) {
		bankservice<String, UserDTO, AccountDTO, TransactionDTO, String> service;
		service = new BankServiceImpl();

		// Register
		UserDTO user = new UserDTO("id01", "pw01", "james", "a@nav.com", "8145");
		try {
			service.register(user);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Login

		String id = "id01";
		String pwd = "pw01";
		UserDTO loginUser = null;

		try {
			loginUser = service.login(id, pwd);
			System.out.println(loginUser);
			System.out.println("로그인 성공");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
