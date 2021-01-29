package edu.bit.ex.service;

import java.util.List;

import edu.bit.ex.vo.EmpVO;

public interface BoardService {

	public List<EmpVO> getList();

	public void inputBoard(EmpVO empVO);

	public List<EmpVO> deptList();

}
