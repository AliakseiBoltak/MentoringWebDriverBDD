## To run cucumber scenarios in serial mode:
mvn test

## To run cucumber scenarios in parallel mode:
mvn test -Pparallel -DforkCount=number of forks

## Detailed info on parallel execution :
https://maven.apache.org/surefire/maven-surefire-plugin/examples/fork-options-and-parallel-execution.html
https://github.com/temyers/cucumber-jvm-parallel-plugin
