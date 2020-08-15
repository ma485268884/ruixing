package com.yintu.ruixing.guzhangzhenduan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author:lcy
 * @date:2020-06-17 10
 * 报警预警树形类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaoJingYuJingPropertyEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private String ziName;



    private Integer parentId;

}
