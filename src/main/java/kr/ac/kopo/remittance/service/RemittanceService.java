package kr.ac.kopo.remittance.service;

import java.util.List;
import java.util.Map;

import kr.ac.kopo.remittance.vo.RemittanceVO;

public interface RemittanceService {
	
	/**
	 * 해외송금 신청
	 * @param remittanceVO
	 */
	void insertRemittance(RemittanceVO remittanceVO);
	
	/**
	 * 해외송금 예약
	 * @param remittanceVO
	 */
	void insertReservation(RemittanceVO remittanceVO);
	
	/**
	 * 모든 해외송금 내역 조회
	 * @param id
	 * @return
	 */
	List<Map<String, Object>> selectAllRemittance(String id);
	
	/**
	 * 해당 remNo의 상세한 송금 내역 조회
	 * @param remNo
	 * @return
	 */
	RemittanceVO selectRemittanceByRemNo(Integer remNo);
	
	/**
	 * 예약된 해외송금 내역 매일 아침 9시마다 해당되면 remittance로
	 * @param remittanceVO
	 */
	void insertRemittanceFromReservation();
	
	/*-------------------------
		ADMIN PAGE
	-------------------------*/
	/**
	* 심사해야할 모든 해외송금내역 조회
	* @return
	*/
	List<Map<String, Object>> selectAllRemittanceAdmin();
	
	/**
	* 송금 총 수 / 대기 수 
	* @return countAll - 총 / countWaiting - 대기중
	*/
	Map<String, Object> selectRemittanceCount();
	
	/**
	* 해외송금 심사 
	* @param remittance
	*/
	void updateStatusRemittance(RemittanceVO remittance);

}
