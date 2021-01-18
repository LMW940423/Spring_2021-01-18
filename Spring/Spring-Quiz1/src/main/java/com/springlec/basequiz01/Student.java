package com.springlec.basequiz01;

public class Student {
	
	//Field
	
	String name;
	String age;
	String grade;
	String classNum;
	
	
	//ConStructor
	
	public Student() {
		
	}


	public Student(String name, String age, String grade, String classNum) {
		super();
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.classNum = classNum;
	}

	
	//Getters And Setters
	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}


	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}


	public String getClassNum() {
		return classNum;
	}


	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}
	
	
	
	
	

}
