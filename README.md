# ATMBackEndService

Code deployment is done on heroeku. This can be accessed through
https://atm-service.herokuapp.com

**Swagger Link**



**Assumptions**

1. For simplicity all the Account information is stored in HashTable.
2. accountInfo API can be used to details of each account.
3. Logging is skipped for now. In production cluster, will be putting a lot of logging.
4. Get balance API can be cached and be invalidated after each balance update. Will be adding through @Cacheable annotation it if time permits.
5. Unit test and integration test for all the possible scenario is skipped in interest of time.
6. Ideally, response should be sent from server as ResponseEntity having response code, success/failure message(including exception). For MVP, this has been skipped.
7. Using AOP, every request can be authorized to pass or not. Skipping this in interest of time.



