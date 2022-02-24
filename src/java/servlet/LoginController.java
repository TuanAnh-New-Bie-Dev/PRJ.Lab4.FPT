/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.DAO;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jdbc.DBConnect;

/**
 *
 * @author tuan anh
 */
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cooky : cookies) {
                if (cooky.getName().equals("username")) {
                    System.out.println(cooky.getValue());
                    request.setAttribute("username", cooky.getValue());
                }
                if (cooky.getName().equals("password")) {
                    System.out.println(cooky.getValue());
                    request.setAttribute("password", cooky.getValue());
                }
            }
        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("check");

        System.out.println(username + " | " + password + " | " + remember);

        DAO dao = new DAO(DBConnect.getConnection());

        User user = dao.login(username, password);

        if (user != null) {

            if (remember != null) {
                Cookie c_user = new Cookie("username", username);
                Cookie c_pass = new Cookie("password", password);
                c_user.setMaxAge(3600 * 24 * 30);
                c_pass.setMaxAge(3600 * 24 * 30);
                response.addCookie(c_pass);
                response.addCookie(c_user);
            }

            HttpSession session = request.getSession();
            session.setAttribute("account", user);

            request.getRequestDispatcher("loginSuccess.jsp").forward(request, response);

        } else {
            out.println("login fail");
        }

    }

}
