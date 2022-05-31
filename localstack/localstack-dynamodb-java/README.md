# Instalar o Python

Linguagem de programação de propósito geral :)

## Instalação

https://www.python.org/downloads/windows/

## Para confirmar a instalação execute 

λ py --version ou python --version

# Instalar a ferramenta AWS CLI

Ferramenta que permite interagir via linha de comandos com os serviços AWS. 

## Instalação

https://docs.aws.amazon.com/cli/latest/userguide/getting-started-install.html

## Para confirmar a instalação execute 

λ aws --version

## Configuração de profile para acesso aos serviços de uma conta AWS (real ou localstack)

https://awscli.amazonaws.com/v2/documentation/api/latest/reference/configure/index.html?highlight=configure

Para configurar um novo profile (para uso do localstack), execute:

λ aws configure --profile localstack

### Informe valores aleatórios para o KEY ID e Access Key. Para o region informe (sa-east-1). O output default é o formato json

Exemplo:

λ aws configure --profile localstack

Saída:

AWS Access Key ID [None]: 6f56076c-6aa2-4265-9323-477da8d2ccc1
AWS Secret Access Key [None]: 9102535d-8ba5-4d6e-bc67-c0c61ea6b346
Default region name [None]: sa-east-1
Default output format [None]: json

### Para listar os profiles configurados, execute

λ aws configure list-profiles

Exemplo:

λ aws configure list-profiles

Saída:

default
localstack

# Instalar o Docker

Docker é uma plataforma para desenvolver, entregar e executar aplicações com todas as dependências empacotadas num único artefato.

https://docs.docker.com/get-started/overview/

https://docs.docker.com/desktop/windows/install/

## Para confirmar a instalação execute 

λ docker info

## Docker compose

Ferramenta para definir e executar multiplos containers no Docker. Com o Docker-compose podemos definir varios serviços

https://docs.docker.com/compose/

https://docs.docker.com/compose/compose-file/

A ferramenta docker compose é fornecida com a instalação padrão do docker desktop para windows. Mais detalhes:

https://docs.docker.com/compose/install/

# Instalação do LocalStack

LocalStack é um emulador de serviços cloud executados num container em ambiente local ou de Continuous Integration - CI (test, stage, etc)

https://localstack.cloud/

https://docs.localstack.cloud/get-started/

## Serviços fornecidos

O localstack permite utilizar no ambiente local serviços da aws como s3, dynamodb, lambda, etc

### Vamos utilizar o localstack com o docker compose para simplificar a configuração e inicialização dos containers

