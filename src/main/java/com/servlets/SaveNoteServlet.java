package com.servlets;

import com.entities.Note;
import com.helper.SessionProvider;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;


//@WebServlet("/SaveNoteServlet")
public class SaveNoteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public SaveNoteServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
//            DATA RETRIEVAL
            String title = request.getParameter("title").trim();
            String content = request.getParameter("content").trim();
            Note note = new Note(title, content, new Date());

//            SESSION CREATION
            Session session = SessionProvider.getSessionFactory().openSession();
            Transaction txn = session.beginTransaction();
//            SAVING THE NOTE
            session.save(note);
            txn.commit();
            session.close();

//            SHOWING USER RESPONSE
            response.getWriter().print("<h1 style='text-align:center;'>Note is added successfully</h1>");
            response.getWriter().print("<h1 style='text-align:center;'><a href='all_notes.jsp'>View all notes</a></h1>");
        } catch (Exception exception) {
            System.out.println("\n\n\n\n\n"+exception.getMessage());
            response.getWriter().print("\n\n\n\n\n"+exception.getMessage());
        }
    }
}