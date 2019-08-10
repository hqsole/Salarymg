package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persist.FindStaffDao;
import domain.Staff;
import domain.Users;

public class FindStaff extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Staff s=new Staff();
		s.setJobNum(request.getParameter("jobNum"));
		s.setName(request.getParameter("names"));
		s.setSex(request.getParameter("sex"));
		String age=request.getParameter("age");
		if(age!=null&&age.length()>0)
			s.setAge(Integer.parseInt(age));
		s.setId(request.getParameter("idNum"));
		s.setDepart(request.getParameter("depart"));
		Users u=(Users)request.getSession().getAttribute("user");
		List<Staff> list=null;
		if(s.getJobNum()!=null&&s.getJobNum().length()>0){
			Staff ss=new FindStaffDao().findStaffByJobNum(s.getJobNum(), u);
			if(ss==null){
				request.setAttribute("msg", "未找到结果！");
				request.getRequestDispatcher("showMessage.jsp").forward(request, response);
			}else{
				list=new ArrayList<Staff>();
				list.add(ss);
				request.setAttribute("list", list);
				request.getRequestDispatcher("showStaff.jsp").forward(request, response);
			}
		}else if(s.getId()!=null&&s.getId().length()>0){
			Staff ss=new FindStaffDao().findStaffByIdNum(s.getId(), u);
			if(ss==null){
				request.setAttribute("msg", "未找到结果！");
				request.getRequestDispatcher("showStaff.jsp").forward(request, response);
			}else{
				list=new ArrayList<Staff>();
				list.add(ss);
				request.setAttribute("list", list);
				request.getRequestDispatcher("showStaff.jsp").forward(request, response);
			}
		}else{
			list=new FindStaffDao().findStaffs(s, u);
			if(list.size()<=0){
				request.setAttribute("msg", "未找到结果！");
				request.getRequestDispatcher("showStaff.jsp").forward(request, response);
			}else{
				request.setAttribute("list", list);
				request.getRequestDispatcher("showStaff.jsp").forward(request, response);
			}
		}
	}

}
