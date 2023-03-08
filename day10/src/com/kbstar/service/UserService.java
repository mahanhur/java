package com.kbstar.service;

import com.kbstar.dao.UserDAO;

import com.kbstar.dto.UserDTO;
import com.kbstar.frame.DAO;
import com.kbstar.frame.Service;

public class UserService implements Service<String, UserDTO>{

	DAO<String, UserDTO> dao;

	public UserService() {
		dao = new UserDAO();
	}
	
	@Override
	public void register(UserDTO v) throws Exception  {
		System.out.println("Security Check...");
		dao.insert(v);
		
		//혹은 이렇게도 표현 가능
		//이런 경우 catch 후 던지므로 중간에 
		//로그를 한 번 확인할 수 있는 장점이 있다
		//(e.printStackTrace 등으로)
//		try {
//			dao.insert(v);
//		} catch(Exception e) {
			//Log 확인
//			throw e;
//		}
		System.out.println("Send Email...");
		System.out.println("Send SMS...");
	}

	@Override
	public void remove(String k) throws Exception {
		dao.delete(k);
		System.out.println("Send Email...");
	}

	@Override
	public void modify(UserDTO v) throws Exception {
		dao.update(v);
		System.out.println("Send Email...");
		
	}

}
