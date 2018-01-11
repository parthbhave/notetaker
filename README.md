# notetaker
Note Taking Application backend using Java / Spring

Technologies used -

Spring Boot, JPA, H2 (In memory database)

Pre requisites for running the application -

1) Spring Tool Suite or Eclipse with the STS (Spring Tool Suite) plugin installed

2) Port 8080 should be free

Setup steps -

1) Clone the respository
2) Startup Eclipse with any workspace directory
3) Select File > Import > Maven > Existing Maven project
4) Click browse in the dialog that shows up and select the local 'notetaker' directory from the cloned project
5) This will show up an entry for a pom.xml file under the Projects box - select the entry and click finish
6) The imported project should be visible in the package explorer - right click the project 
    and click Run As > Spring Boot Application - this should start up the application
7) The application should now respond to http requests made by curl

Caveats -

1) NoteTaker uses H2 (an in memory database) - so the notes saved are available only for the period that the application is running after which they are discarded.
With some effort, a different database may be plugged in without much change to the code.

2) Exception handling needs to be improved
