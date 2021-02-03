package edu.bit.ex.emp;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import edu.bit.ex.mapper.BoardMapper;
import edu.bit.ex.vo.EmpVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") // 커넥션풀 연결
@Log4j
public class TestDeptno {
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
		
	@Test
	public void testMapper() {
		assertNotNull(mapper);;
	}
	
}
