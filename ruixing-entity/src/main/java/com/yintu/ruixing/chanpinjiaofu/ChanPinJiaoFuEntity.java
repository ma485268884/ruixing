package com.yintu.ruixing.chanpinjiaofu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author Mr.liu
 * @Date 2020/6/24 16:25
 * @Version 1.0
 * 需求:产品交付项目状态
 */
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ChanPinJiaoFuEntity {

    private Integer id;//产品交付项目状态id

    private Integer shuId;//产品交付树id

    private String xiangMuName;//项目名称

    private Integer xiangMuState;//项目状态 1：正在执行 ， 2：仅剩尾款，3：项目关闭

    private Integer xiaoShouState;//销售需求状态  1：前续未办理、2：全部品类/数量已下需求、3：部分品类/数量已下需求',

    private Integer faHouState;//发货状态 1：项目停滞暂不发货、2：暂未开始发货、3：陆续发货中、4：工程结束不需发货、5：当前订单是否完成',

    private Integer qianShouState;//签收状态 1：前续未办理、2：公司暂存不签收、3：已转储待签收、4：完成签收',

    private Integer yanGongState;//验工状态 1：是否需要验工、2：前续未办理、3：待验工、4：顾客要求暂缓验工、5：完成部分验工、6：完成验工',

    private Integer xianChangFuWu;//是否需要现场服务   0：否 ，1：是',

    private Date faHuoTiXingTime;//发货提醒日期

    private Integer fileType;//文件类型   1：输入文件 2：输出文件'

    private Integer faBuType;//发布状态 1：录入  2：发布',

    private String fileName;//文件名称

    private String filePath;//文件路径

    private Integer auditorId;//'审核人id',

    private ChanPinJiaoFuPropertyEntity chanPinJiaoFuPropertyEntity;
}
