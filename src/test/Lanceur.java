package test;

import java.util.Scanner;

import presentation.Vue;

public class Lanceur {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Vue vue = new Vue();
		int i=0,iMenu=-1;
		do {
			menu1();
			i=sc.nextInt();
			switch (i) {
				case 0:
					iMenu=0;
					break;
				case 1:
					vue.createClient();
					break;
				case 2:
					vue.showClient();
					break;
				case 3:
					vue.updateClient();
					break;
				case 4:
					vue.showAllClients();
					break;
				case 5:
					vue.deleteClients();
					break;
				default:
					System.out.println("Veuillez renseigner une des valeurs proposées");
			}
		}while(iMenu!=0);
		
		sc.close();
	}
	
	public static void menu1() {
		System.out.println("+------------------------MENU-----------------------+");
		System.out.println("|   1-Creer un client                               |");
		System.out.println("|   2-Detaillé un client                            |");
		System.out.println("|   3-Modifié un client                             |");
		System.out.println("|   4-Lister tous les clients                       |");
		System.out.println("|   5-Supprimer un client                           |");
		System.out.println("|   0-Quitter                                       |");
		System.out.println("+---------------------------------------------------+");
		System.out.print("Que souhaitez vous faire ? -->	");
	}

}
