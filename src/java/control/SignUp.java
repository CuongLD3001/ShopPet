/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import Service.EncodeString;
import dao.DAO;
import entity.Account;
import entity.Email;
import static entity.Email.getRandom;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Random;

/**
 *
 * @author Admin
 */
public class SignUp extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public String genCaptcha() {

        char data[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char index[] = new char[5];

        Random r = new Random();
        int i = 0;
        String captcha = "";

        for (i = 0; i < 5; i++) {
            int ran = r.nextInt(data.length);
            index[i] = data[ran];
            captcha = String.valueOf(index);
        }
        return captcha;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        //sign up
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String c = genCaptcha();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("captcha", c);
        request.getRequestDispatcher("Signup.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Email mail = new Email();
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String re_pass = request.getParameter("repass");
        String email = request.getParameter("email");
        String pin = getRandom();
        String phone = request.getParameter("phone");
        Boolean gender = request.getParameter("gender").equals("M");
        String dob = request.getParameter("dob");
        String sq = request.getParameter("sq");
        String answer = request.getParameter("answer");
        String captcha = request.getParameter("checkcaptcha");
        request.setAttribute("user", user);
        request.setAttribute("pass", pass);
        request.setAttribute("email", email);
        request.setAttribute("phone", phone);
        request.setAttribute("gender", gender);
        request.setAttribute("dob", dob);
        request.setAttribute("sq", sq);
        request.setAttribute("answer", answer);
        request.setAttribute("captcha", c);
        if (!pass.equals(re_pass)) {
            request.setAttribute("mess2", "Different pass and repass");
            request.getRequestDispatcher("Signup.jsp").forward(request, response);
        } else if (!captcha.equals(c)) {
            request.setAttribute("mess2", "Wrong captcha code, please re-enter");
            request.getRequestDispatcher("Signup.jsp").forward(request, response);
        } else {
            DAO dao = new DAO();
            Account a = dao.checkAccountExist(user);
            if (a == null) {
                mail.SendEmail(pin, email);

                request.getSession().setAttribute("pin", pin);
                dao.signup(user, pass, email, phone, gender, dob, sq, answer);
                HttpSession session = request.getSession();
                session.setAttribute("acc", dao.getAccountByUser(user));
                response.sendRedirect("verifymail");
            } else {
                request.setAttribute("mess2", "Account already exists");
                request.getRequestDispatcher("Signup.jsp").forward(request, response);

            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
