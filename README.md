# Mini projet Spring Boot et Angular
## Polytech Paris-Saclay - Frameworks Professionels 2026
**Morgan PHILIPPE et Marko BABIC**

### Pour tester le Backend

1. Lancer le fichier `BackendApplication.java`.
2. Vérifier dans la console que le message suivant s'affiche : `Tomcat started on port 8080`.
3. **Pour tester avec Postman :**

   **a) Inscription**
    * **Méthode :** `POST`
    * **URL :** `http://localhost:8080/api/auth/register`
    * **Body :**
      ```json
      {
        "email": "test@test.com",
        "password": "password123"
      }
      ```

   **b) Login**
    * **Méthode :** `POST`
    * **URL :** `http://localhost:8080/api/auth/login`
    * **Body :**
      ```json
      {
        "email": "test@test.com",
        "password": "password123"
      }
      ```
    * *Note : Récupérer le token dans la réponse pour la suite.*

   **c) Tester une route protégée**
    * **URL :** `http://localhost:8080/api/conferences`
    * **Sans token :** on reçoit une erreur `403`.
    * **Avec token :** Fonctionne si on met le token du login dans le header `Authorization` de type **Bearer Token**.

   **d) Créer une conférence**
    * *Note : Il faut mettre le même token au même endroit.*
    * **Méthode :** `POST`
    * **URL :** `http://localhost:8080/api/conferences`
    * **Body :**
      ```json
      {
        "title": "Conférence Java 2026",
        "location": "Paris",
        "date": "2026-12-25T10:00:00"
      }
      ```
   > **ATTENTION :** CELA DOIT ÊTRE UNE DATE DANS LE FUTUR.

   **e) Récupérer toutes les conférences**
    * *Note : Il faut mettre le même token au même endroit.*
    * **Méthode :** `GET`
    * **URL :** `http://localhost:8080/api/conferences/future`
    * **Body :** Aucun.

   **f) Récupérer une conférence par son ID**
    * *Note : Il faut mettre le même token au même endroit.*
    * **Méthode :** `GET`
    * **URL :** `http://localhost:8080/api/conferences/{id}`
    * **Exemple :** `http://localhost:8080/api/conferences/1`
    * **Condition :** La conférence doit exister.
    * **Body :** Aucun.

   **g) Documentation API**
   Pour avoir un aperçu sur tous les endpoints, nous avons créé une doc Swagger :
    * Aller dans le navigateur : http://localhost:8080/swagger-ui/index.html