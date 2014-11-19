springboot-restful-mongodb
==========================

Sample application to create a rest service to create a person entity with its companies and persist it to a mongo database.


# Run Rest service
under the root dir execute: 
`gradlew bootRun`
this will run the server under the 8080 port

## list persons
to list all the persons the route is "/persons"

## save persons
to save a new person the route is "/saveperson" and the parameters are:
* firstname
* lastname 
* profession 
* latitude
* longitude
* orgname - repeated for multiple
* headquarter - repeated for multiple

example:
/saveperson?firstname=dave&lastname=mustain&profession=musician&latitude=125&longitude=-85&orgname=megadeth&headquarter=la&orgname=metallica&headquarter=ny

# Run web app
under the webapp dir execute
`grunt serve`
this will run the webapp under the 9000 port

