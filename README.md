# Spring and Kafka demo project
## Implementing a library application using Spring - Kafka - Docker
### Relational database for persistence and TDD

### Broad description of the project:

 ```
Crias um serviço que produz mensagens de Kafka. Este serviço pode ter uma API (para teres interface visual podes usar o Swagger). 
Crias outro serviço que consome as mensagens de Kafka e faz update do estado numa DB SQL Server.
Para teres tudo disponível podes usar docker.

O tema deixo ao teu critério. Uma ideia pode ser um sistema de gestão de livros. O primeiro serviço é uma livraria. 
Tens endpoints para inserir, update e delete livros. 
E depois tens outros endpoints que são os que os clientes usam para fazer reservas. 
Sempre que o endpoint das reservas é usado, produzes uma mensagem de Kafka com a identificação do livro, cliente e o estado reserva. 
Depois o outro serviço vai consumir estas mensagens e dar update do estado da reserva do livro na BD.
```


### 1. Create a maven root project 



