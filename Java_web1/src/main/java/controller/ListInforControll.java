package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ListDisplay;
import model.Infor;


@WebServlet("/findInfor")
public class ListInforControll extends HttpServlet {
	private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        try {
            ListDisplay listDAO = new ListDisplay();
            List<Infor> infors = listDAO.getAllInfor();
            
            request.setAttribute("listInfor", infors);
            request.getRequestDispatcher("FindInfor.jsp").forward(request, response);  // Chuyển đến trang hiển thị
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
