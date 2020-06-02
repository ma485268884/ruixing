package com.yintu.ruixing.service.impl;

import com.yintu.ruixing.dao.QuDuanDao;
import com.yintu.ruixing.entity.QuDuanEntity;
import com.yintu.ruixing.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:mlf
 * @date:2020/6/2 15:16
 */
@Service
@Transactional
public class QuDuanServiceImpl implements QuDuanService {

    @Autowired
    private QuDuanDao quDuanDao;
    @Autowired
    private ShouDuanService shouDuanService;
    @Autowired
    private SongDuanService songDuanService;
    @Autowired
    private FenXianPanService fenXianPanService;
    @Autowired
    private TransformerShouDuanService transformerShouDuanService;
    @Autowired
    private TransformerSongDuanService transformerSongDuanService;
    @Autowired
    private TuningService tuningService;

    @Override
    public void add(QuDuanEntity quDuanEntity) {
        quDuanDao.insertSelective(quDuanEntity);
    }

    @Override
    public void remove(Integer id) {
        quDuanDao.deleteByPrimaryKey(id);
    }

    @Override
    public void edit(QuDuanEntity quDuanEntity) {
        quDuanDao.updateByPrimaryKeySelective(quDuanEntity);
    }

    @Override
    public QuDuanEntity findById(Integer id) {
        return quDuanDao.selectByPrimaryKey(id);
    }

    @Override
    public List<QuDuanEntity> findAll() {
        return quDuanDao.selectByAll();
    }

    @Override
    public List<QuDuanEntity> findByCidAndXid(Integer cid, Integer xid) {
        return quDuanDao.selectByCidAndXid(cid, xid);
    }


    @Override
    public Map<String, List<?>> findAll(Integer cid, Integer xid) {
        Map<String, List<?>> map = new HashMap<>();
        map.put("quDuan", this.findByCidAndXid(cid, xid));
        map.put("shouDuan", shouDuanService.findByCidAndXid(cid, xid));
        map.put("songDuan", songDuanService.findByCidAndXid(cid, xid));
        map.put("FenXianPan", fenXianPanService.findByCidAndXid(cid, xid));
        map.put("transformerShouDuan", transformerShouDuanService.findByCidAndXid(cid, xid));
        map.put("transformerSongDuan", transformerSongDuanService.findByCidAndXid(cid, xid));
        map.put("tuning", tuningService.findByCidAndXid(cid, xid));
        return map;
    }
}
