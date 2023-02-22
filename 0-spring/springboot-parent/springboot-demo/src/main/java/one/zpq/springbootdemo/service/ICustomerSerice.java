package one.zpq.springbootdemo.service;

import java.util.List;

import one.zpq.springbootdemo.domain.Customer;

public interface ICustomerSerice {
    public List<Customer> selectCustomer(Customer customer);

    public int deleteCustomer();

    public int updateCustomer();

    public int addCustomer();

    public List<Customer> listCustomerByMybatis();
}


