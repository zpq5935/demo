package one.zpq;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper {
    void  addRepayment(Account record);
}
