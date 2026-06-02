@tag
Feature: Purchase the order form the ECoemmerce site

Background:
Given The user is landed on the ECommerce page

@smoke
Scenario Outline: Positive test of submitting the order

Given Logged in with the username <name> and password <password>
When I add the product <productName> to cart
And checkout <productName> and select the country <countryAbbr> Submit the order
Then "THANKYOU FOR THE ORDER." message is displayed

Examples:
|name                     |password|productName    |countryAbbr|
|hardiksonigra97@gmail.com|Test1234|iphone 13 pro  |ind        |
|hardyboy959595@gmail.com |Test1234|ADIDAS ORIGINAL|new        |