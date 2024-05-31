# CHEIO THOMAS

## Fonctions réalisées

- On peut acheter un billet pour une épreuve, seulement si on n'est pas inscrit à une épreuve à la même date. 🟢
- Il faut au moins un CRUD pour 4 ressources différentes. 🟢
- Les différents rôles des utilisateurs doivent être gérés. 🔄️ (dans le dev)
- Le projet doit bien être architecturé (Service, Controller, Repository, DTO, etc.) 🟢
- On peut acheter un billet soit pour soi-même, soit pour un groupe de personnes. 🟢
- Il faut une certaine logique métier (validation, vérification des possibilités de réservation, etc.)
- Les erreurs doivent être gérées. (en partie)
- Il faut des relations entre les entités. 🟢
- La connexion doit être sécurisée.

## Routes

### Reservations
- **GET /api/reservations**
    - Récupère toutes les réservations.
- **POST /api/reservations** (avec paramètres)
    - Crée une réservation.
- **GET /api/reservations/getReservation/{id}**
    - Récupère la réservation avec l'ID spécifié.
- **PUT /api/reservations/updateReservation/{id}**
    - Met à jour la réservation avec l'ID spécifié en fonction des informations saisies.
- **DELETE /api/reservations/deleteReservation/{id}**
    - Supprime la réservation avec l'ID spécifié.

### Epreuves
- **GET /api/epreuves**
    - Récupère toutes les épreuves.
- **POST /api/epreuves** (avec paramètres)
    - Crée une épreuve.
- **GET /api/epreuves/getEpreuve/{id}**
    - Récupère l'épreuve avec l'ID spécifié.
- **PUT /api/epreuves/updateEpreuve/{id}**
    - Met à jour l'épreuve avec l'ID spécifié en fonction des informations saisies.
- **DELETE /api/epreuves/deleteEpreuve/{id}**
    - Supprime l'épreuve avec l'ID spécifié.

### Visiteurs
- **GET /api/visiteurs**
    - Récupère tous les visiteurs.
- **POST /api/visiteurs** (avec paramètres)
    - Crée un visiteur.
- **GET /api/visiteurs/getVisiteur/{id}**
    - Récupère le visiteur avec l'ID spécifié.
- **PUT /api/visiteurs/updateVisiteur/{id}**
    - Met à jour le visiteur associé à l'ID en fonction des informations saisies.
- **DELETE /api/visiteurs/deleteVisiteur/{id}**
    - Supprime le visiteur associé à l'ID spécifié.

### Tickets
- **GET /api/tickets**
    - Récupère tous les tickets.
- **POST /api/tickets** (avec paramètres)
    - Crée un ticket.
- **GET /api/tickets/getTicket/{id}**
    - Récupère le ticket avec l'ID spécifié.
- **PUT /api/tickets/updateTicket/{id}**
    - Met à jour le ticket associé à l'ID en fonction des informations saisies.
- **DELETE /api/tickets/deleteTicket/{id}**
    - Supprime le ticket associé à l'ID spécifié.
