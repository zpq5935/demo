package one.zpq.service;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import one.zpq.vo.AccountInput;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class AccountServiceImpl implements AccountService {
    @Override
    public List<String> listAccount(AccountInput accountInput) {
        log.info("listAccount-in{}", accountInput);
        List<String> ret = Stream.of("1", "2", "3").collect(Collectors.toList());
        log.info("listAccount-out{}", JSON.toJSONString(ret));
        return ret;
    }
}
