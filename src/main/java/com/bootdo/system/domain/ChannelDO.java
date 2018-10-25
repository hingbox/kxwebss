package com.bootdo.system.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 渠道表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-09-10 23:35:32
 */
public class ChannelDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键id
	private Integer id;
	//渠道id
	private String channelId;
	//渠道名称
	private String channelName;
	//登录账号
	private String loginAccount;
	//渠道性质 0直客，1代理
	private Integer channelType;
	//对接人
	private String contacts;
	//联系人称呼
	private String linkName;
	//联系方式
	private String phone;
	//状态，1有效，-1无效
	private Integer status;
	//创建人
	private String creator;
	//创建时间
	private Date created;
	//更新人
	private String updator;
	//更新时间
	private Date updated;

	/**
	 * 设置：主键id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：主键id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：渠道id
	 */
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	/**
	 * 获取：渠道id
	 */
	public String getChannelId() {
		return channelId;
	}
	/**
	 * 设置：渠道名称
	 */
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	/**
	 * 获取：渠道名称
	 */
	public String getChannelName() {
		return channelName;
	}
	/**
	 * 设置：登录账号
	 */
	public void setLoginAccount(String loginAccount) {
		this.loginAccount = loginAccount;
	}
	/**
	 * 获取：登录账号
	 */
	public String getLoginAccount() {
		return loginAccount;
	}
	/**
	 * 设置：渠道性质 0直客，1代理
	 */
	public void setChannelType(Integer channelType) {
		this.channelType = channelType;
	}
	/**
	 * 获取：渠道性质 0直客，1代理
	 */
	public Integer getChannelType() {
		return channelType;
	}
	/**
	 * 设置：对接人
	 */
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	/**
	 * 获取：对接人
	 */
	public String getContacts() {
		return contacts;
	}
	/**
	 * 设置：联系人称呼
	 */
	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}
	/**
	 * 获取：联系人称呼
	 */
	public String getLinkName() {
		return linkName;
	}
	/**
	 * 设置：联系方式
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：联系方式
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：状态，1有效，-1无效
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态，1有效，-1无效
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：创建人
	 */
	public void setCreator(String creator) {
		this.creator = creator;
	}
	/**
	 * 获取：创建人
	 */
	public String getCreator() {
		return creator;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreated(Date created) {
		this.created = created;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreated() {
		return created;
	}
	/**
	 * 设置：更新人
	 */
	public void setUpdator(String updator) {
		this.updator = updator;
	}
	/**
	 * 获取：更新人
	 */
	public String getUpdator() {
		return updator;
	}
	/**
	 * 设置：更新时间
	 */
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdated() {
		return updated;
	}
}
