package com.chuangyexia.utils;

import java.io.Serializable;

/**
 * json请求 返回
 */
public class AjaxResult implements Serializable {
	
	public static final int CODE_SUCCESS = 0;//执行成功
	public static final int CODE_FAILED = -500;//执行失败
	
	private int code;
	private String message;
	private Object data;

	private AjaxResult(int code, Object data, String message) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public Object getData() {
		return data;
	}

	public boolean isSuccess() {
		return CODE_SUCCESS == code;
	}

	public static final AjaxResult success() {
		return new AjaxResult(CODE_SUCCESS, null, null);
	}

	public static final AjaxResult success(String message) {
		return new AjaxResult(CODE_SUCCESS, null, message);
	}

	public static final AjaxResult success(Object data) {
		return new AjaxResult(CODE_SUCCESS, data, null);
	}

	public static final AjaxResult success(Object data, String message) {
		return new AjaxResult(CODE_SUCCESS, data, message);
	}

	public static final AjaxResult failed() {
		return new AjaxResult(CODE_FAILED, null, null);
	}

	public static final AjaxResult failed(String message) {
		return new AjaxResult(CODE_FAILED, null, message);
	}
	
	public static final AjaxResult failed(int code, String message) {
		return new AjaxResult(code, null, message);
	}

	public static final AjaxResult failed(int code, Object data, String message) {
		return new AjaxResult(code, data, message);
	}

	public static final AjaxResult failed(Object data, String message) {
		return new AjaxResult(CODE_FAILED, data, message);
	}
}
