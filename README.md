# project_portfolio

Projeto desenvolvido utilizando as tecnologias:
<li>Java 8</li>
<li>Maven</li>

<b>Frameworks:</b>
<li>Spring Boot</li>
<li>Hibernate</li>
<li>Interface web com Bootstrap</li>
<li>JUnit 5</li>

<b>Banco de dados:</b>
<li>Postgres</li>
<li>H2Database</li>

<b>OBS:</b>
Por default a aplicação irá iniciar com o banco de dados H2Database, caso necessite alterar para Postgres, basta ir até o arquivo application.properties localizado em: /src/main/resources e comentar as linhas 2 a 6, e tirar o comentário das linhas 13 a 23.

<b>Endpoint</b> <br/>
Só é possível inserir uma nova pessoa através do endpoint: <br/>
{URL}/api/people/ <br/>
método POST

Exemplo do corpo da requisição (body): <br/>
{
	"name": "Maria da Silva",
	"role": "funcionario"
}
