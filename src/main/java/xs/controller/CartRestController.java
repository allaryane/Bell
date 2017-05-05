/**
 *  CartController
 *  [Bell]
 *  Created on : 17-05-01
 *      Author : Ryane Alla
 *  	Email  : allaryane@gmail.com
 *    Copyright (c) 2017 XSoft Development. All rights reserved.
 */
package xs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xs.entity.CartEntity;
import xs.service.CartService;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartRestController
{
    @Autowired CartService cartService;
    
    public String listCartContent()
    {
        return "";
    }
    
    @RequestMapping(value = "{userId}", method= RequestMethod.GET)
    public ResponseEntity<List<CartEntity>> listCart(@PathVariable Long userId)
    {
        try
        {
            List<CartEntity> items = cartService.listCart(userId);
            return ResponseEntity.ok(items);
        }
        catch (ResourceNotFoundException e)
        {
            return ResponseEntity.status(HttpStatus.ACCEPTED.NOT_FOUND).body(null);
        }
    }
    
    @RequestMapping(value = "{userId}/{productId}", method= RequestMethod.GET)
    public ResponseEntity<Void> removeProductFromCart(@PathVariable Long userId, @PathVariable Long productId)
    {
        try
        {
            cartService.removeProductFromCart(userId, productId);
            return ResponseEntity.noContent().build();
        }
        catch (ResourceNotFoundException | EmptyResultDataAccessException e)
        {
            return ResponseEntity.notFound().build();
        }
    }
    
    @RequestMapping(value = "{userId}/{productId}/{quantity}", method= RequestMethod.GET)
    public ResponseEntity<CartEntity> addProductToCart(@PathVariable Long userId, @PathVariable Long productId, @PathVariable Integer quantity)
    {
        try
        {
            CartEntity item = cartService.addProductToCart(userId, productId, quantity);
            return ResponseEntity.ok(item);
        }
        catch (ResourceNotFoundException | EmptyResultDataAccessException e)
        {
            return ResponseEntity.status(HttpStatus.ACCEPTED.NOT_FOUND).body(null);
        }
    }
}
