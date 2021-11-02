Project for API automation 

**How to run tests**

Get your API Key from - https://thecatapi.com/

For launch all tests, generate allure logs and open it:
`mvn clean test -DapiKey={api_key} allure:report allure::serve`

For launch specific tests, generate allure logs and open it:
`mvn clean test -Dtest={test_name} -DapiKey={api_key} allure:report allure::serve`