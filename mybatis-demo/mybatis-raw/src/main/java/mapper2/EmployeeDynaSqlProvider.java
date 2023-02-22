package mapper2;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class EmployeeDynaSqlProvider {

	public String selectWhitParam(Map<String, Object> param) {
		return new SQL() {
			{
				SELECT("*");
				FROM("tb_employee");
				if (param.get("id") != null) {
					WHERE("id=#{id}");
				}
				if (param.get("loginname") != null) {
					WHERE("loginname=#{loginname}");
				}
				if (param.get("password") != null) {
					WHERE("password=#{password}");
				}
				if (param.get("name") != null) {
					WHERE("name=#{name}");
				}
				if (param.get("sex") != null) {
					WHERE("sex=#{sex}");
				}
				if (param.get("age") != null) {
					WHERE("age=#{age}");
				}
				if (param.get("phone") != null) {
					WHERE("phone=#{phone}");
				}
				if (param.get("sal") != null) {
					WHERE("sal=#{sal}");
				}
				if (param.get("state") != null) {
					WHERE("state=#{state}");
				}
			}
		}.toString();

	}
}
