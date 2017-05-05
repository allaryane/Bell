/**
 *  ProductEntity
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
@Table(name = "product", schema = "bell")
public class ProductEntity extends XSAbstractEntity
{
    private Boolean active;
    private String nameEn;
    private String nameFr;
    private String descriptionEn;
    private String descriptionFr;
    private Long catalogId;
    private Long productTypeId;
    private Long markId;
    private CatalogEntity catalog;
    private ProductTypeEntity productType;
    private MarkEntity mark;
    private Float price;
    
    public ProductEntity()
    {
    }
    
    @Basic
    @Column(name = "active", nullable = false)
    public Boolean getActive() {
        return active;
    }
    
    public void setActive(Boolean active) {
        this.active = active;
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
    @Column(name = "description_en", nullable = false, length = -1)
    public String getDescriptionEn() {
        return descriptionEn;
    }
    
    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn;
    }
    
    @Basic
    @Column(name = "description_fr", nullable = false, length = -1)
    public String getDescriptionFr() {
        return descriptionFr;
    }
    
    public void setDescriptionFr(String descriptionFr) {
        this.descriptionFr = descriptionFr;
    }
    
    @Basic
    @Column(name = "catalog_id", nullable = false)
    public Long getCatalogId() {
        return catalogId;
    }
    
    public void setCatalogId(Long catalogId) {
        this.catalogId = catalogId;
    }
    
    @Basic
    @Column(name = "product_type_id", nullable = false)
    public Long getProductTypeId() {
        return productTypeId;
    }
    
    public void setProductTypeId(Long productTypeId) {
        this.productTypeId = productTypeId;
    }
    
    @Basic
    @Column(name = "mark_id", nullable = false)
    public Long getMarkId() {
        return markId;
    }
    
    public void setMarkId(Long markId) {
        this.markId = markId;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        ProductEntity that = (ProductEntity) o;
        
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (active != null ? !active.equals(that.active) : that.active != null) return false;
        if (nameEn != null ? !nameEn.equals(that.nameEn) : that.nameEn != null) return false;
        if (nameFr != null ? !nameFr.equals(that.nameFr) : that.nameFr != null) return false;
        if (descriptionEn != null ? !descriptionEn.equals(that.descriptionEn) : that.descriptionEn != null)
            return false;
        if (descriptionFr != null ? !descriptionFr.equals(that.descriptionFr) : that.descriptionFr != null)
            return false;
        if (catalogId != null ? !catalogId.equals(that.catalogId) : that.catalogId != null) return false;
        if (productTypeId != null ? !productTypeId.equals(that.productTypeId) : that.productTypeId != null)
            return false;
        if (markId != null ? !markId.equals(that.markId) : that.markId != null) return false;
        if (createdDate != null ? !createdDate.equals(that.createdDate) : that.createdDate != null) return false;
        if (modifiedDate != null ? !modifiedDate.equals(that.modifiedDate) : that.modifiedDate != null) return false;
        
        return true;
    }
    
    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (active != null ? active.hashCode() : 0);
        result = 31 * result + (nameEn != null ? nameEn.hashCode() : 0);
        result = 31 * result + (nameFr != null ? nameFr.hashCode() : 0);
        result = 31 * result + (descriptionEn != null ? descriptionEn.hashCode() : 0);
        result = 31 * result + (descriptionFr != null ? descriptionFr.hashCode() : 0);
        result = 31 * result + (catalogId != null ? catalogId.hashCode() : 0);
        result = 31 * result + (productTypeId != null ? productTypeId.hashCode() : 0);
        result = 31 * result + (markId != null ? markId.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (modifiedDate != null ? modifiedDate.hashCode() : 0);
        return result;
    }
    
    @ManyToOne
    @JoinColumn(name = "catalog_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public CatalogEntity getCatalog() {
        return catalog;
    }
    
    public void setCatalog(CatalogEntity catalog) {
        this.catalog = catalog;
    }
    
    @ManyToOne
    @JoinColumn(name = "product_type_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public ProductTypeEntity getProductType() {
        return productType;
    }
    
    public void setProductType(ProductTypeEntity productType) {
        this.productType = productType;
    }
    
    @ManyToOne
    @JoinColumn(name = "mark_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public MarkEntity getMark() {
        return mark;
    }
    
    public void setMark(MarkEntity mark) {
        this.mark = mark;
    }
    
    @Basic
    @Column(name = "price", nullable = false, precision = 2)
    public Float getPrice() {
        return price;
    }
    
    public void setPrice(Float price) {
        this.price = price;
    }
}
