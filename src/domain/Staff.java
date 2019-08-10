package domain;

import java.io.Serializable;

public class Staff implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String jobNum;
	private String name;
	private String sex;
	private int age;
	private String home;
	private String id;
	private String status;
	private String edu;
	private String depart;
	private String trade;
	private String gongLing;
	private String level;
	private double postWage;
	public String getJobNum() {
		return jobNum;
	}
	public void setJobNum(String jobNum) {
		this.jobNum = jobNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getHome() {
		return home;
	}
	public void setHome(String home) {
		this.home = home;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEdu() {
		return edu;
	}
	public void setEdu(String edu) {
		this.edu = edu;
	}
	public String getDepart() {
		return depart;
	}
	public void setDepart(String depart) {
		this.depart = depart;
	}
	public String getTrade() {
		return trade;
	}
	public void setTrade(String trade) {
		this.trade = trade;
	}
	public String getGongLing() {
		return gongLing;
	}
	public void setGongLing(String gongLing) {
		this.gongLing = gongLing;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public double getPostWage() {
		return postWage;
	}
	public void setPostWage(double postWage) {
		this.postWage = postWage;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
}
