To reproduce:
1. run r2dbc-pool-problem app in IDE or via "mvn spring-boot:run"
2. run "ab -n 10 -c 10 -s 10 127.0.0.1:8080/ && sleep 100s && ab -n 10 -c 10 -s 10 127.0.0.1:8080/"
   this executes 10 requests concurrently, waits 100s (mysql server has 90s max lifetime), executes 10 requests again.
3. observe "connection closed by peer" log in spring boot application logs - connections are not closed by pool, but by mysql
4. you can also check active connections lifetime in mysql server via: "show processlist;" 
    - there will be connections that live longer than 60s defined as max lifetime in r2dbc-pool.