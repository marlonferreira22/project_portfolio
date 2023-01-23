# project_portfolio

Projeto desenvolvido utilizando as tecnologias:
<li>Java 8</li>
<li>Maven</li>
<br/>
<b>Frameworks:</b>
<li>Spring Boot</li>
<li>Hibernate</li>
<li>Interface web com Bootstrap</li>
<li>JUnit 5</li>
<br/>
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
	"name": "João Souza",
	"role": "funcionario"
}
<br/>
<b>OBS:</b> <br/>
Para que a lista de gerentes seja preenchida, é necessário o cadastro de uma nova pessoa com a role = "gerente". Segue exemplo: <br/>
{
	"name": "Maria da Silva",
	"role": "gerente"
}
