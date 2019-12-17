package cn.com.trueway.idpjs.entity;

import java.io.Serializable;

public class XqEntity implements Serializable{

	private static final long serialVersionUID = 3263550058576585955L;
	
	private String name;
	private String sql;
	private String key;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
}
