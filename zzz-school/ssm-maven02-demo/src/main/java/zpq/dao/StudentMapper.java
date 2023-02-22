package zpq.dao;

import java.util.List;

import zpq.domain.Student;

public interface StudentMapper {
				   
	public Student selectStudent();
	
	List<Student> selectAllStudents();
}
