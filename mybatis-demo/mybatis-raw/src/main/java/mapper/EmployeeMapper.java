package mapper;

import java.util.*;

import domain.Employee;

public interface EmployeeMapper {

	List<Employee> selectEmployeeByIdLike(HashMap<String, Object> params);
	
	List<Employee> selectEmployeeChoose(HashMap<String, Object> params);
	
	List<Employee> selectEmployeeLike(HashMap<String, Object> params);
	
	int insertEmployee(Employee employee);
}
