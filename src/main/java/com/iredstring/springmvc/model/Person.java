package com.iredstring.springmvc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Person entity
 * 
 * @author chuangtc
 */
@Entity
@Table(name = "Person")
public class Person {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long irsId;
	private Long fbId;
	private Integer memberTypeId;
	private String firstName;
	private String lastName;
	private String userName;
	private String userPassword;
	private String pictureUrl;
	private Integer pictureHeight;
	private Integer pictureWidth;
	
	public Person() {
		
	}
	
	public Person(Long fb_id, Integer memberTypeId,  String firstName, String lastName, String userName, String userPassword, 
			String pictureUrl, Integer pictureHeight, Integer pictureWidth) {
		this.setFbId(fb_id);
		this.setMemberTypeId(memberTypeId);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setUserName(userName);
		this.setUserPassword(userPassword);
		this.setPictureUrl(pictureUrl);
		this.setPictureHeight(pictureHeight);
		this.setPictureWidth(pictureWidth);
	}

	public Long getIrsId() {
		return irsId;
	}

	public void setIrsId(Long irsId) {
		this.irsId = irsId;
	}

	public Long getFbId() {
		return fbId;
	}

	public void setFbId(Long fbId) {
		this.fbId = fbId;
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

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
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

	public Integer getMemberTypeId() {
		return memberTypeId;
	}

	public void setMemberTypeId(Integer memberTypeId) {
		this.memberTypeId = memberTypeId;
	}

	@Override
	public String toString() {
		return "Person [irs_id=" + irsId + ", fb_id="+fbId  + ", username=" + userName + ", last_name="
				+ lastName + ", first_name"+ firstName+ "]";
	}

}