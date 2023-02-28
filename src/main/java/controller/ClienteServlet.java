package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Cliente;
import persistence.ClienteDao;
import persistence.GenericDao;

@WebServlet("/cliente")
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ClienteServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String botao = request.getParameter("botao");
		
		GenericDao gDao = new GenericDao();
		ClienteDao cDao = new ClienteDao(gDao);
		
		Cliente cli = new Cliente();
		List<Cliente> clientes = new ArrayList<>();
		String erro = "";
		String saida = "";
		
		try {
			if(botao.equalsIgnoreCase("listar")) {
				clientes = cDao.list();
			} else {
				cli.setId(Integer.parseInt(request.getParameter("idCliente")));
				if(botao.equalsIgnoreCase("consultar") || botao.equalsIgnoreCase("excluir")) {
					if(botao.equalsIgnoreCase("consultar")) {
						cli = cDao.select(cli);
					} else {
						cDao.delete(cli);
						saida = "Cliente excluido com sucesso";
						cli = new Cliente();
					}
				} else {
					cli.setNome(request.getParameter("nomeCliente"));
					cli.setEmail(request.getParameter("emailCliente"));
					cli.setTelefone(request.getParameter("telefoneCliente"));
					if(botao.equalsIgnoreCase("inserir")) {
						cDao.insert(cli);
						saida = "Cliente inserido com sucesso";
						cli = new Cliente();
					} else {
						cDao.update(cli);
						saida = "Cliente atualizado com sucesso";
						cli = new Cliente();
					}
				}
			}
		} catch(SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		} finally {
			request.setAttribute("saida", saida);
			request.setAttribute("erro", erro);
			request.setAttribute("cli", cli);
			request.setAttribute("clientes", clientes);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("cliente.jsp");
			dispatcher.forward(request, response);
		}

	}

}
