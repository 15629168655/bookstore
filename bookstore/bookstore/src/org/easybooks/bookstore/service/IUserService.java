package org.easybooks.bookstore.service;

import org.easybooks.bookstore.vo.User;

public interface IUserService {
	//保存注册信息
	public void saveUser(User user);
	//验证用户信息
	public User validateUser(String username,String password);
	public boolean exitUser(String username);
}
