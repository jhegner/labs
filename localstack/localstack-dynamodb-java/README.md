# Instalar o Python 🐍

Linguagem de programação de propósito geral (💪) 

## Instalação
https://www.python.org/downloads/windows/

## Para confirmar a instalação execute 

`λ py --version ou python --version`

# Instalar a ferramenta AWS CLI ☁️

Ferramenta que permite interagir via linha de comandos com os serviços AWS. 

## Instalação

https://docs.aws.amazon.com/cli/latest/userguide/getting-started-install.html

## Para confirmar a instalação execute 

`λ aws --version`

## Configuração de profile para acesso aos serviços de uma conta AWS (real ou localstack)

https://awscli.amazonaws.com/v2/documentation/api/latest/reference/configure/index.html?highlight=configure

Para configurar um novo profile (para uso do localstack), execute:

`λ aws configure --profile localstack`

### Informe valores aleatórios para o KEY ID e Access Key. Para o region informe (sa-east-1). O output default é o formato json

Exemplo:

`λ aws configure --profile localstack`

Saída:

```
AWS Access Key ID [None]: 6f56076c-6aa2-4265-9323-477da8d2ccc1
AWS Secret Access Key [None]: 9102535d-8ba5-4d6e-bc67-c0c61ea6b346
Default region name [None]: sa-east-1
Default output format [None]: json
```

### Para listar os profiles configurados, execute

`λ aws configure list-profiles`

Exemplo:

`λ aws configure list-profiles`

Saída:

```
default
localstack
```

# Instalar o Docker 💻

Docker é uma plataforma para desenvolver, entregar e executar aplicações com todas as dependências empacotadas num único artefato.

https://docs.docker.com/get-started/overview/

https://docs.docker.com/desktop/windows/install/

## Para confirmar a instalação execute 

`λ docker info`

## Docker compose

Ferramenta para definir e executar multiplos containers no Docker. Com o Docker-compose podemos definir varios serviços

https://docs.docker.com/compose/

https://docs.docker.com/compose/compose-file/

A ferramenta docker compose é fornecida com a instalação padrão do docker desktop para windows. Mais detalhes:

https://docs.docker.com/compose/install/

# Instalação do LocalStack 🔧

LocalStack é um emulador de serviços cloud (aws, azure) executados num container em ambiente local ou de Continuous Integration - CI (test, stage, etc)

https://localstack.cloud/

https://docs.localstack.cloud/get-started/

## Serviços fornecidos

O localstack permite utilizar no ambiente local serviços da aws como s3, dynamodb, lambda, etc

Vamos utilizar o localstack com o docker-compose para simplificar a configuração e inicialização dos containers, habilitando os serviços s3 e dynamodb.

Utilize o arquivo `compose.yaml` na raiz do projeto e execute o comando `docker-compose up` para inicializacao dos servicos.

# Utilização do LocalStack 🔨

Podemos executar alguns comandos para testar os serviços que acabaram de inicializar.
Observe que para execução dos comandos no aws cli deve-se informar o atributo de URL com seu respectivo valor `--endpoint-url=http://127.0.0.1:4566`.
Este endpoint foi definido no arquivo `compose.yaml` como argumento do atributo ports da imagem docker `localstack/localstack`

## SQS

O AWS SQS (Simple Queue Service) é um serviço de filas de mensagens gerenciado pelo cloud provider, que permite desacoplamento e escabilidade de sistemas distribuidos.

https://aws.amazon.com/pt/sqs/

### Listar as filas criadas 

`λ aws sqs list-queues --endpoint-url="http://127.0.0.1:4566"`

### Criar uma nova fila

`λ aws sqs create-queue --queue-name="labs-localstack-dynamodb-java-queue"  --endpoint-url="http://127.0.0.1:4566"`

Saída:

```json
{
    "QueueUrl": "http://127.0.0.1:4566/000000000000/labs-localstack-dynamodb-java-queue"
}
```
### Enviar uma mensagem

`
λ aws sqs send-message --queue-url "http://127.0.0.1:4566/000000000000/labs-localstack-dynamodb-java-queue" --message-body "Hello SQS World" --delay-seconds 10 --endpoint-url http://127.0.0.1:4566
`

Saída:

```json
{
    "MD5OfMessageBody": "f3c773d134afe22d7f44c315f83340c0",
    "MessageId": "e98e828c-af1b-4065-a56f-d87b149d63bd"
}
```

### Receber mensagem da fila (máximo 10)

`
λ aws sqs receive-message --queue-url "http://127.0.0.1:4566/000000000000/labs-localstack-dynamodb-java-queue" --endpoint-url http://127.0.0.1:4566 --attribute-names All --message-attribute-names All --max-number-of-messages 10
`

Saida:

```json
{
    "Messages": [
        {
            "MessageId": "e98e828c-af1b-4065-a56f-d87b149d63bd",
            "ReceiptHandle": "ZjYzZTM2N2ItY2VhZi00Njc2LWFlZTktOWI2MGUzOTRhNjYxIGFybjphd3M6c3FzOnVzLWVhc3QtMTowMDAwMDAwMDAwMDA6bGFicy1sb2NhbHN0YWNrLWR5bmFtb2RiLWphdmEtcXVldWUgZTk4ZTgyOGMtYWYxYi00MDY1LWE1NmYtZDg3YjE0OWQ2M2JkIDE2NTQwMzIxNTcuNDgzNzk0Mg==",
            "MD5OfBody": "f3c773d134afe22d7f44c315f83340c0",
            "Body": "Hello SQS World",
            "Attributes": {
                "SenderId": "000000000000",
                "SentTimestamp": "1654031646790",
                "ApproximateReceiveCount": "2",
                "ApproximateFirstReceiveTimestamp": "1654032075262"
            }
        }
    ]
}
```

### Obtem todos os atributos da fila

`
λ aws sqs get-queue-attributes --queue-url "http://127.0.0.1:4566/000000000000/labs-localstack-dynamodb-java-queue" --endpoint-url http://127.0.0.1:4566 --attribute-names All
`

Saida:

```json
{
    "Attributes": {
        "ApproximateNumberOfMessages": "1",
        "ApproximateNumberOfMessagesNotVisible": "0",
        "ApproximateNumberOfMessagesDelayed": "0",
        "CreatedTimestamp": "1654028482",
        "DelaySeconds": "0",
        "LastModifiedTimestamp": "1654028482",
        "MaximumMessageSize": "262144",
        "MessageRetentionPeriod": "345600",
        "QueueArn": "arn:aws:sqs:us-east-1:000000000000:labs-localstack-dynamodb-java-queue",
        "ReceiveMessageWaitTimeSeconds": "0",
        "VisibilityTimeout": "30"
    }
}
```

### Obtem um atributo específico da fila | ApproximateNumberOfMessages

`
λ aws sqs get-queue-attributes --queue-url "http://127.0.0.1:4566/000000000000/labs-localstack-dynamodb-java-queue" --endpoint-url http://127.0.0.1:4566 --attribute-names ApproximateNumberOfMessages
`

Saida:

```json
{                                         
    "Attributes": {                       
        "ApproximateNumberOfMessages": "1"
    }                                     
}                                         
```

### Apagar uma mensagem (Deve ser utilizado o ReceiptHandle e não o MessageId)

`
λ aws sqs delete-message --queue-url http://127.0.0.1:4566/000000000000/labs-localstack-dynamodb-java-queue --endpoint-url http://127.0.0.1:4566 --receipt-handle YzAyYTVhZWEtMTRlYi00NjJjLThjNDgtYTc4YWUxNmJlNDBhIGFybjphd3M6c3FzOnVzLWVhc3QtMTowMDAwMDAwMDAwMDA6bGFicy1sb2NhbHN0YWNrLWR5bmFtb2RiLWphdmEtcXVldWUgMjFiNDQ5YmUtMTllMi00NWIwLTkxODYtNDRmOWY2N2YxZDRjIDE2NTQwNTQwODIuNTg5OTY4Mg==
`

## DynamoDB

AWS DynamoDB é um serviço de banco de dados NoSQL gerenciado pelo cloud provider.

### Instalação

Podemos utilizar o DynamoDB como:

- Serviço web (AWS Service)
- Local (download)
- Docker (compose)
- Dependência (Apache Maven)

[AWS DynamoDB Ref](https://docs.aws.amazon.com/dynamodb/index.html)

[Mais informações - Deploying DynamoDB Locally on Your Computer](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DynamoDBLocal.DownloadingAndRunning.html)

[AWS CLI CR - DynamoDB](https://awscli.amazonaws.com/v2/documentation/api/latest/reference/dynamodb/index.html#cli-aws-dynamodb)

### Conceitos básicos

Os componentes principais para utilização do DynamoDB são:

- Tabelas
- Itens
- Atributos
- Chave primária (Partition Key e Sorted Key)
- Indíces secundários

[Mais informações - Core Components of Amazon DynamoDB](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/HowItWorks.CoreComponents.html)


### Listar tabelas utilizando o aws cli

```
λ aws dynamodb list-tables --endpoint-url http://127.0.0.1:4566
```


### Descrever informações da tabela

```
λ aws dynamodb describe-table --table-name "TB_CONTROLE_PROCESSO_PESSOA_JURIDICA"  --endpoint-url http://127.0.0.1:4566
```

### Criar uma tabela utilizando o aws cli

```
λ aws dynamodb create-table \
    --table-name MusicCollection \
    --attribute-definitions AttributeName=Artist,AttributeType=S AttributeName=SongTitle,AttributeType=S \
    --key-schema AttributeName=Artist,KeyType=HASH AttributeName=SongTitle,KeyType=RANGE \
    --provisioned-throughput ReadCapacityUnits=1,WriteCapacityUnits=1 --endpoint-url http://127.0.0.1:4566
```


### Apagar uma tabela utilizando o aws cli

```
λ aws dynamodb delete-table \
    --table-name MusicCollection \
    --endpoint-url http://127.0.0.1:4566
```

### Adicionar novo item com o aws cli

```
λ aws dynamodb put-item \
    --table-name MusicCollection \
    --item '{
        "Artist": {"S": "No One You Know"},
        "SongTitle": {"S": "Call Me Today"} ,
        "AlbumTitle": {"S": "Somewhat Famous"} 
      }' \
    --return-consumed-capacity TOTAL --endpoint-url http://127.0.0.1:4566
```

# 📚 Passos para modelagem DynamoDB

Recomendado em casos de uso onde existem multiplas entidades no modelo

- Identificar as consultas ou acessos que serão realizados
- Modelar o ERD (Entity Relationship Diagram) das entidades do modelo
- Identificar o padrão de acesso aos dados ou entidades
- Criação de tabelas e index
- Prova e validação

# 🏃 Caso de uso

Sistema para controle de processos de pessoas jurídicas

## ❓ Perguntas importantes para modelagem do caso de uso

* Como consultar os processos de uma pessoa jurídica ?
* Como consultar as informações de um processo ?
* Como obter as informações do documento de um processo ?
* Como consultar todos os documentos de uma pessoa jurídica ?
* Como consultar os signatários do documento de um processo?

Estas perguntas permitem identificar os requisitos para acesso e manipulação dos dados no DynamoDB. Uma avaliação pode ser feita com base nos critérios dos filtros e interações dos consumidores.

## Modelagem de relacionamento um-para-muitos

Esse tipo de relacionamento ocorre quando um objeto em particular é dono ou a fonte de um conjunto de 
sub-elementos. Por exemplo:

- Um cliente pode adicionar no carrinho de compras vários produtos
- Uma pessoa (jurídica ou física) pode abrir vários processos num departamento público
- Uma empresa pode ter vários projetos com vários funcionários designados

Para alcançar esse propósito temos o conceito importante de desnormalização dos dados e algumas estratégias, como:

- Desnormalização utilizando atributo complexo
- Duplicação dos dados
- Chave primária (PK) composta + uso da API de consulta do DynamoDB
- Indice secundário + ações da Query API
- Chave secundário (SK) composta + dados com hierárquicos

Vamos usar a abordagem - Chave primária composta + uso da API de consulta do DynamoDB em uma única tabela.

Fonte:

[AWS Developer Guide - Modeling Relational Data in DynamoDB](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/bp-modeling-nosql.html)

[alexdebrie - dynamodb-one-to-many](https://www.alexdebrie.com/posts/dynamodb-one-to-many/)

[Comparing multi and single table approaches](https://serverlessfirst.com/dynamodb-modelling-single-vs-multi-table/)


## Informações na tabela - Nome: TB_CONTROLE_PROCESSO_PESSOA_JURIDICA

### Info. Processo

- PK - Id Pessoa Juridica
- SK - PROCESSO # Id Processo
- Id Pessoa Juridica
- Id Processo
- Tipo Processo [PASSAPORTE, CNH, ALVARÁ]
- Data Inicio
- Data Fim
- Data Expiracao
- Status [PENDENTE, CANCELADO, FINALIZADO, REVISÃO]
- Descricao

### Info. Documento

- PK - Id Pessoa Juridica
- SK - PROCESSO # Id Processo # DOCUMENTO # Id Documento
- Id Processo
- Id Documento
- Nome Documento
- Formato [ PDF, WORD, PPT, TXT, JPG, PNG ]
- Tamanho
- Data entrega

### Info. Assinatura

- PK - Id Pessoa Juridica
- SK - PROCESSO # Id Processo # ASSINATURA # Id Assinatura
- Id Documento
- Id Assinatura
- Data Assinatura

### Info. Signatario

- PK - Id Pessoa Juridica
- SK - PROCESSO # Id Processo # SIGNATARIO # Id Pessoa Fisica
- Id Pessoa Fisica
- Nome Signatario
- Status [ ASSINOU, PENDENTE ]

### Criação da tabela

```
aws dynamodb create-table \
    --table-name tb_controle_processo_pessoa_juridica \
    --attribute-definitions \
		AttributeName=IdPessoaJuridica,AttributeType=S \
		AttributeName=SK,AttributeType=S \
    --key-schema \
		AttributeName=IdPessoaJuridica,KeyType=HASH \
		AttributeName=SK,KeyType=RANGE \
    --provisioned-throughput ReadCapacityUnits=1,WriteCapacityUnits=1 --endpoint-url http://127.0.0.1:4566
```

#### Apagar tabela

```
aws dynamodb delete-table \
    --table-name tb_controle_processo_pessoa_juridica \
    --endpoint-url http://127.0.0.1:4566
```

### Criação de item com as informações do processo

```
aws dynamodb put-item --table-name tb_controle_processo_pessoa_juridica \
    --item '{
        "IdPessoaJuridica": {"S": "e86fcdfb-c200-4737-8b1c-7923e25e0843"},
        "SK": {"S": "PROCESSO#9817be8b-309c-417f-8ff9-fac96655a937"},
		"IdProcesso": {"S": "9817be8b-309c-417f-8ff9-fac96655a937"},  
		"TipoProcesso": {"S": "PASSAPORTE"},   
		"DataInicio": {"S": "2022-06-01"},   
        "DataExpiracao": {"S": "2022-06-01"},   
		"DataFim": {"S": ""},   
		"Status": {"S": "PENDENTE"},   
		"Descricao": {"S": "Processo para obtenção de passaporte"}   
      }'  \
    --return-consumed-capacity TOTAL --endpoint-url http://127.0.0.1:4566
```

### Criação de item com as informações do documento

```
aws dynamodb put-item \
    --table-name tb_controle_processo_pessoa_juridica \
    --item '{
        "IdPessoaJuridica": {"S": "e86fcdfb-c200-4737-8b1c-7923e25e0843"},
        "SK": {"S": "PROCESSO#9817be8b-309c-417f-8ff9-fac96655a937#DOCUMENTO#0b5a2cc2-ede3-466f-8aa1-f866e969bdce"},
		"IdDocumento": {"S": "0b5a2cc2-ede3-466f-8aa1-f866e969bdce"},
		"NomeDocumento": {"S": "9817be8b-309c-417f-8ff9-fac96655a937_PASSAPORTE.pdf"},
		"Formato": {"S": "PDF"},
		"Tamanho": {"S": "2000"},
		"DataHoraEntrega": {"S": ""}
      }' \
    --return-consumed-capacity TOTAL --endpoint-url http://127.0.0.1:4566
```

### Criação de item com as informações do assinatura

```
aws dynamodb put-item \
    --table-name tb_controle_processo_pessoa_juridica \
    --item '{
        "IdPessoaJuridica": {"S": "e86fcdfb-c200-4737-8b1c-7923e25e0843"},
        "SK": {"S": "PROCESSO#9817be8b-309c-417f-8ff9-fac96655a937#ASSINATURA#c68f5bfe-fe7e-4c22-9db4-364eb894d9d0"} ,
		"IdAssinatura": {"S": "c68f5bfe-fe7e-4c22-9db4-364eb894d9d0"},
		"IdDocumento": {"S": "0b5a2cc2-ede3-466f-8aa1-f866e969bdce"},        
		"DataHoraAssinatura": {"S": ""}
      }' \
    --return-consumed-capacity TOTAL --endpoint-url http://127.0.0.1:4566
```    

### Criação de item com as informações do signatário

```
aws dynamodb put-item \
    --table-name tb_controle_processo_pessoa_juridica \
    --item '{
        "IdPessoaJuridica": {"S": "e86fcdfb-c200-4737-8b1c-7923e25e0843"},
        "SK": {"S": "PROCESSO#9817be8b-309c-417f-8ff9-fac96655a937#SIGNATARIO#74a738ef-3d35-4c8e-8b92-74161a0f2c55"} ,
		"IdPessoaFisica": {"S": "74a738ef-3d35-4c8e-8b92-74161a0f2c55"},
		"NomeSignatario": {"S": "Joao Antonio das Palmas"},
		"Status": {"S": "PENDENTE"}
      }' \
    --return-consumed-capacity TOTAL --endpoint-url http://127.0.0.1:4566
```
	
# Geração do projeto 🚀

Utilizado no projeto java 16 e a ferramenta Maven e o Maven Archetype

Para saber mais:

[Maven](https://maven.apache.org/index.html)

[Maven Archetype](https://maven.apache.org/archetype/index.html)

[Git Ignore](https://www.toptal.com/developers/gitignore)

[Markdown - README.md](https://www.markdownguide.org/basic-syntax/)

[Emoji](https://www.markdownguide.org/basic-syntax/)

# Dependências do projeto 📜

## AWS SDK for DynamoDB

No arquivo `pom.xml` adicionamos a tag de gerenciamento de dependência `<dependencyManagement>` com o grupo id `software.amazon.awssdk` na versão 2.17.203 e a dependência `dynamodb`. 

```
 <dependencyManagement>
  <dependencies>
   <dependency>
    <groupId>software.amazon.awssdk</groupId>
    <artifactId>bom</artifactId>
    <version>2.17.203</version>
    <type>pom</type>
    <scope>import</scope>
   </dependency>
  </dependencies>
 </dependencyManagement>
``` 

```
<dependency>
    <groupId>software.amazon.awssdk</groupId>
    <artifactId>dynamodb</artifactId>
</dependency>
```

Para saber mais

- [Get started with the AWS SDK for Java 2.x](https://docs.aws.amazon.com/sdk-for-java/latest/developer-guide/get-started.html)

- [Overview of AWS SDK Support for DynamoDB](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Programming.SDKOverview.html)

# Model View no Workbench

![Model view](images/table.png)

![Facets](images/facets.png)

Viewing data access patterns - Permite representar os padroes de acesso da tabela, 
facilita na visulização de subconjunto de dados. APENAS VISUALIZAÇÃO - NÃO EXISTE NA TABELA

- Para saber mais [Viewing data access patterns](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/workbench.Visualizer.Facets.html)

# ERD (Entity Relationship Diagram / Diagrama de relacionamento das entidades)

![ERD](images/erd.jpg)