/**
 * 
 */
package com.kbstar.service;

import java.util.List;

import com.kbstar.dao.AccountDAO;
import com.kbstar.dao.TransactionDAO;
import com.kbstar.dao.UserDAO;
import com.kbstar.dto.AccountDTO;
import com.kbstar.dto.TransactionDTO;
import com.kbstar.dto.UserDTO;
import com.kbstar.frame.DAO;
import com.kbstar.frame.MakeAccountNumber;
import com.kbstar.frame.Notification;
import com.kbstar.frame.bankservice;
import com.kbstar.noti.Notificationlmpl;

/**
 * @author allow
 *
 */
public class BankServiceImpl implements bankservice<String, UserDTO, AccountDTO, TransactionDTO, String> {

	DAO<String, UserDTO> userDao;
	DAO<String, AccountDTO> accountDao;
	Notification notification;
	DAO<String, TransactionDTO> transDao;
	
	public BankServiceImpl() {
		userDao = new UserDAO();
		notification = new Notificationlmpl();
		accountDao = new AccountDAO();
		transDao = new TransactionDAO();
	}
	
	@Override
	public void register(UserDTO v) throws Exception {
		try {
			userDao.insert(v);
		} catch(Exception e) {
			throw new Exception("등록 오류");
		}
		notification.sendEmail(v.getEmail(), "축하합니다");
		notification.sendSMS(v.getContact(), "축하합니다");
	}

	
	@Override
	public UserDTO login(String k, String p) throws Exception {
		UserDTO user = null;
		user = userDao.select(k);
		if(user!=null) {
			if(user.getPwd().equals(p)) {
				System.out.println("로그인성공");
			} else {
				throw new Exception("로그인실패 - 비밀번호 오입력");
			}
		} else {
			throw new Exception("로그인실패 - 없는 id 입력");
		}
		
		return user;
	}

	@Override
	public UserDTO getUserInfo(String k) throws Exception {
		UserDTO user = null;
		user = userDao.select(k);
		
		return user;
	}

	@Override
	public void makeAccount(String k, double balance) throws Exception {
		//계좌번호 생성 및 DB에 넣기
		String accNo = MakeAccountNumber.makeAccNum();
		AccountDTO account = new AccountDTO(accNo, balance, k);
		accountDao.insert(account);
		//해당 ID를 가진 user정보에 접근하여 message보내기
		UserDTO user = userDao.select(k);
		notification.sendEmail(user.getEmail(), accNo + ", 계좌를 생성하셨습니다email");
		notification.sendSMS(user.getContact(), accNo + ", 계좌를 생성하셨습니다sms");
	}

	@Override
	public List<AccountDTO> getAllAccount(String k) throws Exception {
		List<AccountDTO> list = null;
		list = accountDao.search(k);
		return list;
	}

	@Override
	public List<TransactionDTO> getAllTr(String acc) throws Exception {
		List<TransactionDTO> list = null;
		list = transDao.search(acc);
		return list;
	}

	@Override
	public void transaction(String sendAcc, String receiveAcc, double balance, String desc) throws Exception {
		//계좌 정보 수정 AccountDTO
		//계좌 잔액 정보 조회, 잔액에서 이체하는 금액 차감- 
		AccountDTO account = null;
		account = accountDao.select(sendAcc);
		
		double balance1 = account.getBalance() - balance;
		account.setBalance(balance1);
		accountDao.update(account);
		
		//거래 내역 추가
		TransactionDTO trans = null;
		trans = new TransactionDTO(MakeAccountNumber.makeTrNum(), sendAcc, balance, "O", desc);
		transDao.insert(trans);
		
		//email 전송
		String uid = account.getHolder();
		UserDTO user = userDao.select(uid);
		
		notification.sendEmail(user.getEmail(), sendAcc + "에서 " + balance + "원이 출금되었습니다. email발송필");
		notification.sendSMS(user.getContact(), sendAcc + "에서 " + balance + "원이 출금되었습니다. SMS발송필");
	}

}
