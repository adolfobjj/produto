## Projeto de Operações CRUD com Spring Boot e H2 Database
Este projeto é um aplicativo Spring Boot que realiza operações CRUD (Create, Read, Update, Delete) em uma entidade "Produto" usando uma base de dados H2 (banco de dados em memória).

## Tecnologias Utilizadas
Spring Boot
Spring Data JPA
H2 Database
Maven
JUnit
Postman (ou ferramenta similar para testar os endpoints)
## Estrutura do Projeto
O projeto segue a estrutura padrão do Spring Boot, com as seguintes camadas:

Controller: Camada responsável por receber as requisições HTTP e fornecer respostas apropriadas.
Service: Camada que contém a lógica de negócios e interage com o repositório.
Repository: Camada que lida com a persistência de dados.

## Testando os Endpoints
Use o Postman ou uma ferramenta similar para testar os endpoints.
Utilize os JSONs de exemplo fornecidos para fazer as requisições.
Os endpoints são:
POST /produtos: Criar um novo produto.
GET /produtos: Obter todos os produtos.
GET /produtos/{id}: Obter um produto pelo ID.
PUT /produtos/{id}: Atualizar um produto pelo ID.
DELETE /produtos/{id}: Excluir um produto pelo ID.
Contribuição
Contribuições são bem-vindas! Sinta-se à vontade para abrir um Pull Request ou Issues para sugerir melhorias ou correções.

Segue exemplo de JSOn para o método POST:
{
  "nome": "Produto Teste 1",
  "descricao": "Descrição do Produto Teste",
  "preco": 19.99
}
