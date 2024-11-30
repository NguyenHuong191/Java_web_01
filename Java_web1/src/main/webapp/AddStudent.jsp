<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<title>Add student</title>
</head>
<body>
   <%
      String errorMessage = (String) request.getAttribute("errorMessage");
      if(errorMessage != null){
   %>
   <script type="text/javascript">
        alert("<%= errorMessage %>");
    </script>
    <%
        }
    %>
    
   <div class="container">
		<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center">Add Student</div>
			<div class="card-body">
				<form action="AddStudentControll" method="post">
					<div class="form-group">
						<label>Số CMND</label> 
						<input type="text" name="soCMND" class="form-control" placeholder="Nhập số CMND">
					</div>
					<div class="form-group">
						<label>Họ tên</label> 
                        <input type="text" name="hoTen" class="form-control" placeholder="Nhập họ tên" />					
                    </div>
                    <div class="form-group">
						<label>Email</label> 
                        <input type="text" name="email" class="form-control" placeholder="Nhập email" />					
                    </div>
                    <div class="form-group">
						<label>Số điện thoại</label> 
                        <input type="text" name="phone" class="form-control" placeholder="Nhập số điện thoại" />					
                    </div>
					<div class="form-group">
						<label>Địa chỉ</label> 
                        <input type="text" name="diaChi" class="form-control" placeholder="Nhập Địa Chỉ" />					
                        </div>
                    <div class="form-group">
                        <label for="maTruong">Chọn Trường:</label>
                        <select name="maTruong" id="maTruong" class="form-control">
                           <c:forEach items="${truongList}" var="t">
                            <option value="${t.name}" >${t.name}</option>
                            </c:forEach>
                         </select>
                    </div>
                    <div class="form-group">
                        <label for="maNganh">Chọn Ngành:</label>
                        <select name="maNganh" id="maNganh" class="form-control">
                           <c:forEach items="${nganhList}" var="n">
                            <option value="${n.ten}" >${n.ten}</option>
                            </c:forEach>
                         </select>
                    </div>
                     <div class="form-group">
						<label>Hệ tốt nghiệp</label> 
                        <input type="text" name="heTN" class="form-control" placeholder="Nhập hệ tốt nghiệp" />					
                    </div>
                     <div class="form-group">
						<label>Ngày tốt nghiệp</label> 
                        <input type="date" name="NgayTN" class="form-control" placeholder="" />					
                    </div>
                     <div class="form-group">
						<label>Loại tốt nghiệp</label> 
                        <input type="text" name="loaiTN" class="form-control" placeholder="Nhập loại tốt nghiệp" />					
                    </div>
					<div class="text-center">
						<button type="submit" class="btn btn-primary">Thêm sinh viên</button>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>