package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Student;
import dao.ListDisplay;


@WebServlet("/findStudent")
public class ListStudentControll extends HttpServlet {
	private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        try {
            ListDisplay listDAO = new ListDisplay();
            List<Student> students = listDAO.getAllStudent();
            request.setAttribute("listStudent", students);
            request.getRequestDispatcher("Find.jsp").forward(request, response);  // Chuyển đến trang hiển thị
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
