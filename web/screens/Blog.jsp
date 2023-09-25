
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DURIAN STORE</title>
        <!-- css -->
        <link rel="stylesheet" href="styles/nav-bar.css" type="text/css"/>
        <link rel="stylesheet" href="styles/footer.css" type="text/css"/>
        <link rel="stylesheet" href="styles/blog.css" type="text/css"/>
        <link rel="stylesheet" href="styles/footer.css" type="text/css"/>
        <!-- Font family -->
        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
        <link
            href="https://fonts.googleapis.com/css2?family=Montserrat:wght@500&family=Shadows+Into+Light&display=swap"
            rel="stylesheet"
            />
        <!-- Favicon -->
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
            />
    </head>
    <body>
        <div class="header-container">
            <jsp:include page="../screens/navbar.jsp"></jsp:include>
            </div>
            <section class="container">
                <hr/>
      <div class="side-bar">
        <ul class="category">
          <a href="#">
            <li class="link">News</li>
          </a>
          <a href="#">
            <li class="link">Reviews</li>
          </a>
          <a href="#">
            <li class="link">Updates and Features</li>
          </a>
          <a href="#">
            <li class="link">Tips</li>
          </a>
        </ul>
      </div>
      <div class="blog-container">
        <div class="blog-title">
          Thời nghệ tuần 3 tháng 7: Beats Studio Pro ra mắt, iPhone 16 Pro Max
          có camera siêu tele
        </div>
        <div class="profile">
            <span class="p-name">@Kieu Viet Kien</span>
            <span class="p-date">24/07/2022</span>
        </div>
        <div class="sub-blog">
          <div class="sub-title">iPhone 16 Pro Max sẽ có camera siêu tele?</div>
          <div class="sub-content">
            <p>
              Một rò rỉ xuất hiện trong tuần này vừa tiết lộ thông tin cho biết
              iPhone 16 Pro Max có thể là điện thoại đầu tiên sở hữu camera sử
              dụng ống kính tiềm vọng siêu tele để tăng khả năng zoom quang học.
              <div class="img">
              <img
                src="https://cdn.sforum.vn/sforum/wp-content/uploads/2023/07/iPhone-15-Pro-camera.jpeg"
              />
            </div>
              Theo người dùng Twitter "RGcloudS", dòng ‌iPhone 15‌ sẽ có công
              nghệ pin xếp chồng lên nhau. Được biết, công nghệ pin mới này
              trước đó cũng từng được đồn đại trên mẫu flagship Galaxy S24 Ultra
              sẽ được Samsung ra mắt vào đầu năm sau. Vậy công nghệ này sẽ giúp
              dòng iPhone 15 có pin tốt hơn? Bạn có thể tìm hiểu thêm ở bài viết
              dưới đây.
            </p>
          </div>
        </div>
        <div class="sub-blog">
            <div class="sub-title">iPhone 16 Pro Max sẽ có camera siêu tele?</div>
            <div class="sub-content">
              <p>
                Một rò rỉ xuất hiện trong tuần này vừa tiết lộ thông tin cho biết
                iPhone 16 Pro Max có thể là điện thoại đầu tiên sở hữu camera sử
                dụng ống kính tiềm vọng siêu tele để tăng khả năng zoom quang học.
                <div class="img">
                <img
                  src="https://cdn.sforum.vn/sforum/wp-content/uploads/2023/07/iPhone-15-Pro-camera.jpeg"
                />
              </div>
                Theo người dùng Twitter "RGcloudS", dòng ‌iPhone 15‌ sẽ có công
                nghệ pin xếp chồng lên nhau. Được biết, công nghệ pin mới này
                trước đó cũng từng được đồn đại trên mẫu flagship Galaxy S24 Ultra
                sẽ được Samsung ra mắt vào đầu năm sau. Vậy công nghệ này sẽ giúp
                dòng iPhone 15 có pin tốt hơn? Bạn có thể tìm hiểu thêm ở bài viết
                dưới đây.
              </p>
            </div>
          </div>
      </div>
                <hr/>
    </section>
            

        <jsp:include page="../screens/footer.jsp"></jsp:include>


    </body>
</html>
