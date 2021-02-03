package edu.bit.ex.controller;

import java.text.DateFormat;

import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.bit.ex.paging.Criteria;
import edu.bit.ex.paging.PageVO;
import edu.bit.ex.service.BoardService;
import edu.bit.ex.vo.EmpVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */
@Log4j
@AllArgsConstructor
@Controller
public class listController {
	
	private BoardService boardService;
	
	@PostMapping("/input")
	public String input(EmpVO empVO, Model model) throws Exception{
		log.info("input()");
		boardService.inputBoard(empVO);
		
		return "redirect:/board/check";
	}
	
	@GetMapping("/board/input_view")
	public String input_view(Model model) {
		log.info("input_view");
		model.addAttribute("list", boardService.getList());
		model.addAttribute("list1", boardService.deptList());
		
		return "/board/input_view";
	}
	
	@GetMapping("/board/check")
	public String check(Model model) {
		log.info("check");
		
		return "/board/check";
	}
	
	@GetMapping("/board/list_view")
	public void list_view(Model model) {
		log.info("list_view");
		model.addAttribute("list", boardService.getList());
		System.out.println( boardService.getList().size());// 값이 넘어가는지 확인
	
	}
	
	@GetMapping("/board/list_view2")
	public void list_view2(Criteria cri,Model model) {
		log.info("list_view2");
		log.info("cri");
		model.addAttribute("list", boardService.getList(cri));
		
		int total = boardService.getTotal(cri);
		log.info("total");
		model.addAttribute("pageMaker", new PageVO(cri,total));
		
	}
	
}
