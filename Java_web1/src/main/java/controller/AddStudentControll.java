package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AddStudentDAO;
import model.Student;
import model.TotNghiep;


@WebServlet("/AddStudentControll")
public class AddStudentControll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
        
        try(PrintWriter out = response.getWriter()){
        	
		String soCMND = request.getParameter("soCMND");
		String hoTen = request.getParameter("hoTen");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String diaChi = request.getParameter("diaChi");
		String tenTruong = request.getParameter("maTruong");
		String tenNganh = request.getParameter("maNganh");
		String heTN = request.getParameter("heTN");
		Date ngayTn = Date.valueOf(request.getParameter("NgayTN"));
		String loaiTN = request.getParameter("loaiTN");
		
		if(soCMND == null || soCMND.trim().isEmpty() || tenTruong == null || tenTruong.trim().isEmpty() || tenNganh  == null || tenNganh.trim().isEmpty()) {
			request.setAttribute("errorMessage", "Số CMND, mã trường, mã ngành không được để trống!");
            request.getRequestDispatcher("AddStudent.jsp").forward(request, response);
            return;
		}
		
		try {
			
			Student sinhVien = new Student(soCMND, hoTen, email, phone, diaChi);
			AddStudentDAO addStudentDAO = new AddStudentDAO();
			
			int maTruong = addStudentDAO.getTruongId(tenTruong);
						
			int maNganh = addStudentDAO.getNganhId(tenNganh);
			
            TotNghiep totNghiep = new TotNghiep(soCMND, maTruong, maNganh, heTN,ngayTn, loaiTN);
			
			boolean sinhVienExits = addStudentDAO.isSinhVienExist(soCMND);
			
			if(sinhVienExits) {
                boolean isTotNghiepInserted = addStudentDAO.insertTotNghiep(totNghiep);
                
                if(isTotNghiepInserted) {
                	request.setAttribute("errorMessage", "Thêm thành công!");
                    request.getRequestDispatcher("AddStudent.jsp").forward(request, response);
                }else {
                	request.setAttribute("errorMessage", "Thêm tốt nghiệp thất bại!");
                    request.getRequestDispatcher("AddStudent.jsp").forward(request, response);
                }
			
			}else {
				
                boolean sinhVienInserted = addStudentDAO.insertSvien(sinhVien);
                boolean isTotNghiepInserted = addStudentDAO.insertTotNghiep(totNghiep);
                    
                if(isTotNghiepInserted && sinhVienInserted) {
                    	request.setAttribute("errorMessage", "Thêm thành công!");
                        request.getRequestDispatcher("AddStudent.jsp").forward(request, response);
                    
                }else {
                	request.setAttribute("errorMessage", "Thêm thất bại!");
                    request.getRequestDispatcher("AddStudent.jsp").forward(request, response);
                }
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		
	}
	}
}
