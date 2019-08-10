package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import persist.LoginDao;

import domain.Users;

public class Login extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userName=request.getParameter("userName");
		String pwd=request.getParameter("pwd");
		Users u=new Users();
		u.setUserName(userName);
		u.setPws(pwd);
		LoginDao ld=new LoginDao();
		try {
			ld.login(u);
			HttpSession session=request.getSession();
			session.setAttribute("user", u);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (Exception e) {e.printStackTrace();
			request.setAttribute("msg","µÇÂ¼Ê§°Ü£¡");
			request.getRequestDispatcher("showMessage.jsp").forward(request, response);
		}
	}
}