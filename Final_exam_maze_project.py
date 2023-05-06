import sys

def Threshold():
    # The beginning
    print("Hello there, adventurer! Welcome to the the maze of puzzles!")
    start = str(input("Do you want to continue? Y/N"))
    if start ==  'N' or start == 'n':
      print("Goodbye!")
      sys.exit()
    else:
      print("So long adventurer! Wish you good luck!")
      Entrance();
      return;
def Entrance():
    # In the maze
    print("You see a path in front of you.")
    forward = str(input("Do you want to move forward? Y/N"))
    if forward == 'N' or forward == 'n':
      print("You've chickened out and went back outside. Goodbye")
      sys.exit()
    else:
      print("You move forward")
      Inter1();
      return;
def Inter1():
    # Intersection 1
    print("You see a door in front of you and open it to go through.")
    print("You walk till you are at an intersection.")
    print("At this intersection you see a door at your right and in front of you.")
    choice_door_inter1 = int(input("1 to the right, 2 to the door in front of you."))

    #Door1
    if choice_door_inter1 == 1:
        Inter1_Door1();

    #Door 2
    elif choice_door_inter1 == 2:
        Inter1_Door2();
    return;
def Inter1_Door1():
    # Door 1 operations
      print("You through the door on your right and continue forward.")
      Inter2();
      return;
def Inter1_Door2():
      print("You go through the door in front of you to then walk to a dead end, but you see a path to your right.")
      deadEnd = int(input("1 to go to the right or 2 to go back to the intersection."))
      if deadEnd == 2:
          Inter1();
      elif deadEnd == 1:
          print("You've walked into a dead end again lol!")
          deadEnd2 = int(input("1 to go back to the intersection 2 to continue walking into the dead end."))
          while deadEnd2 != 1 and deadEnd2 == 2:
              print("You've walked into the wall again.")
              back = int(input(" 1 to go back 2 to continue."))
              if back == 2:
                  print("You've walked into the wall again lol.")
              elif back == 1:
                  Inter1();
                  break
      return;
def Inter2():
    #Intersection 2
    print("You walk to another intersection.")
    print ("There are no doors here so you've moved on.")
    return;
def FinaleFl1():
    #Final intersection
    print ("You've made it to the end of Floor 1! You see a door in front of you.")
    print("Would you like to continue?")
    contin = int(input("1 to continue or 2 if not and want to say."))

Threshold();
