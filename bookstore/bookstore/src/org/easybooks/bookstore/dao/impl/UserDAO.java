package org.easybooks.bookstore.dao.impl;

import java.util.List;

import org.easybooks.bookstore.dao.BaseDAO;
import org.easybooks.bookstore.dao.IUserDAO;
import org.easybooks.bookstore.vo.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDAO extends BaseDAO implements IUserDAO{
	//��֤�û���Ϣ�������ȷ������һ��Userʵ�������򷵻�null
	public User validateUser(String username, String password) {
		String sql="from User u where u.username=? and u.password=?";
		Session session=getSession();
		Query query=session.createQuery(sql);
		query.setParameter(0, username);
		query.setParameter(1, password);
		List users=query.list();
		if(users.size()!=0){
			User user=(User)users.get(0);
			return user;
		}
		session.close();
		return null;
	}
	//�����û���ע����Ϣ�����ݿ���
	public void saveUser(User user) {
		Session session=getSession();
		Transaction tx=session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();
	}
	public boolean exitUser(String username){
		Session session=getSession();
		String hql="from User u where u.username=?";
		Query query=session.createQuery(hql);
		query.setParameter(0, username);
		List users=query.list();
		if(users.size()!=0){
			User user=(User)users.get(0);
			return true;
		}
		session.close();
		return false;
	}

}
