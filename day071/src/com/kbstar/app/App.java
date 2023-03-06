package com.kbstar.app;

import com.kbstar.dao.AccountMariaDBDAO;
import com.kbstar.dao.AccountOracleDAO;
import com.kbstar.dao.UserMariaDBDAO;
import com.kbstar.dao.UserOracleDAO;
import com.kbstar.dto.AccountDTO;
import com.kbstar.dto.UserDTO;
import com.kbstar.frame.DAO;

public class App {

	public static void main(String[] args) {
		DAO dao1 = new UserMariaDBDAO();
		UserDTO userM = new UserDTO("idmaria01","pwmaria01","namemaria01");
		dao1.update(userM);
		
		DAO dao2 = new AccountMariaDBDAO();
		AccountDTO accountM = new AccountDTO("100","자유저축",10000);
		dao2.insert(accountM);
		
//		DAO dao = new AccountOracleDAO();
//		AccountDTO account = new AccountDTO("100","자유저축", 1000);
//		dao.insert(account);
				
//		DAO dao = new UserOracleDAO();
//		UserDTO user = new UserDTO("id01","pwd01","james");
//		dao.insert(user);
	}

}
