package com.kbstar.service;

import java.util.List;

import com.kbstar.dao.AccountDAO;
import com.kbstar.dto.AccountDTO;
import com.kbstar.frame.Notification;
import com.kbstar.frame.CRUDService;
import com.kbstar.frame.DAO;
import com.kbstar.noti.Notificationlmpl;

public class AccountService implements CRUDService<String, AccountDTO> {
	DAO<String, AccountDTO> accDao;
	Notification accNoti;

	public AccountService() {
		accDao = new AccountDAO();
		accNoti = new Notificationlmpl();
	}

	@Override
	public void register(AccountDTO v) throws Exception {
		try {
			accDao.insert(v);
		} catch(Exception e) {
			System.out.println("계좌등록실패 오류입니다.");
		}
	}

	@Override
	public void remove(String k) throws Exception {
		try {
			accDao.delete(k);
		} catch(Exception e) {
			System.out.println("계좌해지실패 오류입니다");
		}
	}

	@Override
	public void modify(AccountDTO v) throws Exception {
		try {
			accDao.update(v);
		} catch(Exception e) {
			System.out.println("계좌 업데이트실패 오류입니다");
		}
	}

	@Override
	public AccountDTO get(String k) throws Exception {
		AccountDTO obj = null;
		obj = accDao.select(k);

		return obj;
	}

	@Override
	public List<AccountDTO> get() throws Exception {
		List<AccountDTO> list = null;
		list = accDao.select();
		return list;
	}

}
