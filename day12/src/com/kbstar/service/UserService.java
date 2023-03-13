package com.kbstar.service;

import java.util.ArrayList;
import java.util.List;

import com.kbstar.dao.UserDAO;
import com.kbstar.dto.UserDTO;
import com.kbstar.frame.DAO;
import com.kbstar.frame.Msg;
import com.kbstar.frame.Notification;
import com.kbstar.frame.CRUDService;
import com.kbstar.noti.Notificationlmpl;

public class UserService implements CRUDService<String, UserDTO>{

	DAO<String, UserDTO> userDao;
	Notification noti;
	
	public UserService() {
		userDao = new UserDAO();
		noti = new Notificationlmpl();
	}

	@Override
	public void register(UserDTO v) throws Exception {
		try {
			userDao.insert(v);
		} catch(Exception e) {
			throw new Exception("회원가입에 실패하였습니다.");
		}
		noti.sendEmail(v.getEmail(), Msg.registerMsg1);
		noti.sendSMS(v.getContact(), Msg.registerMsg2);
	}

	@Override
	public void remove(String k) throws Exception {
		UserDTO TempInfo = null;
		TempInfo = userDao.select(k);
		try {
			userDao.delete(k);
		} catch(Exception e) {
			throw new Exception("탈퇴 오류입니다.");
		}
		noti.sendEmail(TempInfo.getEmail(), Msg.removeMsg3);
		noti.sendSMS(TempInfo.getContact(), Msg.removeMsg3);
		
	}

	@Override
	public void modify(UserDTO v) throws Exception {
		try {
			userDao.update(v);
		} catch(Exception e) {
			throw new Exception("수정 오류");
		}
	}

	@Override
	public UserDTO get(String k) throws Exception {
		UserDTO obj = userDao.select(k);
		return obj;
	}

	@Override
	public List<UserDTO> get() throws Exception {
		List<UserDTO> list = null;
		try {
			list = userDao.select();
			return list;
		} catch(Exception e) {
			throw new Exception("조회 오류");
		}
	}

}
