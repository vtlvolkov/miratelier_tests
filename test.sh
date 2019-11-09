#!/bin/sh
mvn clean test
mvn site
mvn jetty:run
