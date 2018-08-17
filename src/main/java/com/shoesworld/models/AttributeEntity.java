package com.shoesworld.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "attribute", schema = "shoes_world", catalog = "")
public class AttributeEntity {
    private int id;
    private int attributeGroupId;
    private String name;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private AttributeGroupEntity attributeGroupByAttributeGroupId;
    private Collection<StockEntity> stocksById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "attribute_group_id", nullable = false)
    public int getAttributeGroupId() {
        return attributeGroupId;
    }

    public void setAttributeGroupId(int attributeGroupId) {
        this.attributeGroupId = attributeGroupId;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "created_at", nullable = true)
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Basic
    @Column(name = "updated_at", nullable = true)
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AttributeEntity that = (AttributeEntity) o;

        if (id != that.id) return false;
        if (attributeGroupId != that.attributeGroupId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + attributeGroupId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "attribute_group_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public AttributeGroupEntity getAttributeGroupByAttributeGroupId() {
        return attributeGroupByAttributeGroupId;
    }

    public void setAttributeGroupByAttributeGroupId(AttributeGroupEntity attributeGroupByAttributeGroupId) {
        this.attributeGroupByAttributeGroupId = attributeGroupByAttributeGroupId;
    }

    @OneToMany(mappedBy = "attributeByAttributeId")
    public Collection<StockEntity> getStocksById() {
        return stocksById;
    }

    public void setStocksById(Collection<StockEntity> stocksById) {
        this.stocksById = stocksById;
    }
}
