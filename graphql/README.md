# Links de ref.

https://graphql.org/


https://www.apollographql.com/docs/apollo-server/getting-started


https://www.graphql-java.com/


# Consulta básica

curl --request POST \
  --header 'content-type: application/json' \
  --url http://localhost:9000/ \
  --data '{"query":"query { __typename }"}'