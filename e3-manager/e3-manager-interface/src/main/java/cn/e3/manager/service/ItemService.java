package cn.e3.manager.service;

import cn.e3.pojo.TbItem;
import cn.e3.pojo.TbItemDesc;
import cn.e3.utils.DatagridPagebean;
import cn.e3.utils.E3mallResult;

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
	/**
	 * 保存商品信息
	 * 参数:TbItem item ,TbItemDesc itemDesc,TbItemParam itemParam
	 * 返回值:E3mallResult
	 */
	public E3mallResult saveItem(TbItem item ,TbItemDesc itemDesc);
}
