package com.kbstar.test;

import java.util.List;

import com.kbstar.dto.UserDTO;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.UserService;

public class UserRegisterTest {

	public static void main(String[] args) {
		CRUDService<String, UserDTO> service = new UserService();
		
		// insert(v) test
		UserDTO user1 = new UserDTO("id01", "pwd01", "james", "allowbas@naver.com", "01068018156");
		UserDTO user2 = new UserDTO("id02", "pwd02", "james2", "2allowbas@naver.com", "01068018157");
		UserDTO user3 = new UserDTO("id03", "pwd03", "james3", "3allowbas@naver.com", "01068018158");
		try {
			service.register(user1);
			service.register(user2);
			service.register(user3);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		UserDTO user = null;
		try {
			user = service.get("id01");
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		//get(k) test
//		List<UserDTO> list = null;
//		try {
//			list = service.get();
//			for(UserDTO userData:list) {
//				System.out.println(userData);
//			}
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		
		//remove test
		try {
			service.remove("id03");
			System.out.println(user3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
