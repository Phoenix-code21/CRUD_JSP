<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="core.Database"%>
<%@page import="core.Helpers"%>
<%@include file="layouts/header.jsp" %>

<div class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
        	
        	<div class="py-1 text-center">
			    <div class="container">
			      <div class="row">
			        <div class="col-md-12">
			          <h1>Tela de leitura de dados</h1>
			        </div>
			      </div>
			    </div>
  			</div>
  			
  			
  			<div class="py-5">
			    <div class="container">
			      <div class="row">
			        <div class="col-md-12">
			          <div class="card">
			            <div class="card-header"> Dados dos usuários </div>
			            <div class="card-body">
			              <%
			              	Helpers helpers = new Helpers();
			                
			              	Database database = new Database();
			                database.connection();
			                
			                PreparedStatement pst;
			                ResultSet rs;
			                
			                pst = database.getConnection().prepareStatement("SELECT * FROM users");
			                rs = pst.executeQuery();
			                
			                while(rs.next()) {
			           
			              %>
			              	<p>
			              	  <%= rs.getString("email") %> 
			              	| <a class="btn btn-sm btn-primary" href="update.jsp?id=<%= rs.getString("id") %>">Atualizar</a> 
			              	| <a class="btn btn-sm btn-danger" href="delete.jsp?id=<%= rs.getString("id") %>">Deletar</a></p>
			              <% } %>
			            </div>
			          </div>
			        </div>
			      </div>
			    </div>
  			</div>
  			
          </div>
       </div>
   </div>
</div>

<%@include file="layouts/footer.jsp" %>