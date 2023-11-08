package one.zpq.service;


import one.zpq.vo.AccountInput;

import java.util.List;

public interface AccountService {

    List<String> listAccount(AccountInput accountInput);

}
