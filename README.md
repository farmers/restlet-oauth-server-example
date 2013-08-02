# External Service Authentication using Restlet OAuth
An example of OAuth external service that uses the Restlet OAuth example server.

### Restlet Example OAuth Provider Security Flaw
Please note that the example server is flawed which I have detailed [here](http://bretkikehara.wordpress.com/2013/08/01/restlet-2-2-oauth/).

Although the implementation is not fully secure in many ways, it is sufficient enough to provide an implementation an OAuth sevice and external access using the Restlet framework.

### Notice
Code has been slightly modified from the original project located [here](https://github.com/restlet/restlet-framework-java).

### How to Run
1. Compile a JAR of the latest version of the OAuth extentsion, since some classes are missing in the `2.2-M3` release. Update the Maven dependency based the compiled JAR's location. (The lib folder has the JAR file I compiled.)
2. Run the project using Maven, or run the OAuth2Sample class.
  >
  > mvn exec:java
  >
3. Open your web browser to [http://localhost:8080/sample/](http://localhost:8080/sample/)
4. Click on the login button.
5. Login with the example user `bob` and password `123456`.
6. Accept or deny the request for default scope.

### License
All source code from the Restlet project is license under the Apache 2.0 license with copyright as its respective owners.

Code that I have written is also license under the Apache 2.0 license for simplicity sake.
