package cn.e3.manager.service;

import cn.e3.pojo.TbItem;
import cn.e3.utils.DatagridPagebean;

public interface ItemService {

	/**
	 * 根据ID查询商品
	 */
	public TbItem findItemById(Long itemId);
	
	/**
	 * 分页查询商品列表
	 * 参数 Integer page,Integer rows
	 * 返回值 DatagridPagebean
	 */
	public DatagridPagebean findItemListByPage(Integer page,Integer rows);
}
