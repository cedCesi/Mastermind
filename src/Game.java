
public class Game {

	private final char colors [] = {'r','b','j','v','n','g'};
	private char [] tableau;
	
	public Game(int taille) {

		tableau  = new char [taille];
		
		// remplissage du tableau des couleurs
		for (int i = 0 ; i < tableau.length ; i++) {
			int color = (int) (Math.random() * colors.length);
			tableau [i] = colors [color];
		}
	}

	// retourne le tableau
	public char[] getTableau() {
		return tableau;
	}

	// imprime le tableau
	public void printTableau () {
		
		for (int i = 0 ; i < tableau.length ; i++) {
			System.out.print(tableau[i]);
		}
		
		System.out.println();
	}

	// imprime le tableau
	public String toString () {

		StringBuffer sb = new StringBuffer();
		
		for (int i = 0 ; i < tableau.length ; i++) {
			sb.append(tableau[i]);
		}
		return sb.toString();
	}

}
