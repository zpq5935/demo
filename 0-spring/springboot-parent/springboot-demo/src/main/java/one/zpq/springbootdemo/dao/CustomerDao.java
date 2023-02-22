package one.zpq.springbootdemo.dao;


import one.zpq.springbootdemo.domain.Customer;

import java.util.List;

public interface CustomerDao {
    List<Customer> listCustomer();
}
