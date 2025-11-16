'''
Automatically place a pizza order for a pizza party
1 person eats 3 slices
1 pie equals 8 slices
Cost of 1 pie equals $12.50
'''
import math
import datetime

# get customer name
customerName = input( "Enter your name, please: " )
customerName = customerName.title()

# amount of people attending party including customer
partyAttendeeAmount = int(input( "How many people are attending the party, including you: " ) )

print( f"Customer Name: {customerName}" )
print( f"Amount of People Attending: {partyAttendeeAmount}" )
print( "1 pie has 8 slices" )
print( "1 pie costs $12.50" )
print( "1 party attendee approx. eats 3 slices" )

print( f"Hello, {customerName}! How do you do?" ) # greet customer
print( f"You've placed an order for {partyAttendeeAmount} attendees at {datetime.date.today()}!" ) # give date of order
# inform amount of slices 
slicesNeeded = int(3 * partyAttendeeAmount)
print( f"The amount of slices that will be eaten is {slicesNeeded} slices!" )
# inform amount of pies
piesNeeded = math.ceil( slicesNeeded / 8 )
print( f"The amount of pizza pies needed is {piesNeeded}!" )
# total cost
totalCost = piesNeeded * 12.50
print( f"All of that totals to ${totalCost:,.2f}!" )
# fun message
print( "Did you know that lots of Chinese people think that the Italians learned to make pizza from them?" )
print( "\"Tried to make scallion pancake and you make pizza?! Such a failure la!\"" )
lettersInName = len(customerName)
print( f"By the way, you have {lettersInName} letters in your name!" )
print( "Thanks for ordering! Have a great day!" )
