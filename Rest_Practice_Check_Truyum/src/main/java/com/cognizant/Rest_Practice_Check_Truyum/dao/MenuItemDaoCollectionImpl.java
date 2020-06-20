package com.cognizant.Rest_Practice_Check_Truyum.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.Rest_Practice_Check_Truyum.model.MenuItem;
import com.cognizant.Rest_Practice_Check_Truyum.util.DateUtil;

@Component
public class MenuItemDaoCollectionImpl implements MenuItemDao {

	private static List<MenuItem> menuItemList = null;

	public MenuItemDaoCollectionImpl() {
		super();
		ApplicationContext context = new ClassPathXmlApplicationContext("truyum.xml");
		menuItemList = context.getBean("menuItems", ArrayList.class);
	
	}

	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		return menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		List<MenuItem> custMenu = new ArrayList<>();
	
		Date date1 = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String compDate = formatter.format(date1);
		Date currentDate = DateUtil.convertToDate(compDate);
		for (MenuItem menu : menuItemList) {
			if ((menu.getDateOfLaunch().compareTo(currentDate) < 0) && menu.isActive()) {
				custMenu.add(menu);
			}
		}

		return custMenu;

	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		for (MenuItem menu : menuItemList) {
			if (menu.getId() == menuItem.getId()) {
				menu.setName(menuItem.getName());
				menu.setPrice(menuItem.getPrice());
				menu.setActive(menuItem.isActive());
				menu.setCategory(menuItem.getCategory());
				menu.setDateOfLaunch(menuItem.getDateOfLaunch());
				menu.setFreeDelivery(menuItem.isFreeDelivery());

			}
		}

	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {

		MenuItem menu1 = null;

		for (MenuItem menu : menuItemList) {
			if (menu.getId() == menuItemId) {
				menu1 = menu;
			}
		}

		return menu1;

	}
}