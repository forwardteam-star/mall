package com.ec.ec.service.impl;

import com.ec.ec.Vo.DataVo;
import com.ec.ec.dao.UserDao;
import com.ec.ec.entity.User;
import com.ec.ec.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (User)表服务实现类
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(long id) {
        return this.userDao.getOne(id);
    }

    @Override
    public User login(String phone, String password) {
        return this.userDao.findByPhoneAndPassword(phone,password);
    }

    @Override
    public User register(String phone,String sex, String name, String age, String address,String address2,String address3, String password) {
        User user=new User( phone, sex,  name,  age,  address,address2,address3,password, new Date()) ;
        //先判断是否已经注册 
        if (userDao.findByPhone(phone)==null){
            this.userDao.save(user);
            return user;
        }else {
            return null;
        } 

    }

    /**
     * 查询多条数据
     *
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public DataVo queryAllByLimit(int page, int limit) {
        PageRequest pageReques=PageRequest.of(page-1,limit);   //获取第1页的两条记录
        Page<User> articleList = userDao.findAll(pageReques);
        DataVo objson = new DataVo();
        objson.setData(articleList.getContent());
        objson.setTotal(userDao.findAll().size());
        objson.setCode(0);
        return objson;
    }

    @Override
    public int queryAllSize() {
        return userDao.findAll().size();
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        this.userDao.save(user);

        return user;
    }


    @Override
    public User update(User user) {
        this.userDao.saveAndFlush(user);
        return this.queryById(user.getId());
    }

    @Override
    public void deleteById(long id) {
         this.userDao.deleteById(id);
    }
}