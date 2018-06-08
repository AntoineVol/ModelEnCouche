package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Client;

public class MemoryClientDao implements IClientDao {
	
	private static final Map<Integer,Client> db = new HashMap<Integer,Client>();
	int dbCompteur = 1;
	
	@Override
	public void save(Client c) {
		db.put(dbCompteur, c);
		c.setId(dbCompteur);
		dbCompteur++;
	}

	@Override
	public void delete(int id) {
		db.remove(id);
	}

	@Override
	public Client findById(int id) {
		return db.get(id);
		
	}

	@Override
	public List<Client> findAll() {
		List <Client> liClient = new ArrayList<Client>(db.values());
		return liClient;
		
	}

	@Override
	public void updateClient(Client c) {
		// TODO Auto-generated method stub
		
	}

}
