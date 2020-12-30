### Projet Login avec Database Room + API

#### Présention

Cette application contient une base de donnée ROOM, et une API, lorsque l'on lance l'application, on se retrouve devant un écran de login, 
où on rentre son identifiant et mot de passe si on est a déjà. Sinon, on créé un nouvel utilisateur en appuyant sur le bouton Create account. 
Une fois qu'on a rentrer le bon identifiant et login on peut accéder à un écran d'acceuil avec un bouton, et une fois qu'on appuie dessus, 
on se retrouve devant une liste (recycler view) qui contient les 151 premiers pokemon avec leurs informations. Si on appuie sur l'image 
ou le nom d'un pokemon on se retrouve sur une autre page avec des informations détaillées

#### Fonctionnalité

##### Login et base de donnée
Lorsque l'on lance l'application, on se retrouve devant 2 champs de texte (Login, password). Si on essaye de rentrer un logins qui n'existent pas ou un mot de passe incorrect un pop up d'erreur apparait.
Lorsqu'on appuie sur le bouton "create account" on peut créer un nouvel utilisateur, si on rentre un login qui existe déjà, on a un message d'erreur qui est renvoyé, de même,
si le champ de login est vide un message d'erreur est envoyer.
Si l'utilisateur rentre un login et mot de passe correct, il est envoyer vers une autre page.

##### API-Pokemon
Après avoir rentré, un login et mot de passe correct, l'utilisateur arrive devant un menu avec un bouton et un musique se lance (musique de la route 11 de pokemon rouge feu). 
Une fois que le bouton est appuyé, l'utilisateur arrive devant une recycler view ou sont ajouté tous les pokemons qui se trouvent sur l'API, si on appuie sur un l'image ou le nom d'un pokemon,
on arrive sur une autre page ou on peut voire des informations détaillées. Il y a aussi un bouton 3D model, mais qui ne renvoie vers rien (pas eu le temp)
