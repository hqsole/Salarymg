package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persist.OperatorWage;

import domain.Users;
import domain.Wage;

public class UpdateWage extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String jobNum=request.getParameter("jobNum");
		String jobSub=request.getParameter("sub");
		String attenDay=request.getParameter("day");
		String overHour=request.getParameter("overHour");
		String overDay=request.getParameter("overDay");
		String overCate=request.getParameter("overCate");
		String overPay=request.getParameter("overPay");
		String sickLeave=request.getParameter("sick");
		String leave=request.getParameter("leave");
		String other=request.getParameter("other");
		String shuldPay=request.getParameter("should");
		String realPay=request.getParameter("real");
		Users u=(Users)request.getSession().getAttribute("user");
		Wage w=new Wage();
		
		w.setJobNum(jobNum);
		if(jobSub!=null&&jobSub.length()>0)
			w.setJobSub(Double.parseDouble(jobSub));
		if(attenDay!=null&&attenDay.length()>0)
			w.setAttenDays(Double.parseDouble(attenDay));
		if(overHour!=null&&overHour.length()>0)
			w.setOverHours(Double.parseDouble(overHour));
		if(overDay!=null&&overDay.length()>0)
			w.setOverDays(Double.parseDouble(overDay));
		if(overCate!=null&&overCate.length()>0)
			w.setOverCate(Double.parseDouble(overCate));
		w.setOverPay(overPay);
		if(sickLeave!=null&&sickLeave.length()>0)
			w.setSickLeave(Double.parseDouble(sickLeave));
		if(leave!=null&&leave.length()>0)
			w.setLeaveCharge(Double.parseDouble(leave));
		if(other!=null&&other.length()>0)
			w.setOther(Double.parseDouble(other));
		if(shuldPay!=null&&shuldPay.length()>0)
			w.setShouldWage(Double.parseDouble(shuldPay));
		if(realPay!=null&&realPay.length()>0)
			w.setRealWage(Double.parseDouble(realPay));
		OperatorWage ow=new OperatorWage();
		ow.updateWage(w, u);
		request.setAttribute("msg", "ÐÞ¸Ä³É¹¦!");
		request.getRequestDispatcher("showMessage.jsp").forward(request, response);
	}
}
