package cn.e3.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3.manager.service.ItemService;
import cn.e3.mapper.TbItemMapper;
import cn.e3.pojo.TbItem;
import cn.e3.pojo.TbItemExample;
import cn.e3.utils.DatagridPagebean;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper tbItemMapper;
	
	@Override
	public TbItem findItemById(Long itemId) {
		return tbItemMapper.selectByPrimaryKey(itemId);
	}

	/**
	 * 分页查询商品列表
	 * 参数 Integer page,Integer rows
	 * 返回值 DatagridPagebean
	 */
	public DatagridPagebean findItemListByPage(Integer page, Integer rows) {
		//创建example对象
		TbItemExample example=new TbItemExample();
		//在查询之前设置分页
		PageHelper.startPage(page, rows);
		//执行查询
		List<TbItem> list = tbItemMapper.selectByExample(example);
		//创建PageInfo
		PageInfo<TbItem> pagaInfo=new PageInfo<>(list);
		//创建分页包装类对象 封装分页信息
		DatagridPagebean pagebean=new DatagridPagebean();
		//设置总记录数
		pagebean.setTotal(pagaInfo.getTotal());
		//设置总记录
		pagebean.setRows(list);
		return pagebean;
	}

}
