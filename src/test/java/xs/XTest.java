/**
 *  XTest
 *  [Bell]
 *  Created on : 17-05-01
 *      Author : Ryane Alla
 *  	Email  : allaryane@gmail.com
 *    Copyright (c) 2017 XSoft Development. All rights reserved.
 */
package xs;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Abstract class designed for testing allowing to configure JUnit tests.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public abstract class XTest
{
    @Before
    public void beforeAll()
    {
        System.out.println("\n\n\n");
    }
    
    @After
    public void afterAll()
    {
        System.out.println("\n\n");
    }
}
