package test;


import factory.MySqlSessionFactory;
import mapper.UserMapperAnnotation;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.Clazz;
import pojo.Student;
import pojo.User;

import java.util.List;
import java.util.Map;

public class test01 {

	public static void main(String[] args) throws Exception {
		System.out.println("test()-->");
		// InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
		// SqlSessionFactory sqlSessionFactory = new
		// SqlSessionFactoryBuilder().build(in);
		// 获取SqlSession
		SqlSession sqlSession = MySqlSessionFactory.getSqlSession();

		User user = new User("admin", "男", 26);
		// 新增用户
//		sqlSession.insert("mapper.UserMapper.saveUser", user);


		UserMapperAnnotation mapper = sqlSession.getMapper(UserMapperAnnotation.class);
		mapper.saveUser(user);

		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void testSelect() {
		SqlSession sqlSession = MySqlSessionFactory.getSqlSession();
		User user = sqlSession.selectOne("mapper.UserMapper.selectUser", 40);
		if (user != null)
			System.out.println(user);
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void testUpdate() {
		SqlSession sqlSession = MySqlSessionFactory.getSqlSession();
		User user = new User("张三", "女", 11);
		user.setId(40);
		sqlSession.update("mapper.UserMapper.updateUser", user);
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void testDelete() {
		SqlSession sqlSession = MySqlSessionFactory.getSqlSession();
		sqlSession.delete("mapper.UserMapper.deleteUser", 39);
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void testSelectMap01() {
		SqlSession sqlSession = MySqlSessionFactory.getSqlSession();
		List<Map<String,Object>> list = sqlSession.selectList("mapper.UserMapper.selectUser_Map");
		for(Map<String, Object> row:list)
			System.out.println(row);
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void testSelectMap02() {
		SqlSession sqlSession = MySqlSessionFactory.getSqlSession();
		List<User> list = sqlSession.selectList("mapper.UserMapper.selectUser2_resultMap");
		for(User user:list)
			System.out.println(user);
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void testSelectStudent(){
		SqlSession sqlSession = MySqlSessionFactory.getSqlSession();
		List<Student> list = sqlSession.selectList("mapper.UserMapper.selectStudent");
		for(Student stu:list){
			System.out.println(stu);
		}
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void testSelectClazz(){
		SqlSession sqlSession = MySqlSessionFactory.getSqlSession();
		List<Clazz> list = sqlSession.selectList("mapper.UserMapper.selectClazz");
		for(Clazz cla:list){
			System.out.println(cla);
			List<Student> stu_list = cla.getStudents();
			for(Student stu:stu_list){
				System.out.println(stu);
			}
		}
		sqlSession.commit();
		sqlSession.close();
	}
}





