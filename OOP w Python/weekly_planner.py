'''
Weekly Task Planner:
Prompts you to list the tasks you want to do and then what day you want to do them on.
Then displays what is going to be done on which days and what tasks are repeated if any.
'''

# a tuple of the days of the week
daysOfTheWeek = 'Sunday', 'Monday', 'Tuesday', 'Wednsday', 'Thursday', 'Friday', 'Saturday'

# prompt user for a list of tasks and turn the whole list into lowercase for future cross-checking
listOfTasks = input( "Enter your tasks (comma separated): " ).lower()
# not sure if we've learned replace() in class before, but I'm using it so I can satisfy
# my edge case OCD with programming
listOfTasks = listOfTasks.replace( " ", "" )
listOfTasks = listOfTasks.split( ',' ) # turn listOfTasks into a list
listOfTasks = tuple(listOfTasks) # turn listOfTasks into tuple

# ask for tasks to be assigned to which day
dayTaskList = []
dayTaskListCounter = 0
print( "Enter only 1 task per day.")
for day in daysOfTheWeek:
    dayTaskList.append( input( f"Which task will you do on {day}: " ).lower() )
    taskFound = False
    while taskFound == False:
        for task in listOfTasks:
            if dayTaskList[-1] == task:
                taskFound = True
                break
            else: 
                continue
        if taskFound:
            break
        else:
            print( "Sorry, that task is not in your list. Please enter a valid task." )
            dayTaskList.append( input( f"Which task will you do on {day}: " ).lower() )
    dayTaskListCounter += 1

# print out the plan 
dayTaskListCounter = 0
print( "Your Weekly Plan:" )
for day in daysOfTheWeek:
    print( f"{day.title() }: {dayTaskList[dayTaskListCounter].title() }")
    dayTaskListCounter += 1
