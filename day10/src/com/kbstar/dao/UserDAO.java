package com.kbstar.dao;

import com.kbstar.dto.UserDTO;
import com.kbstar.frame.DAO;

public class UserDAO implements DAO<String, UserDTO>{

	@Override
	public void insert(UserDTO v) throws Exception  {
		if(v.getId().equals("id01")) {
			throw new Exception("EX0004");
		}
		System.out.println(v.getId()+"님이 저장 되었습니다.");
	}

	@Override
	public void delete(String k) throws Exception {
		if(k.equals("id01")) {
			throw new Exception("EX0005");
		}
		System.out.println(k+"님의 정보가 삭제되었습니다.");		
	}

	@Override
	public void update(UserDTO v) throws Exception {
		if(v.getId().equals("id01")) {
			throw new Exception("EX0006");
		}
		System.out.println(v.getId()+"님의 정보가 수정되었습니다.");
	}

}
