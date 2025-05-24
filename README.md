📋 Description
Cette application Spring Boot expose une API RESTful permettant de gérer les employés et les départements d'une entreprise. Elle supporte les opérations CRUD, la recherche filtrée, la validation des données, et inclut une documentation Swagger.

🚀 Fonctionnalités
🔹 Départements
GET /departments — Liste tous les départements
POST /departments — Crée un nouveau département
PUT /departments/{id} — Met à jour un département
DELETE /departments/{id} — Supprime un département

🔹 Employés
GET /employees — Liste tous les employés (option : ?departmentId=1)
POST /employees — Ajoute un employé
PUT /employees/{id} — Met à jour un employé
DELETE /employees/{id} — Supprime un employé
GET /employees/salaire?min=5000 — Liste des employés avec salaire > 5000

✅ Validation des données
Email valide et unique
Salaire > 0
Nom et prénom non vides

🛠️ Stack technique
Langage : Java 17+
Framework : Spring Boot
Persistance : Spring Data JPA
Base de données : PostgreSQL
Autres : Lombok, Swagger (springdoc), MapStruct

📚 Documentation Swagger
Accéder à la documentation interactive via :
http://localhost:8080/swagger-ui.html
