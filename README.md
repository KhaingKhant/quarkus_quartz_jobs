# quarkus_quartz_jobs

Quarkus with Quartz

This project demonstrates how to pull data from an external REST API and save it periodically into a Postgres database using Quarkus Quartz API.
Prerequisites
* Java 11 or higher
* Gradle
* Postgres database

Usage
The application will pull data from the external REST API every 5 minutes and save it into the database. To change the interval, modify the @QuartzTrigger annotation in the DataFetcherJob class.
To view the saved data, you can query the data table in the Postgres database.
Credits
This project was built using the Quarkus framework and the Quartz API.

