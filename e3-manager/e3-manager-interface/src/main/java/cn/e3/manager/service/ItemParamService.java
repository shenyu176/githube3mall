package cn.e3.manager.service;

import cn.e3.utils.E3mallResult;

public interface ItemParamService {
	/**
	 * 需求:根据分类id查询商品所需要的规格模板
	 * 参数:Long categoryId
	 * 返回值 E3mallResult
	 */
	public E3mallResult findItemParamWithCategoryId(Long categoryId);
	
}

