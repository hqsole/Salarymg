package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persist.FindStaffDao;

import domain.Staff;
import domain.Users;

public class PreUpdateStaff extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String jobNum=request.getParameter("jobNum");
		Users u=(Users)request.getSession().getAttribute("user");
		Staff s=new FindStaffDao().findStaffByJobNum(jobNum, u);
		request.setAttribute("s", s);
		request.getRequestDispatcher("updateStaff.jsp").forward(request, response);
	}
}
