package cn.e3.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;

import cn.e3.manager.service.ItemParamService;
import cn.e3.mapper.TbItemParamMapper;
import cn.e3.pojo.TbItemParam;
import cn.e3.pojo.TbItemParamExample;
import cn.e3.pojo.TbItemParamExample.Criteria;
import cn.e3.utils.E3mallResult;
@Service
public class ItemParamServiceImpl implements ItemParamService {

	@Autowired
	private TbItemParamMapper itemParamMapper;
	
	/**
	 * 需求:根据分类id查询商品所需要的规格模板
	 * 参数:Long categoryId
	 * 返回值 E3mallResult
	 */
	public E3mallResult findItemParamWithCategoryId(Long categoryId) {
		TbItemParamExample example=new TbItemParamExample();
		Criteria criteria = example.createCriteria();
		criteria.andItemCatIdEqualTo(categoryId);
		List<TbItemParam> list = itemParamMapper.selectByExampleWithBLOBs(example);
		TbItemParam itemParam=null;
		if(list!=null&&list.size()>0){
			itemParam=list.get(0);
		}
		return E3mallResult.ok(itemParam);
	}

}
