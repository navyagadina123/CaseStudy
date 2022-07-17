package com.cg.opna.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.opna.order.exception.NoProperDataException;
import com.cg.opna.order.exception.OrderNotFoundException;
import com.cg.opna.order.model.Order;
import com.cg.opna.order.repository.OrderRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

@Autowired
private OrderRepository orderRepository;

@Override
public List<Order> getAllOrders() throws OrderNotFoundException {
	log.info("get all orders from here");
	return orderRepository.findAll();
}



@Override
public Order getOrderById(int id) throws OrderNotFoundException {
	Order orders=orderRepository.findById(id).orElseThrow(()-> new  OrderNotFoundException("order Not Found"+id));

	return orders;
}


@Override
public Order addOrders(Order order) throws NoProperDataException {
	log.info("start");
	if(order!=null) 
	{
		orderRepository.save(order);
		log.debug("orders added");
	}
	else
	{
		throw new NoProperDataException("Please fill fields");
	}
	return order;
}





@Override
public String deleteOrder(int id) throws OrderNotFoundException {
	log.info("Start delete");
	var isRemoved =orderRepository.findById(id);
	if(isRemoved.isPresent())
	{
		orderRepository.deleteById(id);
		log.debug("deleted successfully {}",isRemoved.get());
	}
	else
	{
		throw new OrderNotFoundException("Id Not Available");
	}
	log.info(" deleted End");
	return " deleted successfully";
}


}
