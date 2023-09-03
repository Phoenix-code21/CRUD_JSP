<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="core.Database"%>
<%@include file="layouts/header.jsp" %>

<% 

	Database database = new Database();
	database.connection();
	
	PreparedStatement pst;
	ResultSet rs;
	
	pst = database.getConnection().prepareStatement("SELECT * FROM users WHERE id = ?");
	pst.setInt(1, Integer.parseInt(request.getParameter("id")));
	rs = pst.executeQuery();
	
	if(!rs.next()) {
		response.sendRedirect(request.getContextPath() + "/index.jsp");
		return;
	}
	
%>

<div class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
        
        	<div class="py-1 text-center">
			    <div class="container">
			      <div class="row">
			        <div class="col-md-12">
			          <h1>Tela atualizar dados</h1>
			        </div>
			      </div>
			    </div>
  			</div>
  			
  			<div class="py-5">
			    <div class="container">
			      <div class="row">
			        <div class="col-md-12">
			          <form action="ServletCrud" method="POST" class="">
			          	<input type="hidden" name="action" value="update">
			          	<input type="hidden" name="id" value="<%= rs.getString("id") %>">
			            <div class="form-group"> 
			            <label>Email</label> 
			            <input type="email" name="email" class="form-control" placeholder="Enter email" value="<%= rs.getString("email") %>"> </div>
			            <div class="form-group"> 
			            <label>Password</label> 
			            <input type="password" name="password" class="form-control" placeholder="Password" value="<%= rs.getString("password") %>"> </div> 
			            <button type="submit" class="btn btn-primary">Atualizar</button>
			          </form>
			        </div>
			      </div>
			    </div>
  			</div>
  			
        </div>
     </div>
  </div>
</div>

<%@include file="layouts/footer.jsp" %>