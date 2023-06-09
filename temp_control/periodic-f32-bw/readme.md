# Periodic Temperature Control

 Table of Contents
  * [Diagrams](#diagrams)
    * [AADL Arch](#aadl-arch)
  * [Metrics](#metrics)
    * [AADL Metrics](#aadl-metrics)
    * [JVM Metrics](#jvm-metrics)
  * [Run Instructions](#run-instructions)
    * [JVM](#jvm)

## Diagrams
### AADL Arch
![AADL Arch](aadl/diagrams/aadl-arch.svg)

## Metrics
### AADL Metrics
| | |
|--|--|
|Threads|4|
|Ports|9|
|Connections|5|

### JVM Metrics
Directories Scanned Using [https://github.com/AlDanial/cloc](https://github.com/AlDanial/cloc) v1.94:
- [hamr/slang/src/main](hamr/slang/src/main)

<u><b>Total LOC</b></u>

Total number of HAMR-generated and developer-written lines of code
Language|files|blank|comment|code
:-------|-------:|-------:|-------:|-------:
Scala|63|1899|1228|6507
--------|--------|--------|--------|--------
SUM:|63|1899|1228|6507

<u><b>User LOC</b></u>

The number of lines of code written by the developer.
"Log" are lines of code used for logging that
likely would be excluded in a release build
 |Type|code |
 |--|--:|
 |Behavior|97|
 |Log|6|
 |--------|--------|
 |SUM:|103|

### Distributed SlangCheck Coverage

GUMBOX uses SlangCheck to generate test vectors.  SlangCheck is Sireum's randomized test generator framework similar to ScalaCheck and Haskell's QuickCheck.  By default SlangCheck uses GUMBO datatype invariants, if provided, to reject invalid vectors.  Distributed SlangCheck (DSC) adds a framework that allows test vector generation to be run via a server cluster up to a user specified timeout.  Increasing the timeout allows more vectors to be produced which may lead to increased code coverage during testing.  DSC passes the vectors to user defined unit tests (e.g. the contract-based ``testCompute`` methods generated by GUMBOX) and serializes the passing and failing vectors to seperate files so that they can be replayed if needed.  DSC uses [JaCoCo](https://www.jacoco.org/jacoco/) to produce code coverage information.

The following summarizes the results of running DSC+GUMBOX on the Periodic Temperature Control with different time-out values 

[https://people.cs.ksu.edu/~santos_jenkins/dsc_results/tc/tc.html](https://people.cs.ksu.edu/~santos_jenkins/dsc_results/tc/tc.html)

## Run Instructions
*NOTE:* actual output may differ due to issues related to thread interleaving
### JVM

  |HAMR Codegen Configuration| |
  |--|--|
  | package-name | tc |
  | exclude-component-impl | false |
  | bit-width | 32 |
  | max-string-size | 256 |
  | max-array-size | 1 |


  **How To Run**
  ```
  sireum proyek run temp_control/periodic/hamr/slang tc.Demo
  ```
