package com.kbstar.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLRecoverableException;
import java.util.List;

import com.kbstar.dao.ItemDaoImpl;
import com.kbstar.dto.Item;
import com.kbstar.frame.CRUDService;
import com.kbstar.frame.DAO;
import com.kbstar.frame.MakeItemNumber;

public class ItemCRUDServiceImpl implements CRUDService<String, Item>{

	DAO<String, String, Item> dao = null;
	
	public ItemCRUDServiceImpl() {
		dao = new ItemDaoImpl();
	}
	
	@Override
	public void register(Item v) throws Exception {
		try {
			String id = MakeItemNumber.makeItemNum();
			v.setId(id);
			dao.insert(v);
		} catch (Exception e) {
			if (e instanceof SQLIntegrityConstraintViolationException) {
				throw new Exception("똑같은 아이디 insert 입력 오류(service표출)");
			} else {
//				e.printStackTrace();
				throw new Exception("시스템 장애입니다.");
			}
		}
	}

	@Override
	public void modify(Item v) throws Exception {
	}

	@Override
	public void remove(String k) throws Exception {
	}

	@Override
	public Item get(String k) throws Exception {
		return null;
	}

	@Override
	public List<Item> get() throws Exception {
		List<Item> list = null;
		try {
			list = dao.selectAll();
		} catch (Exception e) {
			if (e instanceof SQLRecoverableException) {
				throw new Exception("시스템오류");
			} else {
				throw new Exception("데이터 없음");
			}
		}
		return list;
	}

}
