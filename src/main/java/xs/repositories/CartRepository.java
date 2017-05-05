/**
 * CartRepository
 * [Bell]
 * Created on : 17-05-04
 * Author : Ryane Alla
 * Email  : allaryane@gmail.com
 * Copyright (c) 2017 XSoft Development. All rights reserved.
 */
package xs.repositories;

import xs.entity.CartEntity;

import java.util.List;

public interface CartRepository extends XSRepository<CartEntity, Long>
{
    List<CartEntity> findByUser_ActiveTrue();
    List<CartEntity> findByUserId(Long userId);
    List<CartEntity> findByQuantityGreaterThanEqual(Integer quantity);
    List<CartEntity> findByUser_EmailEquals(String email);
    void deleteByUserIdAndProductId(Long userId, Long productId);
}
