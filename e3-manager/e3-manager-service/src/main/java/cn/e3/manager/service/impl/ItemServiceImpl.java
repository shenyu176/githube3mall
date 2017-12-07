package cn.e3.manager.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3.manager.service.ItemService;
import cn.e3.mapper.TbItemDescMapper;
import cn.e3.mapper.TbItemMapper;
import cn.e3.pojo.TbItem;
import cn.e3.pojo.TbItemDesc;
import cn.e3.pojo.TbItemExample;
import cn.e3.utils.DatagridPagebean;
import cn.e3.utils.E3mallResult;
import cn.e3.utils.IDUtils;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper tbItemMapper;
	
	//注入商品描述mapper接口代理对象
	@Autowired
	private TbItemDescMapper itemDescMapper;
	
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

	/**
	 * 需求:保存商品对象
	 * 参数:TbItem item,TbItemDesc itemDesc,ItemParam praram
	 * 返回值:E3mallResult
	 * 
	 */
	public E3mallResult saveItem(TbItem item, TbItemDesc itemDesc) {
		//生成商品id
		//毫秒+随机数
		long itemId = IDUtils.genItemId();
		item.setId(itemId);
		//商品状态 1-正常 2-下架 3-删除
		item.setStatus((byte) 1);
		//创建时间
		Date date=new Date();
		item.setCreated(date);
		item.setUpdated(date);
		//保存商品对象
		tbItemMapper.insert(item);
		//保存商品描述对象
		//保存商品描述对象
		itemDesc.setItemId(itemId);
		itemDesc.setCreated(date);
		itemDesc.setUpdated(date);
		
		//保存商品描述对象
		itemDescMapper.insert(itemDesc);
		return E3mallResult.ok();
	}

}
