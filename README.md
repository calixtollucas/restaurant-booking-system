# Restaurante-booking-system
Esta é uma api feita utilizando Java com os frameworks Spring Boot 3, Spring Web, Spring JPA, Lombok, Flyway Migrations e H2 como banco de dados.

O intuíto dessa api é simular um sistema de cadastro de reservas de um restaurante, onde existem neste restaurante várias mesas, cada uma delas possuindo um número e um número de cadeiras.
Cada reserva deve ter no mínimo uma mesa e a reserva é única para um único reservante, ou seja, uma mesma pessoa não pode fazer mais de uma reserva.

## Table Routes
**GET METHODS**
Get todas as tables: /tables
Get table pelo número: /tables/numero/string:numero
Verificar se uma mesa está ocupada: /tables/isoccupied/string:numero

**POST METHODS**

 - Cadastrar Uma Mesa: /tables
	 - body: {"numero": "numero", "num_cadeiras":12}

**PUT METHODS**
