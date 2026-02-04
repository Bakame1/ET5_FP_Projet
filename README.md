### Pour tester le Backend

1) lancer le fichier BackendApplication.java.
2) Il faut que dans la console il y ait le message "Tomcat started on port 8080"
3) Pour tester avec postman :
   a) inscritpion :
    POST http://localhost:8080/api/auth/register
 Avec en body : 
{
   "email": "test@test.com",
   "password": "password123"
   } 
    b) login :
    POST http://localhost:8080/api/auth/login

{
"email": "test@test.com",
"password": "password123"
}
Puis recuperer le token dans la reponse

c) tester une route protegee :
http://localhost:8080/api/conferences
Sans token : on reçoit une erreur 403
Fonctionne si on met  le token du login dans le header Authorization de type Bearer Token

d) Creer une conference : 
A nouveau il faut mettre le meme token au meme endroit
POST http://localhost:8080/api/conferences
body :
{
"title": "Conférence Java 2026",
"location": "Paris",
"date": "2026-12-25T10:00:00"
}
ATTENTION CELA DOIT ETER UNE DATE DANS LE FUTUR

e) Récupérer toutes les conférences
A nouveau il faut mettre le meme token au meme endroit
GET http://localhost:8080/api/conferences/future
Pas de body

f) Récupérer une conférence par son id
A nouveau il faut mettre le meme token au meme endroit
GET http://localhost:8080/api/conferences/{id}
Pas de body
Exemple : http://localhost:8080/api/conferences/1
A condition que la conference existe