package com.kbstar.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.kbstar.dto.ItemDTO;
import com.kbstar.frame.DAO;

public class ItemDAO implements DAO<Integer, ItemDTO> {
	HashMap<Integer, ItemDTO> db = new HashMap<Integer, ItemDTO>();

	@Override
	public void insert(ItemDTO v) throws Exception {
		if (db.containsKey(v.getItmNo())) {
			throw new Exception("이미 있는 item 오류");
		}
		db.put(v.getItmNo(), v);
	}

	@Override
	public void update(ItemDTO v) throws Exception {
		if (!db.containsKey(v.getItmNo())) {
			throw new Exception("없는 item update요청 오류");
		}
		db.put(v.getItmNo(), v);
	}

	@Override
	public void delete(Integer k) throws Exception {
		if (!db.containsKey(k)) {
			throw new Exception("없는 item delete요청 오류");
		}
	}

	@Override
	public ItemDTO select(Integer k) throws Exception {
		return db.get(k);
	}

	@Override
	public List<ItemDTO> select() throws Exception {
		Collection<ItemDTO> col = db.values();
		ArrayList<ItemDTO> list = new ArrayList<ItemDTO>();
		for (ItemDTO data : col) {
			list.add(data);
		}
		return list;
	}

}
