package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.common.util.TreeNodeUtil;
import com.yintu.ruixing.dao.BaoJingYuJingDao;
import com.yintu.ruixing.dao.BaoJingYuJingPropertyDao;
import com.yintu.ruixing.dao.QuDuanBaseDao;
import com.yintu.ruixing.entity.BaoJingYuJingEntity;
import com.yintu.ruixing.entity.BaoJingYuJingPropertyEntity;
import com.yintu.ruixing.entity.QuDuanBaseEntity;
import com.yintu.ruixing.service.BaoJingYuJingPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author:lcy
 * @date:2020-06-17 10
 */
@Service
@Transactional
public class BaoJingYuJingPropertyServiceImpl implements BaoJingYuJingPropertyService {
    @Autowired
    private BaoJingYuJingPropertyDao baoJingYuJingPropertyDao;
    @Autowired
    private BaoJingYuJingDao baoJingYuJingDao;
    @Autowired
    private QuDuanBaseDao quDuanBaseDao;

    @Override
    public List<TreeNodeUtil> findBaoJingYuJingTree(Integer parentId) {
        List<BaoJingYuJingPropertyEntity> baoJingYuJingPropertyEntities = baoJingYuJingPropertyDao.findBaoJingYuJingTree(parentId);
        List<TreeNodeUtil> treeNodeUtils = new ArrayList<>();
        for (BaoJingYuJingPropertyEntity baoJingYuJingPropertyEntity : baoJingYuJingPropertyEntities) {
            TreeNodeUtil treeNodeUtil=new TreeNodeUtil();
            treeNodeUtil.setId((long) baoJingYuJingPropertyEntity.getId());
            treeNodeUtil.setLabel(baoJingYuJingPropertyEntity.getName());
            treeNodeUtil.setChildren(this.findBaoJingYuJingTree(baoJingYuJingPropertyEntity.getId()));
            treeNodeUtils.add(treeNodeUtil);

        }
        return treeNodeUtils;
    }

    @Override
    public List<BaoJingYuJingEntity> findAllYuJingBaoJing(Integer page, Integer size) {
        return baoJingYuJingDao.findAllYuJingBaoJing();
    }

    @Override
    public List<BaoJingYuJingEntity> findYuJingBaoJingBySouSuo(Integer[] ids, Integer sid, Integer qid,
                                                               Date startTime, Date huifuTime, Integer tianChuang,
                                                               Integer lvChuHuiFu, Integer lvChuKaiTong, Integer page, Integer size) {
        return baoJingYuJingDao.findYuJingBaoJingBySouSuo(ids,sid,qid,startTime,huifuTime,tianChuang,lvChuHuiFu,lvChuKaiTong);
    }

    @Override
    public List<QuDuanBaseEntity> findAllQuDuan() {
       // List<QuDuanBaseEntity> list1=null;
        List<QuDuanBaseEntity>list=quDuanBaseDao.findAllQuDuanName();

        return list;
    }
}
