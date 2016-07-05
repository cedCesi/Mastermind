
public class Game {

	private final char colors [] = {'r','b','j','v','n','g'};
	private char [] solution;
	
	public Game(int taille) {

		solution  = new char [taille];
		
		// remplissage du tableau des couleurs
		for (int i = 0 ; i < solution.length ; i++) {
			int color = (int) (Math.random() * colors.length);
			solution [i] = colors [color];
		}
	}

	// retourne le tableau
	public char[] getSolution() {
		return solution;
	}

	// imprime le tableau
	public void printSolution () {
		
		for (int i = 0 ; i < solution.length ; i++) {
			System.out.print(solution[i]);
		}
		
		System.out.println();
	}

	// toString
	public String toString () {

		StringBuffer sb = new StringBuffer();
		
		for (int i = 0 ; i < solution.length ; i++) {
			sb.append(solution[i]);
		}
		return sb.toString();
	}

}
