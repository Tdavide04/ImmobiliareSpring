# ImmobiliareSpring (Spring Boot + MySQL + JWT)

Backend REST per la gestione di immobili e vendite con autenticazione
JWT e ruoli (CLIENT/ADMIN).

## Stack Tecnologico

-   Java 21
-   Spring Boot (Web, Data JPA, Security, Validation)
-   MySQL
-   JWT (Auth0 java-jwt)
-   Swagger / OpenAPI
-   Docker & Docker Compose

------------------------------------------------------------------------

## Architettura

Struttura a layer:

-   controller/ → REST endpoints
-   service/ → logica applicativa
-   repository/ → accesso al database
-   model/ → entità JPA (Utente, Immobile, Vendita)
-   dto/ → oggetti di trasferimento dati
-   security/ → configurazione Spring Security + JWT

------------------------------------------------------------------------

## Autenticazione

Il sistema utilizza JWT.

1.  Login → genera token
2.  Le richieste protette richiedono header:

Authorization: Bearer `<TOKEN>`{=html}

Il token contiene: - subject (email) - ruolo - issuedAt -
expiration

------------------------------------------------------------------------

## Utente

Campi principali: - idUtente - username (unique) - email (unique) -
password (criptata BCrypt) - ruolo (CLIENT / ADMIN)

------------------------------------------------------------------------

## Immobile

-   idImmobile
-   nome
-   indirizzo
-   citta
-   prezzo
-   superficie
-   tipologie
-   categoriaCatastale
-   disponibilita

------------------------------------------------------------------------

## Vendita

-   idVendita
-   immobile (ManyToOne)
-   utente (ManyToOne)
-   prezzo
-   dataCreazione

Durante l'acquisto: - verifica disponibilità - recupera utente
autenticato dal SecurityContext - salva la vendita - imposta immobile
come non disponibile

------------------------------------------------------------------------

## Avvio con Docker

1)  Build del jar: ./mvnw clean package -DskipTests

2)  Avvio: docker compose up --build

Backend: http://localhost:8080

------------------------------------------------------------------------

## Swagger

Disponibile su: http://localhost:8080/swagger-ui/index.html

------------------------------------------------------------------------


Progetto sviluppato a scopo didattico.
