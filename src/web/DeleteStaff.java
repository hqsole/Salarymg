package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Users;

import persist.OperatorStaff;

public class DeleteStaff extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String jobNum=request.getParameter("jobNum");
		OperatorStaff os=new OperatorStaff();
		Users u=(Users)request.getSession().getAttribute("user");
		os.deleteStaff(jobNum, u);
		request.setAttribute("msg", "É¾³ý³É¹¦£¡");
		request.getRequestDispatcher("showMessage.jsp").forward(request, response);
	}

}
