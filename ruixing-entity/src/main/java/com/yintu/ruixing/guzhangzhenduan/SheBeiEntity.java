package com.yintu.ruixing.guzhangzhenduan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author:lcy
 * @date:2020-06-08 19
 * 设备
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SheBeiEntity {

    private Integer id;

    private String sbName;

    private Integer sbNumber;

    private Integer sbTypeId;

    private Integer xid;

    private String xianDuanName;

    private Integer cid;

    private String cheZhanName;


}
