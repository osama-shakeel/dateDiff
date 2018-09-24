# Program Design/Features
- ***The program centers around: ***
	+ Validating the input dates through the static utility methods of **DateUtils** class.
	+ Parsing the input dates into immutable **CalDate** class instances (which is a highly miniature form of **java.util.Date**).
	+ The date difference calculation functionality is part of the **CalDate** class itself.
	+ It is based upon using the representation of the dates in terms of days starting from 01/01/01 AD. The difference of both dates' long representation in days is used to calculate the exact day difference of both dates.
- All the code written is backed by unit test cases.
- The program implemenation has been kept simple with respect to the choice of frameworks.
- The implementation is wholly Java SE based with very minimal use of Java libaries.

# Steps to build
- Please clone and download this repository locally.
- To build the jar file please run the following GRADLE command on command-line interface/terminal:
*If in Windows:*
    `gradlew.bat clean build`
*If in Unix/OSX:*
    `./gradlew clean build`

- The jar file is created in **build/lib** folder.

# Steps to run program
- Navigate into **build/lib** folder.
- Please run the following command with **sample** program arguments on command-line interface/terminal:
`java -jar datediff-1.0.jar 01/01/2000 01/02/2000`
