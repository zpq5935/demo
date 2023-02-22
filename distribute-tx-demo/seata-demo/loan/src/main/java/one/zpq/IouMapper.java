package one.zpq;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IouMapper {
    int updateBalance(Iou record);
    Iou selectByUserId(String userId);
}
