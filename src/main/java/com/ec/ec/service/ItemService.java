package com.ec.ec.service;

import com.ec.ec.Vo.DataVo;
import com.ec.ec.Vo.ItemVo;
import com.ec.ec.entity.Item;

import java.util.List;

/**
 * (Item)表服务接口
 *
 */
public interface ItemService {

    /**
     * @return 实例对象
     */
    ItemVo getItemByid(long Id);
    DataVo getAllItem(long openId);
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Item queryById(long id);

    /**
     * 查询多条数据
     *
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Item> queryAllByLimit();

    /**
     * 新增数据
     *
     * @param item 实例对象
     * @return 实例对象
     */
    Item insert(Item item);

    /**
     * 修改数据
     *
     * @param item 实例对象
     * @return 实例对象
     */
    Item update(Item item);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    void deleteById(long id);

}