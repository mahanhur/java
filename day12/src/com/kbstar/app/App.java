package com.kbstar.app;

import java.util.Scanner;

import com.kbstar.dto.AccountDTO;
import com.kbstar.dto.TransactionDTO;
import com.kbstar.dto.UserDTO;
import com.kbstar.frame.CRUDService;
import com.kbstar.frame.bankservice;
import com.kbstar.service.BankServiceImpl;
import com.kbstar.service.UserService;

public class App {

	public static void main(String[] args) {
		bankservice<String, UserDTO, AccountDTO, TransactionDTO, String> service;
		service = new BankServiceImpl();
		CRUDService<String, UserDTO> userService = new UserService();
		Scanner sc = new Scanner(System.in);

		while (true) {
			UserDTO user = null;
			System.out.println("Input Login(1) / Register(2) / Quit(3)");
			String cmd = sc.next();
			if (cmd.equals("1")) {
				System.out.println("Login : ");
				String id = sc.next();
				String pwd = sc.next();
				try {
					user = service.login(id, pwd);
					System.out.println(user);
					System.out.println("로그인성공~~");
					System.out.println("----------------------------------");
					while(true) {
						System.out.println("Menu(계좌개설m, 이체t, 조회a, 사용자정보조회i, tr, e)");
						String cmn = sc.next();
						if(cmn.equals("e")) {
							System.out.println("로그아웃됨");
							break;
						} else if (cmn.equals("m")) {
							System.out.println("Make Account: input balance");
							double balance = Double.parseDouble(sc.next());
							service.makeAccount(user.getId(), balance);
							System.out.println("Make Account Complete!");
						} else if (cmn.equals("t")) {
							System.out.println("Transaction");
							//String sendAcc, String receiveAcc, double balance, String desc
							String sendAcc = sc.next();
							String receiveAcc = sc.next();
							double balance = Double.parseDouble(sc.next());
							String desc = sc.next();
							service.transaction(sendAcc, receiveAcc, balance, desc);
							System.out.println("Transaction Complete!");
						} else if (cmn.equals("a")) {
							System.out.println("Select Account");
						} else if (cmn.equals("i")) {
							System.out.println("User Info");
							String rid = user.getId();
							UserDTO ruser = null;
							ruser = service.getUserInfo(rid);
							System.out.println(ruser);
							
						} else if (cmn.equals("tr")) {
							System.out.println("Select Transaction");
						}
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

			} else if (cmd.equals("2")) {
				System.out.println("Register : ");
				String id = sc.next();
				String pwd = sc.next();
				String name = sc.next();
				String email = sc.next();
				String contact = sc.next();

				user = new UserDTO(id, pwd, name, email, contact);
				try {
					service.register(user);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			} else if (cmd.equals("3")) {
				System.out.println("bye");
				break;
			}
		}
		sc.close();
	}

}
