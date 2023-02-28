package persistence;

import java.sql.SQLException;
import java.util.List;

import model.Fornecedor;

public class FornecedorDao implements ICRUDDao<Fornecedor>{

	private GenericDao gDao;

	public FornecedorDao(GenericDao gDao) {
		this.gDao = gDao;
	}

	@Override
	public void insert(Fornecedor forn) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Fornecedor forn) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Fornecedor forn) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Fornecedor select(Fornecedor forn) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Fornecedor> list() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
