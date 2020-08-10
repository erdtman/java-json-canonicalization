[![Build Status](https://travis-ci.org/erdtman/java-json-canonicalization.svg?branch=master)](https://travis-ci.org/erdtman/java-json-canonicalization)
[![Coverage Status](https://coveralls.io/repos/github/erdtman/java-json-canonicalization/badge.svg)](https://coveralls.io/github/erdtman/java-json-canonicalization)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.erdtman/java-json-canonicalization.svg?label=Maven%20Central)](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22io.github.erdtman%22%20a%3A%22java-json-canonicalization%22)
# java-json-canonicalization
Java JSON canonicalization 
JSON canonicalize implementation. Creates crypto safe predictable canocalization of
JSON as defined by [RFC8785](https://tools.ietf.org/html/rfc8785)
## Usage
### Example JSON
#### Normal
```json
{
  "from_account": "543 232 625-3",
  "to_account": "321 567 636-4",
  "amount": 500,
  "currency": "USD"
}
```
#### Crazy
```json
{
  "1": {"f": {"f":  "hi","F":  5} ,"\n":  56.0},
  "10": { },
  "":  "empty",
  "a": { },
  "111": [ {"e":  "yes","E":  "no" } ],
  "A": { }
}
```
### Java
```java
String json = new String(Files.readAllBytes(Paths.get("filename.json")));
JsonCanonicalizer jc = new JsonCanonicalizer(json);
System.out.println(jc.getEncodedString());

// output normal: {"amount":500,"currency":"USD","from_account":"543 232 625-3","to_account":"321 567 636-4"}
// output crazy: {"":"empty","1":{"\n":56,"f":{"F":5,"f":"hi"}},"10":{},"111":[{"E":"no","e":"yes"}],"A":{},"a":{}}
```
## Install
### Apache Maven
```xml
<dependency>
  <groupId>io.github.erdtman</groupId>
  <artifactId>java-json-canonicalization</artifactId>
  <version>1.0</version>
</dependency>
```
### Gradle Groovy DSL
```
compile 'io.github.erdtman:java-json-canonicalization:1.0'
```
### Gradle Kotlin DSL
```
compile(group = "io.github.erdtman", name = "java-json-canonicalization", version = "1.0")
```
### Scala SBT
```
libraryDependencies += "io.github.erdtman" % "java-json-canonicalization" % "1.0"
```
### Apache Ivy
```xml
<dependency org="io.github.erdtman" name="java-json-canonicalization" rev="1.0" />
```
### Groovy Grape
```
@Grapes(
  @Grab(group='io.github.erdtman', module='java-json-canonicalization', version='1.0')
)
```
### Leiningen
```
[io.github.erdtman/java-json-canonicalization "1.0"]
```
### Apache Buildr
```
'io.github.erdtman:java-json-canonicalization:jar:1.0'
```
### PURL
```
pkg:maven/io.github.erdtman/java-json-canonicalization@1.0
```
