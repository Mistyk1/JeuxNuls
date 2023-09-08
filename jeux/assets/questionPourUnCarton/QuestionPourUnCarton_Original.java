package jeux.assets.questionPourUnCarton;

import java.util.Scanner;

public class QuestionPourUnCarton_Original{
    private static Scanner sc = new Scanner(System.in);
	
    public static void main(String[] args) {
		System.out.print("Entrez votre nom svp: ");
		String nom = sc.next();
		int vies = 3;

		//Explications

		
		System.out.print("\nSouhaitez vous une petite explication du show?\n1 = Oui\nN'importe quel autre nombre ou chiffre = Non\n> ");
		int accord = sc.next().charAt(0);
		if (accord == '1'){
			System.out.println("----- EXPLICATIONS -----\nQuand une question vous sera posée vous aurez 4 réponses, une seule de ces réponses est correcte.\nPour choisir une réponse il faut écrire le nombre associé\nChoisir une mauvaise réponse vous fera perdre une vie, et vous avez 3 vies maximum.\nSi vous arrivez à répondre mais que vous n'avez plus qu'une vie, une question bonus apparaitra (toute les 10 questions) n'ayant que 2 réponses.\nRépondez correctement et vous gagnerez une vie!\nAppuyer sur la touche Entrer pour passer au dialogue suivant\n----- FIN DES EXPLICATIONS -----");
		}


		//Fin des explications
		
		
		System.out.println("\nPrésentateur: Bienvenue à Question Pour Un Carton! Le show qui, pour cause de contraintes techniques, ne vous est diffusés que textuellement! C'est correct, tex-tu-e-lle-ment!");
		sc.nextLine();
		System.out.println("Présentateur: Nous avons avec nous 4 candidats qui tenterons, en répondant à de nombreuses questions sans intérêts ou sans logique thématique particulière, de gagner ce magnifique carton de 3 mètres cube!");
		sc.next();
		System.out.println("Présentateur: Ce carton peut avoir un nombre exceptionel d'usages: transport, jouet pour vos chats, jouets pour vos enfants, jouet pour vous (qui sait), et cetera...");
		sc.next();
		System.out.println("Présentateur: Assez de blabla, voici nos 4 participants qui répondront à un bon nombre de questions!");
		sc.next();


		//Présentation
		
		
		System.out.println("Brigitte: Bonjour je m'apelle Brigitte, j'ai 74 ans et ce carton est à mes yeux une nécéssité absolue. Voyez-vous, j'ai 35 chats dans mon appartement et ils adorerais s'amuser avec ce carton.");
		sc.next();
		System.out.println("Nicolas: Bonjour, Nicolas, 26 ans, étudiant en infor- *la caméra passe au candidat suivant*");
		sc.next();
		System.out.println("Albert: Je ne peut m'imaginer sans ce carton. Je dois le gagner, ou alors mon existance ne serait qu'un abîme sans sens. Ce carton est pour moi l'objectif de ma vie, le sens même de ma destinée, le fil rouge de mon existence. J'ai rêvé jours et nuits de ce carton depuis mes 2 ans. Je ne fait qu'envoyer des lettres d'inscriptions à ce show depuis mes 3 ans dans l'unique but de pouvoir vivre avec ce carton. J'ai passé 30 ans de ma vie à m'entrainer, de minuit à 23 heures 50, chaque jours de chaque semaines de chaque mois de chaque années. Ma vie tourne autour de ce carton, je me dois donc aujourd'hui de marquer une nouvelle phase de ma vie et de gagner ce carton.");
		sc.next();
		System.out.print(nom + ": ");
		sc.next();


		//Fin des présentations
		
		
		System.out.println("\nPrésentateur: Que de magnifiques présentations! Ça devrait impressioner les spectateur tout en donnant de la prestance au participants! (sauf Nicolas)");
		sc.next();
		System.out.println("Présentateur: C'est donc le temps des rires et des champs nan attendez c'est pas ça le texte... *cherche un peu dans ses feuilles* C'est donc le temps des questions avec la première question!");
		sc.next();

		
		//Question 1

		
		System.out.print("\nQuestion 1 - Comment est ce que je m'appelle?\n1. Bernard\n2. Présentateur\n3. " + nom + "\n4. Je n'ai pas de prénom\n> ");
		int reponse = sc.nextInt();
		System.out.println("\nBrigitte: Heu... Présentateur?");
		System.out.println("\nNicolas n'a pas trouvé la réponse.");
		System.out.println("\nAlbert: Facile, Présentateur!");
		if (reponse == '1'){
			System.out.println("\n" + nom + ": Bernard!");
			vies -= 1;
			System.out.println("\nPrésentateur: Il se trouve que seuls Brigitte et Albert ont trouvés la bonne réponse, je m'appelle bel et bien Présentateur! (merci papa et maman pour ce magnifique prénom)");
		} else if (reponse == '2'){
			System.out.println("\n" + nom + ": Présentateur!");
			System.out.println("\nPrésentateur: Il se trouve que seul Nicolas n'a pas trouvé la bonne réponse, je m'appelle bel et bien Présentateur! (merci papa et maman pour ce magnifique prénom)");
		} else if (reponse == '3'){
			System.out.println("\n" + nom + ": " + nom + "!");
			vies -= 1;
			System.out.println("\nPrésentateur: Il se trouve que seuls Brigitte et Albert ont trouvés la bonne réponse, je m'appelle bel et bien Présentateur! (merci papa et maman pour ce magnifique prénom)");
		} else if (reponse == '4'){
			System.out.println("\n" + nom + ": Vous n'avez pas de prénom!");
			vies -= 1;
			System.out.println("\nPrésentateur: Il se trouve que seuls Brigitte et Albert ont trouvés la bonne réponse, je m'appelle bel et bien Présentateur! (merci papa et maman pour ce magnifique prénom)");
		} else {
			System.out.println("\n" + nom + " n'a pas trouvé la réponse.");
			vies -= 1;
			System.out.println("\nPrésentateur: Il se trouve que seuls Brigitte et Albert ont trouvés la bonne réponse, je m'appelle bel et bien Présentateur! (merci papa et maman pour ce magnifique prénom)");
		}
		System.out.println("\n[Il vous reste " + vies + " vies]");
		sc.next();

		
		//Fin question 1

		
		System.out.println("Présentateur: Que d'engouement de la part du public pour cette première question! Je peut sentir leur exitation à travers leurs cris!");
		sc.next();
		System.out.println("Présentateur: Alalah, je sens que ce show va vraiment être incroy-");
		sc.next();
		System.out.println("Nicolas: Excusez moi monsieur Présentateur? Je me demandais pourquoi-");
		sc.next();
		System.out.println("Présentateur: Selon le contrat d'inscription que vous avez signé mon cher Nicolas, vous n'êtes pas autorisé à poser de question. Ici c'est moi qui les pose.");
		sc.next();
		System.out.println("Nicolas: Autant pour moi...");
		sc.next();
		System.out.println("Présentateur: Je suis même autorisé à retirer une vie dans ce cas précis, ce que je vais faire de suite :)");
		sc.next();
		System.out.println("Nicolas: :(");
		sc.next();
		System.out.println("Présentateur: Bref, passons de suite à la question suivante!");
		sc.next();

		
		//Question 2

		
		System.out.print("\nQuestion 2 - Combien font 1 + 1?\n1. 1\n2. 7\n3. Présentateur\n4. 2\n> ");
		reponse = sc.next().charAt(0);
		System.out.println("\nBrigitte: 2");
		System.out.println("\nNicolas: 2, non?");
		System.out.println("\nAlbert: 2!");
		if (reponse == 1){
			System.out.println("\n" + nom + ": 1!");
			vies -= 1;
			System.out.println("\nPrésentateur: Apparemment " + nom + " ne sait pas compter, ce qui va poser un léger problème pour vos vies et les questions.");
		} else if (reponse == 2){
			System.out.println("\n" + nom + ": 7!");
			vies -= 1;
			System.out.println("\nPrésentateur: Apparemment " + nom + " ne sait pas compter, ce qui va poser un léger problème pour vos vies et les questions.");
		} else if (reponse == 3){
			System.out.println("\n" + nom + ": Présentateur!");
			vies -= 1;
			System.out.println("\nPrésentateur: Quoi, mais... C'est la réponse à la question précédente...");
		} else if (reponse == 4){
			System.out.println("\n" + nom + ": 2!");
			System.out.println("\nPrésentateur: Félicitation, vous avez tous passé l'école primaire! À moins que... *fixe Nicolas*");
		} else {
			System.out.println("\n" + nom + " n'a pas trouvé la réponse.");
			vies -= 1;
			System.out.println("\nPrésentateur: Apparemment " + nom + " ne sait pas compter, ce qui va poser un léger problème pour vos vies et les questions.");
		}
		System.out.println("\n[Il vous reste " + vies + " vies]");
		sc.next();

		
		//Fin question 2

		
		System.out.println("Présentateur: Après cette question extrêmement complexe (nécessitant probablement un BAC+12 en mathématiques), laissez moi vous raconter une anecdote de ma vie.");
		sc.next();

		
		//Flashback 1

		
		System.out.println("Présentateur: C'était il y a 35 ans, j'était à l'école primaire avec mon meilleur ami: Chanteur.");
		sc.next();
		System.out.println("----- FLASHBACK | Il y a 35 ans... -----\n\nPrésentateur (enfant): Bonjour toi. Tu fait quoi?");
		sc.next();
		System.out.println("Chanteur (enfant): Je donne un super concert à tout ces cailloux!");
		sc.next();
		System.out.println("Présentateur (enfant): Waaa, c'est trop bien! Je peux jouer avec toi?");
		sc.next();
		System.out.println("Chanteur (enfant): Désolé, mais tout les tickets sont pris. Tu peut te mettre dans la poubelle si tu veut.");
		sc.next();
		System.out.println("Présentateur (enfant): Trop bien! *plonge dans la poubelle et regarde Chanteur donner un concert*");
		sc.next();
		System.out.println("[15 minutes plus tard...]");
		sc.next();
		System.out.println("Chanteur (enfant): Alors, qu'est ce que tu en dit?");
		sc.next();
		System.out.println("Présentateur (enfant): Tu a chanté deux mêmes notes en boucles pendant 15 minutes mais sinon j'ai adoré! :D");
		sc.next();
		System.out.println("Chanteur (enfant): Dit, tu veut devenir mon copain?");
		sc.next();
		System.out.println("Présentateur (enfant): OUIIIIIIIIIII *O*");
		sc.next();
		System.out.println("----- FIN DU FLASHBACK -----\n\nPrésentateur: Et c'est ainsi que je suis fait mon tout premier ami.");
		sc.next();

		
		//Fin du flashback 1

		
		System.out.println("Présentateur: J'espère que vous avez aimés cette anecdote, car elle n'a strictement rien à voir avec le show.");
		sc.next();
		System.out.println("Présentateur: Sur toute cette émotion, la troisième question!");
		sc.next();

		
		//Question 3

		
		System.out.print("\nQuestion 3 - Quel est le composant principal du fer?\n1. L'élément atomique n°26\n2. De la mystérieuse poudre blanche (de la farine)\n3. Votre mère\n4. N'importe quoi sauf du fer\n> ");
		reponse = sc.next().charAt(0);
		System.out.println("\nBrigitte n'a pas rouvé la réponse.");
		System.out.println("\nNicolas: Du fer.");
		System.out.println("\nAlbert: L'élément atomique n°26!");
		if (reponse == 1){
			System.out.println("\n" + nom + ": L'élément atomique n°26?");
			System.out.println("\nPrésentateur: Nicolas, c'est si dur à dire \"élément atomique n°26\"?!");
		} else if (reponse == 2){
			System.out.println("\n" + nom + ": De la... poudre blanche?!");
			vies -= 1;
			System.out.println("\n*Le présentateur vous regarde suspicieusement*");
		} else if (reponse == 3){
			System.out.println("\n" + nom + ": Je sais, votre mère! >:D");
			vies -= 1;
			System.out.println("\nPrésentateur: Je sens que " + nom + " veut partir du show illico presto!");
		} else if (reponse == 4){
			System.out.println("\n" + nom + ": N'importe quoi, sauf du fer!");
			vies -= 1;
			System.out.println("\nPrésentateur: Il n'y a pas de fer dans du fer? Est-ce que vous réfléchissez?");
		} else {
			System.out.println("\n" + nom + " n'a pas trouvé la réponse.");
			vies -= 1;
			System.out.println("\nPrésentateur: Il semble que " + nom + " et Brigitte n'ont pas fait un BAC scientifique (ou un équivalent du moins).");
		}
		if (vies > 1){
			System.out.println("\n[Il vous reste " + vies + " vies]");
			sc.next();
		} else {
			System.out.println("\nPrésentateur: Aïe, " + nom + " n'a plus de vies, il va devoir quitter le show. Ça aura été une belle aventure pour vous. Adieu, et à jamais!");
			sc.next();
			System.out.println("[Vous partez, désépéré de ne pas avoir pu obtenir le carton. Cette chance ne reviendra pas à vous, et vous allez vivre avec ça durant le reste de votre vie.]");
			System.exit(0);
		}

		
		//Fin question 3

		
		System.out.println("Présentateur: En effet, il se trouve que le fer est principalement composé de fer.");
		sc.next();
		System.out.println("Présentateur: Passons. J'ai une petite faim d'un coup, pas vous?");
		sc.next();
		System.out.println("Nicolas: Ah tiens, moi au-");
		sc.next();
		System.out.println("Présentateur: Non.");
		sc.next();
		System.out.println("Présentateur: Et vous " + nom + ", vous avez faim?");
		sc.next();
		System.out.print(nom + ": ");
		sc.next();
		System.out.println("\nPrésentateur: Très bien. La vérité est que je ne vous ait pas écouté.");
		sc.next();
		System.out.println("Présentateur: Sur ce, je vais aller me chercher un Twix. *Se lève de sa chaise et va chercher un Twix*");
		sc.next();
		System.out.println("...");
		sc.next();
		System.out.println("...");
		sc.next();
		System.out.println("...");
		sc.next();
		System.out.println("...");
		sc.next();
		System.out.println("...");
		sc.next();
		System.out.println("...");
		sc.next();
		System.out.println("...");
		sc.next();
		System.out.println("...");
		sc.next();
		System.out.println("Présentateur: Mmmh, ce Twix fut étonnamment bon.");
		sc.next();
		System.out.println("Présentateur: Alors, la quatrième question...");
		sc.next();
		System.out.println("Présentateur: Oh zut, j'ai fait tomber mon deuxième Twix dessus!");
		sc.next();
		System.out.println("Présentateur: Tant pis, je vais faire ma propre quatrième question.");
		sc.next();
		System.out.println("Présentateur: Donc...");
		

		
		//Question 4

		
		System.out.print("\nQuestion 4 - Pourquoi le chocolat est-il marron?\n1. Car le chocolat était blanc originalement mais la rouille du chocolat l'a rendu marron\n2. Car c'est comme ça.\n3. Car le chocolat est fait de cacao (de mauvaise qualité)\n4. Car le chocolat absorbe certaine parties de la lumière\n> ");
		reponse = sc.next().charAt(0);
		System.out.println("\nBrigitte: Car c'est comme ça?");
		System.out.println("\nNicolas: Car le chocolat absorbe certaine parties de la lumière.");
		System.out.println("\nAlbert: Euuuuuuh... Car le chocolat rouille!");
		if (reponse == 1){
			System.out.println("\n" + nom + ": Car le chocolat blanc rouille!");
			vies -= 1;
			System.out.println("\nPrésentateur: Olalah, Nicolas l'intello là...");
		} else if (reponse == 2){
			System.out.println("\n" + nom + ": Parce que c'est comme ça.");
			vies -= 1;
			System.out.println("\nPrésentateur: Olalah, Nicolas l'intello là...");
		} else if (reponse == 3){
			System.out.println("\n" + nom + ": Car le chocolat est fait avec du cacao de mauvaise qualité!");
			vies -= 1;
			System.out.println("\nPrésentateur: Non, juste non.");
		} else if (reponse == 4){
			System.out.println("\n" + nom + ": Car le chocolat absorbe certaine parties de la lumière!");
			System.out.println("\nPrésentateur: " + nom + ", vous vous êtes alliés à Nicolas?");
		} else {
			System.out.println("\n" + nom + " n'a pas trouvé la réponse.");
			vies -= 1;
			System.out.println("\nPrésentateur: Olalah, Nicolas l'intello là...");
		}
		if (vies > 1){
			System.out.println("\n[Il vous reste " + vies + " vies]");
			sc.next();
		} else {
			System.out.println("\nPrésentateur: Aïe, " + nom + " n'a plus de vies, il va devoir quitter le show. Ça aura été une belle aventure pour vous. Adieu, et à jamais!");
			sc.next();
			System.out.println("[Vous partez, désépéré de ne pas avoir pu obtenir le carton. Cette chance ne reviendra pas à vous, et vous allez vivre avec ça durant le reste de votre vie.]");
			System.exit(0);
		}

		
		//Fin question 4

		
		System.out.println("Présentateur: Bah non, le chocolat ne rouille pas, il est fait avec du cacao de bonne qualité et NON CE N'EST PAS PARCE QUE C'EST COMME ÇA!");
		sc.next();
		System.out.println("Présentateur: Oh regardez, une superbe INTERLUDE SPÉCIALE!");
		sc.next();

		
		//Interlude spéciale

		
		System.out.println("----- INTERLUDE SPÉCIALE -----\n\nPrésentateur: Durant cette interlude spéciale vous avez tous une chance de regagner une vie!");
		sc.next();
		System.out.println("Présentateur: Mais pour cela vous devez répondre à une question...");
		sc.next();
		System.out.print("Présentateur: De quelle couleur est ma cravate?\n> ");
		String reponseCravate = sc.next();
		System.out.println("\nBrigitte: Bleu?");
		System.out.println("\nNicolas n'a pas trouvé la réponse.");
		System.out.println("\nAlbert: Toute les couleurs du spectre en même temps!");
		System.out.println("\n" + nom + ": " + reponseCravate + "!");
		System.out.println("\nPrésentateur: Et bien il se trouve que vous avez tous faux. Je n'ai pas de cravate.");
		sc.next();
		System.out.println("----- FIN DE L'INTERLUDE SPÉCIALE -----\n\nPrésentateur: Quel dommage que personne n'ait réussi à regagner de vies!");
		sc.next();

		
		//Fin de l'interlude spéciale

		
		System.out.println("Présentateur: Oh non!");
		sc.next();
		System.out.println("Présentateur: Le jour est arrivé!");
		sc.next();
		System.out.println("Présentateur: Je vais mourir d'un arrêt cardiaque d'ici 3...");
		sc.next();
		System.out.println("Présentateur: 2...");
		sc.next();
		System.out.println("Présentateur: 1...");
		sc.next();
		System.out.println("Présentateur: *attend*");
		sc.next();
		System.out.println("Présentateur: *attend encore*");
		sc.next();
		System.out.println("Présentateur: *regarde un calendrier*");
		sc.next();
		System.out.println("Présentateur: Autant pour moi, ce jour arrivera la semaine prochaine.");
		sc.next();
		System.out.println("Présentateur: Désormais, la question 5!");
		sc.next();
		
		
		//Question 5

		
		System.out.print("\nQuestion 5 - Pourquoi ma femme m'a quitté?\n1. Car je suis parti acheté du lait\n2. Car je suis un mari extrêmement infidèle\n3. Car j'ai jeté le chat par la fenêtre\n4. Toute les réponses du dessus\n> ");
		reponse = sc.next().charAt(0);
		System.out.println("\nBrigitte n'a pas trouvé la réponse");
		System.out.println("\nNicolas n'a pas trouvé la réponse");
		System.out.println("\nAlbert: Vous êtes parti acheter du lait?");
		if (reponse == 1){
			System.out.println("\n" + nom + ": Car vous êtes parti acheter du lait!");
			vies -= 1;
			System.out.println("\nPrésentateur: Personne n'a bon.");
		} else if (reponse == 2){
			System.out.println("\n" + nom + ": Car vous êtes infidèle!");
			vies -= 1;
			System.out.println("\nPrésentateur: Personne n'a bon.");
		} else if (reponse == 3){
			System.out.println("\n" + nom + ": Car vous avez jeté le chat par la fenêtre!");
			vies -= 1;
			System.out.println("\nPrésentateur: Personne n'a bon.");
		} else if (reponse == 4){
			System.out.println("\n" + nom + ": Car vous êtes le pire mari existant!");
			System.out.println("\nPrésentateur: o)_o)'");
		} else {
			System.out.println("\n" + nom + " n'a pas trouvé la réponse.");
			vies -= 1;
			System.out.println("\nPrésentateur: Personne n'a bon.");
		}
		if (vies > 1){
			System.out.println("\n[Il vous reste " + vies + " vies]");
			sc.next();
		} else {
			System.out.println("\nPrésentateur: Aïe, " + nom + " n'a plus de vies, il va devoir quitter le show. Ça aura été une belle aventure pour vous. Adieu, et à jamais!");
			sc.next();
			System.out.println("[Vous partez, désépéré de ne pas avoir pu obtenir le carton. Cette chance ne reviendra pas à vous, et vous allez vivre avec ça durant le reste de votre vie.]");
			System.exit(0);
		}

		
		//Fin question 5


		System.out.println("Présentateur: Aouch, il se trouve que Nicolas n'a plus de vies.");
		sc.next();
		System.out.println("Présentateur: Quel dommage que Nicolas doivent nous quitter aussi tôt.");
		sc.next();
		System.out.println("Présentateur: Quelque chose à dire Nicolas avant d'être oublié de tous?");
		sc.next();
		System.out.println("Nicolas: Eh bien...");
		sc.next();
		System.out.println("Présentateur: C'est donc sur ces mots (dont tout le monde se fout, soyons honnêtes) que Nicolas nous quitte.");
		sc.next();
		System.out.println("Présentateur: Adieu Nicolas, et à jamais!");
		sc.next();
		System.out.println("[Nicolas est éliminé, ne laissant plus que Brigitte, Albert et " + nom + "]");
		sc.next();
		System.out.println("Présentateur: *Attend que Nicolas sorte du bâtiment*");
		sc.next();
		System.out.println("Présentateur: Il y a quelque chose que je dois vous avouer.");
		sc.next();
		System.out.println("Présentateur: Vous avez en vérité non pas 3 vies maximum mais 5!");
		vies += 2;
		sc.next();
		System.out.println("Présentateur: N'est-ce pas formidable?");
		sc.next();
		System.out.println("Brigitte: Donc vous avez éliminé ce pauvre Nicolas avant même de lui donner deux vies supplémentaires?");
		sc.next();
		System.out.println("Présentateur: Et nous passons à la question 6!");
		sc.next();
		
		
		//Question 6

		
		System.out.print("\nQuestion 6 - Nous savons tous que les polynômes de Tchebychev de seconde espèce sont définis par cette relation de récurrence:\nU[n+1] = 2XU[n] - U[n-1], Pour tout n >= 1 avec U[0] = 1 et U[1] = 2X\nQuel polynôme de Tchebychev de seconde espèce correspond à la 7ème occurence?\n1. U[7] = 16X⁴-12X²+1\n2. U[7] = 128X⁷-192X⁵+80X³-8X\n3. U[7] = 64X⁷-112X⁵+56X³-7X\n4. U[7] = 256X⁸-448X⁶+240X⁴-40X²+1\n> ");
		reponse = sc.next().charAt(0);
		System.out.println("\nBrigitte: U[7] = 128X⁷-192X⁵+80X³-8X");
		System.out.println("\nAlbert n'a pas trouvé la réponse");
		if (reponse == 1){
			System.out.println("\n" + nom + ": U[7] = 16X⁴-12X²+1!");
			vies -= 1;
			System.out.println("\nPrésentateur: Désolé " + nom + ", ce polynôme correspondait à la 4ème occurence.");
		} else if (reponse == 2){
			System.out.println("\n" + nom + ": U[7] = 128X⁷-192X⁵+80X³-8X!");
			System.out.println("\nPrésentateur: Il se trouve que seul Albert n'a pas trouvé la réponse!");
		} else if (reponse == 3){
			System.out.println("\n" + nom + ": U[7] = 64X⁷-112X⁵+56X³-7X!");
			vies -= 1;
			System.out.println("\nPrésentateur: Désolé " + nom + ", ce polynôme correspondait à la 7ème occurence mais de première espèce.");
		} else if (reponse == 4){
			System.out.println("\n" + nom + ": U[7] = 256X⁸-448X⁶+240X⁴-40X²+1t!");
			vies -= 1;
			System.out.println("\nPrésentateur: Désolé " + nom + ", ce polynôme correspondait à la 8ème occurence.");
		} else {
			System.out.println("\n" + nom + " n'a pas trouvé la réponse.");
			vies -= 1;
			System.out.println("\nPrésentateur: Il se trouve que seule Brigitte a trouvée la réponse!");
		}
		if (vies > 1){
			System.out.println("\n[Il vous reste " + vies + " vies]");
			sc.next();
		} else {
			System.out.println("\nPrésentateur: Aïe, " + nom + " n'a plus de vies, il va devoir quitter le show. Ça aura été une belle aventure pour vous. Adieu, et à jamais!");
			sc.next();
			System.out.println("[Vous partez, désépéré de ne pas avoir pu obtenir le carton. Cette chance ne reviendra pas à vous, et vous allez vivre avec ça durant le reste de votre vie.]");
			System.exit(0);
		}

		
		//Fin question 6


		System.out.println("Présentateur: Il se trouve que la réponse était bel est bien U[7] = 128X⁷-192X⁵+80X³-8X, mais tout le monde sait ça bien évidemment.");
		sc.next();
		System.out.println("Présentateur: Nous allons donc passer à-");
		sc.next();
		System.out.println("???: Pas si vite!");
		sc.next();
		System.out.println("Présentateur: QUI OSE M'INTERROMPRE DANS MON PROPRE SHOW?");
		sc.next();
		System.out.println("Policier: C'est la police.");
		sc.next();
		System.out.println("Présentateur: ah.");
		sc.next();
		System.out.println("Policier: On m'a reporté un maximum de bruit ici.");
		sc.next();
		System.out.println("Présentateur: *se fait tout petit* non c'est pas vrai");
		sc.next();
		System.out.println("Policier: Très bien.");
		sc.next();
		System.out.println("Spectateur random: Quoi? Mais ça fait trop de bruit, ça a endommagé mes oreilles!");
		sc.next();
		System.out.println("Policier: Le seul que j'entend ici c'est vous.");
		sc.next();
		System.out.println("Policier: Vous venez avec moi.");
		sc.next();
		System.out.println("Spectateur random: Vous rigolez? C'est moi qui vous ait appelé! Mes oreilles souffrent à cause de- *il se fait emmener dehors par Policier*");
		sc.next();
		System.out.println("Présentateur: Sur cette intervention ma foi assez particulère on peut passer à la question 7!");
		sc.next();
		
		
		//Question 7

		
		System.out.print("\nQuestion 7 - Quelle est est la meilleure blague du monde?\n1. C'est l'histoire d'un zoophile qui prend son élan\n2. Tu connais la blague du mec qui nettoie son clavier? xugfjudfgdfhjdfgdkifsllfjkih;:mkflhdjdvghdbi\n3. C'est l'histoire de 2 putes qui se disputent\n4. Quelle est la partie de la voiture la plus dangereuse? La conductrice\n> ");
		reponse = sc.next().charAt(0);
		System.out.println("\nBrigitte: C'est l'histoire de 2 putes qui se disputent.");
		System.out.println("\nAlbert: Alors, c'est l'histoire d'un zoophile qui prend son élan.");
		if (reponse == 1){
			System.out.println("\n" + nom + ": C'est l'histoire d'un zoophile qui prend son élan.");
			vies -= 1;
			System.out.println("\nPrésentateur: Désolé, on ne fait pas de blagues zoophiles ici.");
		} else if (reponse == 2){
			System.out.println("\n" + nom + ": Tu connais la blague du mec qui nettoie son clavier? xugfjudfgdfhjdfgdkifsllfjkih;:mkflhdjdvghdbi");
			System.out.println("\nPrésentateur: Wow, la blague de " + nom + " est sacrément drôle!");
		} else if (reponse == 3){
			System.out.println("\n" + nom + ": C'est l'histoire de 2 putes qui se disputent.");
			vies -= 1;
			System.out.println("\nPrésentateur: Eh, les gros mots putain!");
		} else if (reponse == 4){
			System.out.println("\n" + nom + ": Quelle est la partie de la voiture la plus dangereuse? La conductrice");
			vies -= 1;
			System.out.println("\nPrésentateur: Oulah, on ne fait pas de blague sur le sexisme ici.");
		} else {
			System.out.println("\n" + nom + " n'a pas trouvé la réponse.");
			vies -= 1;
			System.out.println("\nPrésentateur: Ces blagues ne sont pas autorisées ici.");
		}
		if (vies > 1){
			System.out.println("\n[Il vous reste " + vies + " vies]");
			sc.next();
		} else {
			System.out.println("\nPrésentateur: Aïe, " + nom + " n'a plus de vies, il va devoir quitter le show. Ça aura été une belle aventure pour vous. Adieu, et à jamais!");
			sc.next();
			System.out.println("[Vous partez, désépéré de ne pas avoir pu obtenir le carton. Cette chance ne reviendra pas à vous, et vous allez vivre avec ça durant le reste de votre vie.]");
			System.exit(0);
		}

		
		//Fin question 7


		System.out.println("Présentateur: (à finir)");
		sc.next();
    }
}
