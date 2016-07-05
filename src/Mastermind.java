import java.util.Scanner;

public class Mastermind {

	Game game;
	
	public Mastermind (int taille, boolean afficheSolution){
		
		boolean found = false;
		game = new Game(taille);
		
		if (afficheSolution) {
			game.printTableau();
		}
		
		while (!found) {
			char [] proposition = getProposition();
			int bienPlace = compareTableau(game.getTableau(), proposition);
			
			if (bienPlace == game.getTableau().length) {
				found = true;
			}
		}
		System.out.println();
		System.out.println(" ----- gagné ----- ");
		
	}
	
	// compare les tableaux
	private int compareTableau(char [] jeuOriginal, char [] prop) {
		
		char [] jeu = jeuOriginal.clone();
		
		int bienPlaces = 0;
		int malPlaces = 0;
		
		for (int i = 0 ; i < prop.length ; i++) {
			if (prop[i] == jeu[i]) {
				bienPlaces ++;
				// caractere trouve, on l'efface
				jeu[i] = ' ';
			}
		}

		for (int j = 0 ; j < prop.length ; j++) {
			boolean found = false;
			int k = 0;

			while (!found && k < jeu.length - 1) {
				if (prop[j] == jeu[k]) {
					// caractere trouve, on l'efface
					jeu[k] = ' ';
					malPlaces ++;
					found = true;
				}
				k++;
			}
		}
		
		System.out.println(bienPlaces + " élément(s) bien placé(s) ");
		System.out.println(malPlaces + " élément(s) mal placé(s) ");
		
		return bienPlaces;
	}

	// recueille entrée clavier
	private char [] getProposition() {
		
		boolean stringOK = false;
		char [] prop = null;
		System.out.println("votre proposition :");
		while (!stringOK) {
			
			Scanner sc = new Scanner(System.in);
			String str = sc.nextLine();	
	
			if (str.length() != game.getTableau().length) {
				System.out.println("longueur proposition erronée, réessayez : ");
			} else {
				stringOK = true;
				prop = StringToArray(str);
			}
		}

		return prop;	
	}

	// convertit string en tableau
	private char [] StringToArray (String str) {
		
		char [] prop = new char [game.getTableau().length];
		
		for (int i = 0 ; i < str.length() ; i++) {
			prop[i] = str.charAt(i);
		}
		
		return prop;
	}

	// imprime le tableau
	public void printTableau (char [] tab) {
		
		for (int i = 0 ; i < tab.length ; i++) {
			System.out.print(tab[i]);
		}
	}
}
