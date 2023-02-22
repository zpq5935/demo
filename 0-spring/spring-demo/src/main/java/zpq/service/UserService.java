package zpq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zpq.dao.UserDao;

//@Service
public class UserService {
//	@Autowired
	UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void add() {
		userDao.add();
	}
}
