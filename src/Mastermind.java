import java.util.Scanner;

public class Mastermind{

	

	/*
* pre: tab existe et choix est initialisé, tous les éléments
* du tableau choix sont différents.
* post : tab est initialisé aléatoirement avec des valeurs parmi
* les valeurs du tableau choix et rien n’empêche d’avoir
* plusieurs valeurs identiques dans tab
*/
	public static void genererCodeAvecRepetition(char[] tab, char[] choix){
		for(int index = 0; index < tab.length; index ++){
			int x = (int)(Math.random() * (choix.length - 0)) + 0;
			tab[index] = choix[x];
		}
	}

	/*
* pre: tab existe et choix est initialisé, tous les éléments
* du tableau choix sont différents et
* tab.length <= choix.length
* post : tab est initialisé aléatoirement avec des valeurs parmi
* les valeurs du tableau choix et tous les éléments de tab
* sont différents
*/
	public static void genererCodeSansRepetition (char[] tab, char[] choix){
		genererCodeAvecRepetition(tab, choix);
		while(ifHasRepetition(tab) == true){
			genererCodeAvecRepetition(tab, choix);
		}
	}

	/*
* pre: tab est initialisé.
* post : tab est inchangée
* résultat: est true si tab contient au moins une répétition 
* et false si tab n'en contient aucune
*/
	public static boolean ifHasRepetition (char[] tab){

		boolean repetition = false;
		for(int index1 = 0; index1 < tab.length && repetition == false; index1 ++){
			for(int index2 = index1 + 1; index2 < tab.length; index2 ++){
				if(tab[index1] == tab[index2]){
					repetition = true;
				}
			}
		}
		return repetition;
	}

	/*
* pre: tab et proposition existe et sont initialisé. Tous les éléments 
* de tab sont différents. proposition <= tab
* post: tab et proposition sont inchangées
* résultat: vérifie si proposition contient uniquement les éléments de tab 
* si ce n'est pas le cas afficher un message 
*/
	public static boolean propositionIsValid(char [] proposition, char[] tab){
		boolean foundCharacter = false;
		boolean sameCharacter = true;
		for(int index1 = 0; index1 < proposition.length && sameCharacter == true; index1 ++){
			foundCharacter = false;
			for(int index2 = 0; index2 < tab.length && foundCharacter == false; index2 ++){
				if(proposition[index1] == tab[index2]){
					foundCharacter = true;
				}
			}
			if(foundCharacter == false){
				sameCharacter = false;
			}
		}
		return sameCharacter;
	}

	/*
*pre: secretTab et proposition sont initialisé et
* codeToDiscover.length == proposition.length
* post: codeToDiscover reste inchangées
* résultat: affiche un message avec le nombre de pions bien placés 
* et le nombre de pions mal placés 
*/
	public static void compareSecretCodeWithPropositionCode (char[] secretTab, char[] proposition){
		int counterSamePositionAndColor = 0;
		for(int index = 0; index < proposition.length; index ++){
			if(secretTab[index] == proposition[index]){
				counterSamePositionAndColor ++;
			}
		}

		int counterSameColorOnly = 0;
		boolean sameIndex = false;
		for(int index1 = 0; index1 < secretTab.length; index1 ++){
			for(int index2 = 0; index2 < proposition.length; index2 ++){
				if((secretTab[index1] == proposition[index2]) && proposition[index2] != '.'){
					if((index2 != index1) && (proposition[index1] != secretTab[index1]) && (secretTab[index2] != proposition[index2])){
						counterSameColorOnly ++;
						proposition[index2] = '.';
					}
				}
			}
		}
		System.out.println("nombre de pions bien placés : " + counterSamePositionAndColor);
		System.out.println("nombre de pions mal placés : " + counterSameColorOnly + "\n");
	}

	/*ajoute des espaces avant une chaine de caractère pourqu'elle soit poussé vers le
	 milieu de l'écran*/
	public static void tabulation(){
		for (int space = 0; space < 30; space ++) {
			System.out.print(" ");
		}
	}
	/*Ajoute des espaces avant une chaine de caractère afin
	de nettoyer l'écran */
	public static void clear(){
		for(int space = 0; space < 100; space ++){
			System.out.println(" ");
		}
	}

	/*
*pre: secretTab et proposition sont initialisé et
* codeToDiscover.length == proposition.length
* post: secretTab et proposition reste inchangées
* résultat: vérifie si secretTab et proposistion sont 
* identique et affiche retourne si tel cas sinon retourne faux
*/
	public static boolean userWin(char[] secretTab, char[] proposition){
		boolean rightCode = true;
		for(int index = 0; index < proposition.length && rightCode == true; index ++){
			if(secretTab[index] != proposition[index]){
				rightCode = false;
			}
		}
		return rightCode;
	}

/*Affiche le menu du jeu*/
	public static void menu (){
		clear();
		tabulation();
		System.out.println("MASTERMIND\n");
		tabulation();
		System.out.println("Règles du jeu\n");
		System.out.println("Le jeu utilise les lettres 'b','g','m','j','r','n','v','o' chacune représentant une couleur\n -'b' bleu\n -'g' gris\n -'m' marron\n -'j' jaune\n .'r' rouge\n -'n' noir\n -'v' vert\n -'o' orange\nUn code secret sera générer aléatoirement à partir des lettres correspondantes aux couleurs. \nVotre mission si vous l'acceptez est de découvrir le code secret, c'est-à-dire, les couleurs et leur position dans le même ordre que le code secret.\n Vous aurez droit à 10 essais maximum.\n - Si une ou plusieurs lettres correspondent par leur positions et couleurs à des lettres du code secret, le programme l'indique en affichant le nombre de pions bien placés\n - Si une ou plusieurs lettres correspondent uniquement par leur couleur, le programme l'indique en affichant le nombre de pions mal placés. Par exemple,« nombre de pions mal placés : 2 »\n - Si á la 10ème tentative vous n'avez pas le bon code vous aurez perdu.\n - Si vous decouvrez le code en moins de 10 tentatives vous gagnez.\n\n - Dans le niveau facile le code à découvrir ne contiendra aucune répétition, chaque couleur ne sera présente qu'une seule fois dans le code secret\n - Dans le niveau difficile le code secret peut ou ne pas contenir de répétition\nLe nombre de lettre dans le code secret sera toujours de 4.\nBonne chance !!!\n\n");
		System.out.println("1- Commencer une partie");
		System.out.println("0- Quitter\n\n");
	}
	/*
*pre: array est initialisé 
* post: array reste inchangées
* résultat: affiche les éléments de array
*/
	public static void displayArray(char[] array){
		for(int index = 0; index < array.length; index ++){
			System.out.print(array[index]);
		}
		System.out.println(" ");
	}

	public static void main(String[]args){

		Scanner clavier = new Scanner(System.in);

		int pawns = 4;
		char[] colors = {'b','g','m','j','r','n','v','o'};
		char[] secretCode = new char[pawns];
		char[] propositionCode;
		int numbreOfProposition = 0;
		menu ();
		System.out.println("Entrez 1 pour commencer une partie, 0 pour quiiter le jeu.\n\nVeuillez entrer un nombre : ");
		int userChoice = clavier.nextInt();
		while(userChoice < 0 || userChoice > 1){
			clear();
			System.out.println("      Entrée non valide !\n\nEntrez 1 pour commencer une partie, 0 pour quiiter le jeu.\n\nVeuillez entrer un nombre valide : ");
			userChoice = clavier.nextInt();
		}
		if(userChoice == 0){
			System.exit(0);
		}else{
			clear();
			System.out.println("Veuillez choisir le miveau de difficulté. \n\nEntrez 1 pour facile et 2 pour difficile :");
			int levelChoice = clavier.nextInt();
			while(levelChoice < 1 || levelChoice > 2){
				clear();
				System.out.println("     Entrée non valide. \n\nVeuillez choisir le miveau de difficulté.\n\nEntrez 1 pour facile et 2 pour difficile : ");
				levelChoice = clavier.nextInt();
			}

			clavier.nextLine();
			if(levelChoice == 1){
				int attempt = 1;
				clear();
				tabulation();
				System.out.println("NIVEAU FACILE\n\n\n\n\n");
				System.out.println("Le code secret a été généré !\nVoici les lettres de couleurs parmi lesquelles choisir : 'b','g','m','j','r','n','v','o'\n");
				genererCodeSansRepetition(secretCode,colors);
				do{
					System.out.println("("+ attempt + " tentative) " + "Entrez votre proposition de code") ;
					propositionCode = clavier.nextLine().replaceAll(" ", "").toCharArray() ;

					while(propositionIsValid(propositionCode, colors) == false || propositionCode.length > pawns){
						System.out.println("Entrez votre proposition de code") ;
						propositionCode = clavier.nextLine().replaceAll(" ", "").toCharArray() ;	
					}
				
					compareSecretCodeWithPropositionCode(secretCode, propositionCode);
					attempt ++;
				}
				while(attempt < 10  && userWin(secretCode, propositionCode) == false);
				if(userWin(secretCode, propositionCode) == true){
					System.out.println("Vous avez gagné !");
					System.out.print("Le code secret est ");
					displayArray(secretCode);
				}else{
					System.out.println("Vous avez perdu !");
					System.out.print("Le code secret est ");
					displayArray(secretCode);
				}
			}else{
				int attempt = 1;
				clear();
				tabulation();
				System.out.println("NIVEAU DIFFICILE\n\n\n\n\n");
				System.out.println("Le code secret a été généré !\nVoici les lettres de couleurs parmi lesquelles choisir : 'b','g','m','j','r','n','v','o'\n");
				genererCodeAvecRepetition(secretCode,colors);
				do{
					System.out.println("("+ attempt + " tentative) " + "Entrez votre proposition de code") ;
					propositionCode = clavier.nextLine().replaceAll(" ", "").toCharArray();

					while(propositionIsValid(propositionCode, colors) == false || propositionCode.length > pawns){
						System.out.println("Entrez votre proposition de code") ;
						propositionCode = clavier.nextLine().replaceAll(" ", "").toCharArray() ;
					}
					compareSecretCodeWithPropositionCode(secretCode, propositionCode);
					attempt ++;
				}
				while(attempt < 10  && userWin(secretCode, propositionCode) == false);
				if(userWin(secretCode, propositionCode) == true){
					System.out.println("Vous avez gagné !");
					System.out.print("Le code secret est ");
					displayArray(secretCode);
				}else{
					System.out.println("Vous avez perdu !");
					System.out.print("Le code secret est ");
					displayArray(secretCode);
				}
			}	
		}
	}
}
