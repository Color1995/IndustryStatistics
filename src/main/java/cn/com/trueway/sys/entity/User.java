package cn.com.trueway.sys.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类User,用来存放用户信息的相关数据。
 * 
 * @author JiuGe
 *
 */
public class User implements Serializable {

	private static final long serialVersionUID = 3469343540723236423L;
	
	private String guid;
	private String accountName;
	private String loginName;
	private String loginPassword;
	private Integer userGender;
	private String userPhone;
	private String userPhoto;
	private String userEmail;
	private Integer userStatus;
	private Integer userRole;
	private Integer userSort;
	private String remark;
	private Date createdTime;
	private Date modifiedTime;
	private String modifiedUser;
	private String uuidSalt;
	private String reserved;

	public User() {
		super();
	}

	/**
	 * 用来封装reg时的User对象
	 * @param username
	 * @param password
	 * @param gender
	 * @param phone
	 * @param email
	 */
	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public Integer getUserGender() {
		return userGender;
	}

	public void setUserGender(Integer userGender) {
		this.userGender = userGender;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Integer getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}

	public Integer getUserRole() {
		return userRole;
	}

	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}

	public Integer getUserSort() {
		return userSort;
	}

	public void setUserSort(Integer userSort) {
		this.userSort = userSort;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public String getModifiedUser() {
		return modifiedUser;
	}

	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}

	public String getUuidSalt() {
		return uuidSalt;
	}

	public void setUuidSalt(String uuidSalt) {
		this.uuidSalt = uuidSalt;
	}

	public String getReserved() {
		return reserved;
	}

	public void setReserved(String reserved) {
		this.reserved = reserved;
	}


	
}
