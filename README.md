# project_portfolio

Projeto desenvolvido utilizando as tecnologias:
Java 8
Maven

<b>Frameworks:</b>
Spring Boot
Hibernate
Interface web com Bootstrap
JUnit 5

<b>Banco de dados:</b>
Postgres e H2Database

<b>OBS:</b>
Por default a aplicação irá iniciar com o banco de dados H2Database, caso necessite alterar para Postgres, basta ir até o arquivo application.properties localizado em: /src/main/resources e comentar as linhas 2 a 6, e tirar o comentário das linhas 13 a 23.

<b>Endpoint</b>
Só é possível inserir uma nova pessoa através do endpoint: 
{URL}/api/people/ 
método POST

Exemplo do corpo da requisição (body):
{
	"name": "Maria da Silva",
	"role": "funcionario"
}