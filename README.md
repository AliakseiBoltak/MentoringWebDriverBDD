## Run cucumber scenarios:
mvn clean test -DforkCount={number of forks}

## Generate Allure report:
mvn site

## Open report page:
target/site/allure-maven-plugin/index.html

## Deploy artifact into Nexus repository:
mvn deploy -DskipTests