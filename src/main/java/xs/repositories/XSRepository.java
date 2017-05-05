/**
 * Repository
 * [Bell]
 * Created on : 17-05-04
 * Author : Ryane Alla
 * Email  : allaryane@gmail.com
 * Copyright (c) 2017 XSoft Development. All rights reserved.
 */
package xs.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import xs.entity.XSAbstractEntity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@NoRepositoryBean
public interface XSRepository<T extends XSAbstractEntity, ID extends Serializable> extends CrudRepository<T, Long>
{
    List<T> findAll();
    List<T> findAll(Sort sort);
    Page<T> findAll(Pageable pageable);
}
