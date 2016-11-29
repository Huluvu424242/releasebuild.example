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
# Beschreibung - Releasebau Variante1
(Der master enthält abwechselnd release und snapshot Stände)
1. Projekt aufsetzen
2. branch production erstellen
3. branch feature/xxx erstellen
4. feature auf feature branch implementieren
5. feature in den master mergen
6. release auf dem master bauen, mit Deployment auf einen nexus.
7. release tag in den production branch mergen
8. production branch deployen

# Beschreibung - Releasebau Variante2
(Der master enthält nur release Stände)
1. Projekt aufsetzen
2. bramch production erstellen
3. Feature im Featurebranch entwickeln, mit ständigen CI Läufen
4. feature branch aus master aktualisieren
5. CI Lauf mit Releasebildung am Ende
6. ReleaseTag in den master mergen (evtl. tmpBranch benötigt)
7. CI Stack (Unit, Int, Akzeptanz, Coverage, Last) läuft mit ReleaseTag und falls 
erfolgreich wird der ReleaseTag in den production branch gemerged (automatisch oder händisch wie gewünscht)
8. production branch deployed automatisch und veröffentlicht die Anwendung
(Variante 2 ohne fachliche Umsetzung kan als Spezialform aus Variante 1 Schritt 6 gesehen werden)


# Fallen
1. Beim Bilden des Release 0.0.0 wurde einfach mvn release:prepare und mvn release:perform ausgeführt
* Prepare wurde interaktiv durchgeführt und es wurde ein push des release Tags ausgelöst. Leider enthält 
der Tag release.example-0.0.0 eine pom.xml mit SNAPSHOT Version. Das hätte ich nicht erwartet.
* Das Perform wurde abgebrochen weil das Deployment auf Grund ungültiger Zugangsdaten scheiterte. Es
entstand eine Situation die ich nicht mehr lösen konnte. Ich entschied mich das Release zu canceln und 0.0.1 vorzubereiten.
Dazu spaltete ich den Branch feature/vorgehen2 ab. Die pom.xml steht auf 0.0.1-SNAPSHOT
2. Beim Bilden des Release 0.0.1 wurde wieder einfach mvn release:prepare und mvn release:perform ausgeführt.
 Die Probleme waren die gleichen wie unter 1) allerdings schlug das Deployment nicht fail und so wurde das "Release" mit SNAPSHOT in der
 pom.xml in das snapshot directory auf jfrog deployed. Um die kostenfreien Speierresourcen dort nicht zu belasten habe ich es natürlich 
 gleich wieder gelöscht. 
3. Beim Bilden von Release 0.0.2 wurde mvn release:prepare-with-pom probiert.
 Das führt dazu das ein neuer release-pom.xml versucht wird mit einzuchecken. Irgendwie hinterlässt das release plugin aber lokale Änderungen
 und ein remove des Release Poms scheitert (warum auch immer dieser durchgeführt wird wenn er vorher extra hinzugefügt wird?). Der Push des 
 release Tags funktioniert aber es ist wieder nur die SNAPSHOT pom.xml drin.
4. Beim Bilden von Release v0.0.3 wurde in der pom.xml das release plugin konfiguriert und das Release im Batch Mode gebildet: 
mvn -B release:prepare mvn -B release:perform
Anschließend war ein Release Tag v0.0.3 zu finden mit einer korrekten Release pom.xml 