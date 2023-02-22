package one.zpq.springbootdemo.service.impl;

import one.zpq.springbootdemo.dao.CustomerDao;
import one.zpq.springbootdemo.domain.Customer;
import one.zpq.springbootdemo.service.ICustomerSerice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerSerice {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private CustomerDao customerDao;

    private RowMapper<Customer> getRowMapper() {
        RowMapper<Customer> rowMapper = (ResultSet resultSet, int rownum) -> {
            Customer customer = new Customer();
            customer.setNickname(resultSet.getString("nickname"));
            customer.setEmail(resultSet.getString("email"));

            return customer;
        };
        return rowMapper;
    }

    @Override
    public List<Customer> selectCustomer(Customer customer) {
        String sql = "select * from customer";
        if (Optional.ofNullable(customer).isPresent()) {
            sql += "where 1=1 ";
            if (Optional.ofNullable(customer.getAccount()).isPresent())
                sql += "and account=" + customer.getAccount();
        }
        Object[] params = new Object[]{};
        List<Customer> customers = jdbcTemplate.query(sql, params, getRowMapper());
        return customers;
    }

    @Override
    public int deleteCustomer() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int updateCustomer() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int addCustomer() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Customer> listCustomerByMybatis() {
        return customerDao.listCustomer();
    }

}
