package org.easybooks.bookstore.service;

import java.util.List;

import org.easybooks.bookstore.vo.Book;

public interface IBookService {
	//通过图书类别id号，得到相应类别的图书
	public List getBookbyCatalogid(Integer catalogid);
	public List getBookbyCatalogidPaging(Integer catalogid,int currentPage,int pageSize);
	public int getTotalbyCatalog(Integer catalogid);
	public List getRequiredBookbyHql(String hql);
	//根据图书号得到图书
	public Book getBookbyId(Integer bookid);
}
