package com.springlec.base0401;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("board/confirmId")
	public String confirmId(HttpServletRequest httpServletRequest, Model model) {
		
		String id = httpServletRequest.getParameter("id");
		String pw = httpServletRequest.getParameter("pw");
		
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		return "board/confirmid";
	}
	
	
	
	// 위에 방식을 Spring에서 제공하는 RequestParam으로 보다 간편하게 사용가능하다.
	@RequestMapping("board/checkId")
	public String checkId(@RequestParam("id") String id, @RequestParam("pw") int pw, Model model) {
		
		model.addAttribute("identify", id);
		model.addAttribute("password", pw);
		
		return "board/checkId";
		
	}
	
	@RequestMapping("board/join") // bean에 넣어서 한번에 보내는 방법 (버전 4)
	public String join(@RequestParam("id") String id, @RequestParam("pw") String pw, 
						@RequestParam("name") String name, @RequestParam("email") String email, Model model) {
		
		Member member = new Member();
		member.setId(id);
		member.setPw(pw);
		member.setName(name);
		member.setEmail(email);
		
		model.addAttribute("member", member); // join.jsp에서 member로 써놨기 때문에 그대로 인식한다.
		
		return "board/join";
		
	}
	
	@RequestMapping("board/join2") // 빈을 아예 넣어버리는 방법! (매우 효율적이고 간단하다! 이걸로 쓰자)
	public String join2(Member member) {
		return "board/join";
	}
	
	// 네이버에서 쓰는 방식! {}안의 내용은 Data! PathVariable이 {studentId}의 값을 가져온다.
	// PathVariable 당 {} 하나씩 대응!
	// {}안에 bean을 넣어 가져오기도 한다!
	@RequestMapping("student/{studentId}") 
	public String student(@PathVariable String studentId, Model model) {
	
		model.addAttribute("studentId", studentId);
	
		return "board/studentView";
	}
	
	
	
	
	
	
	
	
	
	
	
}
