package cn.e3.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3.manager.service.ItemCatService;
import cn.e3.utils.TreeNode;

@Controller
public class ItemCatController {

	@Autowired
	private ItemCatService itemCatService;
	
	/**
	 * 需求:根据父id查询此节点下面的子节点
	 * 请求:item/cat/list
	 * 参数:Long parentId
	 * 返回值:json对象List<TreeNode>
	 * [{    
	 * "id": 1,    
	 * "text": "Node 1",    
	 * "state": "closed"
	 * }]
     * easyui tree加载属性菜单特点:
     * 1,参数问题: easyUI 每次传递参数是树形节点id,和业务参数名称不匹配.
     * 2,初次访问菜单:初始化菜单顶级节点 parent_id=0
	 */
	@RequestMapping("item/cat/list")
	@ResponseBody
	public List<TreeNode> findItemCatTreeNodeList(@RequestParam(value = "id", defaultValue = "0") Long parentId) {
		return itemCatService.findItemCatTreeNodeList(parentId);
	}
	
}
