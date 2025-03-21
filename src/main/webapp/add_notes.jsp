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
                $("#addnotes").addClass("active");
            });
        </script>

        <title>Add Notes</title>
    </head>


    <body>
        <div class="container-fluid p-0 m-0">
            <%@include file="navbar.jsp" %>
        </div>
        <br>

        <div class="container">
            <h2>
                Please fill notes Details
            </h2>

            <form action="SaveNoteServlet" method="post">
                <div class="form-group">
                    <label for="title">
                        Note Title
                    </label>
                    <input type="text" class="form-control" id="title" name="title" aria-describedby="emailHelp" placeholder="Enter title" required>
                </div>
                <div class="form-group">
                    <label for="title">
                        Note Content
                    </label>
                    <textarea name="content" id="content" required placeholder="Enter your content here" class="form-control" style="height:300px"></textarea>
                </div>
                <div class="container text-center">
                    <button type="submit" class="btn btn-primary">
                        Save Your Note
                    </button>
                </div>
            </form>
        </div>
        <br><br>

    </body>
</html>