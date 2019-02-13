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

Feature: 
AS an Client
  I want to use this template for my feature file
So that I can see test automation

 
  Scenario: Selnium TestNG Test
    Given I start execution of the class
    When I click on execute button
    Then the execution should begin


	Scenario Outline: title
	Given <name>
	When <value>
	Then <status>
Examples:
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
 