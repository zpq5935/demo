package one.zpq.springbootdemo.dao;

import one.zpq.springbootdemo.domain.ProductPo;

public interface ProductDao {
    ProductPo selectProduct();

    int reduceCount(Long id, int quantity);
}
