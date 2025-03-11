<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.entities.Note"%>
<%@page import="com.helper.SessionProvider"%>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <%@include file="masterJSandStyle.jsp" %>
        <script type="text/javascript">
            $(document).ready(function(){
                $(".active").removeClass("active");
                $("#all_notes").addClass("active");
            });
        </script>

        <title>All Notes</title>
    </head>


    <body>
        <div class="container-fluid p-0 m-0">
            <%@include file="navbar.jsp" %>
        </div>

        <div class="container">
            <br>

            <h2> All Notes </h2>
            <%
                SimpleDateFormat f = new SimpleDateFormat("HH:mm dd MMMM yyyy");
                Session session2 = SessionProvider.getSessionFactory().openSession();
                Query query = session2.createQuery("from Note");
                List<Note> notelist = query.list();
                for (Note nl:notelist) {
            %>
                <div class="card mt-3">
                    <div class="card-body">
                        <img src="assets/images/notes.png" class="card-img-top" style="max-width:50px" alt="Shree Govind Jee Card Image Cap">
                        <br><br>

                        <h5 class="card-title"><%=nl.getTitle()%></h5>
                        <p class="card-title"><%=nl.getContent()%></p>
                        <br>

                        <div class"container text-right">
                            <h6 class="card-title">
                                <%=f.format(nl.getAddedDate())%>
                            </h6>
                        </div>

                        <form action="DeleteNoteServlet" method="post" class="inline">
                            <input type="hidden" name="id" value="<%=nl.getID()%>">
                            <button type="submit" class="btn btn-danger">
                                Delete
                            </button>
                        </form>
                        <form action="edit.jsp" method="post" class="inline">
                            <input type="hidden" name="id" value="<%=nl.getID()%>">
                            <button type="submit" class="btn btn-success">
                                Update
                            </button>
                        </form>
                    </div>
                </div>

            <%
                }
                session2.close();
            %>
        </div>

    </body>
</html>