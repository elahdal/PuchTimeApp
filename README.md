# Rapport du Projet

## Introduction
Ce projet tutoré Java vise à développer une application de suivi des pointages horaires des employés d’une entreprise. Il implique la conception et la réalisation de deux applications principales :

Une application centrale utilisée par le département des ressources humaines pour suivre les pointages des employés.
Un émulateur de pointeuse permettant la simulation des pointages des employés.
L’objectif est de mettre en œuvre des concepts avancés de programmation orientée objet et de modélisation, ainsi que des patterns de conception comme le MVC et le Singleton.

## Objectifs
Les principaux objectifs du projet sont les suivants :

Utilisation de la modélisation orientée objet (UML).
Programmation en Java, avec gestion des dates, multithreading, sockets TCP, et sérialisation.
Application des patterns MVC et Singleton.
Développement en équipe et gestion du projet depuis la conception jusqu’à la livraison.
# Fonctionnalités Principales

## 3.1 Application Centrale
L’application centrale est un outil de gestion RH pour consulter et gérer les pointages des employés, avec les fonctionnalités suivantes :

  Gestion des pointages : Collecte, transfert et sauvegarde des données via des sockets TCP.
  Sauvegarde des données : Les données des employés, départements, et pointages sont sauvegardées via la sérialisation Java.
  Consultation des pointages : Les utilisateurs peuvent visualiser les pointages enregistrés.
  Gestion des employés (CRUD) : Création, modification, suppression et visualisation des employés.
  Gestion des paramètres : Configuration des paramètres réseau pour la communication avec les pointeuses.

## 3.2 Émulateur de Pointeuse
L’émulateur de pointeuse simule les actions des employés lors de l’enregistrement des pointages :

Pointage en temps réel : Simule le pointage d’un employé avec date et heure, transféré à l’application centrale.
Gestion des données hors ligne : Les pointages sont stockés localement si la connexion à l’application centrale est indisponible, puis transférés ultérieurement.
Sérialisation des données : Les données sont automatiquement sauvegardées à la fermeture de l’application et restaurées lors du lancement.

## UML

![Capture d'écran 2024-09-25 173011](https://github.com/user-attachments/assets/fffbd62d-0745-4373-a4db-f6686044217d)

## Design Patterns Utilisés

Ce projet implémente plusieurs **design patterns**, chacun ayant un rôle précis pour garantir la maintenance, l'évolutivité et la modularité du code.

- **MVC (Model-View-Controller)** : Utilisé dans la gestion des interfaces graphiques, ce pattern sépare la logique métier, l'interface utilisateur et le contrôle des actions.
  
- **Template Method** : Permet la redéfinition de certaines étapes d'un algorithme dans des sous-classes sans modifier la structure globale de l'algorithme dans la classe parente.


---

## 1. MVP : Model-View-Presenter
![Capture d'écran 2024-09-25 173041](https://github.com/user-attachments/assets/114f2e48-e816-4452-8e75-35de8ba374b6)
![Capture d'écran 2024-09-25 173029](https://github.com/user-attachments/assets/886baeb4-7096-45e7-a167-528166230055)

Le modèle **MVP** est une variation du modèle **MVC**, particulièrement utilisée pour améliorer la testabilité de l'interface utilisateur. Dans ce projet, il est appliqué à l'interface graphique de l'application.

### Exemple de classes :
- `CentralAppGui` (View)
- `ViewCheckInOut` (View)
- `CentralAppController` (Presenter)

**Explication** :
- **Model** : Représente les données (ex : `TimeRecord`, `Company`).
- **View** : L'interface utilisateur, représentée par des classes comme `CentralAppGui`.
- **Presenter** : Gère la logique et fait le lien entre la View et le Model (ex : `CentralAppController`).

Le pattern MVP permet une séparation claire des responsabilités, facilitant ainsi la testabilité et la maintenance du code.

---

## 2. Template Method Pattern
![Capture d'écran 2024-09-25 173103](https://github.com/user-attachments/assets/dcf59071-833c-4694-91de-72996a6d183f)

Le pattern **Template Method** est utilisé pour définir une structure générique d'opérations tout en permettant aux sous-classes de redéfinir certaines étapes. Il est utilisé dans la gestion des exports de données.

### Exemple de classes :
- `ExportToCsv`
- `ExportToTxt`

Ces classes héritent d'une classe abstraite qui définit une méthode template pour l'exportation de données, tandis que les sous-classes redéfinissent les étapes spécifiques.

**Explication** :
- La classe parente définit la structure de l'algorithme d'export.
- Les sous-classes redéfinissent des étapes spécifiques comme le format des données (CSV, TXT).

Ce pattern permet de centraliser le code commun tout en rendant chaque type d'exportation personnalisable.

---

## 3. Ressources Humaines : `Company`, `Department`, `Employee`

![Capture d'écran 2024-09-25 173055](https://github.com/user-attachments/assets/c534438f-b4a1-49e3-9806-6fedc6507ecf)

Le package **ResourcesOrganization** contient des classes modélisant la gestion des ressources humaines.

### Classes principales :
- `Company` : Gère les employés et les départements de l'entreprise.
- `Department` : Gère les informations relatives à un département spécifique.
- `Employee` : Représente un employé avec ses informations personnelles et ses enregistrements de temps.

**Explication** :
- **Company** : Gère l'ensemble de l'entreprise, avec des méthodes pour ajouter des employés et des départements.
- **Department** : Gère les employés dans chaque département.
- **Employee** : Stocke les informations personnelles et les enregistrements de temps.

Ces classes assurent une gestion claire et flexible de la structure des ressources humaines.

---

## Conclusion

Ce projet est bien structuré grâce à l'utilisation des design patterns **MVP** et **Template Method**, ce qui permet une architecture modulaire et facile à maintenir. La gestion des ressources humaines est bien représentée par les classes `Company`, `Department`, et `Employee`.

L'architecture flexible assure la scalabilité de l'application pour de futures évolutions.
