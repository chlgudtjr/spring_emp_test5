package edu.bit.ex.two;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.bit.ex.paging.Criteria;

@Controller
public class BController2 {

	@Autowired
	BService2 bService;
	
	@RequestMapping("/board/list_view22")
	public String list(Model model) throws Exception{
		System.out.println("list_view22()");
		
		model.addAttribute("list", bService.selectEmpList());
		return "board/list_view2";
	}
}
