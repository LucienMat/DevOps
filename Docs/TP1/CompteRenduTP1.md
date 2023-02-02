
    
# TP 1 - Discover Docker

## Membres du groupe
    - Lucien MATHIEU
    - Guth MOELLE

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
On se connecte ensuite à la base de donnée en passant par adminer à l'addresse http://localhost:8090\
![Auth](./screenshot/authAdminer.PNG)\
![Connexion](./screenshot/connexionAdminer.PNG)\

---
## Load Database
On va créer des tables et les remplir de données, pour ça on utilise des fichers sql qui seront dans le dossier `/docker-entrypoint-initdb.d` du container. En relançant le container la base de données va run ces fichiers et donc créer les tables.\
Pour ajouter les fichiers on modifie Dockerfile :
```
COPY CreateScheme.sql /docker-entrypoint-initdb.d
COPY InsertData.sql /docker-entrypoint-initdb.d
```
Il ne reste plus qu'à supprimer le container actuel, rebuild et relancer :\
![Container relancé](./screenshot/rebuildContainer.PNG)\
On vérifie que la base de données est bien mise à jour :\
![Tables remplies](./screenshot/tables.PNG)\
![Données](./screenshot/donn%C3%A9es.PNG)\
On peut également visualiser les données en utilisant pgAdmin

---
## Sauvegarder les données
Pour permettre de détruire le container sans pour autant supprimer les données stockées dans la base de données, il faut rajouter un volume. Il va permettre de stocker les données sans être affectué par l'état du container.\
Pour créer le volume, on va rajouter `-v /my/own/datadir:/var/lib/postgresql/data` dans la commande de run du container :
```
docker run -p 8888:5000 --name postgres-database --network app-network -v volume-postgres:/var/lib/postgresql/data lucienmat/postgres-database
```
On vérifie qu'il a bien été créé :
```
D:\Documents\CPE\S7-DevOps\DevOps\TP1.last\images\database>docker volume ls
DRIVER    VOLUME NAME
local     volume-postgres
```
On peut retrouver notre volume avec le chemin : `\\wsl$\docker-desktop-data\data\docker\volumes\volume-postgres`

---
## Spring Web
Récupération du Spring Initializr, et ajout du fichier `GreetingController.java` dans le projet Spring : \
![ARboresence spring](./screenshot/Arborescence.PNG)\
Il faut ensuite créer un nouveau Dockerfile situé dans le projet Spring qui va permettre de configurer et de build l'app java 

Ensuite on build puis on run le container en se plaçant bien dans le fichier :\
`docker build -t lucienmat/myapp .`\
`docker run -p 8081:8080 --name myapp --network app-network lucienmat/myapp`

On peut ensuite vérifier le bon fonctionnement avec l'addresse http://localhost:8081 \
![Hello world](./screenshot/helloWorld.PNG)\

---
## Backend API

**Main.java**

![Build DockerFile](./screenshot/build_main.PNG)

![Run container](./screenshot/run_main.PNG)


**Backend simple api**

![Build DockerFile](./screenshot/build_myapp-build.PNG)

![Run container](./screenshot/run_myapp-build.PNG)

![View](./screenshot/view_myapp-build.PNG)


***Question***

1-2 La construction en plusieurs étages va nous permettre de séparer la partie import des dépendances du fichier pom, la génération du Jar et la partie exécution du Jar. L'étape Build du fichier DockerFile va impoter des dépendances et générée le Jar du projet et l'étape Run va allé chercher tous les fichiers Jar dans le répertoireCourant/target et exécuteé ce Jar.


**Backend API**

![View](./screenshot/run_student-main.PNG)

![View](./screenshot/view_student-main.PNG)


## Publish des images

On va publier nos 3 images pour les avoir à disposition sur Dockerhub.\
On commence par se login à Dockerhub avec `docker login`. Ensuite on va ajouter une image et la publier en utilisant `docker tag` et `docker push` :
![Connexion et push des images](./screenshot/publishImage%2BloginDockerHub.PNG)

On repète l'opération pour les 2 autres images `simple-api` et `httpd`. On vérfie qu'ils sont bien accessibles sur Dockerhub :
![Repo Dockerhub](./screenshot/repoDockerhub.PNG)

---
**Tip** : En runnant le container avec -e pour indiquer les variables d'environnement (nom de la db, mdp ect...) on peut stocker ces variables de manière cryptées, pour ensuite les comparer avec celles reçues à leur tour cryptées.


---
