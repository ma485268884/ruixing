package com.yintu.ruixing.chanpinjiaofu.impl;

import com.yintu.ruixing.chanpinjiaofu.ChanPinJiaoFuFileAuditorEntity;
import com.yintu.ruixing.chanpinjiaofu.ChanPinJiaoFuXiangMuEntity;
import com.yintu.ruixing.chanpinjiaofu.ChanPinJiaoFuXiangMuFileEntity;
import com.yintu.ruixing.common.MessageEntity;
import com.yintu.ruixing.common.util.TreeNodeUtil;
import com.yintu.ruixing.chanpinjiaofu.ChanPinJiaoFuXiangMuDao;
import com.yintu.ruixing.common.MessageDao;
import com.yintu.ruixing.xitongguanli.UserDao;
import com.yintu.ruixing.chanpinjiaofu.ChanPinJiaoFuXiangMuService;
import com.yintu.ruixing.xitongguanli.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @Author Mr.liu
 * @Date 2020/7/1 13:44
 * @Version 1.0
 * 需求:产品交付
 */
@Service
@Transactional
public class ChanPinJiaoFuXiangMuServiceImpl implements ChanPinJiaoFuXiangMuService {
    @Autowired
    private ChanPinJiaoFuXiangMuDao chanPinJiaoFuXiangMuDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private MessageDao messageDao;

    @Override
    public List<ChanPinJiaoFuXiangMuEntity> findJiaoFuQingKuangList(String choiceTing, Integer page, Integer size) {
        return chanPinJiaoFuXiangMuDao.findJiaoFuQingKuangList(choiceTing);
    }


    @Override
    public void editXiaoXiById(MessageEntity messageEntity) {
        messageEntity.setStatus((short)2);
        messageDao.updateByPrimaryKeySelective(messageEntity);
    }

    @Override
    public List<MessageEntity> findXiaoXi() {
        return messageDao.findXiaoXi();
    }

    @Override
    public List<ChanPinJiaoFuXiangMuEntity> findAllXiangMu() {
        return chanPinJiaoFuXiangMuDao.findAllXiangMu();
    }

    @Override
    public void addXiaoXi(MessageEntity messageEntity) {
        /*messageEntity.setContext("项目待发货，请及时联系顾客确认供货计划！");
        messageEntity.setType((short)2);
        messageEntity.setStatus((short)1);
        messageEntity.setCreatedDate(new Date());*/
        messageDao.insertSelective(messageEntity);
    }

    @Override
    public List<UserEntity> findAllAuditorNameById(Integer id) {
       Integer[] ids=chanPinJiaoFuXiangMuDao.findAllAuditorNameById(id);
        List<UserEntity > userEntity=new ArrayList<>();
        for (int i = 0; i < ids.length; i++) {
            UserEntity  userEntities=userDao.selectByPrimaryKey((long)ids[i]);
            System.out.println(userEntities);
            userEntity.add(userEntities);
        }
        return userEntity;
    }

    @Override
    public List<ChanPinJiaoFuXiangMuEntity> findJiaoFuQingKuangLists(String choiceTing, Integer page, Integer size) {
        return chanPinJiaoFuXiangMuDao.findJiaoFuQingKuangLists(choiceTing);
    }

    @Override
    public Map<String, Object> findJiaoFuQingKuangNumberAll() {
        Map<String,Object> map=new HashMap<>();
        List<String> zhengZaiZhiXing =chanPinJiaoFuXiangMuDao.findZhengZaiZhiXing();
        zhengZaiZhiXing.add("zhengZaiZhiXing");
        List<String> meiWanChengFaHuo=chanPinJiaoFuXiangMuDao.findFaHuo();
        meiWanChengFaHuo.add("meiWanChengFaHuo");
        List<String> meiWanChengQianShou=chanPinJiaoFuXiangMuDao.findQianShou();
        meiWanChengQianShou.add("meiWanChengQianShou");
        List<String> meiWanChengYanGong=chanPinJiaoFuXiangMuDao.meiWanChengYanGong();
        meiWanChengYanGong.add("meiWanChengYanGong");
        List<String> zanBuFaHuo=chanPinJiaoFuXiangMuDao.zanBuFaHuo();
        zanBuFaHuo.add("zanBuFaHuo");
        List<String> luXuFaHuo=chanPinJiaoFuXiangMuDao.luXuFaHuo();
        luXuFaHuo.add("luXuFaHuo");
        List<String> wuXuFaHuo=chanPinJiaoFuXiangMuDao.wuXuFaHuo();
        wuXuFaHuo.add("wuXuFaHuo");
        List<String> daiQianShu=chanPinJiaoFuXiangMuDao.daiQianShu();
        daiQianShu.add("daiQianShu");
        List<String> daiYanGong=chanPinJiaoFuXiangMuDao.daiYanGong();
        daiYanGong.add("daiYanGong");
        List<String>overQianShouMoney=chanPinJiaoFuXiangMuDao.overQianShouMoney();
        overQianShouMoney.add("overQianShouMoney");
        List<String>overYanGongMoney=chanPinJiaoFuXiangMuDao.overYanGongMoney();
        overYanGongMoney.add("overYanGongMoney");

        map.put("zhengZaiZhiXing",zhengZaiZhiXing);
        map.put("meiWanChengQianShou",meiWanChengQianShou);
        map.put("meiWanChengFaHuo",meiWanChengFaHuo);
        map.put("meiWanChengYanGong",meiWanChengYanGong);
        map.put("zanBuFaHuo",zanBuFaHuo);
        map.put("luXuFaHuo",luXuFaHuo);
        map.put("wuXuFaHuo",wuXuFaHuo);
        map.put("daiQianShu",daiQianShu);
        map.put("daiYanGong",daiYanGong);
        map.put("overQianShouMoney",overQianShouMoney);
        map.put("overYanGongMoney",overYanGongMoney);
        return map;
    }



    /////////////////////////项目交付状态小模块/////////////////////////////////////
    @Override
    public List<ChanPinJiaoFuXiangMuEntity> findXiangMuByIds(Integer stateid, Integer id, Integer typeid, Integer page, Integer size) {
        return chanPinJiaoFuXiangMuDao.findXiangMuByIds(stateid,id,typeid);
    }

    @Override
    public List<ChanPinJiaoFuXiangMuEntity> findXiangMuData(String xiangMuBianHao, String xiangMuName, Integer page, Integer size) {
        return chanPinJiaoFuXiangMuDao.findXiangMuData(xiangMuBianHao,xiangMuName);
    }

    @Override
    public void deletXiangMuFileByIds(Integer[] ids) {
        chanPinJiaoFuXiangMuDao.deletXiangMuFileByIds(ids);
    }

    @Override
    public void deletXiangMuFileById(Integer id) {
        chanPinJiaoFuXiangMuDao.deletXiangMuFileById(id);
    }

    @Override
    public ChanPinJiaoFuXiangMuFileEntity findById(Integer id) {
        return chanPinJiaoFuXiangMuDao.findById(id);
    }

    @Override
    public void editXiangMuFileById(ChanPinJiaoFuXiangMuFileEntity chanPinJiaoFuXiangMuFileEntity,Integer id,Integer[] uids ) {
            //删除中间表的审查人id
            chanPinJiaoFuXiangMuDao.deletAuditor(id);
            //添加审查人
            for (Integer uid : uids) {
                ChanPinJiaoFuFileAuditorEntity chanPinJiaoFuFileAuditorEntity=new ChanPinJiaoFuFileAuditorEntity();
                chanPinJiaoFuFileAuditorEntity.setChanPinJiaoFuFileId(id);
                chanPinJiaoFuFileAuditorEntity.setAuditorId(uid);
                chanPinJiaoFuXiangMuDao.addAuditorName(chanPinJiaoFuFileAuditorEntity);
            }
        chanPinJiaoFuXiangMuDao.editXiangMuFileById(chanPinJiaoFuXiangMuFileEntity);
    }

    @Override
    public void addXiangMuFile(ChanPinJiaoFuXiangMuFileEntity chanPinJiaoFuXiangMuFileEntity,Integer[] uids) {
        chanPinJiaoFuXiangMuDao.addXiangMuFile(chanPinJiaoFuXiangMuFileEntity);
        Integer xid=chanPinJiaoFuXiangMuFileEntity.getId();
        for (Integer uid : uids) {
            ChanPinJiaoFuFileAuditorEntity chanPinJiaoFuFileAuditorEntity=new ChanPinJiaoFuFileAuditorEntity();
            chanPinJiaoFuFileAuditorEntity.setChanPinJiaoFuFileId(xid);
            chanPinJiaoFuFileAuditorEntity.setAuditorId(uid);
            chanPinJiaoFuXiangMuDao.addAuditorName(chanPinJiaoFuFileAuditorEntity);
        }
    }

    @Override
    public List<ChanPinJiaoFuXiangMuEntity> findAll(Integer page,Integer size) {
        return chanPinJiaoFuXiangMuDao.findAll();
    }

    @Override
    public void deletXiagMuById(Integer id) {
        chanPinJiaoFuXiangMuDao.deletXiagMuById(id);
    }

    @Override
    public void editXiangMuById(ChanPinJiaoFuXiangMuEntity chanPinJiaoFuXiangMuEntity) {
        chanPinJiaoFuXiangMuDao.editXiangMuById(chanPinJiaoFuXiangMuEntity);
    }

    @Override
    public void addXiangMu(ChanPinJiaoFuXiangMuEntity chanPinJiaoFuXiangMuEntity) {
        chanPinJiaoFuXiangMuDao.addXiangMu(chanPinJiaoFuXiangMuEntity);
    }

    //展示树形结构
    @Override
    public List<TreeNodeUtil> findSanJiShu() {
        List<ChanPinJiaoFuXiangMuEntity> chanPinJiaoFuXiangMuEntities = chanPinJiaoFuXiangMuDao.findSanJiShu();
        List<TreeNodeUtil> treeNodeUtils = new ArrayList<>();
        for (ChanPinJiaoFuXiangMuEntity chanPinJiaoFuXiangMuEntity : chanPinJiaoFuXiangMuEntities) {
            TreeNodeUtil treeNodeUtil = new TreeNodeUtil();
            if (chanPinJiaoFuXiangMuEntity.getXiangmuState() == 1 || chanPinJiaoFuXiangMuEntity.getXiangmuState() == 2 || chanPinJiaoFuXiangMuEntity.getXiangmuState() == 3) {
                //第一级
                treeNodeUtil.setId((long) chanPinJiaoFuXiangMuEntity.getId());
                treeNodeUtil.setLabel(chanPinJiaoFuXiangMuEntity.getXiangmuState().toString());
                List<ChanPinJiaoFuXiangMuEntity> chanPinJiaoFuXiangMuEntities1 = chanPinJiaoFuXiangMuDao.findDiErJi(chanPinJiaoFuXiangMuEntity.getXiangmuState());
                List<TreeNodeUtil> treeNodeUtilss = new ArrayList<>();
                for (ChanPinJiaoFuXiangMuEntity pinJiaoFuXiangMuEntity : chanPinJiaoFuXiangMuEntities1) {
                    //第二级
                    TreeNodeUtil treeNodeUtil1 = new TreeNodeUtil();
                    Map<String,Object> map=new HashMap();
                    treeNodeUtil1.setId((long) pinJiaoFuXiangMuEntity.getId());
                    treeNodeUtil1.setLabel(pinJiaoFuXiangMuEntity.getXiangmuBianhao());
                    map.put("xiangmu",chanPinJiaoFuXiangMuDao.findOneXiangMU(pinJiaoFuXiangMuEntity.getId()));
                    treeNodeUtil1.setLi_attr(map);
                    treeNodeUtilss.add(treeNodeUtil1);
                    treeNodeUtil.setChildren(treeNodeUtilss);
                    //第三级
                    List<TreeNodeUtil> treeNodeUtilss2 = new ArrayList<>();
                    List<TreeNodeUtil> treeNodeUtilss3 = new ArrayList<>();
                    TreeNodeUtil treeNodeUtil2 = new TreeNodeUtil();
                    TreeNodeUtil treeNodeUtil3 = new TreeNodeUtil();
                    treeNodeUtil2.setId((long) 1);
                    treeNodeUtil2.setLabel("输入文件");
                    treeNodeUtil2.setChildren(treeNodeUtilss3);
                    treeNodeUtil3.setId((long) 2);
                    treeNodeUtil3.setLabel("输出文件");
                    treeNodeUtil3.setChildren(treeNodeUtilss3);
                    treeNodeUtilss2.add(treeNodeUtil2);
                    treeNodeUtilss2.add(treeNodeUtil3);
                    treeNodeUtil1.setChildren(treeNodeUtilss2);
                }
            }
            treeNodeUtils.add(treeNodeUtil);
        }
        return treeNodeUtils;
    }

}




