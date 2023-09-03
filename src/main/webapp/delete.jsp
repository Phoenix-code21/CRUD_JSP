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
				         <h1>Tela de excluir dados</h1>
				     </div>
				  </div>
			  </div>
	  		</div>
	  		
          <div class="card">
            <div class="card-header"> Excluir </div>
            <div class="card-body">
              <div class="row">
	              <div class="col-md-12">
	             	 <strong>Deseja excluir usuário <%= rs.getString("email") %> ? </strong>
	              </div>
	              <div class="col-md-12">
	              	 <form method="POST" action="ServletCrud">
	              	    <input type="hidden" name="action" value="delete" />
	             	 	<input type="hidden" name="option" value="yes" />
	             	 	<input type="hidden" name="id" value="<%= rs.getString("id") %>" />
	             	 	<button type="submit" class="btn btn-success">Sim</button>
	              	 </form>
	              </div><hr>  
	              <div class="col-md-12">
	             	 <form method="POST" action="ServletCrud">
	              	    <input type="hidden" name="action" value="delete" />
	             	 	<input type="hidden" name="id" value="<%= rs.getString("id") %>" />
	             	 	<input type="hidden" name="option" value="no" />
	             	 	<button type="submit" class="btn btn-danger">Não</button>
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