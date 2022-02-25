import pile.Pile;

public class AdditionALEnvers {

	/*
	 * Programme pour faire des additions " � l'envers".
	 * Ex : si on lui donne 12 45 56,  il affichera : 
	 * 45 + 56 = 101 
	 * 12 + 101 = 113 
	 * Le r�sultat est : 113 
	 * Les op�randes sont fournis par la m�thode statique donneesInitiales()
	 */
	public static void main(String args[]) {

		Pile pileOperandes; // Pile des op�randes durant le calcul
		int operande; // op�rande lue dans l'expression
		int res; // r�sultats interm�diaires de calculs
		int resPrev; // r�sultat du calcul pr�c�dentt
		int[] tabValeurs;
		
		tabValeurs = AdditionALEnvers.donneesInitiales();
		
		// Valeurs initiales
		System.out.println("Valeurs initiales");
		AdditionALEnvers.afficherTableau(tabValeurs);
		
		// Mettre les op�randes dans pileOperandes pour faire les additions "� l'envers"
		pileOperandes = new Pile(tabValeurs.length);
		for (int i=0; i<tabValeurs.length; i++) {
			pileOperandes.empiler(tabValeurs[i]);
		}

		// Caluls � partir de pileOperandes
		res = pileOperandes.sommet();
		pileOperandes.depiler();
		resPrev = res;
		while (!pileOperandes.estVide()) {
			operande = pileOperandes.sommet();
			pileOperandes.depiler();
			res = operande + resPrev;
			System.out.println("" + operande + " + " + resPrev + " = " + res);
			resPrev = res;
		}

		System.out.println("Le r�sultat est : " + res);

	}

	/*
	 * Convertit une chaine contenant une liste d'entiers s�par�s par des espace en
	 * tableau.
	 * Modifier la valeur de expr dans le code pour une autre ex�cution
	 * 
	 * @return le tableau contenant une liste d'entiers. 
	 * Si une erreur de conversion de chaine en nombre a lieu au runtime : le programme est arr�t�
	 */
	public static int[] donneesInitiales() {
		int[] data; // liste finale des valeurs enti�res
		String expr; // expression initiale (liste de valeurs s�par�es par des espaces)
		String[] exprEclatee; // expr "�clat�e"en sur s�parateur espace

		expr = "a ba a";

		exprEclatee = expr.split(" ");
		data = new int[exprEclatee.length];
		for (int i = 0; i < exprEclatee.length; i++) {
			try {
				data[i] = Integer.parseInt(exprEclatee[i]);
			} catch (NumberFormatException nfe) { // �chec de parseInt()
				System.out.println("Erreur de format");
				System.exit(1);
			}
		}
		return data;
	}
	
	/*
	 * Affiche les valeurs d'un tableau d'entier
	 * 
	 * @param pfTableauDeValeurs tableau � afficher
	 */
	public static void afficherTableau (int[] pfTableauDeValeurs) {
		String resultatAAfficher;
		resultatAAfficher = "";
		for (int i = 0; i < pfTableauDeValeurs.length; i++) {
			resultatAAfficher = resultatAAfficher + pfTableauDeValeurs[i] + ", ";
		}
		resultatAAfficher = resultatAAfficher.substring(0, resultatAAfficher.length() - 2);
		System.out.println(resultatAAfficher);
	}
}
