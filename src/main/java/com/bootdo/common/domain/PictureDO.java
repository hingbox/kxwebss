package com.bootdo.common.domain;

import java.io.Serializable;


/**
 * 字典表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-29 18:28:07
 */
public class PictureDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//编号
	private Long id;
	//标签名
	private String url;
	private String keyword;
	private String picture;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "PictureDO{" +
				"id=" + id +
				", url='" + url + '\'' +
				", keyword='" + keyword + '\'' +
				", picture='" + picture + '\'' +
				'}';
	}
}
