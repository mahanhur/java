package com.kbstar.service;

import java.util.List;

import com.kbstar.dao.TransactionDAO;
import com.kbstar.dto.TransactionDTO;
import com.kbstar.frame.CRUDService;
import com.kbstar.frame.DAO;

public class TransactionService implements CRUDService<String, TransactionDTO> {
	DAO<String, TransactionDTO> traDao;
	
	public TransactionService() {
		traDao = new TransactionDAO();
	}

	@Override
	public void register(TransactionDTO v) throws Exception {
		try {
			traDao.insert(v);
		} catch(Exception e) {
			System.out.println("거래내역 등록 오류");
		}
	}

	@Override
	public void remove(String k) throws Exception {
	}

	@Override
	public void modify(TransactionDTO v) throws Exception {
	}

	@Override
	public TransactionDTO get(String k) throws Exception {
		TransactionDTO obj = null;
		try {
			obj = traDao.select(k);
		} catch (Exception e) {
			System.out.println("없는 거래내역을 요청하였습니다");
		}
		return obj;
			
	}

	@Override
	public List<TransactionDTO> get() throws Exception {
		List<TransactionDTO> list = null;
		list = traDao.select();		
		return list;
	}

}
