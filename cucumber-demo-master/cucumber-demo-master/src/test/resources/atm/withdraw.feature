Feature: Withdraw money
    In order to avoid going to the bank
    As a customer
    I want to withdraw money from an ATM

    @run_me
    Scenario: Withdraw less money than the account has
        Given I have 200 rupees on my account
        When I withdraw 100 rupees
        Then I get 100 rupees from the ATM
        And My account has 100 rupees left

    @run_me
    Scenario: Withdraw more money than the account has
        Given I have 50 rupees on my account
        When I withdraw 100 rupees
        Then I get 0 rupees from the ATM
        And My account has 50 rupees left
        And error message about the lack of money is displayed

    @run_me
    Scenario: Withdraw negative amount from the account
        Given I have 50 rupees on my account
        When I withdraw -1 rupees
        Then I get 0 rupees from the ATM
        And My account has 50 rupees left
        And error message about incorrect amount is displayed