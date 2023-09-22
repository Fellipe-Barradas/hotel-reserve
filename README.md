# Hotel Reserve
Projeto spring boot e react, para reserva de hoteis. Visando apenas para educação, seguindo principios de arquitetura limpa.

<br>**Em desenvolvimento.**
## Descriçao
Projeto consiste em duas partes, o client, no qual será feito com vue.js, com a interface bonita. API Restfull, stateless e que usa autenticação e autorização por token jwt.

## Principais usos

- O client podera fazer login e registro de novos usuários.
- Verificar hoteis disponíveis.
- Fazer reserva.
- Ver todas as reservas feitas.
- Poder "salvar" como favorito hoteis.
- Ver hoteis favoritos.
- Buscar por hoteis por nome e por filtr.

## Diagrama de classes

``` mermaid
classDiagram
    class Hotel {
        + hotel_id : int
        + name : string
        + description : string
        + price : decimal
        + creation_date : date
        + state : string
        + city : string
    }

    class User {
        + user_id : int
        + name : string
        + email : string
        + password : string
    }

    class FavoriteHotel {
        + favorite_id : int
    }

    class Reservation {
        + reservation_id : int
        + guests : int
        + total_price : decimal
        + start_date : date
        + end_date : date
    }

    User --|> FavoriteHotel : "Has"
    Hotel --|> Reservation : "Is Reserved By"
    User --|> Reservation : "Makes"
```
