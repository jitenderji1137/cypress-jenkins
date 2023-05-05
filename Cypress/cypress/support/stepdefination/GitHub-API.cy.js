import {before,Given,When,And,Then} from "cypress-cucumber-preprocessor/steps";
var token = "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";
var baseUrl = "https://api.github.com";
Given("Make a post request with the resource '{word}'",(Resource)=>{
    cy.request({
        method:"POST",
        url: baseUrl+Resource,
        headers: {
            Authorization: `Bearer ${token}`,
        },
        header:"application/json",
        body:{
            name: 'Hello-World-by',
            description: 'This is your first repo!',
        }
    }).then((response) => {
        Cypress.env("StatusCode", response.status);
        let body = JSON.parse(JSON.stringify(response.body))
        Cypress.env('MyResponse',JSON.stringify(body));
    });
})
Then("Print the response in console",()=>{
    cy.log(Cypress.env("MyResponse"));
})
Then("Store Necessary data in the variable",()=>{
    Cypress.env("RepoName",(JSON.parse(Cypress.env("MyResponse")).name));  
})
Then("The response status code should be '{word}'",(StatusCode)=>{
    const sta = +(Cypress.env("StatusCode"));
    expect(sta).to.eql(+StatusCode)
})
Then("Check Wether the RepoName is stored in variable '{word}'",(Repo)=>{
    expect(Cypress.env("RepoName")).to.eql(Repo)
})


// Update a repository
Given("Make a PATCH request with the resource '{word}'",(Resource)=>{
    cy.request({
        method:"PATCH",
        url:baseUrl+Resource,
        headers: {
            Authorization: `Bearer ${token}`,
        },
        header:"application/json",
        body:{
            name: 'Updated-Hello-World-by',
            description: 'This is your updated repo!',
        }
    }).then((response) => {
        Cypress.env("StatusCode", response.status);
        let body = JSON.parse(JSON.stringify(response.body))
        Cypress.env('MyResponse',JSON.stringify(body));
    });
})
Then("Print the response in console",()=>{
    cy.log(Cypress.env("MyResponse"));
})
Then("Store Necessary data in the variable",()=>{
    Cypress.env("RepoName",(JSON.parse(Cypress.env("MyResponse")).name));  
})
Then("The response status code should be '{word}'",(StatusCode)=>{
    const sta = +(Cypress.env("StatusCode"));
    expect(sta).to.eql(+StatusCode)
})
Then("Check Wether the updated RepoName is stored in variable '{word}'",(Repo)=>{
    expect(Cypress.env("RepoName")).to.eql(Repo)
})





// 4. Get a repository
Given("Make a GET request with the resource '{word}'",(Resource)=>{
    cy.request({
        method:"GET",
        url:baseUrl+Resource+(Cypress.env("RepoName")),
        headers: {
            Authorization: `Bearer ${token}`,
        },
        header:"application/json",
    }).then((response) => {
        Cypress.env("StatusCode", response.status);
        let body = JSON.parse(JSON.stringify(response.body))
        Cypress.env('MyResponse',JSON.stringify(body));
    });
})
Then("Print the response in console",()=>{
    cy.log(Cypress.env("MyResponse"));
})
Then("The response status code should be '{word}'",(StatusCode)=>{
    const sta = +(Cypress.env("StatusCode"));
    expect(sta).to.eql(+StatusCode)
})



// Create file contents
Given("Make a PUT request with the resource '{word}'",(Resource)=>{
    cy.request({
        method:"PUT",
        url:baseUrl+Resource,
        headers: {
            Authorization: `Bearer ${token}`,
        },
        header:"application/json",
        body:{
            message:"File Successfully Created",
            content:"SGVsbG8gV29ybGQ="
        }
    }).then((response) => {
        Cypress.env("StatusCode", response.status);
        let body = response.body;
        Cypress.env('MyResponse',JSON.stringify(body));
        Cypress.env("ShaValue",JSON.parse(JSON.stringify(body)).content.sha);  
    });
})
Then("Print the response in console",()=>{
    cy.log(Cypress.env("MyResponse"));
})
Then("Store Necessary data in the variable",()=>{
    cy.log(Cypress.env("ShaValue"));
})
Then("The response status code should be '{word}'",(StatusCode)=>{
    const sta = +(Cypress.env("StatusCode"));
    expect(sta).to.eql(+StatusCode)
})
Then("Check Wether the sha value is stored in variable",()=>{
    cy.log(Cypress.env("ShaValue"))
})




// 5. CREATE A FORK
Given("Make a POST request with the resource '{word}'",(Resource)=>{
    cy.request({
        method:"POST",
        url:baseUrl+Resource,
        headers: {
            Authorization: `Bearer ${token}`,
        },
        header:"application/json",
        body:{
            organization:"jitenderji1137-org-For-API-Testing",
            name:"New-Fork"
        }
    }).then((response) => {
        Cypress.env("StatusCode", response.status);
        let body = JSON.parse(JSON.stringify(response.body))
        Cypress.env('MyResponse',JSON.stringify(body));
    });
})
Then("Print the response in console",()=>{
    cy.log(Cypress.env("MyResponse"));
})
Then("The response status code should be '{word}'",(StatusCode)=>{
    const sta = +(Cypress.env("StatusCode"));
    expect(sta).to.eql(+StatusCode)
})



//  6. LIST FORKS
Given("Make a GET request For FORKS with the resource '{word}'",(Resource)=>{
    cy.request({
        method:"GET",
        url:baseUrl+Resource,
        headers: {
            Authorization: `Bearer ${token}`,
        },
        header:"application/json",
    }).then((response) => {
        Cypress.env("StatusCode", response.status);
        let body = JSON.parse(JSON.stringify(response.body))
        Cypress.env('MyResponse',JSON.stringify(body));
    });
})
Then("Print the response in console",()=>{
    cy.log(Cypress.env("MyResponse"));
})
Then("The response status code should be '{word}'",(StatusCode)=>{
    const sta = +(Cypress.env("StatusCode"));
    expect(sta).to.eql(+StatusCode)
})


// 7. List repositories for a user
Given("Make a GET request for user repositories with the resource '{word}'",(Resource)=>{
    cy.request({
        method:"GET",
        url:baseUrl+Resource,
        headers: {
            Authorization: `Bearer ${token}`,
        },
        header:"application/json",
    }).then((response) => {
        Cypress.env("StatusCode", response.status);
        let body = JSON.parse(JSON.stringify(response.body))
        Cypress.env('MyResponse',JSON.stringify(body));
    });
})
Then("Print the response in console",()=>{
    cy.log(Cypress.env("MyResponse"));
})
Then("The response status code should be '{word}'",(StatusCode)=>{
    const sta = +(Cypress.env("StatusCode"));
    expect(sta).to.eql(+StatusCode)
})



// List repository languages
Given("Make a GET request for repositories languages with the resource '{word}'",(Resource)=>{
    cy.request({
        method:"GET",
        url:baseUrl+Resource,
        headers: {
            Authorization: `Bearer ${token}`,
        },
        header:"application/json",
    }).then((response) => {
        Cypress.env("StatusCode", response.status);
        let body = JSON.parse(JSON.stringify(response.body))
        Cypress.env('MyResponse',JSON.stringify(body));
    });
})
Then("Print the response in console",()=>{
    cy.log(Cypress.env("MyResponse"));
})
Then("The response status code should be '{word}'",(StatusCode)=>{
    const sta = +(Cypress.env("StatusCode"));
    expect(sta).to.eql(+StatusCode)
})





// 9. List public repositories
Given("Make a GET request for public repositories with the resource '{word}'",(Resource)=>{
    cy.request({
        method:"GET",
        url:baseUrl+Resource,
        headers: {
            Authorization: `Bearer ${token}`,
        },
        header:"application/json",
    }).then((response) => {
        Cypress.env("StatusCode", response.status);
        let body = JSON.parse(JSON.stringify(response.body))
        Cypress.env('MyResponse',JSON.stringify(body));
    });
})
Then("Print the response in console",()=>{
    cy.log(Cypress.env("MyResponse"));
})
Then("The response status code should be '{word}'",(StatusCode)=>{
    const sta = +(Cypress.env("StatusCode"));
    expect(sta).to.eql(+StatusCode)
})





// Delete a FORK
Given("Make a Delete request with the resource '{word}'",(Resource)=>{
    cy.wait(5000);
    cy.request({
        method:"DELETE",
        url:baseUrl+Resource,
        headers: {
            Authorization: `Bearer ${token}`,
        },
    }).then((response) => {
        Cypress.env("StatusCode", response.status);
    });
})
Then("The Delete response status code should be '{word}'",(StatusCode)=>{
    const sta = Cypress.env("StatusCode");
    expect(sta).to.eql(+StatusCode)
})

// 11. Delete a file
Given("Make a Delete file request with the resource '{word}'",(Resource)=>{
    cy.request({
        method:"DELETE",
        url:baseUrl+Resource,
        headers: {
            Authorization: `Bearer ${token}`,
        },
        body:{
            message:"deleted file",
            sha:`${Cypress.env("ShaValue")}`
        }
    }).then((response) => {
        Cypress.env("StatusCode", response.status);
    });
})
Then("The Delete response status code should be '{word}'",(StatusCode)=>{
    const sta = Cypress.env("StatusCode");
    expect(sta).to.eql(+StatusCode)
})



// Extra. Create a release
Given("Make a POST request to create a release with the resource '{word}'",(Resource)=>{
    cy.request({
        method:"POST",
        url:baseUrl+Resource,
        headers: {
            Authorization: `Bearer ${token}`,
        },
        header:"application/json",
        body:{
            tag_name:"GitHun"
        }
    }).then((response) => {
        Cypress.env("StatusCode", response.status);
        let body = JSON.parse(JSON.stringify(response.body))
        Cypress.env('MyResponse',JSON.stringify(body));
    });
})
Then("Print the response in console",()=>{
    cy.log(Cypress.env("MyResponse"));
})
Then("The response status code should be '{word}'",(StatusCode)=>{
    const sta = +(Cypress.env("StatusCode"));
    expect(sta).to.eql(+StatusCode)
})

// 12. List repository tags
Given("Make a GET request for repositories tags with the resource '{word}'",(Resource)=>{
    cy.request({
        method:"GET",
        url:baseUrl+Resource,
        headers: {
            Authorization: `Bearer ${token}`,
        },
        header:"application/json",
    }).then((response) => {
        Cypress.env("StatusCode", response.status);
        let body = JSON.parse(JSON.stringify(response.body))
        Cypress.env('MyResponse',JSON.stringify(body));
    });
})
Then("Print the response in console",()=>{
    cy.log(Cypress.env("MyResponse"));
})
Then("The response status code should be '{word}'",(StatusCode)=>{
    const sta = +(Cypress.env("StatusCode"));
    expect(sta).to.eql(+StatusCode)
})



// Create an autolink reference for a repository
Given("Make a POST request For autolink with the resource '{word}'",(Resource)=>{
    cy.request({
        method:"POST",
        url:baseUrl+Resource,
        headers: {
            Authorization: `Bearer ${token}`,
        },
        header:"application/json",
        body:{
            key_prefix:"Github-Api-Testing",
            url_template:"https://example.com/Api?query=<num>"
        }
    }).then((response) => {
        Cypress.env("StatusCode", response.status);
        let body = response.body;
        Cypress.env('MyResponse',JSON.stringify(body));
        Cypress.env("autolink_id",JSON.parse(JSON.stringify(body)).id);  
    });
})
Then("Print the response in console",()=>{
    cy.log(Cypress.env("MyResponse"));
})
Then("Store Necessary data in the variable",()=>{
    cy.log(Cypress.env("autolink_id"));
})
Then("The response status code should be '{word}'",(StatusCode)=>{
    const sta = +(Cypress.env("StatusCode"));
    expect(sta).to.eql(+StatusCode)
})




// 18. Replace all repository topics
Given("Make a PUT request for repositories topics with the resource '{word}'",(Resource)=>{
    cy.request({
        method:"PUT",
        url:baseUrl+Resource,
        headers: {
            Authorization: `Bearer ${token}`,
        },
        header:"application/json",
        body:{
            names:["github","github-api","github-api-testing"]
        }
    }).then((response) => {
        Cypress.env("StatusCode", response.status);
        let body = JSON.parse(JSON.stringify(response.body))
        Cypress.env('MyResponse',JSON.stringify(body));
    });
})
Then("Print the response in console",()=>{
    cy.log(Cypress.env("MyResponse"));
})
Then("The response status code should be '{word}'",(StatusCode)=>{
    const sta = +(Cypress.env("StatusCode"));
    expect(sta).to.eql(+StatusCode)
})




// Get all repository topics
Given("Make a GET request for repositories topics with the resource '{word}'",(Resource)=>{
    cy.request({
        method:"GET",
        url:baseUrl+Resource,
        headers: {
            Authorization: `Bearer ${token}`,
        },
        header:"application/json",
    }).then((response) => {
        Cypress.env("StatusCode", response.status);
        let body = JSON.parse(JSON.stringify(response.body))
        Cypress.env('MyResponse',JSON.stringify(body));
    });
})
Then("Print the response in console",()=>{
    cy.log(Cypress.env("MyResponse"));
})
Then("The response status code should be '{word}'",(StatusCode)=>{
    const sta = +(Cypress.env("StatusCode"));
    expect(sta).to.eql(+StatusCode)
})





// 15. Get an autolink reference of a repository
Given("Make a GET request for repositories autolink with the resource '{word}'",(Resource)=>{
    cy.request({
        method:"GET",
        url:baseUrl+Resource+Cypress.env("autolink_id"),
        headers: {
            Authorization: `Bearer ${token}`,
        },
        header:"application/json",
    }).then((response) => {
        Cypress.env("StatusCode", response.status);
        let body = JSON.parse(JSON.stringify(response.body))
        Cypress.env('MyResponse',JSON.stringify(body));
    });
})
Then("Print the response in console",()=>{
    cy.log(Cypress.env("MyResponse"));
})
Then("The response status code should be '{word}'",(StatusCode)=>{
    const sta = +(Cypress.env("StatusCode"));
    expect(sta).to.eql(+StatusCode)
})




// 16. Delete an autolink reference from a repository
Given("Make a Delete request to delete autolink with the resource '{word}'",(Resource)=>{
    cy.request({
        method:"DELETE",
        url:baseUrl+Resource+Cypress.env("autolink_id"),
        headers: {
            Authorization: `Bearer ${token}`,
        },
    }).then((response) => {
        Cypress.env("StatusCode", response.status);
    });
})
Then("The Delete response status code should be '{word}'",(StatusCode)=>{
    const sta = Cypress.env("StatusCode");
    expect(sta).to.eql(+StatusCode)
})


// 17. Get a repository
Given("Make a GET request  with the resource '{word}'",(Resource)=>{
    cy.request({
        method:"GET",
        url:baseUrl+Resource,
        headers: {
            Authorization: `Bearer ${token}`,
        },
        header:"application/json",
    }).then((response) => {
        Cypress.env("StatusCode", response.status);
        let body = JSON.parse(JSON.stringify(response.body))
        Cypress.env('MyResponse',JSON.stringify(body));
    });
})
Then("Print the response in console",()=>{
    cy.log(Cypress.env("MyResponse"));
})
Then("The response status code should be '{word}'",(StatusCode)=>{
    const sta = +(Cypress.env("StatusCode"));
    expect(sta).to.eql(+StatusCode)
})





// Make a Delete request with the resource '/repos/jitenderji1137/Hello-World-by'

Given("Make a Delete request to delete repo with the resource '{word}'",(Resource)=>{
    cy.request({
        method:"DELETE",
        url:baseUrl+Resource,
        headers: {
            Authorization: `Bearer ${token}`,
        },
    }).then((response) => {
        Cypress.env("StatusCode", response.status);
    });
})
Then("The Delete response status code should be '{word}'",(StatusCode)=>{
    const sta = Cypress.env("StatusCode");
    expect(sta).to.eql(+StatusCode)
})