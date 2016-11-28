# files2gramps
Java lib for files to pack as a export into gramps database format.

[![Build Status](https://travis-ci.org/FunThomas424242/releasebuild.example.svg?branch=master)](https://travis-ci.org/FunThomas424242/releasebuild.example)
[![codecov](https://codecov.io/gh/FunThomas424242/releasebuild.example/branch/master/graph/badge.svg)](https://codecov.io/gh/FunThomas424242/releasebuild.example)
[![Download](https://api.bintray.com/packages/funthomas424242/funthomas424242-maven-plugins/releasebuild.example/images/download.svg) ](https://bintray.com/funthomas424242/funthomas424242-maven-plugins/releasebuild.example/_latestVersion)


# Usage
```
java -jar target/releasebuild.example-0.0.0-SNAPSHOT-jar-with-dependencies.jar
or
mvn exec:java
```
# Beschreibung - Releasebau
1. Projekt aufsetzen
2. branch production erstellen
3. branch feature/xxx erstellen
4. feature auf feature branch implementieren
5. feature in den master mergen
6. release auf dem master bauen
7. release tag in den production branch mergen
8. production branch deployen
