package org.easybooks.bookstore.service;

import org.easybooks.bookstore.vo.Orders;

public interface IOrderService {
	//保存购物信息
	public Orders saveOrder(Orders order);
}
