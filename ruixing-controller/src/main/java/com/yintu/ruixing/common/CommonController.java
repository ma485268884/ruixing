package com.yintu.ruixing.common;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yintu.ruixing.common.enumobject.EnumAuthType;
import com.yintu.ruixing.common.exception.BaseRuntimeException;
import com.yintu.ruixing.common.util.*;
import com.yintu.ruixing.xitongguanli.UserEntity;
import com.yintu.ruixing.xitongguanli.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author:mlf
 * @date:2020/6/20 9:17
 */
@RestController
@RequestMapping("/common")
public class CommonController extends SessionController {

    @Autowired
    private UserService userService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private DistrictService districtService;

    /**
     * 获取当前用户菜单栏
     *
     * @return 当前用户权限
     */
    @GetMapping("/menu")
    public Map<String, Object> findUserMenuBar() {
        List<TreeNodeUtil> treeNodeUtils = this.getLoginAuthType().equals((EnumAuthType.ADMIN.getValue())) ?
                userService.findPermission(-1L, (short) 1) :
                userService.findPermissionById(this.getLoginUserId(), -1L, (short) 1);

        return ResponseDataUtil.ok("获取菜单栏成功", treeNodeUtils);
    }

    /**
     * 修改真实姓名
     *
     * @param truename 真实姓名
     * @return 返回信息
     */
    @PutMapping("/edit/truename")
    public Map<String, Object> editTrueNameById(@RequestParam("truename") String truename) {
        if (truename.isEmpty()) {
            throw new BaseRuntimeException("真实姓名不能为空");
        }
        UserEntity userEntity = userService.findById(this.getLoginUserId());
        if (userEntity != null) {
            if (truename.equals(userEntity.getTrueName())) {
                throw new BaseRuntimeException("原始信息和修改信息相同");
            }
            userService.editTruenameById(this.getLoginUserId(), truename);
        }
        return ResponseDataUtil.ok("修改真实姓名成功");
    }

    /**
     * @param oldPassword 原始密码
     * @param newPassword 新密码
     * @return 返回信息
     */
    @PutMapping("/edit/password")
    public Map<String, Object> editPasswordById(@RequestParam("old_password") String oldPassword, @RequestParam("new_password") String newPassword) {
        if (oldPassword.isEmpty() || newPassword.isEmpty()) {
            throw new BaseRuntimeException("原始密码或新密码不能为空");
        }
        if (oldPassword.equals(newPassword)) {
            throw new BaseRuntimeException("原始密码和新密码相同");
        }
        UserEntity userEntity = userService.findById(this.getLoginUserId());
        if (userEntity != null) {
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            if (!passwordEncoder.matches(oldPassword, userEntity.getPassword())) {
                throw new BaseRuntimeException("原始密码错误");
            }
            userEntity.setPassword(newPassword);
            userService.edit(userEntity);
        }
        return ResponseDataUtil.ok("修改密码成功,请重新登录");
    }


    /**
     * 未读消息改为已读消息
     *
     * @param id 消息id
     * @return 返回信息
     */
    @PutMapping("/message/{id}")
    public Map<String, Object> changeMessageStatus(@PathVariable Integer id) {
        messageService.changeStatus(id);
        return ResponseDataUtil.ok("修改消息信息成功");
    }

    /**
     * 获取公共消息列表
     *
     * @param pageNumber 页码
     * @param pageSize   每页大小
     * @param orderBy    排序字段
     * @param type       模块标识类型
     * @param status     消息状态
     * @return
     */
    @GetMapping("/message")
    public Map<String, Object> findMessageById(@RequestParam("page_number") Integer pageNumber,
                                               @RequestParam("page_size") Integer pageSize,
                                               @RequestParam(value = "order_by", required = false, defaultValue = "id DESC") String orderBy,
                                               @RequestParam(value = "type", required = false) Short type,
                                               @RequestParam(value = "status", required = false) Short status) {
        PageHelper.startPage(pageNumber, pageSize, orderBy);
        List<MessageEntity> messageEntities = messageService.findByTypeAndStatus(type, status);
        PageInfo<MessageEntity> pageInfo = new PageInfo<>(messageEntities);
        return ResponseDataUtil.ok("查询消息信息列表成功", pageInfo);
    }

    /**
     * 上传文件集
     *
     * @param multipartFiles 文件数组
     * @param request        请求数据
     * @return 返回信息
     * @throws IOException io异常
     */
    @PostMapping("/upload/file")
    public Map<String, Object> uploadFile(@RequestParam("file") MultipartFile[] multipartFiles, HttpServletRequest request) throws IOException {
        String prefix = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/files" + "/";
        JSONArray ja = new JSONArray();
        for (MultipartFile multipartFile : multipartFiles) {
            if (multipartFile.getSize() == 0)
                throw new BaseRuntimeException("不能上传空文件");
            String fileName = multipartFile.getOriginalFilename();
            String filePath = FileUploadUtil.save(multipartFile.getInputStream(), fileName);
            JSONObject jo = new JSONObject();
            jo.put("filePath", prefix + filePath.substring(1) + "/" + fileName);
            jo.put("fileName", fileName);
            ja.add(jo);
        }
        return ResponseDataUtil.ok("上传文件成功", ja);
    }

    /**
     * 上传图片集
     *
     * @param multipartFiles 文件数组
     * @param request        请求数据
     * @return 返回信息
     * @throws IOException io异常
     */
    @PostMapping("/upload/photo")
    public Map<String, Object> uploadPhotoFile(@RequestParam("photo") MultipartFile[] multipartFiles, HttpServletRequest request) throws IOException {
        String prefix = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/files" + "/";
        JSONArray ja = new JSONArray();
        for (MultipartFile multipartFile : multipartFiles) {
            if (multipartFile.getSize() == 0)
                throw new BaseRuntimeException("不能上传空文件");
            String photoName = multipartFile.getOriginalFilename();
            String photoPath = FileUploadUtil.save(multipartFile.getInputStream(), photoName);
            if (!FileUtil.isImage(new File(FileUploadUtil.FilePath + File.separator + photoPath + File.separator + photoName)))//判断是否为图片文件
                throw new BaseRuntimeException("此文件不是图片文件");
            JSONObject jo = new JSONObject();
            jo.put("photoPath", prefix + photoPath.substring(1) + "/" + photoName);
            jo.put("photoName", photoName);
            ja.add(jo);
        }
        return ResponseDataUtil.ok("上传图片成功", ja);
    }

    /**
     * 按照父节点id查询区域信息
     *
     * @param parentId 父节点id
     * @return 返回信息
     */
    @GetMapping("/district")
    public Map<String, Object> findDistrictByParentId(@RequestParam("parent_id") Integer parentId) {
        List<DistrictEntity> districtEntities = districtService.findByParentId(parentId);
        return ResponseDataUtil.ok("获取区域信息成功", districtEntities);
    }


}
