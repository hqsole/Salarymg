package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persist.OperatorStaff;

import domain.Staff;
import domain.Users;

public class UpdateStaff extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Staff s=new Staff();
		s.setJobNum(request.getParameter("jobNum2"));
		s.setName(request.getParameter("name2"));
		s.setSex(request.getParameter("sex"));
		String age=request.getParameter("age2");
		if(age!=null&&age.length()>0){
			s.setAge(Integer.parseInt(age));
		}else
		 s.setAge(0);
		s.setHome(request.getParameter("hometown2"));
		s.setId(request.getParameter("idNum2"));
		s.setStatus(request.getParameter("marital_status2"));
		s.setEdu(request.getParameter("edu2"));
		s.setDepart(request.getParameter("depart2"));
		s.setTrade(request.getParameter("trade2"));
		s.setGongLing(request.getParameter("gongling2"));
		s.setLevel(request.getParameter("level2"));
		String w=request.getParameter("wage2");
		if(w!=null&&w.length()>0)
			s.setPostWage(Double.parseDouble(w));
		else
			s.setPostWage(0.0);
		OperatorStaff os=new OperatorStaff();
		Users u=(Users)request.getSession().getAttribute("user");
		os.updateStaff(s, u);
		request.setAttribute("msg", "ÐÞ¸Ä³É¹¦£¡");
		request.getRequestDispatcher("showMessage.jsp").forward(request, response);
	}
}
