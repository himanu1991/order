package com.example.order.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import com.example.order.model.Product;
import com.example.order.utils.OrderUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.order.entity.Order;
import com.example.order.repository.OrderRepository;
import com.example.order.service.OrderService;

/*
 * Service implementation class for Order, use for writing the business logic
 */

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired OrderRepository orderRepository;
	
	@Autowired OrderUtils orderUtils;

	@Override
	public List<Order> createOrder(Order order) {
		List<Order> orderList = new ArrayList<>();
		if (order != null) {
			List<Long> productIds = order.getProductIds();
			if (productIds != null) {
				for (Long productId : productIds) {
					Product product = orderUtils.getProductDetails(productId);
					if (product != null) {
						order.setProductId(productId);
						Order dbOrder = orderRepository.save(order);
						orderList.add(dbOrder);
					}
				}
			}
		}
		return orderList;
	}

}
