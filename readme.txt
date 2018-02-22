* This is a Spring boot project.

* Software requirement  : 
		IDE - IntelliJ
		DB - MySql
		JMeter

* Deployment Steps: 
	1.	Setup database 
			Create a schema name : test_db 
			user - root
			password - root

	2.	Import project in IntelliJ IDE.
	3.	Wait for Maven dependencies to resolve.
	4.	Run DemoApplication.Java
	-> Server will start on 8080 port 

* Testing :
	1. Hit GET http://localhost:8080/increment from browser to check application is up and running - It should initial integer value (1)
	2. Once application is up and running Import TestIncrement.jmx (inside jmx folder) in JMeter and run it. Validate the output 