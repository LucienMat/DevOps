    
# TP 3 - Discover Ansible

## Membres du groupe
    - Lucien MATHIEU
    - Guth MOELLE

## Install Ansible
Pour commencer il faut installer Ansible, sous Windows il faudra passer par un Sous-système Linux.\
Nous avons utilisé un sous-styème Ubuntu. Une fois wsl (`wsl --install`) et Ubuntu installés, on va venir se placer dans notre projet avec : `cd /mnt/path/to/project` le mnt sert à relié le sous système au fichiers Windows\
![cd ubtuntu](./screenshot/cdMnt.PNG)
On voit avec `ansible --version` que Ansible n'est pas encore installé. Pour l'installer `sudo apt install ansible` (si le package n'est pas reconnu, bien mettre à jour apt avec `sudo apt update` et `sudo apt upgrade`).\
On peut vérifier que Ansible est bien installé :
![ansible isntallé](./screenshot/ansibleVersion.PNG)

On peut maintenant commencer le TP

## Inventories
Créer un nouveau dossier ansible/inventories qui va contenir le setup d'Ansible et la clé privée.**
![ansible folder](./screenshot/ansibleFolder.PNG)
Le fichier setup.yml va servir à se connecter à notre compte github. 
```
all:
 vars:
   ansible_user: centos
   ansible_ssh_private_key_file: /mnt/d/Documents/CPE/S7-DevOps/DevOps/ansible/inventories/id_rsa
 children:
   prod:
     hosts: lucien.mathieu.takima.cloud
```
Le chemin vers la clé ssh est bien à mettre en fonction du sous-système Ubuntu, donc en rajoutant `/mnt/` au début.\
Le host sera la lien par lequel on pourra se connecter pour vérifier le fonctionnement d'Ansible.

On test la connexion avec `ansible all -i inventories/setup.yml -m ping` :
![Connexion Ansible](./screenshot/firstConnexion.PNG)
