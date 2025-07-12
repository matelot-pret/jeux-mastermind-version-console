# Mastermind - Jeu en Console

## Description

Ce projet est une implémentation du jeu **Mastermind** en version console, développée en Java dans le cadre d'un cours de première année de programmation.

Le Mastermind est un jeu de logique où le joueur doit deviner un code secret composé de couleurs. Le programme génère aléatoirement un code secret de 4 couleurs, et le joueur a 10 tentatives maximum pour le découvrir.

## Fonctionnalités

### Règles du jeu

- **Code secret** : 4 positions avec des couleurs représentées par des lettres
- **Couleurs disponibles** : 8 couleurs au choix
  - `b` : bleu
  - `g` : gris
  - `m` : marron
  - `j` : jaune
  - `r` : rouge
  - `n` : noir
  - `v` : vert
  - `o` : orange

### Modes de jeu

1. **Niveau facile** : Le code secret ne contient aucune répétition de couleurs
2. **Niveau difficile** : Le code secret peut contenir des répétitions de couleurs

### Système de réponses

Après chaque proposition, le jeu indique :

- **Pions bien placés** : nombre de couleurs correctes à la bonne position
- **Pions mal placés** : nombre de couleurs correctes mais à la mauvaise position

## Prérequis

- Java 8 ou version supérieure
- Un terminal/console pour exécuter le programme

## Compilation et exécution

### Compilation

```bash
javac src/Mastermind.java
```

### Exécution

```bash
java -cp src Mastermind
```

## Structure du projet

```
mastermind/
├── src/
│   └── Mastermind.java     # Code source principal
├── test/
│   └── TestMastermind.pdf  # Tests du projet
├── doc/                    # Documentation générée
│   ├── Doxyfile           # Configuration Doxygen
│   ├── html/              # Documentation HTML
│   └── latex/             # Documentation LaTeX
├── README.md              # Ce fichier
└── .gitignore            # Fichiers à ignorer par Git
```

## Comment jouer

1. Lancez le programme
2. Choisissez de commencer une partie (1) ou quitter (0)
3. Sélectionnez le niveau de difficulté :
   - 1 pour facile (sans répétitions)
   - 2 pour difficile (avec répétitions possibles)
4. Entrez vos propositions de code (4 lettres parmi les couleurs disponibles)
5. Analysez les indices fournis après chaque tentative
6. Trouvez le code secret en 10 tentatives maximum !

## Exemple d'utilisation

```
MASTERMIND

(1 tentative) Entrez votre proposition de code
> bjrn
nombre de pions bien placés : 1
nombre de pions mal placés : 2

(2 tentative) Entrez votre proposition de code
> rbgj
nombre de pions bien placés : 2
nombre de pions mal placés : 0
...
```

## Fonctions principales

- `genererCodeSansRepetition()` : Génère un code secret sans répétition
- `genererCodeAvecRepetition()` : Génère un code secret avec répétitions possibles
- `propositionIsValid()` : Valide la proposition du joueur
- `compareSecretCodeWithPropositionCode()` : Compare et affiche les résultats
- `userWin()` : Vérifie si le joueur a gagné

## Contexte pédagogique

Ce projet a été réalisé dans le cadre d'un **cours de Java en première année** et illustre les concepts fondamentaux suivants :

- Manipulation de tableaux en Java
- Structures de contrôle (boucles, conditions)
- Méthodes et fonctions
- Entrées/sorties console avec Scanner
- Génération de nombres aléatoires
- Programmation procédurale

## Auteur

Projet développé dans le cadre des cours de programmation Java - Première année.
