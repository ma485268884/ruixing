package com.yintu.ruixing.chanpinjiaofu;

import com.yintu.ruixing.chanpinjiaofu.ChanPinJiaoFuCostZhiChuEntity;
import com.yintu.ruixing.chanpinjiaofu.ChanPinJiaoFuXiangMuEntity;

import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @Author Mr.liu
 * @Date 2020/7/4 20:25
 * @Version 1.0
 * 需求:
 */
public interface ChanPinJiaoFuCostZhiChuService {
    List<ChanPinJiaoFuXiangMuEntity> findXiangMu();

    void addZhiChuCost(ChanPinJiaoFuCostZhiChuEntity chanPinJiaoFuCostZhiChuEntity);

    void editZhiChuCost(ChanPinJiaoFuCostZhiChuEntity chanPinJiaoFuCostZhiChuEntity);

    List<ChanPinJiaoFuCostZhiChuEntity> findZhiChuCostByName(Integer page, Integer size, String xiangMuName);

    void deletZhiChuCostByIds(Integer[] ids);

    List<ChanPinJiaoFuCostZhiChuEntity> findAllZhiChuCost(Integer page, Integer size);

    void exportFile(ServletOutputStream outputStream, Integer[] ids) throws IOException;
}
