Feature: Ex1

  Scenario: Different Elements Page test
    Given I open JDI GitHub site
    And I login as user "Roman Iovlev"
    When I click on "Service" button in Header
    And I click on "Different Elements" button in Service dropdown
    And I select checkboxes:
      | Water |
      | Wind  |
    And I select radiobutton "Selen"
    And I select in color dropdown value "Yellow"
    Then Log section should contain:
      | Water: condition changed to true |
      | Wind: condition changed to true  |
      | metal: value changed to Selen    |
      | Colors: value changed to Yellow  |