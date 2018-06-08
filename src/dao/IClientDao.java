package dao;

import java.util.List;

import model.Client;

public interface IClientDao {

	void save (Client c);
	void delete (int id);
	void updateClient(Client c);
	Client findById (int id);
	List<Client> findAll ();
	
}
