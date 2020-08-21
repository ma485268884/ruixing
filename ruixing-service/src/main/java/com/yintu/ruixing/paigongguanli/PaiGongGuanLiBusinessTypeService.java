package com.yintu.ruixing.paigongguanli;



import java.util.List;

/**
 * @Author Mr.liu
 * @Date 2020/8/14 15:18
 * @Version 1.0
 * 需求:派工管理  任务类型
 */
public interface PaiGongGuanLiBusinessTypeService {

    void addBusinessTypea(PaiGongGuanLiBusinessTypeEntity paiGongGuanLiBusinessTypeEntity);

    void editBusinessTypeaById(PaiGongGuanLiBusinessTypeEntity paiGongGuanLiBusinessTypeEntity);

    List<PaiGongGuanLiBusinessTypeEntity> findSomeBusinessTypea(Integer page, Integer size, String businessTypeaName);

    List<PaiGongGuanLiBusinessTypeEntity> findSomeChuChaRenWu(Integer id,Integer page, Integer size, String businessTypeaName);

    void addChuChaRenWu(Integer pid, PaiGongGuanLiBusinessTypeEntity paiGongGuanLiBusinessTypeEntity);

    void editChuChaRenWuById(PaiGongGuanLiBusinessTypeEntity paiGongGuanLiBusinessTypeEntity);

    void deleteChuChaRenWuByIds(Integer[] ids);

    List<PaiGongGuanLiBusinessTypeEntity> findChuChaRenWu(Integer id);

    void deleteBusinessTypeByIds(Integer id);
}
