# TP 2 - Discover Githun Action

## Notes
**yaml file** : fichier qui décris les étapes à lancer au moment de l'éxecution de la pipeline. Par exemple des tests, des vérification de synthaxe...

La commande `mvn clean verify` sert à nettoyer le projet avec clean afin de le rebuild et de le relancer proprement sans cache. Verify va build tous les modules de l'application et runner les tests pour s'assurer que les critères de qualité définis sont rempli (Tests unitaires et d'intégration). [Maven commands sheets](https://www.digitalocean.com/community/tutorials/maven-commands-options-cheat-sheet)\
La commande soit être lancer depuis le dossier contenant `pom.xml` ou en précisant sa route avec `--file [path to pom.xml]`

**testcontainer** : présents dans le fichier `pom.xml` ce sont des containers issues de librairies java qui vont premttrent de lancer les tests et de lancer notre application en même temps.

Pour les workflows, `need` ne marche que avec les pipelines qui se trouvent dans le même workflow. Si on cherche à lancer en fonction d'un autre workflow il faut utiliser `if`

## Configuration du main.yml
Pour indiquer quand lancer les tests, on configure les variables push et pull_requests :
```
push:
   branches: [ "main"]
  pull_request:
    branches: [ "main"]
```
Ici nos tests seront lancés s'il y a un pull ou un push sur la branche "main"

On set up le container responsable des test dans le backend, intitulé `test-backend`. Il faut indiquer la version de Java à utiliser, quel JDK, le nom de la distribution ect...
```
- name: Set up JDK 17
        uses: actions/setup-java@v3
        with:
          java-version: '17'
          distribution: 'temurin'
          #cache: maven
```
*Attention bien mettre la v3 et commenté le cache*
Pour avoir un exemple de configuration aller sur le projet Github, onglet `Actions`, et `New workflow`. On a un exemple de fichier main.yml configuré, avec la version de java, la distribution...

Pour finir on indique la commande à run pour lancer les tests :
```
#finally build your app with the latest command
      - name: Build and test with Maven
        run:  mvn clean verify --file /./TP2/simple-api/pom.xml
```
*Mettre le chemin vers le pom relatif au fichier main*
On retrouve `mvn clean verify` (cf. Notes), avec le chemin qui amène vers le fichier pom.xml qui contients les différents testcontainers


## Ajout des secrets dans Github



---
## Membres du groupe
    - Lucien MATHIEU
    - Guth MOELLE
