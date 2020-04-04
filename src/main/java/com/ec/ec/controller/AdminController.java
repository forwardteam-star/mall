package com.ec.ec.controller;

import com.ec.ec.dao.AdminDao;
import com.ec.ec.entity.Admin;
import com.ec.ec.service.AdminService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
@RestController
@CrossOrigin(allowCredentials="true",allowedHeaders="*")
@RequestMapping("admin")
public class AdminController {
    /**
     * 服务对象
     */
    @Resource
    private AdminService adminService;

    @Resource
    private AdminDao adminDao;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Admin selectOne(Integer id) {
        return this.adminService.queryById(id);
    }

    @GetMapping("login")
    public boolean login(String phone,String password) {
        return adminDao.findByTeleAndPassword(phone,password).size()!=0;
    }
}