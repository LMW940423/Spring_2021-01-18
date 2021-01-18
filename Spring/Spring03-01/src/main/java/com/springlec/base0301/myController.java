package com.springlec.base0301;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 선언해주면 컨트롤러로 사용가능하다.
public class myController {

	@RequestMapping("test/view1")
	public String view1() {
		return "test/view1";
	}
	
	@RequestMapping("test/view2") // 굳이 jsp명과 같을 필요없다! return만 정확하게 시키면 된다!
	public String view2(Model model) {
		model.addAttribute("id", "tester");
		return "test/viewid";
	}
	
}
