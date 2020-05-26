package com.yintu.ruixing.dao;

import com.yintu.ruixing.entity.*;

import java.util.List;
/**
 * @author Qiao
 * @date 2020/5/21 14:39
 * @return 
 */

public interface ListDao {
    /**
     * @author Qiao
     * @date 2020/5/21 14:42
     * @return 查找所有的铁路局
     */
    List<TieLuJuEntity> getListTieLuJuAll();
    /**
     * @author Qiao
     * @date 2020/5/21 14:42
     * @return 根据传过来的铁路局ID查找电务段
     */
    List<DianWuDuanEntity> getDianWuDuan(Long tlj_id );
    /**
     * @author Qiao
     * @date 2020/5/21 14:43
     * @return 根据传过来的电务段ID查找线段
     */
    List<XianDuanEntity> getXianDuan(Long dwd_id);
    /**
     * @author Qiao
     * @date 2020/5/21 14:44
     * @return 根据传过来的线段ID查找车站
     */
    List<CheZhanEntity>getCheZhan(Long xd_id);

}
