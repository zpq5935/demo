package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;


import pojo.Student;

public interface StudentMapperAnnotation {

	@Select("select * from tb_student where clazz_id = #{id}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="name",property="name"),
		@Result(column="sex",property="sex"),
		@Result(column="age",property="age"),
	})
	List<Student> selectAllStudentByClazzId(Integer clazz_id);
}
