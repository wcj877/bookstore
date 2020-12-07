package com.wsgs.bookstore.servlet;

import com.wsgs.bookstore.dao.OrdersDao;
import com.wsgs.bookstore.dao.impl.OrdersImpl;
import com.wsgs.bookstore.entity.Book;
import com.wsgs.bookstore.entity.Orders;
import com.wsgs.bookstore.utils.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrderServlet", urlPatterns = "/OrderServlet")
public class OrderServlet extends HttpServlet {

    OrdersDao dao = new OrdersImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");

        if ("add".equals(method)){
            this.add(request,response);
        } else if ("showAll".equals(method)){
            this.showAll(request, response);
        }
    }

    private void showAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currPage = request.getParameter("currentPage");
        // 判断
        if (currPage == null || "".equals(currPage.trim())) {
            currPage = "1"; // 第一次访问，设置当前页为1;
        }
        // 转换
        int currentPage = Integer.parseInt(currPage);

        // 创建PageBean对象，设置当前页参数； 传入service方法参数
        PageBean<Orders> pageBean = new PageBean<>();
        pageBean.setCurrentPage(currentPage);

        dao.querysAll(pageBean); // 【pageBean已经被dao填充了数据】
        // 保存pageBean对象，到request域中

        List<Orders> ordersList = pageBean.getPageData();

        request.setAttribute("pageBean", pageBean);
        request.setAttribute("ordersList", ordersList);
        request.getRequestDispatcher("/admin/order/orderList.jsp").forward(request, response);

    }

    private void add(HttpServletRequest request, HttpServletResponse response) {

    }
}
