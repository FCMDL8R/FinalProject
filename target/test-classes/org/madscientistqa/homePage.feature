Feature: Home page
  This test will verify the functionality of the functionality of the Software Testing Course Main Page

  Scenario: Navigating to the Software Testing Course Main Page
    Given I am on the main page
    Then The page title should say "Software Testing Course"

  Scenario: Check what you will learn navbar buttons
    Given I am on the main page
    When I click on the What You'll Learn navigation button
    Then I should see the Learn The Fundamentals heading

  Scenario: Sign up for newsletter with email
    Given I am on the main page
    And I type "mewmewnyancat@gmail.com" in the email field
    When I click on the submit button
    Then I should see a pop-up saying "Email saved - you will now receive our monthly newsletter. Thank you!"

  Scenario: Sign up for newsletter with a phone number
    Given I am on the main page
    And I type "+1 234 567 8900" in the email field
    When I click on the submit button
    Then I should see a red outline on the email input field

  Scenario: Reveal FAQ answers
    Given I am on the main page
    And I scroll to the Frequently Asked Questions element
    When I click on the first question
    Then I should see the answer to the question

  Scenario Outline: Check instructors social media
    Given I am on the main page
    And I scroll to the Our Instructors element
    When I click on the "<socialButton>" social button
    Then I should see the "<socialPage>" page

    Examples:
      | socialButton               | socialPage |
      | https://www.twitter.com/   | Twitter    |
      | https://www.facebook.com/  | Facebook   |
      | https://www.linkedin.com/  | LinkedIn   |
      | https://www.instagram.com/ | Instagram  |

  Scenario: Go back to top
    Given I am on the main page
    And I scroll at the bottom of the page
    When I click on the back-to-top arrow
    Then I should see the Certified Software Tester text
