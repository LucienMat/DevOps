# TP 2 - Discover Githun Action

## Notes
**yaml file** : fichier qui décris les étapes à lancer au moment de l'éxecution de la pipeline. Par exemple des tests, des vérification de synthaxe...

La commande `mvn clean verify` sert à nettoyer le projet avec clean afin de le rebuild et de le relancer proprement sans cache. Verify va build tous les modules de l'application et runner les tests pour s'assurer que les critères de qualité définis sont rempli (Tests unitaires et d'intégration). [Maven commands sheets](https://www.digitalocean.com/community/tutorials/maven-commands-options-cheat-sheet)\
La commande soit être lancer depuis le dossier contenant `pom.xml` ou en précisant sa route avec `--file [path to pom.xml]`

**testcontainer** : présents dans le fichier `pom.xml` ce sont des containers issues de librairies java qui vont premttrent de lancer les tests et de lancer notre application en même temps. 


---
## Membres du groupe
    - Lucien MATHIEU
    - Guth MOELLE
