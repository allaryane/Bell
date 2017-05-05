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

/**
 * Cart Rest Controller allowing to access and modify a user cart. Note only existing products can be added to cart.
 */
@RestController
@RequestMapping("/cart")
public class CartRestController
{
    @Autowired CartService cartService;
    
    /**
     * Lists cart content for the given user.
     * @param userId id of the user for which the cart content must retrieved.
     * @return cart content as JSON.
     */
    @RequestMapping(value = "{userId}", method= RequestMethod.GET)
    public ResponseEntity<List<CartEntity>> listCartContent(@PathVariable Long userId)
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
    
    /**
     * Removes an item from the cart of the given user.
     * @param userId if of the target user.
     * @param productId product's id to remove.
     * @return nothing.
     */
    @RequestMapping(value = "{userId}/{productId}", method= RequestMethod.DELETE)
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
    
    /**
     * Adds a new cart item for a given.
     * @param userId if of the target user.
     * @param productId product's id to add.
     * @param quantity quantity of added product.
     * @return saved cart entity.
     */
    @RequestMapping(method= RequestMethod.POST)
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
