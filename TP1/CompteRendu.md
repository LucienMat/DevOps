# TP 1 - Discover Docker

[TP 1](http://school.pages.takima.io/devops-resources/ch1-discover-docker-tp/)

---
## Database
Pour build l'image de la database :
`docker build -t lucienmat/postgres-database .`

Pour run le container :
`docker run -p 8888:5000 --name postgres-database lucienmat/postgres-database`
