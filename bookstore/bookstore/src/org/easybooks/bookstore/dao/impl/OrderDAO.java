package org.easybooks.bookstore.dao.impl;

import org.easybooks.bookstore.dao.BaseDAO;
import org.easybooks.bookstore.dao.IOrderDAO;
import org.easybooks.bookstore.vo.Orders;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OrderDAO extends BaseDAO implements IOrderDAO{

	//保存购物信息
	public Orders saveOrder(Orders order) {
		Session session=getSession();
		Transaction tx=session.beginTransaction();
		session.save(order);
		tx.commit();
		session.close();
		return order;
	}
	
}
