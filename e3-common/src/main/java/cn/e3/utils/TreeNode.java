package cn.e3.utils;

import java.io.Serializable;

public class TreeNode implements Serializable {

	// id
	private Long id;
	// 树形菜单节点名称
	private String text;
	// 是否有子节点
	private String state;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
