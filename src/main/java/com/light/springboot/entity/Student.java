package com.light.springboot.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="student")
public class Student implements Serializable{

	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="tfclass")
	private String myclass;
	
	@Column(name="age")
	private Integer age;
	

	@Transient
	private Integer sumid;
	
	
	public Integer getSumid() {
		return sumid;
	}


	public void setSumid(Integer sumid) {
		this.sumid = sumid;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getMyclass() {
		return myclass;
	}


	public void setMyclass(String myclass) {
		this.myclass = myclass;
	}


	public Integer getAge() {
		return age;
	}


	public void setAge(Integer age) {
		this.age = age;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", myclass=" + myclass
				+ ", age=" + age + ", sumid=" + sumid + "]";
	}


	
}
