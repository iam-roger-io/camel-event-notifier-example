
The purpose of this project is to demonstrate the events of Apache Camel 

This applications was developed and tested with:
 - JBoss fuse Version 7.8.0.fuse-sb2-780038-redhat-00001
 - Apache Camel 2.23
 - Spring Boot: 2.3.4
 - Open JDK 1.8.0.275

## Running the application

	mvc clean spring-boot:run

## Testing Routes

There are 3 Routes:

 - route-a
 
	 - To test this route create a file called test-a.txt with some content in folder trigger in this project.
	 - The purpose of this route is to demonstrate the basic events between a method ***from()*** and ***to()***
	 
 - route-non-handled-exception
 
	 - To test this route create a file called test-b.txt with some content in folder trigger in this project.
	 - The purpose of this route is to demonstrate an error event  between a method ***from()*** and ***to()*** in a non-handled exception.
 
 - route-handled-exception
  
	 - To test this route create a file called test-c.txt with some content in folder trigger in this project.
	 - The purpose of this route is to demonstrate an error event  between a method ***from()*** and ***to()*** in a handled exception.