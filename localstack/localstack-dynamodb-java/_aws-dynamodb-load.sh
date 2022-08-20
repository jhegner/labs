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
    }' \
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
    "SK": {"S": "PROCESSO#9817be8b-309c-417f-8ff9-fac96655a937#ORDEMASSINATURA#c68f5bfe-fe7e-4c22-9db4-364eb894d9d0"},
		"IdOrdemAssinatura": {"S": "c68f5bfe-fe7e-4c22-9db4-364eb894d9d0"},
		"IdDocumento": {"S": "0b5a2cc2-ede3-466f-8aa1-f866e969bdce"},        
		"DataHoraAssinatura": {"S": ""}
      }' \
  --return-consumed-capacity TOTAL --endpoint-url http://127.0.0.1:4566

### Criação de item com as informações do signatário

aws dynamodb put-item \
  --table-name tb_controle_processo_pessoa_juridica \
  --item '{
    "IdPessoaJuridica": {"S": "e86fcdfb-c200-4737-8b1c-7923e25e0843"},
    "SK": {"S": "PROCESSO#9817be8b-309c-417f-8ff9-fac96655a937#SIGNATARIO#c29207a8-9bd9-4903-8906-cfb28fcc4f9f"},
		"IdPessoaFisica": {"S": "c29207a8-9bd9-4903-8906-cfb28fcc4f9f"},
		"NomeSignatario": {"S": "Simone Luciana Luiza Assunção"},
		"Status": {"S": "PENDENTE"}
      }' \
  --return-consumed-capacity TOTAL --endpoint-url http://127.0.0.1:4566

aws dynamodb put-item \
  --table-name tb_controle_processo_pessoa_juridica \
  --item '{
    "IdPessoaJuridica": {"S": "e86fcdfb-c200-4737-8b1c-7923e25e0843"},
    "SK": {"S": "PROCESSO#9817be8b-309c-417f-8ff9-fac96655a937#SIGNATARIO#05a4876e-5158-41da-ab1f-51c6bc0d5257"},
		"IdPessoaFisica": {"S": "05a4876e-5158-41da-ab1f-51c6bc0d5257"},
		"NomeSignatario": {"S": "Sara Luana Costa"},
		"Status": {"S": "PENDENTE"}
      }' \
  --return-consumed-capacity TOTAL --endpoint-url http://127.0.0.1:4566

aws dynamodb put-item \
  --table-name tb_controle_processo_pessoa_juridica \
  --item '{
    "IdPessoaJuridica": {"S": "e86fcdfb-c200-4737-8b1c-7923e25e0843"},
    "SK": {"S": "PROCESSO#9817be8b-309c-417f-8ff9-fac96655a937#SIGNATARIO#5e631725-c993-4647-aba5-55d452565753"},
		"IdPessoaFisica": {"S": "5e631725-c993-4647-aba5-55d452565753"},
		"NomeSignatario": {"S": "Antônia Melissa Olivia da Luz"},
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
     }' \
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
        "SK": {"S": "PROCESSO#89e27526-3de1-4dd1-bbc4-50f0eb6604b8#ORDEMASSINATURA#c68f5bfe-fe7e-4c22-9db4-364eb894d9d0"} ,
		"IdOrdemAssinatura": {"S": "c68f5bfe-fe7e-4c22-9db4-364eb894d9d0"},
		"IdDocumento": {"S": "585f658a-5609-4608-8d14-66c0172d0bec"},        
		"DataHoraAssinatura": {"S": ""}
      }' \
  --return-consumed-capacity TOTAL --endpoint-url http://127.0.0.1:4566

### Criação de item com as informações do signatário

aws dynamodb put-item \
  --table-name tb_controle_processo_pessoa_juridica \
  --item '{
        "IdPessoaJuridica": {"S": "7747a1ac-ac7e-4bed-ac85-cdef4c7fa06c"},
        "SK": {"S": "PROCESSO#89e27526-3de1-4dd1-bbc4-50f0eb6604b8#SIGNATARIO#7ab6af7c-d6e2-40ec-ba02-51c062122a2b"} ,
		"IdPessoaFisica": {"S": "7ab6af7c-d6e2-40ec-ba02-51c062122a2b"},
		"NomeSignatario": {"S": "Silvana Eloá da Cunha"},
		"Status": {"S": "PENDENTE"}
      }' \
  --return-consumed-capacity TOTAL --endpoint-url http://127.0.0.1:4566

aws dynamodb put-item \
  --table-name tb_controle_processo_pessoa_juridica \
  --item '{
        "IdPessoaJuridica": {"S": "7747a1ac-ac7e-4bed-ac85-cdef4c7fa06c"},
        "SK": {"S": "PROCESSO#89e27526-3de1-4dd1-bbc4-50f0eb6604b8#SIGNATARIO#4dcfec26-5c37-4276-a199-d73b8b640e3f"} ,
		"IdPessoaFisica": {"S": "4dcfec26-5c37-4276-a199-d73b8b640e3f"},
		"NomeSignatario": {"S": "Silvana Eloá da Cunha"},
		"Status": {"S": "PENDENTE"}
      }' \
  --return-consumed-capacity TOTAL --endpoint-url http://127.0.0.1:4566
