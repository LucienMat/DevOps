# DevOps
[DevOps TD et TP](http://school.pages.takima.io/devops-resources/)\
[TD1](http://school.pages.takima.io/devops-resources/ch1-discover-docker-td/)\
[TP1](http://school.pages.takima.io/devops-resources/ch1-discover-docker-tp/)\
[Présentation module](https://docs.google.com/presentation/d/1J8k-HSHraDPfNTElyaviuDwb28wFP26mO270dUtNUb0/edit#slide=id.p1)\
[Dépot d'images docker](https://store.docker.com)

## 1.1 Docker Run
### Liste des commandes importantes :
* `docker pull [nom]` : récupère une image (depuis la bibliothèque Docker)

* `docker image list` OU `docker images` : affiche la liste des images installées/sauvegardées

* `docker run [image] ls -l` : créé et run un container, download l'image si elle n'est pas déjà sur installée (tout ça fait par Le Docker Daemon ?). \
 `ls -l` pour voir la liste des éléments lancés, on peut mettre aussi `echo "text"` pour avoir un retour. \
 On peut ajouter `it` après le run pour lancer un terminal interactif de l'image. Quitter avec `exit`

 * `docker ps [-a]` : liste les containers lancés, en rajoutant `-a` on a la liste de tous ceux qu'on a déjà une fois

 * `docker rm [-f]` supprime les conteneurs par leur nom ou leur ID.La parmètre [-f] permet de forcer la suppression d'un conteneur en cours d'exécution (utilise SIGKILL)
 
 * `docker inspect [image]` : avoir toutes les informations sur [image]

---
## 1.2 Terminology

**Images** : Fichier system et de configuration utilisé pour créer des containers. On peut le visualiser avec la commande `docker inspect [nom du container]`. C'est le fichier que l'on télécharge au moment de un `docker pull`

**Containers** : Ce sont les instances lancées qui proviennent de d'une image. Ils sont créés avec `docker run`

**Docker Daemon** : Service à la base de docker qui permet de gérer les containers (building, running, distributing)

**Docker client** : L'outil qui permet de d'intéragir avec Docker deamon en ligne de commandes

**Docker Store** : Dépot d'images Docker, avec des containers officiaux ect

---
## 2.0 Webapps with Docker
## 2.1 Run a static website in a container
[Dépot github du code](https://github.com/docker/labs/tree/master/beginner/static-site)

Lancer un webserver dans un container docker :
```
docker run --name [static-site] -e AUTHOR="[Your Name]" -d -P dockersamples/static-site
```
`-d` créé un container détaché du terminal\
`-P` publi les ports exposés sur l'hebergeur Docker\
`-e` pour passer des variables d'environnement au container\
`--name` nom du container
`AUTHOR=""` nom de la variable d'environnement

```
$ docker port static-site
443/tcp -> 0.0.0.0:49153
80/tcp -> 0.0.0.0:49154
```
--> http://localhost:49154 amène vers le serveur web local

---
## Docker images
Build son container depuis le dossier contenant les fichiers du projet (surtout Dockerfile) :
```
docker build -t [YOUR_USERNAME]/[myfirstapp] .
```
Le username est celui sur Docker Cloud, et le `.` indique le dossier actuel dans lequel on se trouve\
On peut ensuite run le container :
```
docker run -p 8888:5000 --name [myfirstapp] [YOUR_USERNAME]/[myfirstapp]
```
On peut aller voir le résultat avec http://localhost:8888, 8888 car c'est le port qu'on a indiqué dans la commande run

# Que se passe-t-il lorsque vous exécutez la commande : docker run -d dockersamples/static-site ? 
    * Après l'exécution de la commande `docker run -d dockersamples/static-site` le container dockersamples/static-site télécharger l'image dockersamples/static-site si elle n'existe pas en local et l'exécute en arrière plan, puis docker rend la main au terminal de l'host via la parmètre `-d`.




---
## Membres du groupe
    - Lucien MATHIEU
    - Guth MOELLE
    

 


