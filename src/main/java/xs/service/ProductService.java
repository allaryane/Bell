/**
 *  ProductManager
 *  [Bell]
 *  Created on : 17-05-04
 *      Author : Ryane Alla
 *  	Email  : allaryane@gmail.com
 *    Copyright (c) 2017 XSoft Development. All rights reserved.
 */
package xs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xs.entity.ProductEntity;
import xs.repositories.ProductRepository;

import java.util.List;

@Service
@Transactional
public class ProductService extends XSAbstractService
{
    @Autowired ProductRepository productRepository;
    
    public ProductService()
    {
    }
    
    public List<ProductEntity> getAll()
    {
        return productRepository.findAll();
    }
    
    public List<ProductEntity> getActiveProducts()
    {
        return productRepository.findByActiveTrue();
    }
    
    public List<ProductEntity> getNonActiveProducts()
    {
        return productRepository.findByActiveFalse();
    }
    
    public List<ProductEntity> getProductsByCatalogId(Long catalogId)
    {
        return productRepository.findByCatalogId(catalogId);
    }
    
    public ProductEntity getProductById(Long productId)
    {
        return productRepository.findOne(productId);
    }
    
    public ProductEntity create(ProductEntity product)
    {
        return productRepository.save(product);
    }
    
    public ProductEntity update(ProductEntity product)
    {
        return productRepository.save(product);
    }
    
    public void delete(ProductEntity product)
    {
        productRepository.delete(product);
    }
    
    public void deleteById(Long productId)
    {
        productRepository.delete(productId);
    }

    public Page<ProductEntity> getAll(Integer page, Integer size)
    {
        Page pageOfProducts = productRepository.findAll(new PageRequest(page, size));
        return pageOfProducts;
    }
}
