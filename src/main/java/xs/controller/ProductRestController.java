/**
 *  ProductController
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
import org.springframework.web.bind.annotation.*;
import xs.entity.ProductEntity;
import xs.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductRestController
{
    @Autowired ProductService productService;
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ProductEntity>> getAll()
    {
        return ResponseEntity.ok(productService.getAll());
    }
    
    @RequestMapping(path = "/active", method = RequestMethod.GET)
    public ResponseEntity<List<ProductEntity>> getActiveTrue()
    {
        return ResponseEntity.ok(productService.getActiveProducts());
    }
    
    @RequestMapping(path = "/nonActive", method = RequestMethod.GET)
    public ResponseEntity<List<ProductEntity>> getNonActiveTrue()
    {
        return ResponseEntity.ok(productService.getNonActiveProducts());
    }
    
    @RequestMapping(path="/catalog/{catalogId}", method = RequestMethod.GET)
    public ResponseEntity<List<ProductEntity>> getProductsByCatalogId(@PathVariable Long catalogId)
    {
        try
        {
            List<ProductEntity> products = productService.getProductsByCatalogId(catalogId);
            return ResponseEntity.ok(products);
        }
        catch (ResourceNotFoundException e)
        {
            return ResponseEntity.status(HttpStatus.ACCEPTED.NOT_FOUND).body(null);
        }
    }
    
    @RequestMapping(value = "{productId}", method=RequestMethod.GET)
    public ResponseEntity<ProductEntity> getProductById(@PathVariable Long productId)
    {
        try
        {
            ProductEntity product = productService.getProductById(productId);
            return ResponseEntity.ok(product);
        }
        catch (ResourceNotFoundException e)
        {
            return ResponseEntity.status(HttpStatus.ACCEPTED.NOT_FOUND).body(null);
        }
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ProductEntity> create(@RequestBody ProductEntity product)
    {
        return ResponseEntity.ok(productService.create(product));
    }
    
    @RequestMapping(method = RequestMethod.PUT, value="{productId}")
    public ResponseEntity<ProductEntity> update(@PathVariable Long productId, @RequestBody ProductEntity product)
    {
        try
        {
            product.setId(productId);
            return ResponseEntity.ok(productService.update(product));
        }
        catch (ResourceNotFoundException e)
        {
            return ResponseEntity.status(HttpStatus.ACCEPTED.NOT_FOUND).body(null);
        }
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value="{productId}")
    public ResponseEntity<Void> delete(@PathVariable Long productId)
    {
        try
        {
            productService.deleteById(productId);
            return ResponseEntity.noContent().build();
        }
        catch (ResourceNotFoundException | EmptyResultDataAccessException e)
        {
            return ResponseEntity.notFound().build();
        }
    }
    
}
