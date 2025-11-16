'''
A habit tracker that takes in the starting date
and how many days the user would like to track for.
Also takes in the days they've done the habit and spits out 
the results at the end.
'''

from datetime import date, timedelta
import calendar

trackAgain = True 
while trackAgain:
    # ask user for name
    username = input( "Enter your name: " )

    # ask user for year, month, and day to create a starting date
    startYear = int( input( "Enter the year you'd like to start habit tracking: " ) )
    startMonth = int( input( "Enter the month you'd like to start habit tracking: " ) )
    startDay = int( input( "Enter the day you'd like to start habit tracking: " ) )

    startDate = date(startYear, startMonth, startDay)
    # print starting date
    print( f"You'd like to start tracking your habit on {startDate}." )

    # ask for how many days to track habit
    daysToTrack = int( input( "How many days would you like to track this habit for: " ) )
    # ask for what habit they'd like to track
    habitName = input( "What's the habit you'd like to track, e.g. study, exercise, etc. : " )

    # loop and track the days the habit has been done
    daysCommitted = 0
    for day in range(daysToTrack):
        checkDay = input( f"Did you {habitName} on day {day + 1} [yes/no]: " )
        
        if checkDay.lower() == "yes":
            daysCommitted += 1
        elif checkDay.lower == "no": 
            continue

    # print summary of results
    print( f"Habit tracker for {username.title()}:" )
    print( f"Habit: {habitName.upper() }" )
    endDate = startDate + timedelta(days=daysToTrack)
    print( f"Tracking period from {startDate.strftime('%B %d, %Y') } to {endDate.strftime('%B %d, %Y') }" )
    print( f"Completed {daysCommitted} out of {daysToTrack}." )
    successRate = float( (daysCommitted / daysToTrack) * 100)
    print( f"Success Rate: {successRate:.2f}%.")

    ageOfTracking = date.today() - endDate
    print( f"Your tracking ended {ageOfTracking.days} days ago." )

    # ask whether to track another habit
    trackAnother = input( "Would your like to track another habit? Type 'y' to continue or hit Enter to quit: " )
    if trackAnother != 'y':
        trackAgain = False
    elif trackAnother == 'y':
        continue
