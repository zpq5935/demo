package one.zpq.springbootdemo.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 购买记录
 * 
 * @author 22517
 *
 */
public class PurchaseRecordPo implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Long id;
    private Long userId;
    private Long productId;
    private BigDecimal price;
    private int quantity;
    private BigDecimal sum;
    private Timestamp purchaseDate;
    private String note;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public Timestamp getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Timestamp purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "PurchaseRecordPo [id=" + id + ", userId=" + userId + ", productId=" + productId + ", price=" + price
                + ", quantity=" + quantity + ", sum=" + sum + ", purchaseDate=" + purchaseDate + ", note=" + note + "]";
    }

}
