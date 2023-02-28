package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;

public class ClienteDao implements ICRUDDao<Cliente> {
	
	private GenericDao gDao;

	public ClienteDao(GenericDao gDao) {
		this.gDao = gDao;
	}
	
	public void insert(Cliente cli) throws ClassNotFoundException, SQLException {
		Connection c = gDao.getConnection();
		String sql = "INSERT INTO cliente VALUES (?,?,?,?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, cli.getId());
		ps.setString(2, cli.getNome());
		ps.setString(3, cli.getEmail());
		ps.setString(4, cli.getTelefone());
		ps.execute();
		ps.close();
		c.close();
	}

	@Override
	public void update(Cliente cli) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "UPDATE cliente SET nome_cliente = ?, email_cliente = ?, telefone_cliente = ? WHERE id_cliente = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, cli.getNome());
		ps.setString(2, cli.getEmail());
		ps.setString(3, cli.getTelefone());
		ps.setInt(4, cli.getId());
		ps.execute();
		ps.close();
		c.close();		
	}

	@Override
	public void delete(Cliente cli) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "DELETE cliente WHERE id_cliente = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, cli.getId());
		ps.execute();
		ps.close();
		c.close();		
	}

	@Override
	public Cliente select(Cliente cli) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "SELECT id_cliente, nome_cliente, email_cliente, telefone_cliente FROM cliente WHERE id_cliente = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, cli.getId());
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			cli.setNome(rs.getString("nome_cliente"));
			cli.setEmail(rs.getString("email_cliente"));
			cli.setTelefone(rs.getString("telefone_cliente"));
		}
		rs.close();
		ps.close();
		c.close();		
		return cli;
	}

	@Override
	public List<Cliente> list() throws SQLException, ClassNotFoundException {
		List<Cliente> clientes = new ArrayList<>();
		
		Connection c = gDao.getConnection();
		String sql = "SELECT id_cliente, nome_cliente, email_cliente, telefone_cliente FROM cliente";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			Cliente cli = new Cliente();
			cli.setId(rs.getInt("id_cliente"));
			cli.setNome(rs.getString("nome_cliente"));
			cli.setEmail(rs.getString("email_cliente"));
			cli.setTelefone(rs.getString("telefone_cliente"));
			clientes.add(cli);
		}
		rs.close();
		ps.close();
		c.close();		
		return clientes;
	}
	
}
