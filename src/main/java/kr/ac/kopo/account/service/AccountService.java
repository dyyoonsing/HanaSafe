package kr.ac.kopo.account.service;

import java.util.List;
import java.util.Map;

import kr.ac.kopo.remittance.vo.RemittanceVO;
import kr.ac.kopo.account.vo.AccountVO;

public interface AccountService {

	/**
	 * 해당 아이디의 모든 계좌 조회
	 * @param id 아이디
	 * @return  계좌 list
	 */
	List<AccountVO> selectAccountList(String id);
	
	/**
	 * 해당 계좌의 잔액 조회
	 * @param accNo 계좌번호
	 * @return String 잔액(콤마, 소수점 표시)
	 */
	String selectAccountBalance(String accNo);
	
	/**
	 * 해당 계좌의 모든 정보 조회
	 * @param accNo
	 * @return
	 */
	AccountVO selectAccountByAccNo(String accNo);
	/**
	 * 송금하면 계좌에서 돈 나감
	 * @param statement
	 */
	void updateRemittanceAmount(RemittanceVO remittanceVO);
	
	/**
	 * 해당 id의 총자산 계산 ( 통화별로 분류)
	 * @param id
	 * @return currency, balance
	 */
	List<Map<String, Object>> selectBalanceSumGroupByCurrency(String id);
	
	/**
	 * 유저 계좌중 대표계좌 조회
	 * @param id
	 * @return
	 */
	AccountVO selectFavoriteAccount(String id);

}
