package edu.bit.ex.mapper;

import java.util.List;

import edu.bit.ex.vo.EmpVO;

public interface BoardMapper {

	public List<EmpVO> getList();
	
	public List<EmpVO> deptList();

	public void insert(EmpVO empVO);

}
