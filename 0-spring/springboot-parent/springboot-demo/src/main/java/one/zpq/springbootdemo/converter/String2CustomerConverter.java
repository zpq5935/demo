package one.zpq.springbootdemo.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import one.zpq.springbootdemo.domain.Customer;

/**
 * springmvc之转换器
 * @author 22517
 *
 */
@Component
public class String2CustomerConverter implements Converter<String, Customer> {

    @Override
    public Customer convert(String source) {
        String[] strings = source.split("-");
        Customer customer = new Customer();
        customer.setAccount(strings[0]);
        customer.setEmail(strings[1]);
        return customer;
    }

}
