@echo off
javac LaserTagSystem.java Splash.java Model.java View.java Controller.java Player.java DatabaseConnection.java
if %errorlevel% neq 0 (
	echo There was an error. Exiting now. 
) else (
	echo Compiled correctly! Running program...
	java -cp .;postgresql-42.3.3.jar LaserTagSystem
	del *.class
)
