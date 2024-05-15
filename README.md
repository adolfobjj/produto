<h1 align="center">Projeto de Operações CRUD com Spring Boot e H2 Database</h1>
Este projeto é um aplicativo Spring Boot que realiza operações CRUD (Create, Read, Update, Delete) nas entidades:
"Produto" <br />
"Cliente" <br />
"Compra" <br />
usando uma base de dados H2 (banco de dados em memória).

<h2 align="left">Tecnologias Utilizadas</h2>
Spring Boot<br />
Spring Data JPA<br />
H2 Database<br />
Maven<br />
JUnit<br />
Postman (ou ferramenta similar para testar os endpoints)<br />

<h2 align="left">Estrutura do Projeto</h2>
O projeto segue a estrutura padrão do Spring Boot, com as seguintes camadas:<br />
Controller: Camada responsável por receber as requisições HTTP e fornecer respostas apropriadas.<br />
Service: Camada que contém a lógica de negócios e interage com o repositório.<br />
Repository: Camada que lida com a persistência de dados.<br />

<h2 align="left">Testando os Endpoints</h2>
Use o Postman ou uma ferramenta similar para testar os endpoints.<br />
Utilize os JSONs de exemplo fornecidos para fazer as requisições.<br />
Os endpoints são:<br /><br />
POST /produtos: Criar um novo produto.<br />
GET /produtos: Obter todos os produtos.<br />
GET /produtos/{id}: Obter um produto pelo ID.<br />
PUT /produtos/{id}: Atualizar um produto pelo ID.<br />
DELETE /produtos/{id}: Excluir um produto pelo ID.<br /><br />

foi criado um endpoint onde pode se consultar se existe um cliente pelo nome: <br />
Neste exemplo, o endpoint /clientes/buscar é mapeado para o método buscarPorNome no controlador. <br />
Ele espera um parâmetro de consulta chamado "nome" e usa o método findByNomeContainingIgnoreCase <br />
no repositório de clientes para buscar clientes cujos nomes contenham a sequência fornecida, ignorando maiúsculas e minúsculas. <br />
exemplo : http://localhost:8080/clientes/buscar?nome=Maria <br />

Segue exemplo de JSOn para o método POST:<br /><br />
{<br />
  "nome": "Produto Teste 1",<br />
  "descricao": "Descrição do Produto Teste",<br />
  "preco": 19.99<br />
}<br />
Segue exemplo de insert no sql: <br />
INSERT INTO cliente (nome, email) VALUES ('Maria Oliveira', 'maria@example.com');<br />
INSERT INTO cliente (nome, email) VALUES ('Carlos Santos', 'carlos@example.com');<br />
INSERT INTO cliente (nome, email) VALUES ('Ana Silva', 'ana@example.com');<br />
INSERT INTO produto (nome, descricao, preco) VALUES ('Calça Jeans', 'Calça jeans azul, tamanho M', 79.90);<br />
INSERT INTO produto (nome, descricao, preco) VALUES ('Tênis Esportivo', 'Tênis de corrida preto, tamanho 42', 129.90);<br />
INSERT INTO produto (nome, descricao, preco) VALUES ('Mochila', 'Mochila escolar preta, com compartimento para notebook', 49.90);<br />


Contribuições são bem-vindas! Sinta-se à vontade para abrir um Pull Request ou Issues para sugerir melhorias ou correções.<br />
