'''
A program that analyzes car data from a CSV data 
and provides meaningful analyses from said data
'''
from pathlib import Path
import math

# load_cars() func
def load_cars(data):
    '''
    summary: 
        Cleans up the string given by data and creates a list of dictionaries of the cars
    parameters: 
        data (str): data of cars given a string, read from a file
    returns: a list of a dictionary of the car data
    '''
    carDictList = []
    for car in data:
        car = car.replace("\n", "")
        car = car.split(",")
        newItem = dict([ ("make", car[0]), ("model", car[1]), ("year", int(car[2]) )])
        carDictList.append(newItem)
    return carDictList

# get_cars_by_make() func 
def get_cars_by_make(carList, make="toyota"):
    '''
    summary:
    get cars by make for the user and prints out the cars that match
    parameters:
    carList (list): a list of the dictionaries of cars
    returns:
    a printed list of the cars that match the argumented make
    '''
    for car in carList:
        if car["make"].lower() == make: 
            print(f"{car['make'].title() } {car['model'].title() } - {car['year']}" )

# get cars by the oldest year
def show_oldest_cars(car_list):
    '''
    summary: shows the oldest car(s)
    parameters: car_list(list): a list of car data
    returns: prints out all cars that are the oldest
    '''
    # get the youngest year to compare to
    youngestYear = 0
    for car in car_list:
        if car['year'] > youngestYear:
            youngestYear = car['year']
    # compare to the youngest year to get the oldest
    oldestYear = youngestYear
    for car in car_list:
        if car['year'] < oldestYear:
            oldestYear = car['year']
    print("Oldest car(s):")
    for car in car_list:
        yearToInt = int(car['year'])
        if yearToInt == oldestYear:
            print(f"{car['make'].title() } {car['model'].title() } - {car['year']}" )

def get_average_year(car_list):
    '''
    summary: gets the average year of the car years
    parameters: car_list(list): a list of cars
    returns: the average year
    '''
    yearAvg = 0
    for car in car_list:
        yearAvg += car['year']
    yearAvg /= 50
    return yearAvg

# read CSV file
carDataFile = Path.cwd()/"cars.csv"
with open(carDataFile, mode = 'r') as file:
    carData = file.readlines()
    carList = load_cars(carData)

# ui menu 
userQuit = False
while( userQuit != True ):
    print("1. View all cars sorted by make")
    print("2. Filter cars by make")
    print("3. Show the oldest car(s)")
    print("4. Show the average car year")
    print("5. Exit")
    userChoice = int(input("Enter a number from the menu: ") )
    if userChoice == 1:
        carList = sorted(carList, key=lambda car: car['make'] )
        for car in carList:
            print(f"{car['make'].title() } {car['model'].title() } - {car['year']}" )
        print()
    elif userChoice == 2:
        # prompt user for a car make and print cars that match
        make = input("Enter the make: ").lower()
        make.replace(" ", "")
        get_cars_by_make(carList, make)
        print()
    elif userChoice == 3:
        show_oldest_cars(carList)
        print()
    elif userChoice == 4:
        print(f"The average car year is {get_average_year(carList):.0f}")
        print()
    elif userChoice == 5:
        userQuit = True
    else:
        continue
