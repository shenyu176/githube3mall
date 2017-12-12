package cn.e3.content.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;

import cn.e3.content.service.ContentCategoryService;
import cn.e3.mapper.TbContentCategoryMapper;
import cn.e3.pojo.TbContentCategory;
import cn.e3.pojo.TbContentCategoryExample;
import cn.e3.pojo.TbContentCategoryExample.Criteria;
import cn.e3.utils.E3mallResult;
import cn.e3.utils.TreeNode;
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

	@Autowired
	private TbContentCategoryMapper contentCategoryMapper;
	/**
	 * 需求:根据父id查询节点下面子节点
	 * 参数 Long parentId
	 * 返回值 List<TreeNode>
	 */
	public List<TreeNode> findContentCategoryTreeNodeList(Long parentId) {
		//创建树形菜单集合对象
		List<TreeNode> treeList=new ArrayList<>();
		//创建example对象
		TbContentCategoryExample example = new TbContentCategoryExample();
		//创建criteria对象 开始查询
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbContentCategory> catList = contentCategoryMapper.selectByExample(example);
		//遍历查询结果,把分类数据封装到treeList中
		for (TbContentCategory cat : catList) {
			TreeNode node = new TreeNode();
			node.setId(cat.getId());
			node.setText(cat.getName());
			node.setState(cat.getIsParent()?"closed":"open");
			treeList.add(node);
		}
		return treeList;
	}
	
	/**
	 * 需求:新建节点
	 * 参数 Long parentId,String name
	 * 返回值E3mallResult
	 */
	public E3mallResult createNode(Long parentId, String name) {
		//创建广告分类对象
		TbContentCategory contentCategory = new TbContentCategory();
		//封装属性
		contentCategory.setParentId(parentId);
		contentCategory.setName(name);
		contentCategory.setStatus(1);
		contentCategory.setSortOrder(1);
		contentCategory.setIsParent(false);
		Date date=new Date();
		contentCategory.setCreated(date);
		contentCategory.setUpdated(date);
		//新建节点parentId,是父节点的id
		//因此可以根据父节点id查询出父节点对象,然后更新 父节点的状态
		TbContentCategory parent = contentCategoryMapper.selectByPrimaryKey(parentId);
		parent.setIsParent(true);
		contentCategoryMapper.updateByPrimaryKeySelective(parent);
		
		contentCategoryMapper.insert(contentCategory);
		return E3mallResult.ok(contentCategory);
	}

	
}
