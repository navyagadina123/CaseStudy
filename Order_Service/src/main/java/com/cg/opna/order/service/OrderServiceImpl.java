package com.cg.opna.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public ResponseEntity<List<Order>> getAllOrders() throws OrderNotFoundException {
	log.info("get all orders from here");
	return new  ResponseEntity<>(orderRepository.findAll(),HttpStatus.OK);
}



@Override
public ResponseEntity<Order> getOrderById(int id) throws OrderNotFoundException {
	Order orders=orderRepository.findById(id).orElseThrow(()-> new  OrderNotFoundException("order Not Found"+id));

	return ResponseEntity.ok().body(orders);
}


@Override
public ResponseEntity<Order> addOrders(Order order) throws NoProperDataException {
	log.info("start");
	if(order!=null) 
	{
		orderRepository.save(order);
		System.out.println("orders added");
	}
	else
	{
		throw new NoProperDataException("Please fill fields");
	}
	return ResponseEntity.ok(order);
}




@Override
public ResponseEntity<Order> updateOrder(Order order, int id) throws OrderNotFoundException {
Order orders=orderRepository.findById(id).orElseThrow(()-> new OrderNotFoundException("order not "+id));
	
	orders.setBookingOrderId(order.getBookingOrderId());
	orders.setOrderDate(order.getOrderDate());
	orders.setQuantity(order.getQuantity());
	orders.setTotalCost(order.getTotalCost());
	orders.setTransactionMode(order.getTransactionMode());
	final Order updatedOrder = orderRepository.save(order);
	return ResponseEntity.ok(updatedOrder);
}


@Override
public ResponseEntity<String> deleteOrder(int id) throws OrderNotFoundException {
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
	return ResponseEntity.ok(id+" deleted successfully");
}


}
