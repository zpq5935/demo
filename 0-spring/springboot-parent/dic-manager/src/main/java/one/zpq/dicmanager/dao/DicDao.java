package one.zpq.dicmanager.dao;

import one.zpq.dicmanager.dao.po.DicPo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DicDao {

    List<DicPo> listAll();
}
