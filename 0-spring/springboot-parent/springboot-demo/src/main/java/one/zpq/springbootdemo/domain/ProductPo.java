package one.zpq.springbootdemo.domain;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 产品
 * 
 * @author 22517
 *
 */
@Alias("product")
public class ProductPo implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Long id;
    private String product_name;
    private int stock;
    private Long price;
    private int version;
    private Long note;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Long getNote() {
        return note;
    }

    public void setNote(Long note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "ProductPo [id=" + id + ", product_name=" + product_name + ", stock=" + stock + ", price=" + price
                + ", version=" + version + ", note=" + note + "]";
    }

}
