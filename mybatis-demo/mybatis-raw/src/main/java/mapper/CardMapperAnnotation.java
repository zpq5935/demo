package mapper;

import org.apache.ibatis.annotations.Select;

import domain.Card;

public interface CardMapperAnnotation {

	@Select("select * from tb_card where id=#{id}")
	Card selectCardById(Integer id);
}
