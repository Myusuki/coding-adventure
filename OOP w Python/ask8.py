# a magic 8 ball program
import random

# prompt user for name
username = input( "Enter your name: " )
if not username: # assign username as Guest if name is not given
    username = 'Guest'
    print( f"Welcome, {username}! To The Magic 8 Ball!")
else: # name has been given
    print( f"Welcome, {username.title()}! To The Magic 8 Ball!" )
    if len(username) < 4:
        print( "Your name is short and sweet!" )
    elif len(username) >=4 and len(username) <= 6:
        print( "Great name! Balanced and bold." )
    else:
        print( "Your name carries power in every letter!" )

# user asks question
input("Enter a question: " )
rngNum = random.randint(1,8) # generate result
# display result
if rngNum == 1:
    print( "MAGIC 8-BALL SAYS: ")
    print( "\"Yes, definitely.\"")
elif rngNum == 2:
    print( "MAGIC 8-BALL SAYS: ")
    print( "\"No, certainly not.\"")
elif rngNum == 3:
    print( "MAGIC 8-BALL SAYS: ")
    print( "\"Ask again later.\"")
elif rngNum == 4:
    print( "MAGIC 8-BALL SAYS: ")
    print( "\"Outlook not so good.\"")
elif rngNum == 5:
    print( "MAGIC 8-BALL SAYS: ")
    print( "\"It is possible.\"")
