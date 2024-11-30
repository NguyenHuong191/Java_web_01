package controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NganhDAO;
import dao.TruongDAO;
import model.Nganh;
import model.Truong;

@WebServlet("/add-student")
public class HomeControll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          response.setContentType("text/html;charset=UTF-8");
		try {
			TruongDAO truongDAO = new TruongDAO();
			List<Truong> truong = truongDAO.getAllTruong();
			request.setAttribute("truongList", truong);
		} catch (SQLException e) {
			e.printStackTrace();
		}
          
          
         try {
        	 NganhDAO nganhDAO = new NganhDAO();
 			List<Nganh> nganh = nganhDAO.getAllNganh(); 
 			request.setAttribute("nganhList", nganh);
		} catch (Exception e) {
			e.printStackTrace();
		}
          
          RequestDispatcher dispatcher = request.getRequestDispatcher("/AddStudent.jsp");
          dispatcher.forward(request, response);
	}  



}

