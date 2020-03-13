package com.ec.ec.controller;

import com.ec.ec.Vo.DataVo;
import com.ec.ec.dao.UserDao;
import com.ec.ec.entity.User;
import com.ec.ec.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin(allowCredentials="true",allowedHeaders="*")
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public User selectOne(Integer id) {
        return this.userService.queryById(id);
    }

    /**
     * 注册/如果已经注册过，返回空
     * @return
     */
    @GetMapping("register")
    public User register(String phone,String sex, String name, String age, String address,String address2,String address3,String password) {
        return this.userService.register( phone, sex,  name,  age,  address,address2,address3,password);
    }

    /**
     * 登录
     * @return
     */
    @GetMapping("login")
    public User login(HttpServletRequest request, String phone, String password) {
        HttpSession session = request.getSession();
        User user=this.userService.login( phone ,password);
        session.setAttribute("user", user);
        return user;
    }

    @GetMapping("queryAllByLimit")
    public DataVo queryAllByLimit(int page, int limit) {
        System.out.println(page+limit);
        return this.userService.queryAllByLimit(page,limit);
    }
    @GetMapping("deleteById")
    public void deleteById(long id) {
        this.userService.deleteById(id);
    }

    @RequestMapping(value = "/getSession", method = RequestMethod.GET)
    @ResponseBody
    public DataVo getSession(HttpServletResponse response, HttpServletRequest request){
        DataVo dataVo = new DataVo();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            dataVo.setCode(404);
            dataVo.setMsg("用户未登录");
        } else {
            dataVo.setCode(0);
            dataVo.setMsg("用户登录");
            dataVo.setData(user);
        }
        return dataVo;
    }


}