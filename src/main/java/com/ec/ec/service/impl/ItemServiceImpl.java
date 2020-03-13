package com.ec.ec.service.impl;

import com.ec.ec.Vo.DataVo;
import com.ec.ec.Vo.ItemVo;
import com.ec.ec.dao.IssuesDao;
import com.ec.ec.dao.ItemDao;
import com.ec.ec.entity.Issues;
import com.ec.ec.entity.Item;
import com.ec.ec.service.ItemService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (Item)表服务实现类
 *
 */
@Service("itemService")
public class ItemServiceImpl implements ItemService {
    @Resource
    private ItemDao itemDao;

    @Resource
    private IssuesDao issuesDao;

    @Override
    public ItemVo getItemByid(long id) {
        Item i=itemDao.getOne(id);
        Issues issues=issuesDao.getOne(i.getIssuesId());
        ItemVo itemVo=new ItemVo(i,issues);
        return itemVo;
    }

    @Override
    public DataVo getAllItem(long id) {
        List<Item> items=itemDao.findByOpenId(id);
        List<ItemVo> itemVos=new ArrayList<>();
        for (int j=items.size()-1;j>=0;j--){
            Item i=items.get(j);
            Issues issues=issuesDao.getOne(i.getIssuesId());
            ItemVo itemVo=new ItemVo(i,issues);
            itemVos.add(itemVo);
        }
        DataVo dataVo=new DataVo();
        dataVo.setData(itemVos);
        dataVo.setTotal(itemVos.size());
        return dataVo;
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Item queryById(long id) {
        return this.itemDao.getOne(id);
    }

    /**
     * 查询多条数据
     *
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Item> queryAllByLimit() {
        List<Item> items= this.itemDao.findAll();
        for (Item item:
        items) {
            item.setIssuesName(issuesDao.getOne(item.getIssuesId()).getIssuesName());
        }
        return items;

    }

    /**
     * 新增数据
     *
     * @param item 实例对象
     * @return 实例对象
     */
    @Override
    public Item insert(Item item) {
        this.itemDao.save(item);
        return item;
    }

    /**
     * 修改数据
     *
     * @param item 实例对象
     * @return 实例对象
     */
    @Override
    public Item update(Item item) {
        this.itemDao.saveAndFlush(item);
        return this.queryById(item.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public void deleteById(long id) {
        this.itemDao.deleteById(id);
    }
}