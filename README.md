# java-jdbc
 des exos en java-jdbc
 # une application Java qui gère des clients et des services:
 
Interface utilisateur :

L'application utilise une interface utilisateur graphique (GUI) Swing pour interagir avec les utilisateurs.
L'interface comprend un formulaire permettant de rechercher des clients en fonction du service auquel ils sont associés.
Classes et services :

Le programme comporte plusieurs classes, notamment Client, Service, ClientService, et ServiceService, pour représenter des clients, des services, et les services liés à la gestion de ces entités.
La classe Client contient des informations sur les clients, notamment leur nom, prénom, date de naissance, et le service auquel ils sont associés.
La classe Service représente les services fournis, avec un identifiant et un nom.

Base de données :

Le programme utilise une base de données pour stocker des informations sur les clients et les services.

Fonctionnalités clés :

La classe ClientService propose des méthodes pour créer, mettre à jour, supprimer, rechercher et obtenir des informations sur les clients.
La classe ServiceService offre des méthodes similaires pour les services.
Une fonction de recherche de clients en fonction du service auquel ils sont associés est mise en œuvre dans la classe ClientService et utilisée dans l'interface graphique.

Sécurité :

Le programme utilise PreparedStatement pour éviter les attaques par injection SQL, améliorant ainsi la sécurité des opérations de base de données.
 

![ser](https://github.com/sana7867/java-jdbc/assets/147515885/87d7068d-ca04-408f-935c-77ccf4076396)

![ser2](https://github.com/sana7867/java-jdbc/assets/147515885/d96ddfaf-1768-45c8-89a0-ec4827513b1b)

![gestion client](https://github.com/sana7867/java-jdbc/assets/147515885/dc226a04-0714-45d2-95cd-8070ad6ce4db)

![modifier](https://github.com/sana7867/java-jdbc/assets/147515885/66435f86-95cf-42e7-8b5a-3f0c13571551)

![recherche](https://github.com/sana7867/java-jdbc/assets/147515885/1c61a171-ed09-4107-b093-dd88151fc4fb)

![supprimer](https://github.com/sana7867/java-jdbc/assets/147515885/a220fe60-9ffd-410c-8aea-0281855a5f57)
