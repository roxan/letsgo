Create the JDBC Connection Pool in glassfish console ---> Name of the Pool: LetsGoPool / Name of Database: LETS_GO_DB
Create the JDBC Resource in glassfish console ---> Name of the resource: jdbc/letsgodb

start server
Change glassfish_client.bat so that it loads the correct ij.propeties file.
Also make sure ij.properties file has the correct letsgodb jndi selected

Run glassfish_client.bat
First create the tables: run 'create_table.sql'
Second import the data run 'location.sql' etc


