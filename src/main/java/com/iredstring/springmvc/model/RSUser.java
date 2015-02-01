package com.iredstring.springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * RSUser entity
 * 
 * @author chuangtc
 * @date 2015-01-30
 */
@Entity
@Table(name = "RSUser")
public class RSUser {

	@Id 
	@Column(name = "rsid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long rsid;
	@Column(name = "fbid")
	private Long fbid;
	@Column(name = "member_type_id")
	private Integer memberTypeId;
	@Column(name = "user_name")
	private String userName;
	@Column(name = "user_email")
	private String userEmail;
	@Column(name = "user_password")
	private String userPassword;
	@Column(name = "nickname")
	private String nickname;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "picture_url")
	private String pictureUrl;
	@Column(name = "picture_height")
	private Integer pictureHeight;
	@Column(name = "picture_width")
	private Integer pictureWidth;
	
	public RSUser() {
		
	}
	public Long getRsid() {
		return rsid;
	}

	public void setRsid(Long rsid) {
		this.rsid = rsid;
	}

	public Long getFbid() {
		return fbid;
	}

	public void setFbid(Long fbid) {
		this.fbid = fbid;
	}

	public Integer getMemberTypeId() {
		return memberTypeId;
	}

	public void setMemberTypeId(Integer memberTypeId) {
		this.memberTypeId = memberTypeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public Integer getPictureHeight() {
		return pictureHeight;
	}

	public void setPictureHeight(Integer pictureHeight) {
		this.pictureHeight = pictureHeight;
	}

	public Integer getPictureWidth() {
		return pictureWidth;
	}

	public void setPictureWidth(Integer pictureWidth) {
		this.pictureWidth = pictureWidth;
	}

	

}
