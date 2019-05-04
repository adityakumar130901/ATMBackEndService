# ATMBackEndService

Code deployment is done on heroeku. This can be accessed through
https://atm-service.herokuapp.com

**Swagger Link**



**Assumptions**

1. For simplicity all the Account information is stored in HashTable.
2. accountInfo API can be used to details of each account.
3. Logging is skipped for now. In production cluster, will be putting a lot of logging.
4. Get balance API can be cached and be invalidated after each balance update. Will be adding through @Cacheable annotation it if time permits.



