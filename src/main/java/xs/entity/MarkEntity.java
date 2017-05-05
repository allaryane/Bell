/**
 *  MarkEntity
 *  [Bell]
 *  Created on : 17-05-04
 *      Author : Ryane Alla
 *  	Email  : allaryane@gmail.com
 *    Copyright (c) 2017 XSoft Development. All rights reserved.
 */
package xs.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "mark", schema = "bell")
public class MarkEntity extends XSAbstractEntity
{
    private String name;
    private String descriptionEn;
    private String descriptionFr;
    private Long productTypeId;
    
    public MarkEntity()
    {
    
    }

    @Basic
    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Basic
    @Column(name = "description_en", nullable = true, length = 500)
    public String getDescriptionEn() {
        return descriptionEn;
    }
    
    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn;
    }
    
    @Basic
    @Column(name = "description_fr", nullable = false, length = 500)
    public String getDescriptionFr() {
        return descriptionFr;
    }
    
    public void setDescriptionFr(String descriptionFr) {
        this.descriptionFr = descriptionFr;
    }
    
    @Basic
    @Column(name = "product_type_id", nullable = false)
    public Long getProductTypeId() {
        return productTypeId;
    }
    
    public void setProductTypeId(Long productTypeId) {
        this.productTypeId = productTypeId;
    }
   
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        MarkEntity that = (MarkEntity) o;
        
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (descriptionEn != null ? !descriptionEn.equals(that.descriptionEn) : that.descriptionEn != null)
            return false;
        if (descriptionFr != null ? !descriptionFr.equals(that.descriptionFr) : that.descriptionFr != null)
            return false;
        if (productTypeId != null ? !productTypeId.equals(that.productTypeId) : that.productTypeId != null)
            return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (modifiedDate != null ? !modifiedDate.equals(that.modifiedDate) : that.modifiedDate != null) return false;
        
        return true;
    }
    
    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (descriptionEn != null ? descriptionEn.hashCode() : 0);
        result = 31 * result + (descriptionFr != null ? descriptionFr.hashCode() : 0);
        result = 31 * result + (productTypeId != null ? productTypeId.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (modifiedDate != null ? modifiedDate.hashCode() : 0);
        return result;
    }
}
