package com.kbstar.app;

import java.util.Scanner;

import com.kbstar.dto.ItemDTO;
import com.kbstar.dto.UserDTO;
import com.kbstar.frame.SearchService;
import com.kbstar.frame.Service;
import com.kbstar.service.ItemService;
import com.kbstar.service.UserService;

public class App {
	public static void main(String[] args) {
		Service<Integer, ItemDTO> service = new ItemService();
		SearchService SS = new ItemService();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("Input command(q,i,d,u,s)");
			String cmd = sc.next();

			if (cmd.equals("q")) {
				System.out.println("Bye");
				break;
			} else if (cmd.equals("i")) {
				System.out.println("Input ID...");
				int id = Integer.parseInt(sc.next());
				System.out.println("Input NAME...");
				String name = sc.next();
				System.out.println("Input PRICE...");
				double price = Double.parseDouble(sc.next());
				System.out.println("Input QUANTITY...");
				int qt = Integer.parseInt(sc.next());

				ItemDTO item = new ItemDTO(id, name, price, qt);
				service.register(item);
			} else if (cmd.equals("d")) {
				System.out.println("Input ID...");
				try {
					int id = Integer.parseInt(sc.next());
					service.remove(id);
				} catch (Exception e) {
					System.out.println("잘못 입력 하셨습니다");
				}

			} else if (cmd.equals("u")) {
				System.out.println("Input ID...");
				int id = Integer.parseInt(sc.next());
				System.out.println("Input NAME...");
				String name = sc.next();
				System.out.println("Input PRICE...");
				double price = Double.parseDouble(sc.next());
				System.out.println("Input QUANTITY...");
				int qt = Integer.parseInt(sc.next());

				ItemDTO item = new ItemDTO(id, name, price, qt);
				service.modify(item);
			} else if (cmd.equals("s")) {
				SS.search();
			}
		}
		sc.close();
	}

}
