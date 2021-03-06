package kr.ac.kopo.exchange.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.exchange.dao.ExchangeDAO;
import kr.ac.kopo.exchange.vo.ExchangeVO;
@Service
public class ExchangeServiceImpl implements ExchangeService {

	@Autowired
	ExchangeDAO exchangeDAO;
	
	@Override
	public List<ExchangeVO> selectAllExchangeRate() {
		return exchangeDAO.selectAllExchangeRate();
	}

	@Override
	public List<Map<String, Object>> selectExchangeRateForIndex() {
		return exchangeDAO.selectExchangeRateForIndex();
	}

}
