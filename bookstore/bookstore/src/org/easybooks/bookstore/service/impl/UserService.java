package org.easybooks.bookstore.service.impl;

import org.easybooks.bookstore.dao.IUserDAO;
import org.easybooks.bookstore.service.IUserService;
import org.easybooks.bookstore.vo.User;

public class UserService implements IUserService {
	private IUserDAO userDAO;
	//验证用户信息
	public User validateUser(String username, String password) {
		return userDAO.validateUser(username, password);
	}
	//保存注册信息
	public void saveUser(User user) {
		this.userDAO.saveUser(user);
	}
	public boolean exitUser(String username){
		return userDAO.exitUser(username);
	}

	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
