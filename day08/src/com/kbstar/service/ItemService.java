package com.kbstar.service;

import com.kbstar.dao.ItemDAO;
import com.kbstar.dto.ItemDTO;
import com.kbstar.frame.DAO;
import com.kbstar.frame.SearchService;
import com.kbstar.frame.Service;

public class ItemService implements Service<Integer, ItemDTO>, SearchService {

	DAO<Integer, ItemDTO> dao;
	
	public ItemService() {
		dao = new ItemDAO();
	}
	
//	public void search() {
//		System.out.println("Search...");
//	}
	
	
	@Override
	public void register(ItemDTO v) {
		System.out.println(v + " Data Check...");
		dao.insert(v);
		System.out.println("send SMS...");
	}

	@Override
	public void remove(Integer k) {
		System.out.println(k + " Data Check...");
		dao.delete(k);
		System.out.println("send SMS...");
		
	}

	@Override
	public void modify(ItemDTO v) {
		System.out.println(v + " Data Check...");
		dao.update(v);
		System.out.println("send SMS...");
		
	}

	@Override
	public void search() {
		System.out.println("Searching...");
	}

//	@Override
//	public void search() {
//		System.out.println("Search...");
//	}

}
