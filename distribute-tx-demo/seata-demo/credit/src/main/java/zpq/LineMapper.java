package zpq;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LineMapper {
    void  updateBalance(Line record);
}
