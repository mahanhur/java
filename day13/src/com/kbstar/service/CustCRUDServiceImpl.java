package com.kbstar.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLRecoverableException;
import java.util.ArrayList;
import java.util.List;

import com.kbstar.dao.CustDaoImpl;
import com.kbstar.dto.Cust;
import com.kbstar.frame.CRUDService;
import com.kbstar.frame.DAO;

public class CustCRUDServiceImpl implements CRUDService<String, Cust> {

	DAO<String, String, Cust> dao;

	public CustCRUDServiceImpl() {
		dao = new CustDaoImpl();
	}

	@Override
	public void register(Cust v) throws Exception {
		// 데이터 검증
		// db 입력
		try {
			dao.insert(v);
		} catch (Exception e) {
			if (e instanceof SQLIntegrityConstraintViolationException) {
				throw new Exception("똑같은 아이디 insert 입력 오류(service표출)");
			} else {
				throw new Exception("시스템 장애입니다.");
			}
		}
		// Email, SMS 전송
	}

	@Override
	public void modify(Cust v) throws Exception {
		try {
			dao.update(v);
		} catch(Exception e) {
			if (e instanceof SQLIntegrityConstraintViolationException) {
				throw new Exception("시스템장애");
			} else {
				throw new Exception("해당 ID가 존재하지 않습니다");
			}
		}
	}

	@Override
	public void remove(String k) throws Exception {
		try {
			dao.delete(k);
		} catch (Exception e) {
			if(e instanceof SQLRecoverableException) {
				throw new Exception("시스템 장애");
			} else {
				throw new Exception("해당 ID가 존재하지 않습니다.");
			}
		}
	}

	@Override
	public Cust get(String k) throws Exception {
		Cust cust = null;
		try {
			cust = dao.select(k);
			System.out.println("id는 "+k+ ", name은 " + cust.getName() + ", age는 " + cust.getAge() + "입니다.");
			
		} catch (Exception e) {
			throw new Exception("해당 ID가 존재하지 않습니다.");
		}		
		return cust;
	}

	@Override
	public List<Cust> get() throws Exception {
		List<Cust> list = null;
		try {
			list = dao.selectAll();
			return list;
		} catch (Exception e) {
			throw new Exception("오류가 뭐야");
		}
	}

}
