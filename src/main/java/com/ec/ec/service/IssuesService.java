package com.ec.ec.service;

import com.ec.ec.Vo.DataVo;
import com.ec.ec.entity.Issues;

import java.util.List;

/**
 * (Issues)表服务接口
 *
 */
public interface IssuesService {


    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DataVo queryByName(String name);
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Issues queryById(long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    DataVo queryAllByLimit(int page, int limit);

    /**
     * 新增数据
     *
     * @param issues 实例对象
     * @return 实例对象
     */
    Issues insert(Issues issues);

    /**
     * 修改数据
     *
     * @param issues 实例对象
     * @return 实例对象
     */
    Issues update(Issues issues);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    void deleteById(long id);

}