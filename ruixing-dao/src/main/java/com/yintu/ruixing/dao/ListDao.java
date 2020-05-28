package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @author Qiao
 * @date 2020/5/21 14:39
 * @return 
 */

public interface ListDao {

    List<TieLuJuEntity> selectTieLuJuList();

    List<DianWuDuanEntity> selectDwdListBytId(@Param("tId") long tId);

    List<XianDuanEntity> selectXdListByDwdId(@Param("dwdId") long dwdId);

    List<CheZhanEntity> selectCzListByXdId(@Param("xdId") Long dwdId);


}
