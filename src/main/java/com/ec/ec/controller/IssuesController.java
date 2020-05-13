package com.ec.ec.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ec.ec.Vo.DataVo;
import com.ec.ec.dao.IssuesDao;
import com.ec.ec.entity.Issues;
import com.ec.ec.service.IssuesService;

@RestController
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
@RequestMapping("issues")
public class IssuesController {
    /**
     * 服务对象
     */
    @Resource
    private IssuesService issuesService;
    @Resource
    private IssuesDao issuesDao;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Issues selectOne(Integer id) {
        return this.issuesService.queryById(id);
    }

    /**
     * 模糊查询（搜索）
     *
     * @param name
     * @return 单条数据
     */
    @GetMapping("selectByName")
    public DataVo selectByName(String name) {
        if (name.equals("")) {
            return null;
        }
        return this.issuesService.queryByName(name);
    }

    //新增商品
    @GetMapping("insert")
    public DataVo insert(String issuesName, String issuesUrl, Integer issuesNum, String issuesDetails, Double issuesPrice) {
        System.out.println(issuesName + issuesUrl);
        DataVo dataVo = new DataVo();
        try {
            Issues issues = new Issues(issuesName, issuesUrl, issuesNum, issuesDetails, issuesPrice);
            this.issuesService.insert(issues);
            dataVo.setMsg("添加成功");
            dataVo.setCode(0);
            dataVo.setData(issues);
        } catch (Exception e) {
            dataVo.setMsg("添加失败");
            dataVo.setCode(500);
        }
        return dataVo;
    }

    //获取所有商品列表
    @GetMapping("queryAllByLimit")
    public DataVo queryAllByLimit(int page, int limit) {
        return this.issuesService.queryAllByLimit(page, limit);
    }

    @GetMapping("getSize")
    public int getSize() {
        return issuesDao.findAll().size();
    }

    //删除商品
    @GetMapping("delete")
    public DataVo delete(Integer id) {
        DataVo dataVo = new DataVo();
        try {
            issuesService.deleteById(id);
            dataVo.setMsg("成功");
            dataVo.setCode(0);
        } catch (Exception e) {
            dataVo.setMsg("失败");
            dataVo.setCode(500);
        }
        return dataVo;
    }

    //更新商品
    @PostMapping("update")
    public String update(Integer id, String issuesName, Integer issuesNum, String issuesDetails, Double issuesPrice) {
        if (id != null) {
            Issues oldIssue = issuesService.queryById(id);

            if (issuesName != null) {
                oldIssue.setIssuesName(issuesName);
            }
            if (issuesNum != null) {
                oldIssue.setIssuesNum(issuesNum);
            }

            if (issuesDetails != null) {
                oldIssue.setIssuesDetails(issuesDetails);
            }

            if (issuesPrice != null) {
                oldIssue.setIssuesPrice(issuesPrice);
            }
            try {
                issuesService.update(oldIssue);
                return "success";
            } catch (Exception e) {
                return "error";
            }
        }
        return "success";
    }

}