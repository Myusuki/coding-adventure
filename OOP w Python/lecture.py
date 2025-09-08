import datetime

last_name = 'xyz'

# prints value of last_name duh!
print(last_name)

user_age = input( "Enter in your age: " )
# a funny joke
if int(user_age) < 18:
    print( "Your a minor! HA!" )
elif int(user_age) >= 18:
    print( "Wow, a mature man!" )

# prof code
print( type(user_age) )

print( f"You're {user_age}." )

last_name = input( "Enter your name: " )
print( f"Welcome {last_name} to this program." )

todays_date = datetime.date.today()
print( todays_date )
print( type(todays_date) )
