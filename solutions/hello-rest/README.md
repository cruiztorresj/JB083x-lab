# hello-rest

## Composed of the following architecture:

* Maven Project - builds a WAR
* Using CDI scopes on beans, @Named
* Stateless EJB for services - uses JPA entity beans - exposes appropriate method as REST API using JAX-RS annotations
* JAX-RS Application class
* JPA entity bean to store names - uses H2 in-memory database
* Use EJB Singleton to lookup messaging connection and queue destination and inject into stateless EJB - lookup should only occur once on startup
* Servlet that returns "OK" - this is a health check - path should be [context]/health
* H2 (embedded in-memory DB) backend
