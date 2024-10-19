package com.example.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.order.entity.Order;
import com.example.order.service.OrderService;

/*
 * This is the controller class for order
 */

@RestController
public class OrderController {
	
	@Autowired OrderService orderService;
	
	
	/*
	 * This API is useful for creating order
	 */
	@PostMapping("/orders")
	public ResponseEntity<Object> createOrder(@RequestBody Order order) {
		List<Order> dbOrders = orderService.createOrder(order);
		return new ResponseEntity<Object> (dbOrders, HttpStatus.OK);
		
	}

}
