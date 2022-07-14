package com.cg.opna.order.service;

import java.util.List;
import com.cg.opna.order.exception.NoProperDataException;
import com.cg.opna.order.exception.OrderNotFoundException;
import com.cg.opna.order.model.Order;


public interface OrderService {
	public  List<Order> getAllOrders() throws  OrderNotFoundException;
	public Order getOrderById( int id) throws OrderNotFoundException;
	public Order addOrders( Order order)  throws NoProperDataException;
	public String deleteOrder( int id) throws OrderNotFoundException;
}
