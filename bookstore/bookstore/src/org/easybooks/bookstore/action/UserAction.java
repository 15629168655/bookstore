package org.easybooks.bookstore.action;

import java.util.Map;

import org.easybooks.bookstore.dao.IUserDAO;
import org.easybooks.bookstore.service.IUserService;
import org.easybooks.bookstore.vo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	//属性user，用于接收从界面输入的用户信息
	private User user;
	//属性userService用于帮助action完成相关的操作
	protected IUserService userService;
	//用户注册，调用Service层的saveUser()方法
	public String register() throws Exception{
		userService.saveUser(user);
		return SUCCESS;
	}
	//用户登陆
	public String execute() throws Exception {
		boolean validated=false;
		User u=userService.validateUser(user.getUsername(), user.getPassword());
		if(u!=null){
			Map session=ActionContext.getContext().getSession();
			//保存此次会话的u（用户账号）信息
			session.put("user", u);
			return SUCCESS;
		}
		return ERROR;
	}
	//用户注销，去掉会话中的用户账号信息即可，无须调用Service层
	public String logout() throws Exception {
		Map session=ActionContext.getContext().getSession();
		session.remove("user");
		return SUCCESS;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user=user;
	}
	public IUserService getUserService() {
		return userService;
	}
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
}
