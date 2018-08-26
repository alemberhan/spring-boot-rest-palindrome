# Spring Boot "Palindrome" Project

The program check if the English text You entered is a palindrome or not. It also check if the English word entered is a valid English word in the dictionary. It display all the relevant messages on the screen including the text that you entered and the palindrome string.
  
It also display all of the string that has ever been entered in and the relevant reversed (/palindrome) string.

## Dependencis

For dictionary I use Extended Java WordNet Library
```
<dependency>
			<groupId>net.sf.extjwnl</groupId>
			<artifactId>extjwnl</artifactId>
			<version>1.9.4</version>
		</dependency>
		<!-- Princeton WordNet 3.1 data dependency -->
		<dependency>
			<groupId>net.sf.extjwnl</groupId>
			<artifactId>extjwnl-data-wn31</artifactId>
			<version>1.2</version>
		</dependency>
```
## HOW TO RUN

This application is packaged as a war which has Tomcat 8 embedded. No Tomcat installation is necessary. You run it using the java -jar command.

* Clone this repository
* Make sure you are using JDK 1.8 and Maven 3.x
* You can build the project and run the tests by running ```mvn clean package```
* Once successfully built, you can run the service by one of these two methods:

```
 mvn spring-boot:run
 or
 java -jar -Dspring.profiles.active=test target/spring-boot-rest-palindrome-0.0.1-SNAPSHOT.war
```
* Visit http://localhost:8080

## Developer
* **Alemberhan Getahun**