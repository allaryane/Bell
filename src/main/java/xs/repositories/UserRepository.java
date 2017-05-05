/**
 * UserRepository
 * [Bell]
 * Created on : 17-05-04
 * Author : Ryane Alla
 * Email  : allaryane@gmail.com
 * Copyright (c) 2017 XSoft Development. All rights reserved.
 */
package xs.repositories;

import xs.entity.UserEntity;

import java.util.List;

public interface UserRepository extends XSRepository<UserEntity, Long>
{
    
    List<UserEntity> findByActive(boolean active);
    List<UserEntity> findByActiveTrue();
    List<UserEntity> findByActiveFalse();
}
