Feature: Enrollment page
  This test will verify the functionality of the functionality of the Software Testing Course Main Page

  Scenario: Fill all Personal Information
    Given I am on the enrollment page
    And I type in the "firstName" field "Andreea"
    And I type in the "lastName" field "Sturzu"
    And I type in the "username" field "mewmewnyancat"
    And I type in the "password" field "Password123"
    And I type in the "cpassword" field "Password123"
    When I click the "next-btn"
    Then I should see the Contact Information header

  Scenario: Fill all Personal Information and Contact Information
    Given I am on the enrollment page
    * I type in the "firstName" field "Andreea"
    * I type in the "lastName" field "Sturzu"
    * I type in the "username" field "mewmewnyancat"
    * I type in the "password" field "Password123"
    * I type in the "cpassword" field "Password123"
    * I click the "next-btn"
    * I type in the "email" field "andreea.sturzu@gmail.com"
    * I type in the "phone" field "+1 234 567 8900"
    * I type in the "country" field "USA"
    * I type in the "city" field "Los Angeles"
    * I type in the "postCode" field "66600"
    When I click the "next-btn"
    Then I should see the Course Options header

  Scenario: Fill all Personal Information, Contact Information, and select Course Options
    Given I am on the enrollment page
    * I type in the "firstName" field "Andreea"
    * I type in the "lastName" field "Sturzu"
    * I type in the "username" field "mewmewnyancat"
    * I type in the "password" field "Password123"
    * I type in the "cpassword" field "Password123"
    * I click the "next-btn"
    * I type in the "email" field "andreea.sturzu@gmail.com"
    * I type in the "phone" field "+1 234 567 8900"
    * I type in the "country" field "USA"
    * I type in the "city" field "Los Angeles"
    * I type in the "postCode" field "66600"
    * I click the "next-btn"
    And I select the "flexRadioButton1"
    * I select the "flexRadioButton2"
    * I select the "flexRadioButton3"
    * I select the "flexRadioButton3"
    When I click the "next-btn"
    Then I should see the Payment Information header

  Scenario: Fill all Personal Information, Contact Information, select Course Options, and fill in Payment information
    Given I am on the enrollment page
    * I type in the "firstName" field "Andreea"
    * I type in the "lastName" field "Sturzu"
    * I type in the "username" field "mewmewnyancat"
    * I type in the "password" field "Password123"
    * I type in the "cpassword" field "Password123"
    * I click the "next-btn"
    * I type in the "email" field "andreea.sturzu@gmail.com"
    * I type in the "phone" field "+1 234 567 8900"
    * I type in the "country" field "USA"
    * I type in the "city" field "Los Angeles"
    * I type in the "postCode" field "66600"
    * I click the "next-btn"
    * I select the "flexRadioButton1"
    * I select the "flexRadioButton2"
    * I select the "flexRadioButton3"
    * I select the "flexRadioButton4"
    * I click the "next-btn"
    And I put in the "card-name" field "Andreea R. Sturzu"
    * I put in the "card-number" field "4400-5500-6600-7700"
    * I put in the "card-cvc" field "666"
    And I select from "month" 7
    * I select from "year" 6
    When I click the "next-btn"
    Then I should see the Success page

  Scenario: Don't select any course options
    Given I am on the enrollment page
    * I type in the "firstName" field "Andreea"
    * I type in the "lastName" field "Sturzu"
    * I type in the "username" field "mewmewnyancat"
    * I type in the "password" field "Password123"
    * I type in the "cpassword" field "Password123"
    * I click the "next-btn"
    * I type in the "email" field "andreea.sturzu@gmail.com"
    * I type in the "phone" field "+1 234 567 8900"
    * I type in the "country" field "USA"
    * I type in the "city" field "Los Angeles"
    * I type in the "postCode" field "66600"
    * I click the "next-btn"
    When I click the "next-btn"
    Then I should see a pop-up saying "Course options are required"

  Scenario: Select all Course Options, then come back to deselect the second
    Given I am on the enrollment page
    * I type in the "firstName" field "Andreea"
    * I type in the "lastName" field "Sturzu"
    * I type in the "username" field "mewmewnyancat"
    * I type in the "password" field "Password123"
    * I type in the "cpassword" field "Password123"
    * I click the "next-btn"
    * I type in the "email" field "andreea.sturzu@gmail.com"
    * I type in the "phone" field "+1 234 567 8900"
    * I type in the "country" field "USA"
    * I type in the "city" field "Los Angeles"
    * I type in the "postCode" field "66600"
    * I click the "next-btn"
    * I select the "flexRadioButton1"
    * I select the "flexRadioButton2"
    * I select the "flexRadioButton3"
    * I select the "flexRadioButton4"
    * I click the "next-btn"
    * I click the "previous-btn"
    When I deselect the "flexRadioButton2"
    Then The "flexRadioButton2" should be deselected