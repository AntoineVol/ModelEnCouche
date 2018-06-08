package service;

import java.util.List;

import dao.DbClientDao;
import dao.IClientDao;
import model.Client;

public class ClientServiceImpl implements IClientService{
	IClientDao dao = new DbClientDao();

	@Override
	public void addClient(Client c) {
		dao.save(c);
		
	}

	@Override
	public void delete(int id) {
		dao.delete(id);
	}

	@Override
	public Client getValidatedClient(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Client> getAllClients() {
		return dao.findAll();
	}

	@Override
	public void updateClient(Client c) {
		dao.updateClient(c);
		
	}



}
