# Hotel Reserve
Projeto spring boot e react, para reserva de hoteis. Visando apenas para educação e estudo.

## Documentação
<br>**Link deploy api railway:** https://hotel-reserve-production.up.railway.app/swagger-ui/index.html
<br>**Figma design:** https://www.figma.com/file/2Jc0gyQH5ML3WpHNOKpPBA/hoteis?type=design&node-id=0-1&mode=design&t=ItbPwWdoGFP4GPj2-0
<br>
## Descriçao
Projeto consiste em uma API Restfull, stateless e que usa autenticação e autorização por token jwt.

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

    class Reservation {
        + reservation_id : int
        + guests : int
        + total_price : decimal
        + start_date : date
        + end_date : date
    }

    class Favorite {
        + user_id : int
        + hotel_id : int
    }

    Hotel --|> Reservation : "Is Reserved By"
    User --|> Reservation : "Makes"
    User --|> Favorite : "Has"
    Hotel --|> Favorite : "Has"
```

## Tecnologias e depêndencias
- Spring Boot 3
- Java 20
- H2
- Postgresql
- Spring security
- Lombok
- Java jwt
- Open API
- Hibernate
- Railway

