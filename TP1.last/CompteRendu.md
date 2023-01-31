# TP 1 - Discover Docker

[TP 1](http://school.pages.takima.io/devops-resources/ch1-discover-docker-tp/)

---
## Database's Initialization
Pour build l'image de la database :
```
docker build -t lucienmat/postgres-database .
```

Pour run le container :
```
docker run -p 8888:5000 --name postgres-database lucienmat/postgres-database
```

En rajoutant la connexion avec adminer :
```
docker run -p 8888:5000 --name postgres-database --network app-network lucienmat/postgres-database
```
Il faut bien créer un nouveau réseau, ici le réseau app-network :
```
docker network create app-network
```

Pour visualiser la database, on utlisez adminer :
```
docker pull adminer
```

On va ensuite le lancer en le reliant au réseau où se trouve notre base de données:
```
docker run -p "8090:8080" --net=app-network --name=adminer -d adminer
```
On se connecte ensuite à la base de donnée en passant par adminer à l'addresse http://localhost:8090
![Auth](./images/database/authAdminer.PNG)
![Connexion](./images/database/connexionAdminer.PNG)


## Load Database
On va créer des tables et les remplir de données automatiquement, pour ça on utilise des fichers sql qui seront dans le dossier dans le même répertoire que le Dockerfile, dans le Dockerfile on fera une copie de ces fichiers dans le répertoire `/docker-entrypoint-initdb.d` du container. pour exécuter ces scripts on fait: `docker build .`. En relançant le container de la bdd, la base de données va run ces fichiers et donc créer les tables.\
Pour ajouter les fichiers on modifie Dockerfile :
```
COPY CreateScheme.sql /docker-entrypoint-initdb.d
COPY InsertData.sql /docker-entrypoint-initdb.d
```
Il ne reste plus qu'à supprimer le container actuel, rebuild et relancer :\
![Container relancé](./images/database/rebuildContainer.PNG)
On vérifie que la base de données est bien mise à jour :
![Tables remplies](./images/database/tables.PNG)
![Données](./images/database/donn%C3%A9es.PNG)

## Sauvegarder les données
Pour permettre de détruire le container sans pour autant supprimer les données stockées dans la base de données, il faut rajouter un volume. Il va permettre 

---
**Tip** : En runnant le container avec -e pour indiquer les variables d'environnement (nom de la db, mdp ect...) on peut stocker ces variables de manière cryptées, pour ensuite les comparer avec celles reçues à leur tour cryptées.

---


## Backend API

**Main.java**

![Build DockerFile](./images/java/build_main.PNG)

![Run container](./images/java/run_main.PNG)


**Backend simple api**

![Build DockerFile](./images/java/build_myapp-build.PNG)

![Run container](./images/java/run_myapp-build.PNG)

![View](./images/java/view_myapp-build.PNG)


**Backend API**

![View](./images/java/run_student-main.PNG)

![View](./images/java/view_student-main.PNG)



---
## Membres du groupe
    - Lucien MATHIEU
    - Guth MOELLE




