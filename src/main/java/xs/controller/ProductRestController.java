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

/**
 * Product Rest Controller managing the products life and access.
 */
@RestController
@RequestMapping("/product")
public class ProductRestController
{
    @Autowired ProductService productService;
    
    /**
     * Retrieves all products (active or not).
     * @return retrieved products.
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ProductEntity>> getAll()
    {
        return ResponseEntity.ok(productService.getAll());
    }
    
    /**
     * Retrieves active products.
     * @return retrieved active products.
     */
    @RequestMapping(path = "/active", method = RequestMethod.GET)
    public ResponseEntity<List<ProductEntity>> getActiveTrue()
    {
        return ResponseEntity.ok(productService.getActiveProducts());
    }
    
    /**
     * Retrieves non active products.
     * @return retrieved non active products.
     */
    @RequestMapping(path = "/nonActive", method = RequestMethod.GET)
    public ResponseEntity<List<ProductEntity>> getNonActiveTrue()
    {
        return ResponseEntity.ok(productService.getNonActiveProducts());
    }
    
    /**
     * Lists all products from a given catalog.
     * @param catalogId id of the target catalog.
     * @return catalog's products. Note in case catalogId does not exist an empty body will be returned.
     */
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
    
    /**
     * Gets a product from his given id.
     * @param productId id of the product to be retrieve.
     * @return retrieved product entity.
     */
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
    
    /**
     * Create a new product.
     * @param product product entity to save. Id of the product entity is suppose to be null.
     * @return saved product entity. Id of the saved product will be set after db auto increment operation.
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ProductEntity> create(@RequestBody ProductEntity product)
    {
        return ResponseEntity.ok(productService.create(product));
    }
    
    /**
     * Update an existing product.
     * @param productId id of the product to be updated.
     * @param product product entity to update.
     * @return updated product entity.
     */
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
    
    /**
     * Delete a product given by his id.
     * @param productId d of the product to be deleted.
     * @return nothing.
     */
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
