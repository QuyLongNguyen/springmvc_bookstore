<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <!-- Bootstrap CSS CDN -->
    <link rel="stylesheet"
			href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
    <!-- Our Custom CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin-style.css">

    <!-- Font Awesome JS -->
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js" integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ" crossorigin="anonymous"></script>
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js" integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY" crossorigin="anonymous"></script>
</head>

<body>
    
        <!-- Sidebar  -->
        <nav id="sidebar">
            <div class="sidebar-header">
               <a href="${pageContext.request.contextPath}/admin"><h3>Hogwarts bookstore</h3></a>
            </div>

            <ul class="list-unstyled components">
                <a href="${pageContext.request.contextPath}/admin"><p>Trang quản trị </p></a>
                <li class="active">
                    <a href="#homeSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Quản lý sản phẩm</a>
                    <ul class="collapse list-unstyled" id="homeSubmenu">
                        <li>
                            <a href="${pageContext.request.contextPath}/admin/categories">Loại sản phẩm</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/admin/books">Tất cả sản phẩm</a>
                        </li>
                       
                    </ul>
                </li>
                 <li>
                    <a href="${pageContext.request.contextPath}/admin/users">Quản lý tài khoản</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/admin/carts">Quản lý giỏ hàng</a>
                </li>
                <li>
                    <a href="#pageSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Quản lý bán hàng</a>
                    <ul class="collapse list-unstyled" id="pageSubmenu">
                        <li>
                            <a href="${pageContext.request.contextPath}/admin/bills">Hóa đơn</a>
                        </li>
                        <li>
                            <a href="#">Doanh số bán hàng</a>
                        </li>
                        
                    </ul>
                </li>
               
                
            </ul>

            <ul class="list-unstyled CTAs">
                <li>
               		<form id="my_form" action="${pageContext.request.contextPath}/logout" method="POST">	
						<a class="dropdown-item download" href="javascript:{}" onclick="document.getElementById('my_form').submit(); return false;">Đăng xuất</a>
					</form>
                </li>
                <li><br></li>
                <li>
                    <a href="${pageContext.request.contextPath}/home" class="article">Quay về trang chủ</a>
                </li>
            </ul>
        </nav> 
    

    <!-- jQuery CDN - Slim version (=without AJAX) -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <!-- Popper.JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>

    <script type="text/javascript">
        $(document).ready(function () {
            $('#sidebarCollapse').on('click', function () {
                $('#sidebar').toggleClass('active');
            });
        });
    </script>
</body>

</html>