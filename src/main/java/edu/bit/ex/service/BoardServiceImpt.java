package edu.bit.ex.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.bit.ex.mapper.BoardMapper;
import edu.bit.ex.paging.Criteria;
import edu.bit.ex.vo.EmpVO;
import jdk.internal.org.jline.utils.Log;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
@Service
public class BoardServiceImpt implements BoardService{
	private BoardMapper mapper;
	
	@Override
	public List<EmpVO> getList() {
		log.info("getList..........");
		return mapper.getList();
	}

	@Override
	public void inputBoard(EmpVO empVO) {
		mapper.insert(empVO);
	}

	@Override
	public List<EmpVO> deptList() {
		log.info("deptList..........");
		return mapper.deptList();
	}

	@Override
	public List<EmpVO> getList(Criteria cri) {
		log.info("getListWithCriteria");
		return mapper.getListWithCriteria(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		log.info("getTotalCount");
		return mapper.getTotalCount(cri);
	}

}
