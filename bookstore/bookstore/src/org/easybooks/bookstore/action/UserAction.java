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
	//����user�����ڽ��մӽ���������û���Ϣ
	private User user;
	//����userService���ڰ���action�����صĲ���
	protected IUserService userService;
	//�û�ע�ᣬ����Service���saveUser()����
	public String register() throws Exception{
		userService.saveUser(user);
		return SUCCESS;
	}
	//�û���½
	public String execute() throws Exception {
		boolean validated=false;
		User u=userService.validateUser(user.getUsername(), user.getPassword());
		if(u!=null){
			Map session=ActionContext.getContext().getSession();
			//����˴λỰ��u���û��˺ţ���Ϣ
			session.put("user", u);
			return SUCCESS;
		}
		return ERROR;
	}
	//�û�ע����ȥ���Ự�е��û��˺���Ϣ���ɣ��������Service��
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
