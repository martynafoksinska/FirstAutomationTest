Feature: Address registration

  Scenario Outline: Adding address to an account

    Given user is on "https://mystore-testlab.coderslab.pl" page
    When user clicks on SignIn button and logs in
    And user click create new address and inputs "<alias>", "<address>", "<city>", "<zip>","<country>", "<phone>"
    And user checks if data is correct
    Then user deletes added address
    Examples:
    |alias          |address |city    |zip    |country        |phone     |
    |Home address   |Nowa    |Poznan  |25-789 |United Kingdom |500698377 |