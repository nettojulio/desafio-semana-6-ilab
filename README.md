# DESAFIO SEMANA 6 ILAB

### 1- Faça um projeto CRUD (CRUD: projeto que contém operações de Create, Read, Update e Delete, ou seja, projeto que é possível Adicionar, Ler, Atualizar e Deletar).

### 2- Para manter a persistência do seu aplicativo, faça um Banco de Dados, PostgreSQL, para salvar e manipular dados do seu projeto.

---

Antes de executar o projeto, insira as variáveis necessárias e crie o banco com o arquivo `schema.sql`. 

```
export PG_DATABASE_PASSWORD="postgres"
export PG_DATABASE_URL="postgresql://localhost:5432/projeto_semana_06?useTimezone=true&serverTimezone=UTC"
export PG_DATABASE_USER="postgres"
```

Após essa configuração inicial, execute o comando `gradle bootRun`.

O arquivo `Insomnia_Endpoints.json` contém osendpoints cadastrados.

GET

`/clientes` - Retorna a lista de clientes cadastrados

Exemplo de retorno:

```
[
	{
		"id": 1,
		"nome": "A",
		"cpf": "12345678901",
		"email": "a@hotmail.com",
		"telefone": "71999999999"
	},
	{
		"id": 2,
		"nome": "B",
		"cpf": "12345678902",
		"email": "b@hotmail.com",
		"telefone": "71999999998"
	},
	{
		"id": 3,
		"nome": "C",
		"cpf": "12345678903",
		"email": "c@hotmail.com",
		"telefone": "71999999997"
	},
	{
		"id": 4,
		"nome": "D",
		"cpf": "12345678904",
		"email": "d@hotmail.com",
		"telefone": "71999999996"
	},
	{
		"id": 5,
		"nome": "E",
		"cpf": "12345678905",
		"email": "e@hotmail.com",
		"telefone": "71999999995"
	},
	{
		"id": 6,
		"nome": "F",
		"cpf": "12345678906",
		"email": "f@hotmail.com",
		"telefone": "71999999994"
	},
	{
		"id": 7,
		"nome": "G",
		"cpf": "12345678907",
		"email": "g@hotmail.com",
		"telefone": "71999999993"
	},
	{
		"id": 8,
		"nome": "H",
		"cpf": "12345678908",
		"email": "h@hotmail.com",
		"telefone": "71999999992"
	},
	{
		"id": 9,
		"nome": "I",
		"cpf": "12345678909",
		"email": "i@hotmail.com",
		"telefone": "71999999991"
	}
]
```

`/clientes/{id}`- Retorna (caso exista) o cliente correspondente ao ID informado

Exemplo de retorno:

```
{
	"id": 2,
	"nome": "B",
	"cpf": "12345678902",
	"email": "b@hotmail.com",
	"telefone": "71999999998"
}
```

POST

`/clientes` - Cadastra novo cliente

Para a inclusão, será necessário encaminhar os dados no Body do novo cliente na requisição.

Exemplo de envio:

```
{
	"nome": "Ana",
	"cpf": "12345678903",
	"email": "ana@ana.com",
	"telefone": "71999999988"
}
```

PUT

`/clientes/{id}` - Atualiza os dados (caso exista o id informado) do cliente

Para a atualização, será necessário encaminhar os dados no Body.

Exemplo de envio:

```
{
	"nome": "Ana",
	"cpf": "12345678903",
	"email": "ana@ana.com",
	"telefone": "71999999988"
}
```

DELETE

`/clientes/{id}` - Exclui os dados (caso exista o id informado) do cliente.

Exemplo de retorno:

```
{
	"statusCode": 200,
	"message": "Cliente deletado com sucesso"
}
```