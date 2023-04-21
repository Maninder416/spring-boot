### Spring boot app with client credentials flow

**Steps to do**

```shell
1. We have created 2 modules one is server and other is client.
2. In server, we have written the endpoints which we are calling from
client side using rest template.
3. Server side, we have enabled the security so we cannot hit endpoints
directly from client side. We need to send the token along with rest template.
4. Basic configuration is generating token is same that we did in client side.
5. Make sure use the same maven dependencies as there are some version specific
issues I faced.
6. Attaching the document and postman collection.

```