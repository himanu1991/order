package com.example.order.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.order.entity.Order;

/*
 * Service for Order
 */
@Service
public interface OrderService {

	public List<Order> createOrder(Order order);
}
