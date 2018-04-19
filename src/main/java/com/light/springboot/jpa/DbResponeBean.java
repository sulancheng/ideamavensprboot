package com.light.springboot.jpa;

public class DbResponeBean {
	private Object myclass;
	private Object id;
	private Object message;
	private Object name;
	private Object guo;
	private Object sheng;

	@Override
	public String toString() {
		return "DbResponeBean{" +
				"myclass=" + myclass +
				", id=" + id +
				", message=" + message +
				", name=" + name +
				", guo=" + guo +
				", sheng=" + sheng +
				'}';
	}

	public Object getMyclass() {
		return myclass;
	}

	public void setMyclass(Object myclass) {
		this.myclass = myclass;
	}

	public Object getId() {
		return id;
	}

	public void setId(Object id) {
		this.id = id;
	}

	public Object getMessage() {
		return message;
	}

	public void setMessage(Object message) {
		this.message = message;
	}

	public Object getName() {
		return name;
	}

	public void setName(Object name) {
		this.name = name;
	}

	public Object getGuo() {
		return guo;
	}

	public void setGuo(Object guo) {
		this.guo = guo;
	}

	public Object getSheng() {
		return sheng;
	}

	public void setSheng(Object sheng) {
		this.sheng = sheng;
	}
}
