#!/bin/sh

docker-compose up

aws dynamodb create-table \
    --table-name TB_CONTROLE_PROCESSO_PESSOA_JURIDICA \
    --attribute-definitions \
		AttributeName=PK,AttributeType=S \
		AttributeName=SK,AttributeType=S \
    --key-schema \
		AttributeName=PK,KeyType=HASH \
		AttributeName=SK,KeyType=RANGE \
    --provisioned-throughput ReadCapacityUnits=1,WriteCapacityUnits=1 --endpoint-url http://127.0.0.1:4566

