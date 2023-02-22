package dao;





import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import po.Student;

public class studentDao {
	
	@Test
	public void test01(){
		Configuration conf = new Configuration().configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		Student stu = new Student();
		stu.setCET4(111);
		stu.setCET6(222);
		stu.setDepartment("Abc");
		//stu.setId(5);
		stu.setSname("小章");
		stu.setSno("154341");
		Transaction tran = session.beginTransaction();
		session.save(stu);
		tran.commit();
		session.close();
	}

}
