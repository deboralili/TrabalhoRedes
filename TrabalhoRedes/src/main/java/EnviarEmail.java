/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.SimpleEmail;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EnviarEmail extends HttpServlet {

    public static void Brigde(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        System.out.println("Indo pegar os dados.");
        String emailFrom = req.getParameter("txtEmailFrom");
        String senha = req.getParameter("txtSenha");
        String emailTo = req.getParameter("txtEmailTo");
        String assunto = req.getParameter("txtAssunto");
        String mensagem = req.getParameter("txtMensagem");

        Submit(emailFrom, senha, emailTo, assunto, mensagem);

    }

    public static void Submit(String emailFrom, String senha, String emailTo, String assunto, String mensagem) {
        System.out.println("Estabelecendo conexao...");
        SimpleEmail email = new SimpleEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator(emailFrom, senha));
        email.setSSLOnConnect(true);
        System.out.println("Preparando para enviar mensagem...");

        try {
            email.setFrom(emailFrom);
            email.setSubject(assunto);
            email.setMsg(mensagem);
            email.addTo(emailTo);
            email.send();
            System.out.println("Email foi enviado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param req servlet request
     * @param res servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        try {
            processRequest(req, res);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }

    protected void processRequest(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException, SQLException, ClassNotFoundException {

        String acao = req.getParameter("acao");

        if (acao == "MandarEmail") {
            Brigde(req, res);
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param req servlet request
     * @param res servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        try {
            processRequest(req, res);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
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
