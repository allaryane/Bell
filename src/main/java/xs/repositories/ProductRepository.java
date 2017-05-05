/**
 * ProductRepository
 * [Bell]
 * Created on : 17-05-01
 * Author : Ryane Alla
 * Email  : allaryane@gmail.com
 * Copyright (c) 2017 XSoft Development. All rights reserved.
 */
package xs.repositories;

import xs.entity.ProductEntity;

import java.util.List;

public interface ProductRepository extends XSRepository<ProductEntity, Long>
{
    
    List<ProductEntity> findByActive(boolean active);
    List<ProductEntity> findByActiveTrue();
    List<ProductEntity> findByActiveFalse();
}
