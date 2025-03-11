<!doctype html>

<html lang="en">
<head>
    <meta charset="uft-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <%@include file="masterJSandStyle.jsp" %>
    <script type="text/javascript">
        $(document).ready(function(){
            $(".active").removeClass("active");
            $("home").addClass("active");
        })
    </script>

    <title> Home Page </title>
</head>


<body>
    <div class="container-fluid p-0 m-0">
        <%@include file="navbar.jsp" %>
        <br>

        <div class="card">
            <img src="assets/images/notes.png" alt="Shree Govind Jee Notes" class="img-fluid mx-auto" style="width:400px"/>
            <br>

            <div class="container text-center">
                <a href="add_notes.jsp" class="btn btn-outline-primary text-center">
                    Start Here
                </a>
            </div>
            <br><br>
        </div>
    </div>
</body>

</html>
