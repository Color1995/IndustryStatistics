package cn.com.trueway.sys.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类User,用来存放用户信息的相关数据。
 *
 * @author JiuGe
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
    private Date createdTime;
    private Date modifiedTime;
    private String createdUser;
    private String modifiedUser;
    private String uuidsalt;
    private String photo;
    private String orgGuid;
    private String orgName;

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

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
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

    public String getOrgGuid() {
        return orgGuid;
    }

    public void setOrgGuid(String orgGuid) {
        this.orgGuid = orgGuid;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
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
                ", createdTime=" + createdTime +
                ", modifiedTime=" + modifiedTime +
                ", createdUser='" + createdUser + '\'' +
                ", modifiedUser='" + modifiedUser + '\'' +
                ", uuidsalt='" + uuidsalt + '\'' +
                ", photo='" + photo + '\'' +
                ", orgGuid='" + orgGuid + '\'' +
                ", orgName='" + orgName + '\'' +
                '}';
    }
}
