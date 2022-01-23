<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<!-- Sidenav -->
  <nav class="sidenav navbar navbar-vertical  fixed-left  navbar-expand-xs navbar-light bg-white" id="sidenav-main">
    <div class="scrollbar-inner">
      <!-- Brand -->
      <div class="sidenav-header  align-items-center">
        <a class="navbar-brand" href="javascript:void(0)">
          <img src="<c:url value = "/templates/assets/img/brand/blue.png" />" class="navbar-brand-img" alt="...">
        </a>
      </div>
      <div class="navbar-inner">
        <!-- Collapse -->
        <div class="collapse navbar-collapse" id="sidenav-collapse-main">
          <!-- Nav items -->
          <ul class="navbar-nav">
            <li class="nav-item ">
              <a class="nav-link ${tagactive == 4 ? "active": "" }" href="thongke">
                <i class="ni ni-tv-2 text-primary"></i>
                <span class="nav-link-text">Thống kê</span>
              </a>
            </li>
            
            <li class="nav-item">
              <a class="nav-link ${tagactive == 3 ? "active": "" }" href="information">
                <i class="ni ni-single-02 text-yellow"></i>
                <span class="nav-link-text">Profile</span>
              </a>
            </li>
            <li class="nav-item ">
              <a class="nav-link ${tagactive == 2 ? "active": "" }" href="list">
                <i class="ni ni-bullet-list-67 text-default"></i>
                <span class="nav-link-text">Danh sách sản phẩm</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link ${tagactive == 1 ? "active": "" }" href="add">
                <i class="ni ni-key-25 text-info"></i>
                <span class="nav-link-text">Thêm sản phẩm</span>
              </a>
            </li>
          </ul>
          
          
        </div>
      </div>
    </div>
  </nav>