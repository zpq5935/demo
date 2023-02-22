package mapper;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import pojo.Clazz;

public interface ClazzMapperAnnotation {
	@Select("select * from tb_clazz where id=#{id}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="code",property="code"),
		@Result(column="name",property="name"),
		@Result(column="id",property="students",
				many=@Many(
						select="mapper.StudentMapperAnnotation.selectAllStudentByClazzId",
						fetchType=FetchType.LAZY))
	})
	Clazz selectById(Integer id);
}
