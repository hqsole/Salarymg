package domain;

import java.io.Serializable;

public class Wage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String jobNum;
	private double jobSub;
	private double attenDays;
	private double overDays;
	private double overHours;
	private double overCate;
	private String overPay;
	private double sickLeave;
	private double leaveCharge;
	private double other;
	private double shouldWage;
	private double realWage;
	public String getJobNum() {
		return jobNum;
	}
	public void setJobNum(String jobNum) {
		this.jobNum = jobNum;
	}
	public double getJobSub() {
		return jobSub;
	}
	public void setJobSub(double jobSub) {
		this.jobSub = jobSub;
	}
	public double getAttenDays() {
		return attenDays;
	}
	public void setAttenDays(double attenDays) {
		this.attenDays = attenDays;
	}
	public double getOverDays() {
		return overDays;
	}
	public void setOverDays(double overDays) {
		this.overDays = overDays;
	}
	public double getOverHours() {
		return overHours;
	}
	public void setOverHours(double overHours) {
		this.overHours = overHours;
	}
	public double getOverCate() {
		return overCate;
	}
	public void setOverCate(double overCate) {
		this.overCate = overCate;
	}
	public String getOverPay() {
		return overPay;
	}
	public void setOverPay(String overPay) {
		this.overPay = overPay;
	}
	public double getSickLeave() {
		return sickLeave;
	}
	public void setSickLeave(double sickLeave) {
		this.sickLeave = sickLeave;
	}
	public double getLeaveCharge() {
		return leaveCharge;
	}
	public void setLeaveCharge(double leaveCharge) {
		this.leaveCharge = leaveCharge;
	}
	public double getOther() {
		return other;
	}
	public void setOther(double other) {
		this.other = other;
	}
	public double getShouldWage() {
		return shouldWage;
	}
	public void setShouldWage(double shouldWage) {
		this.shouldWage = shouldWage;
	}
	public double getRealWage() {
		return realWage;
	}
	public void setRealWage(double realWage) {
		this.realWage = realWage;
	}
}
