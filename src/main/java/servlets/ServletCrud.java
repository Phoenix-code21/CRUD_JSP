package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import core.Database;
import core.Helpers;

/**
 * Servlet implementation class ServletCrud
 */
public class ServletCrud extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCrud() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// Helpers
		Helpers helpers = new Helpers();
		
		// actions
		String action = request.getParameter("action");
		
		// nenhuma ação identificada
		if(action == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			request.setAttribute("msg", helpers.message("Ação não identificada!", "error"));
			dispatcher.forward(request, response);
			return;
		}
		
		// create
		if(action.equals("create")) {
		
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			if(email == null || email.equals("") || password == null || password.equals("")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				request.setAttribute("msg", helpers.message("Preencha todos os campos", "error"));
				dispatcher.forward(request, response);
				return;
			}
			
			Database database = new Database();
			database.connection();
			
			PreparedStatement pst;
			ResultSet rs;
			
			try {
				pst = database.getConnection().prepareStatement("SELECT email FROM users WHERE email = ?");
				pst.setString(1, email);
				rs = pst.executeQuery();
				
				if(rs.next()) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
					request.setAttribute("msg", helpers.message("Endereço de e-mail já cadastrado", "error"));
					dispatcher.forward(request, response);
					return;
				}
				
				pst = database.getConnection().prepareStatement("INSERT INTO users (email, password) VALUES (?, ?)");
				pst.setString(1, email);
				pst.setString(2, password);
				
				if(pst.executeUpdate() > 0) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
					request.setAttribute("msg", helpers.message("Dados cadastrados com sucesso!", "success"));
					dispatcher.forward(request, response);
					return;
				}
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				request.setAttribute("msg", helpers.message("Erro ao cadastrar dados!", "error"));
				dispatcher.forward(request, response);
				return;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		// update
		if(action.equals("update")) {
			
			String id = request.getParameter("id");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			
			if(id == null || id.equals("") || email == null || email.equals("") || password == null || password.equals("")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("update.jsp?id=" + id);
				request.setAttribute("msg", helpers.message("Preencha todos os campos", "error"));
				dispatcher.forward(request, response);
				return;
			}
			
			Database database = new Database();
			database.connection();
			
			PreparedStatement pst;
			ResultSet rs;
			
			try {
				
				pst = database.getConnection().prepareStatement("SELECT id, email FROM users WHERE email = ?");
				pst.setString(1, email);
				rs = pst.executeQuery();
				
				if(rs.next()) {
					if(rs.getInt("id") != Integer.parseInt(id)) {
						RequestDispatcher dispatcher = request.getRequestDispatcher("update.jsp?id=" + id);
						request.setAttribute("msg", helpers.message("Endereço de e-mail já cadastrado", "error"));
						dispatcher.forward(request, response);
						return;
					}
				}
				
				pst = database.getConnection().prepareStatement("UPDATE users SET email = ?, password = ? WHERE id = ?");
				pst.setString(1, email);
				pst.setString(2, password);
				pst.setInt(3, Integer.parseInt(id));
				
				if(pst.executeUpdate() > 0) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("update.jsp?id=" + id);
					request.setAttribute("msg", helpers.message("Dados atualizados com sucesso!", "success"));
					dispatcher.forward(request, response);
					return;
				}
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("update.jsp?id=" + id);
				request.setAttribute("msg", helpers.message("Erro ao atualizar dados!", "error"));
				dispatcher.forward(request, response);
				return;
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		// delete
		if(action.equals("delete")) {
			
			String id = request.getParameter("id");
			String option = request.getParameter("option");
			
			if(id == null || id.equals("") || option == null || option.equals("")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("delete.jsp?id=" + id);
				request.setAttribute("msg", helpers.message("Selecione uma das opções", "error"));
				dispatcher.forward(request, response);
				return;
			}
			
			if(option.equals("yes")) {
				
				Database database = new Database();
				database.connection();
				
				PreparedStatement pst;
				ResultSet rs;
				
				try {
					pst = database.getConnection().prepareStatement("SELECT id FROM users WHERE id = ?");
					pst.setInt(1, Integer.parseInt(id));
					rs = pst.executeQuery();
					
					if(!rs.next()) {
						RequestDispatcher dispatcher = request.getRequestDispatcher("delete.jsp?id=" + id);
						request.setAttribute("msg", helpers.message("Usuário não encontrado", "error"));
						dispatcher.forward(request, response);
						return;
					}
					
					pst = database.getConnection().prepareStatement("DELETE FROM users WHERE id = ?");
					pst.setInt(1, Integer.parseInt(id));
					
					if(pst.executeUpdate() > 0) {
						RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
						request.setAttribute("msg", helpers.message("Usuário deletado com sucesso", "success"));
						dispatcher.forward(request, response);
						return;
					}
					
					RequestDispatcher dispatcher = request.getRequestDispatcher("delete.jsp?id=" + id);
					request.setAttribute("msg", helpers.message("Erro ao deletar usuário", "error"));
					dispatcher.forward(request, response);
					return;
					
				}catch(SQLException e) {
					e.printStackTrace();
				}
				
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("delete.jsp?id=" + id);
			request.setAttribute("msg", helpers.message("Usuário não foi deletado devido opção selecionada", "error"));
			dispatcher.forward(request, response);
			return;
			
		}
		
	}

}
