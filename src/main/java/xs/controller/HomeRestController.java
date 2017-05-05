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

@RestController
public class HomeRestController
{
    @RequestMapping("/")
    public String index()
    {
        String welcomeMsg = "";
        welcomeMsg += "<h4>Welcome In Bell Project [By Ryane Alla] ... :-)</h4><br/>";
        welcomeMsg += "Available Rest URLs : <br/>";
        
        return welcomeMsg;
    }
}
