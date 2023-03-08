package com.kbstar.frame;

import java.util.List;

public interface DAO<K, V> {
	// CRUD(Create, Read, Update, Delete)
	public void insert(V v) throws Exception;
	public void update(V v) throws Exception;
	public void delete(K k) throws Exception;
	
	public V select(K k) throws Exception; //키값이 k인 놈의 v를 가져와
	public List<V> select() throws Exception; //전체의 v를 list 형태로 전부 가져와
	
}
