Feature: Test gmail login
	I want to use this template for my feature file
	
Scenario Outline: Able to access gmail
Given I access gmail site, <url>
When a valid email is entered, <email>
And a valid password entered, <password>
And login button is clicked
Then I should be logged in to gmail site, <finalURL>

Examples: 
	| url | email | password | loginButton | finalURL |
	| {url} | {email} | {password} | {loginButton} | {finalURL} |