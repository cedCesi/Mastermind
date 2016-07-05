import java.util.Scanner;

public class Mastermind {

	Game game;
	
	public Mastermind (int taille, boolean afficheSolution){
		
		boolean found = false;
		game = new Game(taille);
		
		if (afficheSolution) {
			game.printSolution();
		}
		
		while (!found) {
			char [] proposition = getProposition();
			int bienPlace = compareTableau(game.getSolution(), proposition);
			
			if (bienPlace == game.getSolution().length) {
				found = true;
			}
		}

		System.out.println(" ----- gagné ----- ");
		
	}
	
	// compare les tableaux solution et proposition
	private int compareTableau(char [] solOriginal, char [] prop) {
		
		char [] sol = solOriginal.clone();
		
		int bienPlace = 0;
		int malPlace = 0;
		
		for (int i = 0 ; i < prop.length ; i++) {
			if (prop[i] == sol[i]) {
				bienPlace ++;
				// caractere trouve, on l'efface
				sol[i] = ' ';
			}
		}

		for (int j = 0 ; j < prop.length ; j++) {
			boolean found = false;
			int k = 0;

			while (!found && k < sol.length - 1) {
				if (prop[j] == sol[k]) {
					// caractere trouve, on l'efface
					sol[k] = ' ';
					malPlace ++;
					found = true;
				}
				k++;
			}
		}
		
		System.out.println(bienPlace + " élément(s) bien placé(s) ");
		System.out.println(malPlace + " élément(s) mal placé(s) ");
		
		return bienPlace;
	}

	// recueille entrée clavier
	private char [] getProposition() {
		
		boolean stringOK = false;
		char [] prop = null;
		System.out.println("votre proposition :");
		
		while (!stringOK) {
			Scanner sc = new Scanner(System.in);
			String str = sc.nextLine();	
	
			if (str.length() != game.getSolution().length) {
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
		
		char [] prop = new char [game.getSolution().length];
		
		for (int i = 0 ; i < str.length() ; i++) {
			prop[i] = str.charAt(i);
		}
		
		return prop;
	}

	// affiche le tableau
	public void printArray (char [] tab) {
		
		for (int i = 0 ; i < tab.length ; i++) {
			System.out.print(tab[i]);
		}
	}
}
