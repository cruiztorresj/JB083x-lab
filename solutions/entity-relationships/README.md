# entity-relationships

### This app is composed of the following architecture:

- Maven Project - builds a WAR
- Using JSF 4.1 for web interface, HTML5 facelets page, JSF backing beans, CDI scopes on beans, @Named
- Stateless EJB for services - uses JPA entity beans
- JPA entity bean to store names - uses H2 in-memory database

### Notes on refactoring this solution.
By taking a look at the original code for `entity-relationships` you will notice some drastic changes took place, e.g. Renaming some classes.

The class `Persona` was initially `User`, the reason for the change is that the in-memory database, H2, now enforces some reserved keywords. `User` being one of those reserved keywords. This resulted in a lot of refactoring of the existing code, the design remains the same but with a different name for some files in order to avoid the database errors already commented.
