package org.easybooks.bookstore.dao;

import org.easybooks.bookstore.vo.User;


public interface IUserDAO {
	//用户注册时，保存注册信息
	public void saveUser(User user);
	//用户登陆时，验证用户信息
	public User validateUser(String username,String password);
	public boolean exitUser(String username);
}
