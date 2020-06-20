package com.cognizant.Rest_Practice_Check_Truyum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.Rest_Practice_Check_Truyum.exception.CartEmptyException;
import com.cognizant.Rest_Practice_Check_Truyum.model.MenuItem;
import com.cognizant.Rest_Practice_Check_Truyum.service.CartService;

@RestController
@RequestMapping("/carts")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@PostMapping("/{userid}/{menuItemId}")
	public void addCartItem(@PathVariable String userid, @PathVariable Long menuItemId)
	{
		cartService.addCartItem(userid, menuItemId);
	}
	
	@GetMapping("/{userid}")
	public List<MenuItem> getAllCartItems(@PathVariable String userid) throws CartEmptyException
	{
		return cartService.getAllCartItems(userid);
	}
	
	@DeleteMapping("/{userid}/{menuItemId}")
	public void deleteCartItem(@PathVariable String userid,@PathVariable long menuItemId)
	{
		cartService.deleteCartItem(userid, menuItemId);
	}

}