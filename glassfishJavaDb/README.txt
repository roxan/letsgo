1. Copy this folder to your local.
2. Change the location of derbyrun.jar in start.bat ---> for me it is: C:\Program Files\Java\jdk1.8.0_11\db\lib\derbyrun.jar
3. Change the location of derbyrun.jar in stop.bat  ---> for me it is: C:\Program Files\Java\jdk1.8.0_11\db\lib\derbyrun.jar
4. Change the location of glassfish derbyrun.jar in glassfish_client.bat ---> for me it is: F:\glassfish-4.0\javadb\lib\derbyrun.jar
5. Create the JDBC Connection Pool in glassfish console ---> Name of the Pool: LetsGoPool / Name of Database: LETS_GO_DB
6. Create the JDBC Resource in glassfish console ---> Name of the resource: jdbc/letsgodb
7. run stat.bat
8. run glassfish_client.bat
9. On the ij prompt type this: run 'db_sql_script.sql'; and press enter

Your DB is created!!!

