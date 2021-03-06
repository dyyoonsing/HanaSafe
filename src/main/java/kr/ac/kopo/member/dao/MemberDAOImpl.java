package kr.ac.kopo.member.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.member.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public MemberVO login(MemberVO member) {
		MemberVO loginVO = sqlSession.selectOne("member.dao.MemberDAO.login", member);
		
		return loginVO;
	}

	@Override
	public MemberVO selectInformationById(String id) {
		return sqlSession.selectOne("member.dao.MemberDAO.selectInformationById", id);
	}
	
	@Override
	public void updateMyInfo(MemberVO member) {
		sqlSession.update("member.dao.MemberDAO.updateMyInfo", member);
	}

	@Override
	public MemberVO selectIdInfoOfAcc(String accNo) {
		return sqlSession.selectOne("member.dao.MemberDAO.selectIdInfoOfAcc", accNo);
	}


}
