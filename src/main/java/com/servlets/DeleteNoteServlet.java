package com.servlets;

import com.entities.Note;
import com.helper.SessionProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;


//@WebServlet("/DeleteNoteServlet")
public class DeleteNoteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public DeleteNoteServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
//            NOTE-ID
            int noteID = Integer.parseInt(request.getParameter("id").trim());

//            SESSION MANAGE
            Session session = SessionProvider.getSessionFactory().openSession();
            Transaction txn = session.beginTransaction();

//            EXTRACTING THE NOTE
            Note note = (Note) session.get(Note.class, noteID);
//            DELETING THE NOTE
            session.delete(note);
            txn.commit();
            session.close();
            response.sendRedirect("all_notes.jsp");
        } catch (Exception exception) {
            System.out.println("\n\n\n\n\n"+exception.getMessage());
            response.getWriter().print("\n\n\n\n\n"+exception.getMessage());
        }
    }
}