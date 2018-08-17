package com.shoesworld.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "product", schema = "shoes_world", catalog = "")
public class ProductEntity {
    private int id;
    private int categoryId;
    private int brandId;
    private String name;
    private double discount;
    private Timestamp discountFrom;
    private Timestamp discountTo;
    private byte isActive;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Collection<ImageEntity> imagesById;
    private CategoryEntity categoryByCategoryId;
    private BrandEntity brandByBrandId;
    private Collection<ReviewEntity> reviewsById;
    private Collection<StockEntity> stocksById;
    private Collection<WishlistEntity> wishlistsById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "category_id", nullable = false)
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "brand_id", nullable = false)
    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
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
    @Column(name = "discount", nullable = false, precision = 2)
    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Basic
    @Column(name = "discount_from", nullable = false)
    public Timestamp getDiscountFrom() {
        return discountFrom;
    }

    public void setDiscountFrom(Timestamp discountFrom) {
        this.discountFrom = discountFrom;
    }

    @Basic
    @Column(name = "discount_to", nullable = false)
    public Timestamp getDiscountTo() {
        return discountTo;
    }

    public void setDiscountTo(Timestamp discountTo) {
        this.discountTo = discountTo;
    }

    @Basic
    @Column(name = "is_active", nullable = false)
    public byte getIsActive() {
        return isActive;
    }

    public void setIsActive(byte isActive) {
        this.isActive = isActive;
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

        ProductEntity that = (ProductEntity) o;

        if (id != that.id) return false;
        if (categoryId != that.categoryId) return false;
        if (brandId != that.brandId) return false;
        if (Double.compare(that.discount, discount) != 0) return false;
        if (isActive != that.isActive) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (discountFrom != null ? !discountFrom.equals(that.discountFrom) : that.discountFrom != null) return false;
        if (discountTo != null ? !discountTo.equals(that.discountTo) : that.discountTo != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + categoryId;
        result = 31 * result + brandId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        temp = Double.doubleToLongBits(discount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (discountFrom != null ? discountFrom.hashCode() : 0);
        result = 31 * result + (discountTo != null ? discountTo.hashCode() : 0);
        result = 31 * result + (int) isActive;
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "productByProductId")
    public Collection<ImageEntity> getImagesById() {
        return imagesById;
    }

    public void setImagesById(Collection<ImageEntity> imagesById) {
        this.imagesById = imagesById;
    }

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public CategoryEntity getCategoryByCategoryId() {
        return categoryByCategoryId;
    }

    public void setCategoryByCategoryId(CategoryEntity categoryByCategoryId) {
        this.categoryByCategoryId = categoryByCategoryId;
    }

    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public BrandEntity getBrandByBrandId() {
        return brandByBrandId;
    }

    public void setBrandByBrandId(BrandEntity brandByBrandId) {
        this.brandByBrandId = brandByBrandId;
    }

    @OneToMany(mappedBy = "productByProductId")
    public Collection<ReviewEntity> getReviewsById() {
        return reviewsById;
    }

    public void setReviewsById(Collection<ReviewEntity> reviewsById) {
        this.reviewsById = reviewsById;
    }

    @OneToMany(mappedBy = "productByProductId")
    public Collection<StockEntity> getStocksById() {
        return stocksById;
    }

    public void setStocksById(Collection<StockEntity> stocksById) {
        this.stocksById = stocksById;
    }

    @OneToMany(mappedBy = "productByProductId")
    public Collection<WishlistEntity> getWishlistsById() {
        return wishlistsById;
    }

    public void setWishlistsById(Collection<WishlistEntity> wishlistsById) {
        this.wishlistsById = wishlistsById;
    }
}
