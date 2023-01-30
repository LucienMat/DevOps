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
 
 * `docker rm -f [container]` : force l'arrêt et supprime un container
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
Le username est celui sur Docker Cloud, et le `.` indique le dossier actuel dans lequel on se trouve



---
## Membres du groupe
    - Lucien MATHIEU
    - Guth MOELLE
    

 


