export TOKEN=`curl -s -X POST http://localhost:8080/oauth/token \
  -H 'authorization: Basic Y2xpZW50OnNlY3JldA==' \
  -d 'grant_type=password&username=vikas&password=vikas' | jq -r .access_token`

curl -H "authorization: Bearer $TOKEN" http://localhost:8080/app/hello/user

echo

