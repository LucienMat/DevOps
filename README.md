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

* `docker inspect [image]` : avoir toutes les informations sur [image]


# Que se passe-t-il lorsque vous exécutez la commande : docker run -d dockersamples/static-site ? 
    * Après l'exécution de la commande `docker run -d dockersamples/static-site` le container dockersamples/static-site télécharger l'image dockersamples/static-site si elle n'existe pas en local et l'exécute en arrière plan, puis docker rend la main au terminal de l'host via la parmètre `-d`.




---
## Membres du groupe
    - Lucien MATHIEU
    - Guth MOELLE
    

 


