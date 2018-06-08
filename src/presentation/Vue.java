package presentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Client;
import service.ClientServiceImpl;
import service.IClientService;

public class Vue {
	Scanner sc = new Scanner(System.in);
	IClientService service = new ClientServiceImpl();
	
	public void showClient() {
		showAllClients();
		System.out.print("Entrer l'id du client à afficher : ");
		int id = sc.nextInt();
		System.out.println(service.getValidatedClient(id));
	}
	
	public void createClient() {
		System.out.print("Entrer le nom du client à créer : ");
		String nom = sc.nextLine();
		service.addClient(new Client(nom));
		
	}
	
	public void showAllClients(){
		List<Client> liClient = new ArrayList<Client>();
		liClient = service.getAllClients();
		for (Client clt: liClient) {
			System.out.println(clt.toString());
		}
	}
	
	public void deleteClients() {
		showAllClients();
		System.out.print("Entrer l'id du client à afficher : ");
		int id = sc.nextInt();
		service.delete(id);
	}
	
	public void updateClient() {
		int iMenu=-1,i=-1;
		showAllClients();
		System.out.print("Entrer l'id du client à modifier : ");
		int id = sc.nextInt();
		System.out.print("\nVous avez choisi :");
		System.out.println(service.getValidatedClient(id));
		do {
		menu2();
		i = sc.nextInt();
		switch (i) {
			case 1 :
				System.out.print("Entrer le nouveau nom : ");
				String str0 = sc.nextLine();
				String nom = sc.nextLine();
				Client c = new Client();
				c.setId(id);
				c.setName(nom);
				service.updateClient(c);
				break;
			case 0 :
				iMenu=0;
				break;
			default : 
				System.out.println("Veuillez renseigner une des valeurs proposées");
		}
		}while(iMenu!=0);
	}
	
	public static void menu2() { 
		System.out.println("+--------------Modification Client------------------+");
		System.out.println("|   1-Nom                                           |");
		System.out.println("|   0-Quitter                                       |");
		System.out.println("+---------------------------------------------------+");
		System.out.print("Que souhaitez vous modifier ? -->	");
	}

	
}
