package org.easybooks.bookstore.dao.impl;

import java.util.List;

import org.easybooks.bookstore.dao.BaseDAO;
import org.easybooks.bookstore.dao.IBookDAO;
import org.easybooks.bookstore.vo.Book;
import org.hibernate.Query;
import org.hibernate.Session;

public class BookDAO extends BaseDAO implements IBookDAO {
	//实现IBookDAO接口的getBookbyCatalogid()方法
	public List getBookbyCatalogid(Integer catalogid) {
		Session session=getSession();
		String hql="from Book b where b.catalog.catalogid=?";
		Query query=session.createQuery(hql);
		query.setParameter(0, catalogid);
		List books=query.list();
		session.close();
		return books;
	}
	//分页显示图书
	public List getBookbyCatalogidPaging(Integer catalogid, int currentPage,
			int pageSize) {
		Session session=getSession();
		Query query=session.createQuery("from Book b where b.catalog.catalogid=?");
		query.setParameter(0, catalogid);
		//确定起始游标的位置
		int startRow=(currentPage-1)*pageSize;
		query.setFirstResult(startRow);
		query.setMaxResults(pageSize);
		List books=query.list();
		session.close();
		return books;
	}

	//得到某种类型图书的数目
	public int getTotalbyCatalog(Integer catalogid) {
		Session session=getSession();
		Query query=session.createQuery("from Book b where b.catalog.catalogid=?");
		query.setParameter(0, catalogid);
		List books=query.list();
		int totalSize=books.size();
		session.close();
		return totalSize;
	}

	//搜索图书
	public List getRequiredBookbyHql(String hql) {
		Session session=getSession();
		Query query=session.createQuery(hql);
		List books=query.list();
		return books;
	}
	//根据图书号得到图书
	public Book getBookbyId(Integer bookid) {
		Session session=getSession();
		//Hibernate返回Book类的持久对象
		Book book=(Book) session.get(Book.class, bookid);
		session.close();
		return book;
	}
}
