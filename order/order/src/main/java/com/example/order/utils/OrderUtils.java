package com.example.order.utils;

import java.net.http.HttpClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.order.model.Product;

/*
 * Utility class for Order
 */
@Component
public class OrderUtils {
	
	@Value("product.service.url")
	String productServiceURL;
	
	/*
	 * Util method for fetch the details of product by id
	 */
	public Product getProductDetails(Long produtId) {
		String url = productServiceURL + "product/" + produtId;
		RestTemplate restTemplate = new RestTemplate();
		
		Product product = null;
		/*
		 * HttpHeaders headers = new HttpHeaders(); //Its a dummy oAuth token
		 * headers.add("oAuth", "erfewrewrewdfewdewew"); String url = productServiceURL
		 * + "product/" + produtId;
		 * 
		 * HttpEntity<Product> entity = new HttpEntity<>(headers); //HttpClient
		 */		
		ResponseEntity<Product> responseEntity  = restTemplate.getForEntity(url, Product.class);
		if (responseEntity != null) {
			product = responseEntity.getBody();
		}
		
		return product;
	}

}
