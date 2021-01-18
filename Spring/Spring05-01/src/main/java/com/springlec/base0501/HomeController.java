package com.springlec.base0501;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping("index")
	public String goIndex() {
		return "index";
	}
	
//	@RequestMapping(method = RequestMethod.GET, value = "student") // GET방식일 때!
//	public String goStudent(HttpServletRequest httpServletRequest, Model model) {
//		System.out.println("RequestMethod.GET");
//		
//		String id = httpServletRequest.getParameter("id");
//		System.out.println("id : " + id);
//		
//		model.addAttribute("studentId", id);
//		
//		return "student/studentId";
//	}
//	
//	@RequestMapping(method = RequestMethod.POST, value = "student") // POST방식일 때! 만약 메소드 이름을 똑같이 쓰고 싶다면 ModelAndView로 리턴하자!
//	public ModelAndView goStudent(HttpServletRequest httpServletRequest) {
//		System.out.println("RequestMethod.POST");
//		
//		String id = httpServletRequest.getParameter("id");
//		System.out.println("id : " + id);
//
//		ModelAndView andView = new ModelAndView();
//		andView.setViewName("student/studentId");
//		andView.addObject("studentId", id);
//		
//		return andView;
//	}
	
	
	// 버전 4에서는 get,post 바뀌어도 상관없이 controller은 둘다 사용가능하다!
	@RequestMapping("student") 
	public String goStudent(HttpServletRequest httpServletRequest, Model model) {
		System.out.println("RequestMethod.GET");
		
		String id = httpServletRequest.getParameter("id");
		System.out.println("id : " + id);
		
		model.addAttribute("studentId", id);
		
		return "student/studentId";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
