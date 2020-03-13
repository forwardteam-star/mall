package com.ec.ec.service.impl;

import com.ec.ec.Vo.DataVo;
import com.ec.ec.dao.IssuesDao;
import com.ec.ec.entity.Issues;
import com.ec.ec.service.IssuesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Issues)表服务实现类
 *
 */
@Service("issuesService")
public class IssuesServiceImpl implements IssuesService {
    @Resource
    private IssuesDao issuesDao;

    @Override
    public DataVo queryByName(String name) {
        name="%"+name+"%";
        DataVo dataVo=new DataVo();
        dataVo.setData(this.issuesDao.findByIssuesNameLike(name));
        dataVo.setTotal(this.issuesDao.findByIssuesNameLike(name).size());
        return dataVo;
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Issues queryById(long id) {
        return this.issuesDao.getOne(id);
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
        Page<Issues> articleList = issuesDao.findAll(pageReques);
        DataVo objson = new DataVo();
        objson.setData(articleList.getContent());
        objson.setTotal(issuesDao.findAll().size());
        objson.setCode(0);
        return objson;
    }


    /**
     * 新增数据
     *
     * @param issues 实例对象
     * @return 实例对象
     */
    @Override
    public Issues insert(Issues issues) {
        this.issuesDao.save(issues);
        return issues;
    }

    /**
     * 修改数据
     *
     * @param issues 实例对象
     * @return 实例对象
     */
    @Override
    public Issues update(Issues issues) {
        this.issuesDao.saveAndFlush(issues);
        return this.queryById(issues.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public void deleteById(long id) {
         this.issuesDao.deleteById(id) ;
    }
}