/**
 * XSRepositoryAC
 * [Bell]
 * Created on : 17-05-05
 * Author : Ryane Alla
 * Email  : allaryane@gmail.com
 * Copyright (c) 2017 XSoft Development. All rights reserved.
 */
package xs.repositories;


import org.springframework.data.repository.NoRepositoryBean;
import xs.entity.UserEntity;
import xs.entity.XSAbstractEntity;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public interface XSRepositoryAC<T extends XSAbstractEntity, ID extends Serializable> extends XSRepository<T, ID>
{
    List<T> findByActive(boolean active);
    List<T> findByActiveTrue();
    List<T> findByActiveFalse();
}
