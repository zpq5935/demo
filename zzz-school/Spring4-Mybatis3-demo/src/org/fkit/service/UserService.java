package org.fkit.service;

import org.fkit.domain.User;

public interface UserService {

	User login(String loginname,String password);
}
