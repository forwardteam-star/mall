package com.ec.ec.service;

import com.ec.ec.entity.Admin;

/**
 * (Admin)表服务接口
 *
 */
public interface AdminService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Admin queryById(long id);

}