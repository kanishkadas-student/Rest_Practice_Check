package com.cognizant.Rest_Practice_Check_Truyum.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cognizant.Rest_Practice_Check_Truyum.exception.CartEmptyException;
import com.cognizant.Rest_Practice_Check_Truyum.model.Cart;
import com.cognizant.Rest_Practice_Check_Truyum.model.MenuItem;

@Component
public class CartDaoCollectionImpl implements CartDao {

	private static HashMap<String, Cart> userCarts = null;

	public CartDaoCollectionImpl() {
		super();

		if (userCarts == null) {
			userCarts = new HashMap<>();
		}
	}

	@Override
	public void addCartItem(String userid, long menuItemId) {

		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		MenuItem menuItem = menuItemDao.getMenuItem(menuItemId);

		if (userCarts.containsKey(userid)) {
			Cart cart = userCarts.get(userid);
			List<MenuItem> menuItemList = cart.getMenuItemList();
			menuItemList.add(menuItem);
			cart.setMenuItemList(menuItemList);
			userCarts.put(userid, cart);

		} else {
			List<MenuItem> menuItemList = new ArrayList<>();
			Cart cart = new Cart(menuItemList, 0.0);
			menuItemList.add(menuItem);
			cart.setMenuItemList(menuItemList);
			userCarts.put(userid, cart);
		}

	}

	@Override
	public List<MenuItem> getAllCartItems(String userid) throws CartEmptyException {
		Cart cart = userCarts.get(userid);

		if (cart == null) {
			throw new CartEmptyException();
		} else {
			List<MenuItem> menuItemList = cart.getMenuItemList();
			double price = (float) 0.0;
			for (MenuItem menu : menuItemList) {
				price += menu.getPrice();
			}

			cart.setTotal(price);
			return menuItemList;
		}
	}

	@Override
	public void removeCartItem(String userid, long menuItemId) {
		Cart cart = userCarts.get(userid);
		List<MenuItem> menuItemList = cart.getMenuItemList();
		Iterator iterator = menuItemList.iterator();
		while (iterator.hasNext()) {
			MenuItem m = (MenuItem) iterator.next();
			if (m.getId() == menuItemId)
				iterator.remove();
		}

	}
}
