package cn.e3.manager.service;

import cn.e3.pojo.TbItem;

public interface ItemService {

	/**
	 * 根据ID查询商品
	 */
	public TbItem findItemById(Long itemId);
	
}
