package cn.e3.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3.manager.service.ItemService;
import cn.e3.pojo.TbItem;
import cn.e3.pojo.TbItemDesc;
import cn.e3.utils.DatagridPagebean;
import cn.e3.utils.E3mallResult;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@RequestMapping("item/list/{itemId}")
	@ResponseBody
	public TbItem findItemById(@PathVariable Long itemId){
		return itemService.findItemById(itemId);
	}
	
	/**
	 * 需求:分页查询商品列表
	 * 请求:/item/list
	 * 参数:Integer page,Integer rows
	 * 返回值:DatagridPagebean
	 */
	@RequestMapping("item/list")
	@ResponseBody
	public DatagridPagebean findItemListByPage(@RequestParam(defaultValue="1") Integer page,
			@RequestParam(defaultValue="30") Integer rows){
		
		return itemService.findItemListByPage(page, rows);
	}
	/**
	 * 需求:保存商品对象
	 * 请求:/item/save
	 * 参数:TbItem item,TbItemDesc itemDesc,ItemParam praram
	 * 返回值:json格式E3mallResult
	 * 
	 */
	@RequestMapping("item/save")
	@ResponseBody
	public E3mallResult saveItem(TbItem item,TbItemDesc itemDesc){
		return itemService.saveItem(item, itemDesc);
	}
}
