package kr.ac.kopo.account.service;

import java.util.List;

import kr.ac.kopo.account.vo.AccountVO;

public interface AccountService {

	/**
	 * 해당 아이디의 모든 계좌 조회
	 * @param id 아이디
	 * @return  계좌 list
	 */
	List<AccountVO> selectAccountList(String id);
}
