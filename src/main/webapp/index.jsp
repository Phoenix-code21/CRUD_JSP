<%@include file="layouts/header.jsp" %>

<div class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
        
        <div class="py-1 text-center">
		    <div class="container">
		      <div class="row">
		        <div class="col-md-12">
		          <h1>Tela de cadastro de dados</h1>
		        </div>
		      </div>
		    </div>
  		</div>
        
          <form action="ServletCrud" method="POST" class="">
          
          	<input name="action" type="hidden" value="create" />
            
            <div class="form-group"> 
            	<label>E-mail</label> 
            	<input type="email" name="email" class="form-control" placeholder="Entre com seu email">  
            </div>
            
            <div class="form-group"> 
            	<label>Password</label> 
            	<input type="password" name="password" class="form-control" placeholder="Password"> 
            </div> 
            
            <button type="submit" class="btn btn-primary">Cadastrar</button>
          </form>
        </div>
      </div>
    </div>
  </div>

<%@include file="layouts/footer.jsp" %>