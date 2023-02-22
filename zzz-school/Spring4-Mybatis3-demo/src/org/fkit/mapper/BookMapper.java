package org.fkit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.fkit.domain.Book;

public interface BookMapper {
	@Select("select * from tb_book")
	List<Book> findAll();
}
