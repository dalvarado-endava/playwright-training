# Playwright with JavaScript

The main purpose of this framework is to provide a wide variety of UI tests for the Automation Practice website. The tests can be executed in all of the browsers provided by Playwright, namely Chromium, Firefox and WebKit. The main language used for this framework is JavaScript. For the package management, npm was used and for the test runner, Playwright Test was used.

## Main features

- Page Object Model (POM) implemented for more clarity and reusability
- Separate data.json file to provide all data needed throughout the tests
- Class randomize.js to provide random data necessary for the execution of certain tests
- Integration with Allure to provide clearer and more detailed reports of the executions
- Integration with Jenkins for periodic and parameterizd executions
- Dotenv used to manage environment variables for handling sensitive data
- Specific scripts to run the tests on a specific browser or to run them headed or headless
- For specific flows (like Purchase and Search) Data Driven Testing (DDT) was implemented in order to improve test coverage

## Tools used

- npm package manager
- Playwright (including Playwright Test runner)
- Allure reporting tool
- Jenkins

#### Basic command for executing tests:

```sh
npm run test
```