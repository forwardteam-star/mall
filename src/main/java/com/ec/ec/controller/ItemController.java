package com.ec.ec.controller;

import com.ec.ec.Vo.DataVo;
import com.ec.ec.Vo.ItemVo;
import com.ec.ec.dao.IssuesDao;
import com.ec.ec.dao.ItemDao;
import com.ec.ec.entity.Issues;
import com.ec.ec.entity.Item;
import com.ec.ec.entity.User;
import com.ec.ec.service.ItemService;
import com.ec.ec.util.Util;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
@RestController
@CrossOrigin(allowCredentials="true",allowedHeaders="*")
@RequestMapping("item")
public class ItemController {
    /**
     * 服务对象
     */
    @Resource
    private ItemService itemService;
    @Resource
    private ItemDao itemDao;
    @Resource
    private IssuesDao issuesDao;
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Item selectOne(Integer id) {
        return this.itemService.queryById(id);
    }

    @GetMapping("getAllItem")
    public DataVo getAllItem(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        return this.itemService.getAllItem(user.getId());
    }
    @GetMapping("getItemByid")
    public ItemVo getItemByid(  Integer Id) {
        return this.itemService.getItemByid(Id);
    }

    //获取所有订单列表
    @GetMapping("queryAllByLimit")
    public DataVo queryAllByLimit() {
        DataVo dataVo=new DataVo();
        try {
            List<Item> items= this.itemService.queryAllByLimit();
            for (int j=items.size()-1;j>=0;j--){
                Item i=items.get(j);
                Issues issues=issuesDao.getOne(i.getIssuesId());
                items.get(j).setIssuesId(issues.getId());
                items.get(j).setItemAddress(Util.decode(items.get(j).getItemAddress()));
            }
            dataVo.setData(items);
            dataVo.setTotal(this.itemDao.findAll().size());
            dataVo.setCode(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            dataVo.setMsg("查询失败");
            dataVo.setCode(500);
        }
        return dataVo;
    }
    //删除商品
    @GetMapping("delete")
    public DataVo delete( Integer id) {
        DataVo dataVo=new DataVo();
        try {
            itemService.deleteById(id);
            dataVo.setMsg("成功");
            dataVo.setCode(0);
        }catch (Exception e){
            dataVo.setMsg("失败");
            dataVo.setCode(500);
        }
        return dataVo;
    }


    /**
     * 结账
     * @param id
     */
    @GetMapping("Bill")
    public void Bill(Integer id) {
        Item item=itemService.queryById(id);
        item.setItemType("等待发货");
        itemService.update(item);
    }

    /**
     * 收货
     * @param id
     */
    @GetMapping("Receipt")
    public void Receipt(Integer id) {

        Item item=itemService.queryById(id);
        item.setItemType("已收货");
        itemService.update(item);
    }
    /**
     * 发货
     * @param id
     */
    @GetMapping("Ship")
    public void Ship(Integer id) {
        Item item=itemService.queryById(id);
        if (item.getItemType().equals("等待发货")){
            item.setItemType("已发货");
            itemService.update(item);
        }
    }

    /**
     * 退货
     * @param id
     */
    @GetMapping("Returns")
    public void Returns(Integer id) {
        Item item=itemService.queryById(id);
        item.setItemType("已退货");
        itemService.update(item);
    }



}