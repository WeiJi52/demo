package com.zr.demo.model;

public class ResObject {
	private int status;
	private String op;
	private Object result;
	public ResObject(int value, String string) {
		this.setStatus(value);
		this.setOp(string);
	}
	public ResObject(int value, Object user) {
		this.setStatus(value);
		this.setResult(user);
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
}
