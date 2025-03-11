package com.servlets;

import com.entities.Note;
import com.helper.SessionProvider;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.util.Date;


//@WebServlet("/UpdateNoteServlet")
public class UpdateNoteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public UpdateNoteServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
//            Data Retrieval
            int noteID = Integer.parseInt(request.getParameter("id").trim());
            String title = request.getParameter("title").trim();
            String content = request.getParameter("content").trim();

//            Session Creation
            Session session = SessionProvider.getSessionFactory().openSession();
            Transaction txn = session.beginTransaction();

//            NOTE CREATION-THAT-TO-BE-SAVED
            Note note = (Note) session.get(Note.class, noteID);
            note.setTitle(title);
            note.setContent(content);
            note.setAddedDate(new Date());

//            SAVING PROCESS
            txn.commit();
            session.close();
            response.sendRedirect("all_notes.jsp");
        } catch (Exception exception) {
            System.out.println("\n\n\n\n\n"+exception.getMessage());
            response.getWriter().print("\n\n\n\n\n"+exception.getMessage());
        }
    }
}