package edu.bit.ex.two;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import edu.bit.ex.paging.Criteria;
import edu.bit.ex.vo.EmpVO;

@Service
public class BService2 {
	
	@Inject
	SqlSession sqlSession;
	
	public List<EmpVO> selectEmpList() throws Exception{
		return sqlSession.selectList("list.selectEmpList");
	}
}
