Simple USSD Rest Example
Assumptions

    Users are already registered.
    Users cannot cancel the transfer/flow once started (One directional flow)

How to start

$ git clone https://github.com/breyden/spring-rest-simple-ussd.git
$ cd spring-rest-simple-ussd
$ mvn spring-boot:run -X

## Example of subsequent calls (Tranfer of R20 to Kenya)
$  curl -H "Content-Type:application/json" -X POST --data '{"msisdn":"27658378793","sessionId":"1234"}' http://localhost:8080/ussd
$  curl -H "Content-Type:application/json" -X POST --data '{"msisdn":"27658378793","userEntry":"1","sessionId":"1234"}' http://localhost:8080/ussd
$  curl -H "Content-Type:application/json" -X POST --data '{"msisdn":"27658378793","userEntry":"20","sessionId":"1234"}' http://localhost:8080/ussd
$  curl -H "Content-Type:application/json" -X POST --data '{"msisdn":"27658378793","userEntry":"1","sessionId":"1234"}' http://localhost:8080/ussd

## Example of subsequent calls (Tranfer of R20 to Malawi)
$  curl -H "Content-Type:application/json" -X POST --data '{"msisdn":"27658378793","sessionId":"1234"}' http://localhost:8080/ussd
$  curl -H "Content-Type:application/json" -X POST --data '{"msisdn":"27658378793","userEntry":"2","sessionId":"1234"}' http://localhost:8080/ussd
$  curl -H "Content-Type:application/json" -X POST --data '{"msisdn":"27658378793","userEntry":"20","sessionId":"1234"}' http://localhost:8080/ussd
$  curl -H "Content-Type:application/json" -X POST --data '{"msisdn":"27658378793","userEntry":"1","sessionId":"1234"}' http://localhost:8080/ussd
