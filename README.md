SOAProject
==========

Sample SOA project client with SOAP, Rest and CXF.

URL
http://localhost:8081/SOAProjectClient/static/index.html

In SOAProjectClient/src
wsdl2java -d ./ http://localhost:8080/SOAProject/CarService?wsdl

URLs to use:

Save a Car
http://localhost:8081/SOAProjectClient/carRest/save?plateNumber=plateNumber-here
List all Cars:
http://localhost:8081/SOAProjectClient/carRest/cars
