export TOKEN=`curl -s -X POST http://localhost:8080/oauth/token \
  -H 'authorization: Basic Y2xpZW50OnNlY3JldA==' \
  -d 'grant_type=password&username=james&password=james' | jq -r .access_token`


echo Access admin resources - 
curl -H "authorization: Bearer $TOKEN" http://localhost:8080/app/hello/admin

echo
echo Access user resources - 
curl -H "authorization: Bearer $TOKEN" http://localhost:8080/app/hello/user 

echo

