package mapper2;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;

import domain.Employee;

public interface EmployeeMapper {

	@SelectProvider(type = EmployeeDynaSqlProvider.class, method = "selectWhitParam")
	List<Employee> selectWhitParam(Map<String, Object> param);

}

