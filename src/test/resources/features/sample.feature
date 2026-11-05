Feature: Sample appium demo apk feature

  @smoke
  Scenario: Checking text submenu
    Given User is on home page
    When  User click on text button
    Then  User navigated to text related submenu