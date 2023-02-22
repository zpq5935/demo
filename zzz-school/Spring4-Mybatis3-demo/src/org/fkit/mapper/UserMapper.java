package org.fkit.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.fkit.domain.User;

public interface UserMapper {

	@Select("select * from tb_user where loginname=#{loginname} and password = #{password}")
	User findWithLoginnameAndPassword(
			@Param("loginname")String loginname,
			@Param("password")String password);
}
