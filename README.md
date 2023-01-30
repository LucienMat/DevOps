# DevOps

## Liste des commandes importantes :
* `docker pull [nom]` : récupère une image (depuis la bibliothèque Docker)

* `docker image list` OU `docker images` : affiche la liste des images installées/sauvegardées

* `docker run [image] ls -l` : créé et run un container, download l'image si elle n'est pas déjà sur installée (tout ça fait par Le Docker Daemon ?). \
 `ls -l` pour voir la liste des éléments lancés, on peut mettre aussi `echo "text"` pour avoir un retour

* `docker run -it [image]` : lancer le container de [image] et accès au terminal de [image]

* `docker inspect [image]` : avoir toutes les informations sur [image]


# Que se passe-t-il lorsque vous exécutez la commande : docker run -d dockersamples/static-site ? 
    * Après l'exécution de la commande `docker run -d dockersamples/static-site` le container dockersamples/static-site est exécuter en arrière plan et docker rend la main au terminal de l'host via la parmètre `-d`.


## Membres du groupe
    - Lucien MATHIEU
    - Guth MOELLE
    

 


