package com.shoesworld.models;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class OrderDetailEntityPK implements Serializable {
    private int orderId;
    private int stockId;

    @Column(name = "order_id", nullable = false)
    @Id
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Column(name = "stock_id", nullable = false)
    @Id
    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderDetailEntityPK that = (OrderDetailEntityPK) o;

        if (orderId != that.orderId) return false;
        if (stockId != that.stockId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + stockId;
        return result;
    }
}
