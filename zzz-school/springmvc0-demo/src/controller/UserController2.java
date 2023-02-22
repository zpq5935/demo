package controller;

import java.util.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import domain.User2;

@Controller
public class UserController2 {
	@RequestMapping(value="register",method=RequestMethod.GET)
	public String registerForm(Model model){
		User2 user = new User2();
		user.setAge(25);
		user.setSex("男");
		user.setUsername("jack");
		List<String> courses = new ArrayList<String>();
		courses.add("JAVAEE");
		courses.add("C++");
		user.setDeptId(2);
		user.setCourses(courses);
		//
//		User2 user2 = new User2();
//		user2.setAge(35);
//		user2.setSex("女");
//		user2.setUsername("jackson");
//		List<String> courses2 = new ArrayList<String>();
//		courses2.add("PHP");
//		courses2.add("C++");
//		user2.setCourses(courses2);
		//
		List<String> courseList = new ArrayList<String>();
		courseList.add("JAVAEE");
		courseList.add("C++");
		courseList.add("PHP");
		courseList.add("android");
		//
		User2 user22 = new User2();
		user22.setDeptId(3);
		model.addAttribute("userFSelect", user22);
		Map<Integer, String> deptMap = new HashMap<>();
		deptMap.put(1, "财务部");
		deptMap.put(2, "开发部");
		deptMap.put(3, "销售部");
		//
		model.addAttribute("deptMap", deptMap);
		model.addAttribute("user", user);
		//model.addAttribute("user2", user2);
		model.addAttribute("courseList", courseList);
		return "/jsp/registerForm.jsp";
	}

}
