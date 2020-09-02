package kr.ac.kopo.account.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.account.vo.AccountVO;
@Repository
public class AccountDAOImpl implements AccountDAO {

	@Autowired
	SqlSessionTemplate session;
	
	@Override
	public List<AccountVO> selectAccountList(String id) {
		return session.selectList("account.dao.AccountDAO.selectAccountList", id);
	}

}