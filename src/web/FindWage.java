package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persist.FindWageDao;

import domain.Users;
import domain.Wage;

public class FindWage extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String jobNum=request.getParameter("job");
		Users u=(Users)request.getSession().getAttribute("user");
		Wage w=new FindWageDao().findWageByNum(jobNum, u);
		if(w==null){
			request.setAttribute("msg", "Î´ÕÒµ½½á¹û£¡");
			request.getRequestDispatcher("showMessage.jsp").forward(request, response);
		}else{
			request.setAttribute("w", w);
			request.getRequestDispatcher("showWage.jsp").forward(request, response);
		}
	}

}
