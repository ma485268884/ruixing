package com.yintu.ruixing.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author:lcy
 * @date:2020-05-30 14
 * 调谐单元
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TuningEntity {

    private long xid;//线段id

    private long cid;//车站id

    private long id;

    private long ALongInFBAZhu;//主信号FBA长内电流A

    private long ALongInFBADiao;//调信号FBA长内电流A

    private long ALongOutFBAZhu;//主信号FBA长外电流A

    private long ALongOutFBADiao;

    private long AShoutInFBAZhu;//主信号FBA短内电流A

    private long AShoutInFBADiao;

    private long AShoutOutFBAZhu;//主信号FBA短外电流A

    private long AShoutOutFBADiao;

    private long ALongInJBAZhu;//主信号JBA长内电流A

    private long ALongInJBADiao;

    private long ALongOutJBAZhu;//主信号JBA长外电流A

    private long ALongOutJBADiao;

    private long AShortInJBAZhu;//主信号JBA短内电流A

    private long AShortInJBADiao;

    private long AShortOutJBAZhu;//主信号JBA短外电流A

    private long AShortOutJBADiao;//调信号JBA短外电流A

}
