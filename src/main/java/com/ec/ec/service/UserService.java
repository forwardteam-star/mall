package com.ec.ec.service;

import com.ec.ec.Vo.DataVo;
import com.ec.ec.entity.User;


/**
 * (User)表服务接口
 *
 * @author Mr.wang
 * @since 2020-01-06 15:48:58
 */
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    User queryById(long id);


    User login(String phone,String password);

    /**
     * 注册
     */
    User register(String phone,String sex, String name, String age, String address,String address2,String address3, String password);
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    DataVo queryAllByLimit(int page, int limit);

    int queryAllSize();

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User update(User user);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    void deleteById(long id);

    User queryByPhone(String mobilePhone);

}