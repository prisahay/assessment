#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Search for appium Book on amazon.com
  I want to use this template for my feature file

  @tag1
  Scenario: Checking url
    Given Browser is open
    When amazon.com is searched
    Then amazon.com opens successfully
   
  @tag2
  Scenario: Item search functionality
   Given amazon.com is open
    When Search for a book called appium
    Then books with title including appium are listed

   @tag3
  Scenario: Item selection functionality
    Given required book listed
    When select 10th book
    Then the selected book's page opens
      
   @tag4
  Scenario: Item's rating
    Given the selected book's page is open
    When query the rating of the book
    Then the rating is fetched successfully
   
   @tag5
  Scenario: Add item to cart functionality
    Given the selected book's page is open and rating fetched
    When click on add to cart 
    Then the book is added to cart
    
   @tag6
  Scenario: Display item's price
    Given the book is in the cart
    When search for the price of the book
    Then price of the book is retrieved   