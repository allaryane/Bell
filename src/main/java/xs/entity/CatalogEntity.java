/**
 *  CatalogEntity
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
@Table(name = "catalog", schema = "bell")
public class CatalogEntity extends XSAbstractEntity
{
    private String nameEn;
    private String nameFr;
    private String descriptionEn;
    private String descriptionFr;
    
    public CatalogEntity()
    {
    }
    
    @Basic
    @Column(name = "name_en", nullable = false, length = 100)
    public String getNameEn() {
        return nameEn;
    }
    
    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }
    
    @Basic
    @Column(name = "name_fr", nullable = false, length = 100)
    public String getNameFr() {
        return nameFr;
    }
    
    public void setNameFr(String nameFr) {
        this.nameFr = nameFr;
    }
    
    @Basic
    @Column(name = "description_en", nullable = false, length = 500)
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
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        CatalogEntity that = (CatalogEntity) o;
        
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nameEn != null ? !nameEn.equals(that.nameEn) : that.nameEn != null) return false;
        if (nameFr != null ? !nameFr.equals(that.nameFr) : that.nameFr != null) return false;
        if (descriptionEn != null ? !descriptionEn.equals(that.descriptionEn) : that.descriptionEn != null)
            return false;
        if (descriptionFr != null ? !descriptionFr.equals(that.descriptionFr) : that.descriptionFr != null)
            return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (modifiedDate != null ? !modifiedDate.equals(that.modifiedDate) : that.modifiedDate != null) return false;
        
        return true;
    }
    
    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nameEn != null ? nameEn.hashCode() : 0);
        result = 31 * result + (nameFr != null ? nameFr.hashCode() : 0);
        result = 31 * result + (descriptionEn != null ? descriptionEn.hashCode() : 0);
        result = 31 * result + (descriptionFr != null ? descriptionFr.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (modifiedDate != null ? modifiedDate.hashCode() : 0);
        return result;
    }
}
