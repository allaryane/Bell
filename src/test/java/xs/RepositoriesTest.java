/**
 * RepositoriesTest
 * [Bell]
 * Created on : 17-05-01
 * Author : Ryane Alla
 * Email  : allaryane@gmail.com
 * Copyright (c) 2017 XSoft Development. All rights reserved.
 */
package xs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import xs.entity.*;
import xs.repositories.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(false)
public class RepositoriesTest extends XTest
{
    @Autowired ProductRepository productRepository;
    @Autowired CatalogRepository catalogRepository;
    @Autowired MarkRepository markRepository;
    @Autowired ProductTypeRepository productTypeRepository;
    @Autowired CartRepository cartRepository;
    @Autowired UserRepository userRepository;
    
    @Test
    public void testProductRepository()
    {
        List<String> columnNamesToIgnore = Arrays.asList("catalog", "mark", "productType");
        List<ProductEntity> pList = productRepository.findAll();
        
        long n = productRepository.count();
        int i = (int)(n - 1);
        
        assertTrue(13 == n);
        
        System.out.println("---| Number Of Products : " + n);
        
        XSUtils.print(pList, columnNamesToIgnore);
        productRepository.findOne(1L).print();
        XSUtils.print(productRepository.findByActiveTrue(), columnNamesToIgnore);
        pList.get(i).getCatalog().print();
        pList.get(i).getMark().print();
        pList.get(i).getProductType().print();
    
        XSUtils.print(productRepository.findByCatalogId(1L), columnNamesToIgnore);
        
        ProductEntity product = new ProductEntity();
        product.setCatalogId(1L);
        product.setMarkId(1L);
        product.setPrice(15.50F);
        product.setProductTypeId(1L);
        product.setCreatedDate(Timestamp.from(Instant.now()));
        product.setActive(true);
        product.setNameEn("P. Name EN");
        product.setNameFr("P. Name FR");
        product.setDescriptionEn("Desc. Name EN ...");
        product.setDescriptionFr("Desc. Name FR ...");
    
        product.print();
        product = productRepository.save(product);
        product.print();
        productRepository.delete(product);
    
        n = productRepository.count();
        assertTrue(13 == n);
    
        System.out.println("---| Number Of Products : " + n);
    }
    
    @Test
    public void testCatalogRepository()
    {
        List<CatalogEntity> cList = catalogRepository.findAll();
        XSUtils.print(cList);
        long n = catalogRepository.count();
    
        assertTrue(2 == n);
        
        System.out.println("---| Number Of Catalog : " + n);
        
        catalogRepository.findOne(1L).print();
        CatalogEntity catalog = new CatalogEntity();
        catalog.setNameFr("Cat. fr");
        catalog.setNameEn("Cat. en");
        catalog.setDescriptionEn("... en ...");
        catalog.setDescriptionFr("... fr ...");
        catalog.setCreatedDate(Timestamp.from(Instant.now()));
    
        catalog.print();
        catalog = catalogRepository.save(catalog);
        catalog.print();
        catalogRepository.delete(catalog);
    
        n = catalogRepository.count();
        assertTrue(2 == n);
    
        System.out.println("---| Number Of Catalog : " + n);
    }
    
    @Test
    public void testMarkRepository()
    {
        List<MarkEntity> mList = markRepository.findAll();
        XSUtils.print(mList);
        long n = markRepository.count();
        assertTrue(6 == n);
        System.out.println("---| Number Of Mark : " + n);
        markRepository.findOne(1L).print();
    
        MarkEntity mark = new MarkEntity();
        mark.setName("XS Mark");
        mark.setDescriptionEn("Desc. EN...");
        mark.setDescriptionFr("Desc. FR...");
        mark.setProductTypeId(2L);
        mark.setCreatedDate(Timestamp.from(Instant.now()));
    
        mark.print();
        mark = markRepository.save(mark);
        mark.print();
        markRepository.delete(mark);
    
        n = markRepository.count();
        assertTrue(6 == n);
        System.out.println("---| Number Of Mark : " + n);
    }
    
    @Test
    public void testProductTypeRepository()
    {
        List<ProductTypeEntity> ptList = productTypeRepository.findAll();
        XSUtils.print(ptList);
        long n = productTypeRepository.count();
        assertTrue(3 == n);
        System.out.println("---| Number Of Product Type : " + n);
        productTypeRepository.findOne(2L).print();
        
        ProductTypeEntity productType = new ProductTypeEntity();
        productType.setNameFr("XS P. Type FR");
        productType.setNameEn("XS P. Type EN");
        productType.setCreatedDate(Timestamp.from(Instant.now()));
        productType.setModifiedDate(null);
    
        productType.print();
        productType = productTypeRepository.save(productType);
        productType.print();
        productTypeRepository.delete(productType);
    
        n = productTypeRepository.count();
        assertTrue(3 == n);
        System.out.println("---| Number Of Product Type : " + n);
    }
    
    @Test
    public void testCartRepository()
    {
        List<String> columnNamesToIgnore = Arrays.asList("user", "product");
    
        List<CartEntity> cartList = cartRepository.findAll();
        /*
        XSUtils.print(cartList, columnNamesToIgnore);
        cartList.get(0).getUser().print();
        cartList.get(0).getProduct().print();
    
        XSUtils.print(cartRepository.findByUser_ActiveTrue(), columnNamesToIgnore);
        XSUtils.print(cartRepository.findByUserId(1L), columnNamesToIgnore);
        XSUtils.print(cartRepository.findByQuantityGreaterThanEqual(3), columnNamesToIgnore);
        XSUtils.print(cartRepository.findByUser_EmailEquals(cartList.get(0).getUser().getEmail()), columnNamesToIgnore);
        
        */
        long n = cartRepository.count();
        assertTrue(4 == n);
    
        System.out.println("---| Number Of Cart Items : " + n);
        
        CartEntity cart1 = new CartEntity();
        cart1.setUserId(1L);
        cart1.setProductId(1L);
        cart1.setQuantity(2);
        cart1.setCreatedDate(Timestamp.from(Instant.now()));
        cart1.setModifiedDate(null);
    
        CartEntity cart2 = new CartEntity();
        cart2.setUserId(2L);
        cart2.setProductId(3L);
        cart2.setQuantity(4);
        cart2.setCreatedDate(Timestamp.from(Instant.now()));
        cart2.setModifiedDate(null);
    
        cart1 = cartRepository.save(cart1);
        cart2 = cartRepository.save(cart2);
        cart1.print();
        cart2.print();
        cartRepository.delete(cart1);
        cartRepository.deleteByUserIdAndProductId(cart2.getUserId(), cart2.getProductId());
    
        n = cartRepository.count();
        assertTrue(4 == n);
        System.out.println("---| Number Of Cart Items : " + n);
    }
    
    @Test
    public void testUserRepository()
    {
        List<UserEntity> uList = userRepository.findAll();
        XSUtils.print(uList);
        
        long n = userRepository.count();
        assertTrue(2 == n);
        System.out.println("---| Number Of User : " + n);
        userRepository.findOne(2L).print();
    
        UserEntity user = new UserEntity();
        user.setFirstName("Pierre");
        user.setLastName("Elliot");
        user.setActive(true);
        user.setEmail("pierre@bell.ca");
        user.setPassword("myPassord");
        user.setCreatedDate(Timestamp.from(Instant.now()));
    
        user.print();
        user = userRepository.save(user);
        user.print();
        userRepository.delete(user);
    
        n = userRepository.count();
        assertTrue(2 == n);
        System.out.println("---| Number Of User : " + n);
    }
}
