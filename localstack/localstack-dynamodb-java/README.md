# Instalar o Python

Linguagem de programação de propósito geral :)

## Instalação
https://www.python.org/downloads/windows/

## Para confirmar a instalação execute 

`λ py --version ou python --version`

# Instalar a ferramenta AWS CLI

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

# Instalar o Docker

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

# Instalação do LocalStack

LocalStack é um emulador de serviços cloud (aws, azure) executados num container em ambiente local ou de Continuous Integration - CI (test, stage, etc)

https://localstack.cloud/

https://docs.localstack.cloud/get-started/

## Serviços fornecidos

O localstack permite utilizar no ambiente local serviços da aws como s3, dynamodb, lambda, etc

Vamos utilizar o localstack com o docker-compose para simplificar a configuração e inicialização dos containers, habilitando os serviços s3 e dynamodb.

Utilize o arquivo `compose.yaml` na raiz do projeto e execute o comando `docker-compose up` para inicializacao dos servicos.

# Utilização do LocalStack

Podemos executar alguns comandos para testar os serviços que acabaram de inicializar.
Observe que para execução dos comandos no aws cli deve-se informar o atributo de URL com seu respectivo valor `--endpoint-url=http://127.0.0.1:4566`.
Este endpoint foi definido no arquivo `compose.yaml` como argumento do atributo ports da imagem docker `localstack/localstack`

## SQS

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