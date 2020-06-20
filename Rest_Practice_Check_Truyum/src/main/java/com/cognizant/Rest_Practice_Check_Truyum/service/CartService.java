package com.cognizant.Rest_Practice_Check_Truyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.Rest_Practice_Check_Truyum.dao.CartDaoCollectionImpl;
import com.cognizant.Rest_Practice_Check_Truyum.exception.CartEmptyException;
import com.cognizant.Rest_Practice_Check_Truyum.model.MenuItem;

@Service
public class CartService {
	@Autowired
	private CartDaoCollectionImpl cartdao;

	public void addCartItem(String userid, long menuItemId) {
		cartdao.addCartItem(userid, menuItemId);
	}

	public List<MenuItem> getAllCartItems(String userid) throws CartEmptyException {
		List<MenuItem> allCartItems = cartdao.getAllCartItems(userid);
		return allCartItems;
	}
	
	public void deleteCartItem(String userid, long menuItemId)
	{
		cartdao.removeCartItem(userid, menuItemId);
	}
	
}