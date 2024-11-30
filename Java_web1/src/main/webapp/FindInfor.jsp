<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
     <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <title>Tìm thông tin việc làm</title>
</head>
<body>
    <div class="container">
        <!-- Thẻ Card chứa tiêu đề -->
        <div class="card w-50 mx-auto my-5">
            <div class="card-header text-center">Tìm thông tin việc làm</div>
            <div class="card-body">
            
                <!-- Form tìm kiếm -->
                <form action="search-controll" method="post" class="form-inline mx-auto my-2 my-lg-0">
                   <input name="action" value="infor" type="hidden">
                    <div class="input-group input-group-sm mx-auto">
                        <input name="search" type="text" class="form-control" placeholder="Search..." aria-label="Search">
                        <div class="input-group-append">
                            <button type="submit" class="btn btn-secondary btn-number">
                                <i class="fa fa-search"></i> <!-- Đây là icon tìm kiếm -->
                            </button>
                        </div>
                    </div>
                </form>

                <!-- Bảng dữ liệu -->
                <div class="row mt-4">
                    <table class="table table-striped table-bordered text-center">
                        <thead>
                            <tr>
                                <th></th>
                                <th>Số CMND</th>
                                <th>Họ tên</th>
                                <th>Mã ngành (tốt nghiệp)</th>
                                <th>Mã trường</th>
                                <th>Mã ngành (công ty)</th>
                                <th>Tên công ty</th>
                                <th>Thời gian làm việc</th>
                            </tr>
                        </thead>
                        <tbody>  
                        <c:if test="${not empty listInfor}">
                          <c:forEach items="${listInfor}" var="i">
                            <tr>
                                <td></td>
                                <td>${i.soCMND }</td>
                                <td>${i.hoTen }</td>
                                <td>${i.maNganhTN }</td>
                                <td>${i.maTruong }</td>
                                <td>${i.maNganhCty }</td>
                                <td>${i.tenCty }</td>
                                <td>${i.tgianLam }</td>
                            </tr>
                            </c:forEach>
                          </c:if>
                          <c:if test="${empty listInfor }">
                          
                          </c:if>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
