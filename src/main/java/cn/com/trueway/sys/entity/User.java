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
	private String account;
	private String password;
	private String username;
	private String gender;
	private Integer phone;
	private Integer status;
	private Integer role;
	private Integer sort;
	private String remark;
	private String email;
	private Date created_time;
	private Date modified_time;
	private String created_user;
	private String modified_user;
	private String uuidsalt;
	private String photo;
	private String reserved;

	public User() {
		super();
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreated_time() {
		return created_time;
	}

	public void setCreated_time(Date created_time) {
		this.created_time = created_time;
	}

	public Date getModified_time() {
		return modified_time;
	}

	public void setModified_time(Date modified_time) {
		this.modified_time = modified_time;
	}

	public String getCreated_user() {
		return created_user;
	}

	public void setCreated_user(String created_user) {
		this.created_user = created_user;
	}

	public String getModified_user() {
		return modified_user;
	}

	public void setModified_user(String modified_user) {
		this.modified_user = modified_user;
	}

	public String getUuidsalt() {
		return uuidsalt;
	}

	public void setUuidsalt(String uuidsalt) {
		this.uuidsalt = uuidsalt;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getReserved() {
		return reserved;
	}

	public void setReserved(String reserved) {
		this.reserved = reserved;
	}

	@Override
	public String toString() {
		return "User{" +
				"guid='" + guid + '\'' +
				", account='" + account + '\'' +
				", password='" + password + '\'' +
				", username='" + username + '\'' +
				", gender='" + gender + '\'' +
				", phone=" + phone +
				", status=" + status +
				", role=" + role +
				", sort=" + sort +
				", remark='" + remark + '\'' +
				", email='" + email + '\'' +
				", created_time=" + created_time +
				", modified_time=" + modified_time +
				", created_user='" + created_user + '\'' +
				", modified_user='" + modified_user + '\'' +
				", uuidsalt='" + uuidsalt + '\'' +
				", photo='" + photo + '\'' +
				", reserved='" + reserved + '\'' +
				'}';
	}
}
