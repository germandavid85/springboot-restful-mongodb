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

example: use curl o postman (chrome extension) to test the rest service with a json document like this:

```json
{
    "firstName": "dave",
    "lastName": "mustain",
    "profession": "musician",
    "location": [
        125,
        -85
    ],
    "companies": [
        {
            "orgName": "megadeth",
            "headquarter": "la"
        },
        {
            "orgName": "metallica",
            "headquarter": "la"
        }
    ]
}
```

# Run web app
under the webapp dir execute
`grunt serve`
this will run the webapp under the 9000 port

