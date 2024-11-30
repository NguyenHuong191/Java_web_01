package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SearchDAO;
import model.Infor;
import model.Student;


@WebServlet("/search-controll")
public class SearchControll extends HttpServlet {       
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String action = request.getParameter("action");
		String text = request.getParameter("search");
		
		try {
			SearchDAO searchDAO = new SearchDAO();
			if(action.equals("student")) {
			    List<Student> student = searchDAO.getSearchStudent(text);
				request.setAttribute("listStudent", student);
	            request.getRequestDispatcher("Find.jsp").forward(request, response);  // Chuyển đến trang hiển thị
			}else {
				List<Infor> infor = searchDAO.getSearchInfor(text);
			    request.setAttribute("listInfor", infor);
	            request.getRequestDispatcher("FindInfor.jsp").forward(request, response);  // Chuyển đến trang hiển thị
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
