#!/bin/sh

### Criação da tabela

aws dynamodb create-table \
    --table-name tb_controle_processo_pessoa_juridica \
    --attribute-definitions \
		AttributeName=IdPessoaJuridica,AttributeType=S \
		AttributeName=SK,AttributeType=S \
    --key-schema \
		AttributeName=IdPessoaJuridica,KeyType=HASH \
		AttributeName=SK,KeyType=RANGE \
    --provisioned-throughput ReadCapacityUnits=1,WriteCapacityUnits=1 --endpoint-url http://127.0.0.1:4566

#### Apagar tabela

#aws dynamodb delete-table \
#    --table-name tb_controle_processo_pessoa_juridica \
#    --endpoint-url http://127.0.0.1:4566

## REGISTRO 1

### Criação de item com as informações do processo

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

### Criação de item com as informações do documento

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

### Criação de item com as informações do assinatura

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

### Criação de item com as informações do signatário

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
    
 
## REGISTRO 2

### Criação de item com as informações do processo

aws dynamodb put-item --table-name tb_controle_processo_pessoa_juridica \
    --item '{
        "IdPessoaJuridica": {"S": "7747a1ac-ac7e-4bed-ac85-cdef4c7fa06c"},
        "SK": {"S": "PROCESSO#89e27526-3de1-4dd1-bbc4-50f0eb6604b8"},
		"IdProcesso": {"S": "89e27526-3de1-4dd1-bbc4-50f0eb6604b8"},  
		"TipoProcesso": {"S": "PASSAPORTE"},   
		"DataInicio": {"S": "2022-06-01"},   
        "DataExpiracao": {"S": "2022-06-01"},   
		"DataFim": {"S": ""},   
		"Status": {"S": "PENDENTE"},   
		"Descricao": {"S": "Processo para obtenção de passaporte"}   
      }'  \
    --return-consumed-capacity TOTAL --endpoint-url http://127.0.0.1:4566

### Criação de item com as informações do documento

aws dynamodb put-item \
    --table-name tb_controle_processo_pessoa_juridica \
    --item '{
        "IdPessoaJuridica": {"S": "7747a1ac-ac7e-4bed-ac85-cdef4c7fa06c"},
        "SK": {"S": "PROCESSO#89e27526-3de1-4dd1-bbc4-50f0eb6604b8#DOCUMENTO#585f658a-5609-4608-8d14-66c0172d0bec"},
		"IdDocumento": {"S": "585f658a-5609-4608-8d14-66c0172d0bec"},
		"NomeDocumento": {"S": "89e27526-3de1-4dd1-bbc4-50f0eb6604b8_PASSAPORTE.pdf"},
		"Formato": {"S": "PDF"},
		"Tamanho": {"S": "2000"},
		"DataHoraEntrega": {"S": ""}
      }' \
    --return-consumed-capacity TOTAL --endpoint-url http://127.0.0.1:4566

### Criação de item com as informações do assinatura

aws dynamodb put-item \
    --table-name tb_controle_processo_pessoa_juridica \
    --item '{
        "IdPessoaJuridica": {"S": "7747a1ac-ac7e-4bed-ac85-cdef4c7fa06c"},
        "SK": {"S": "PROCESSO#89e27526-3de1-4dd1-bbc4-50f0eb6604b8#ASSINATURA#c68f5bfe-fe7e-4c22-9db4-364eb894d9d0"} ,
		"IdAssinatura": {"S": "c68f5bfe-fe7e-4c22-9db4-364eb894d9d0"},
		"IdDocumento": {"S": "585f658a-5609-4608-8d14-66c0172d0bec"},        
		"DataHoraAssinatura": {"S": ""}
      }' \
    --return-consumed-capacity TOTAL --endpoint-url http://127.0.0.1:4566

### Criação de item com as informações do signatário

aws dynamodb put-item \
    --table-name tb_controle_processo_pessoa_juridica \
    --item '{
        "IdPessoaJuridica": {"S": "7747a1ac-ac7e-4bed-ac85-cdef4c7fa06c"},
        "SK": {"S": "PROCESSO#89e27526-3de1-4dd1-bbc4-50f0eb6604b8#SIGNATARIO#2a82d829-63a9-49bb-8ff5-4e7db7ef4987"} ,
		"IdPessoaFisica": {"S": "2a82d829-63a9-49bb-8ff5-4e7db7ef4987"},
		"NomeSignatario": {"S": "Joao Antonio das Palmas"},
		"Status": {"S": "PENDENTE"}
      }' \
    --return-consumed-capacity TOTAL --endpoint-url http://127.0.0.1:4566

