package service;

import java.util.List;

import model.Client;

public interface IClientService {
	
	void addClient(Client c);
	void updateClient(Client c);
	void delete(int id);
	Client getValidatedClient(int id);
	List<Client> getAllClients();
}
