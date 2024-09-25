# Rapport du Projet


## UML

![Uploading Capture d'écran 2024-09-25 173011.png…]()

## Design Patterns Utilisés

Ce projet implémente plusieurs **design patterns**, chacun ayant un rôle précis pour garantir la maintenance, l'évolutivité et la modularité du code.

- **MVC (Model-View-Controller)** : Utilisé dans la gestion des interfaces graphiques, ce pattern sépare la logique métier, l'interface utilisateur et le contrôle des actions.
  
- **Template Method** : Permet la redéfinition de certaines étapes d'un algorithme dans des sous-classes sans modifier la structure globale de l'algorithme dans la classe parente.


---
![Capture d'écran 2024-09-25 173103](https://github.com/user-attachments/assets/dcf59071-833c-4694-91de-72996a6d183f)
![Capture d'écran 2024-09-25 173041](https://github.com/user-attachments/assets/114f2e48-e816-4452-8e75-35de8ba374b6)
![Capture d'écran 2024-09-25 173029](https://github.com/user-attachments/assets/886baeb4-7096-45e7-a167-528166230055)

## 1. MVP : Model-View-Presenter

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
