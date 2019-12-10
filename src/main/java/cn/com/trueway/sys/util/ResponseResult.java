package cn.com.trueway.sys.util;

import java.io.Serializable;

/**
 * 响应数据类
 * 
 * @author Administrator
 *
 * @param <T>
 */
public class ResponseResult<T> implements Serializable{

	private static final long serialVersionUID = -3798158717004406365L;
	public final static Integer STATE_OK = 1;
	public final static Integer STATE_ERROR = 0;

	private Integer state;
	private String message;
	private T data;

	public ResponseResult() {
		super();
	}

	public ResponseResult(Integer state) {
		super();
		setState(state);
	}

	public ResponseResult(Integer state, String message) {
		super();
		setState(state);
		setMessage(message);
	}

	public ResponseResult(Exception e){
		super();
		setState(STATE_ERROR);
		setMessage(e.getMessage());
	}
	
	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
