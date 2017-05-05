/**
 *  HomeController
 *  [Bell]
 *  Created on : 17-05-01
 *      Author : Ryane Alla
 *  	Email  : allaryane@gmail.com
 *    Copyright (c) 2017 XSoft Development. All rights reserved.
 */
package xs.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Home Rest Controller.
 */
@RestController
public class HomeRestController
{
    /**
     * Display the welcome message.
     * @return welcome message as a HTML string.
     */
    @RequestMapping("/")
    public String index()
    {
        String welcomeMsg = "";
        welcomeMsg += "<h4>Welcome In Bell Project [By Ryane Alla : allaryane@gmail.com] ... :-)</h4><br/>";
        welcomeMsg += "Available Rest URLs : <br/><br/>";
        welcomeMsg += "Listing Products From A Catalog : GET http://localhost:8080/product/catalog/{catalogId}<br/><br/>";
        welcomeMsg += "Product Details : GET http://localhost:8080/product/{productId}<br/><br/>";
        welcomeMsg += "Add Product To Cart : POST http://localhost:8080/product<br/><br/>";
        welcomeMsg += "Delete Product From Cart : DELETE http://localhost:8080/cart/{productId}<br/><br/>";
        welcomeMsg += "List Cart Content For A Given User : GET http://localhost:8080/cart/{userId}<br/><br/>";
    
        welcomeMsg += "<p>For more information about this rest API, go to : <a href=\"https://github.com/allaryane/Bell/blob/master/README.md\">GitHub</a> </p>";
    
        return welcomeMsg;
    }
}
