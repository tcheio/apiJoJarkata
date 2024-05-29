CHEIO THOMAS

Fonctions réalisé:
On peut acheter un billet pour une épreuve, seulement si on n'est pas inscrit à une épreuve à la même date. 🟢
Il faut au moins un CRUD pour 4 ressources différentes.
Les différents rôles des utilisateurs doivent être gérés.
Le projet doit bien être architecturé (Service, Controller, Repository, DTO etc...) 🟢
On peut acheter un billet soit pour soi-même, soit pour un groupe de personnes 🟢
Il faut une certaine logique métier (validation, vérification des possibilités de réservation etc...) 
Les erreurs doivent être gérées 
Il faut des relations entre les entités 🟢
La connexion doit être sécurisée
\n

Routes:
api/reservations 🟢
    - 
api/epreuves 🟢
    - / -> Récupère toutes les épreuves GET
    - [avec paramètres] -> Créer une épreuves POST
    - /getEpreuve/{id} -> Récupère l'épreuve {id} GET
    - /updateEpreuve/{id} -> Met à jour l'épreuve {id} en fonction des informations saisie PUT
    - /deleteEpreuve/{id} -> Supprime l'épreuve {id} DELETE
api/visiteurs 🟢
    - / -> Récupère tous les visiteurs GET
    - [avec paramètres] -> Créer un visiteur POST
    - /getVisiteur/{id} -> Récupère le visiteur {id} GET
    - /UpdateVisiteur/{id} - Met à jour le visiteur associé à l'id en fonction des infos saisie PUT
    - /DeleteVisiteur/{id} -> Supprime le visiteur associé à cet id DELETE
