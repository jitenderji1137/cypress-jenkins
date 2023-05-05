Feature:  Api Testing for GitHub As a Project

    Scenario: Create a repository for the authenticated user
        Given Make a post request with the resource1 '/user/repos'
        Then Print the response in console2
        Then Store Necessary data in the variable3
        Then The response status code should be4 201
        And Check Wether the RepoName is stored in variable5 'Hello-World-by'


    Scenario: Update a repository
        Given Make a PATCH request with the resource6 '/repos/jitenderji1137/Hello-World-by'
        Then Print the response in console7
        Then Store Necessary data in the variable8
        Then The response status code should be9 200
        And Check Wether the updated RepoName is stored in variable10 'Updated-Hello-World-by'

    
    Scenario: Get a repository
        Given Make a GET request with the resource11 '/repos/jitenderji1137/'
        Then Print the response in console12
        And The response status code should be13 200

    
    Scenario: Create file contents
        Given Make a PUT request with the resource14 '/repos/jitenderji1137/Updated-Hello-World-by/contents/README.md'
        Then Print the response in console15
        Then Store Necessary data in the variable16
        Then The response status code should be17 201
        And Check Wether the sha value is stored in variable18

    Scenario: CREATE A FORK
        Given Make a POST request with the resource19 '/repos/jitenderji1137/Updated-Hello-World-by/forks'
        Then Print the response in console20
        And The response status code should be21 202

    Scenario: LIST FORKS
        Given Make a GET request For FORKS with the resource22 '/repos/jitenderji1137/Updated-Hello-World-by/forks'
        Then Print the response in console23
        And The response status code should be24 200
    

    Scenario: List repositories for a user
        Given Make a GET request for user repositories with the resource25 '/users/jitenderji1137/repos'
        Then Print the response in console26
        And The response status code should be27 200

    Scenario: List repository languages
        Given Make a GET request for repositories languages with the resource28 '/repos/jitenderji1137/Free-Netflix/languages'
        Then Print the response in console29
        And The response status code should be30 200

    Scenario: List public repositories
        Given Make a GET request for public repositories with the resource31 '/repositories'
        Then Print the response in console32
        And The response status code should be33 200



    Scenario: Delete a FORK
        Given Make a Delete request with the resource34 '/repos/jitenderji1137-org-For-API-Testing/New-Fork'
        And The response status code should be35 204
    
    Scenario: Delete a file
        Given Make a Delete file request with the resource36 '/repos/jitenderji1137/Updated-Hello-World-by/contents/README.md'
        And The response status code should be37 200
    
    Scenario: Create a release
        Given Make a POST request to create a release with the resource38 '/repos/jitenderji1137/Updated-Hello-World-by/releases'
        Then Print the response in console39
        And The response status code should be40 201
    
    Scenario: List repository tags
        Given Make a GET request for repositories tags with the resource41 '/repos/jitenderji1137/Updated-Hello-World-by/tags'
        Then Print the response in console42
        And The response status code should be43 200

    Scenario: Create an autolink reference for a repository
        Given Make a POST request For autolink with the resource44 '/repos/jitenderji1137/Updated-Hello-World-by/autolinks'
        Then Print the response in console45
        Then Store Necessary data in the variable46
        Then The response status code should be47 201


    Scenario: Replace all repository topics
        Given Make a PUT request for repositories topics with the resource48 '/repos/jitenderji1137/Updated-Hello-World-by/topics'
        Then Print the response in console49
        And The response status code should be50 200

    Scenario: Get all repository topics
        Given Make a GET request for repositories topics with the resource51 '/repos/jitenderji1137/Updated-Hello-World-by/topics'
        Then Print the response in console52
        And The response status code should be53 200


    Scenario: Get an autolink reference of a repository
        Given Make a GET request for repositories autolink with the resource54 '/repos/jitenderji1137/Updated-Hello-World-by/autolinks/'
        Then Print the response in console55
        And The response status code should be56 200


    Scenario: Delete an autolink reference from a repository
        Given Make a Delete request to delete autolink with the resource57 '/repos/jitenderji1137/Updated-Hello-World-by/autolinks/'
        Then The Delete response status code should be58 204


    Scenario: Get a repository
        Given Make a GET request  with the resource59 '/repos/jitenderji1137/Updated-Hello-World-by'
        Then Print the response in console60
        And The response status code should be61 200

    Scenario: Delete a repository
        Given Make a Delete request to delete repo with the resource62 '/repos/jitenderji1137/Updated-Hello-World-by'
        Then The Delete response status code should be63 204