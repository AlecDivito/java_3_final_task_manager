-----------------------------------------------------------
If you would like to run this project on your computer
-----------------------------------------------------------
IF YOU DON'T ALREADY CREATE A DATA BASE CALLED 'Java3' create it
1. Run db.sql on a MySQL database to create all the needed tables
   (maybe (idk im not on windows) you can run a command like this:
	'mysql -u root -proot Java3 < db.sql'
   and as long as you have Java3 created and your username and password is
   in place where root and -p'root' is you should be ok and it should run.

IF You created the 'Java3' Database you could skip this part
2.a) configer the hibernate.cfg.xml(input the name into connection.url)
     and the hibernate.reveng.xml (input the name into    <schema-selection match-catalog="Java3"/> tags)
     files to use the database you just created . 
  b) also change your username and password to your db username and password

3. You need to change the absloute location inside the web 
   xml inside the context param called 'file-upload' in 
   relitivity to your own computer. Just keep the 'build/web/images/'.

I think if the Config files are correct it should run without
a problem

