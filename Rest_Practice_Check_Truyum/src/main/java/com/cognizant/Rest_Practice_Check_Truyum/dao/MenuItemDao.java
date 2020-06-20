package com.cognizant.Rest_Practice_Check_Truyum.dao;

import java.util.List;

import com.cognizant.Rest_Practice_Check_Truyum.model.MenuItem;

public interface MenuItemDao {
	public List<MenuItem> getMenuItemListAdmin();

	public List<MenuItem> getMenuItemListCustomer();

	public void modifyMenuItem(MenuItem menuItem);

	public MenuItem getMenuItem(long menuItemId);

}