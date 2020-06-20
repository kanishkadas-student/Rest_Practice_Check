package com.cognizant.Rest_Practice_Check_Truyum.dao;

import java.util.List;

import com.cognizant.Rest_Practice_Check_Truyum.exception.CartEmptyException;
import com.cognizant.Rest_Practice_Check_Truyum.model.MenuItem;

public interface CartDao {

	public void addCartItem(String userid, long menuItemId);

	public List<MenuItem> getAllCartItems(String userid) throws CartEmptyException;

	public void removeCartItem(String userid, long menuItemId);

}