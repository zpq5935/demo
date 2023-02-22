package controller;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import domain.Book;


@Controller
public class BookController {

	@RequestMapping("/main")
	public String main(Model model){
		List<Book> book_list = new ArrayList<Book>();
		book_list.add(new Book("疯狂Java讲义", "李刚", 74.2));
		book_list.add(new Book("轻量级JavaEE企业应用实战", "李刚", 59.2));
		book_list.add(new Book("疯狂Android讲义", "李刚", 60.6));
		book_list.add(new Book("疯狂Ajax讲义", "李刚", 66.6));
		model.addAttribute("book_list",book_list);
		return "/WEB-INF/jsp/main.jsp";
	}
}
