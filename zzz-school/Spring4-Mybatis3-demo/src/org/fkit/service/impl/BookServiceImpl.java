package org.fkit.service.impl;

import java.util.List;

import org.fkit.domain.Book;
import org.fkit.mapper.BookMapper;
import org.fkit.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bookService")
public class BookServiceImpl implements BookService {
	@Autowired
	private BookMapper bookMapper;

	@Override
	public List<Book> getAll() {
		return bookMapper.findAll();
	}
}
