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
Feature: Manipulando uma livraria online
  Eu como cliente quero a habilidade de consultar, comprar ou alugar um livro.

  @tag1
  Scenario: Consulta livro cadastrado
    Given  Eu quero consultar um livro por autor
    When Eu digito o nome
    Then Eu obtenho o resultado

