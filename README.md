# Project description
The program starts from the console where you must enter the exact number of players. The number has to correspond to 
the number of players in the CSV file.  After you enter the number the program calls the method "createObjectsForTornament" 
from the tournament object and creates (six) empty objects of players. Then the program checks all files in the folder "CSV_files". 
If you put a file in a format other than CSV format to the folder of "CSV_files" the program will throw "WrongFileFormatException". 
Next, the program begins to read all files in the folder "CSV_files" folder. The first row of each file specifies the kind of game. 
For example, if the file starts from the row basketball the program calls the method "createTeam" from the basketball object and 
passes the arguments. The method creates teams according to the game (basketball) and puts them on the "playerList" which is located 
in the tournament object. Then the program calls the method "defineWinnerTeamAndRatingPoints"  from the basketball object and passes 
the "playerList" to this method. The method counts scored points of each team after that defines the winner team and adds 10 extra 
points to each player of the winning team next counts rating points of each player. After all calculations, the method makes changes 
in the "playerList" which is located in the tournament object. Next the program checks for the uniqueness of the nickname of each player. 
If the nickname is repeated the program will ask to change it. Then the program displays "playerList" to the console. Finally, the program 
calls the method "definingMVP" from the tournament object and this method defines the most valuable player of the tournament.
