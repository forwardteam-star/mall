package com.ec.ec.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ec.ec.dao.AdminDao;
import com.ec.ec.entity.Admin;
import com.ec.ec.service.AdminService;

/**
 * (Admin)表服务实现类
 *
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminDao adminDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Admin queryById(long id) {
        return this.adminDao.getOne(id);
    }
}