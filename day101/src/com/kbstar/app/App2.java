package com.kbstar.app;

import java.util.Scanner;

import com.kbstar.dao.ItemDAO;
import com.kbstar.dto.ItemDTO;
import com.kbstar.frame.DAO;

public class App2 {

	public static void main(String[] args) {
		DAO<Integer, ItemDTO> dao = new ItemDAO();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("Input command(q, i, d, u, s, sa)");
			String cmd = sc.next();
			if(cmd.equals("q")) {
				System.out.println("bye");
			} else if(cmd.equals("i")) {
				System.out.println("Input item No");
				int itmNo = sc.nextInt();
				System.out.println("Input item Name");
				String itmName = sc.next();
				System.out.println("Input item Price");
				int price = sc.nextInt();
				System.out.println("Input item Quantity");
				int qt = sc.nextInt();
				
				ItemDTO item = new ItemDTO(itmNo, itmName, price , qt);
				try {
					dao.insert(item);
				} catch(Exception e) {
					System.out.println(e.getMessage());
				}
			} else if(cmd.equals("d")) {
				System.out.println("Input item No");
				int itmNo = sc.nextInt();
				dao.update(itmNo);
			} else if(cmd.equals("u")) {
				
			} else if(cmd.equals("s")) {
				
			} else if(cmd.equals("sa")) {
				
			}
		}
	}

}
