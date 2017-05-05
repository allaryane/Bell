/**
 *  XSAbstractEntity
 *  [Bell]
 *  Created on : 17-05-04
 *      Author : Ryane Alla
 *  	Email  : allaryane@gmail.com
 *    Copyright (c) 2017 XSoft Development. All rights reserved.
 */
package xs.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import xs.XSUtils;

import javax.persistence.*;
import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.List;

@MappedSuperclass
public abstract class XSAbstractEntity
{
    protected Long id;
    @CreatedDate protected Timestamp createdDate;
    @LastModifiedDate protected Timestamp modifiedDate;
    
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    @Basic
    @Column(name = "created_date", nullable = false)
    public Timestamp getCreatedDate() {
        return createdDate;
    }
    
    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }
    
    @Basic
    @Column(name = "modified_date", nullable = true)
    public Timestamp getModifiedDate() {
        return modifiedDate;
    }
    
    public void setModifiedDate(Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
    
    
    @Override
    public String toString()
    {
        List<Field> fieldsList = XSUtils.getObjectReflectFieldsList(this.getClass());
    
        return this.getClass().getName();
    }
    
    public void print()
    {
        System.out.println(this.toString());
    }
}
