/**
 *  CartManager
 *  [Bell]
 *  Created on : 17-05-04
 *      Author : Ryane Alla
 *  	Email  : allaryane@gmail.com
 *    Copyright (c) 2017 XSoft Development. All rights reserved.
 */
package xs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xs.entity.CartEntity;
import xs.repositories.CartRepository;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Service
@Transactional
public class CartService extends XSAbstractService
{
    @Autowired CartRepository cartRepository;
    
    public CartService()
    {
    }
    
    public CartEntity addProductToCart(Long userId, Long productId, Integer quantity)
    {
        CartEntity cartItem = new CartEntity();
        cartItem.setUserId(userId);
        cartItem.setProductId(productId);
        cartItem.setQuantity(quantity);
        cartItem.setCreatedDate(Timestamp.from(Instant.now()));
        return cartRepository.save(cartItem);
    }
    
    public void removeProductFromCart(Long userId, Long productId)
    {
        cartRepository.deleteByUserIdAndProductId(userId, productId);
    }
    
    public List<CartEntity> listCart(Long userId)
    {
        return cartRepository.findByUserId(userId);
    }
}
