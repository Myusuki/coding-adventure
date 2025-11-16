from pathlib import Path

# Car class
class Car:
    '''
    A class for creating a car object
    Attributes:
    make: a car's make
    year: a car's year
    model: a car's model
    '''
    def __init__(self, make:str, year:int, model:str):
        '''
        summary: initialises a car object
        parameters: 
        make(str): a car's make
        year(int): a car's year
        model(str): a car's model
        '''
        self.make = make
        self.year = year
        self.model = model
    def __str__(self) -> str:
        '''
        summary: returns a simple friendly string about the car object
        parameters: NULL
        returns: NULL
        '''
        return f"{self.make.title()} {self.model.title()} - {int(self.year)}"
    def __repr__(self) -> str:
        '''
        summary: returns a string about the car object for debugging
        paramteres: NULL
        returns: NULL
        '''
        return f"Make: {self.make.title()}, Model: {self.model.title()}, Year: {int(self.year)}"

# Car Catalog class
class CarCatalog:
    '''
    A class that acts as the catalog to the list of cars provided in a csv
    Attributes:
    carList: a list of car objects
    carYears: a list of car years
    '''
    carList = []
    carYears = []
    def load_cars(self, sourceFile = Path.cwd()/"cars.csv"):
        '''
        summary: cleans up the csv file given and loads cars into carList
        parameters:
        sourceFile(str): the path to the csv file
        returns: NULL
        '''
        with open(sourceFile, mode = 'r') as file:
            carData = file.readlines()
        for data in carData:
            data = data.strip("\n").split(",")
            newCar = Car(data[0], int(data[2]), data[1])
            self.carList.append(newCar)
            self.carYears.append(newCar.year)
    def get_cars_by_make(self, make):
        '''
        summary: gets cars by an inputted make from carList
        parameters:
        make(str): the make a user wants to get cars on 
        returns: NULL
        '''
        for car in self.carList:
            if car.make.lower() == make:
                print(f"{car.make.title() } {car.model.title() } - {car.year}" )
    def show_oldest_cars(self):
        '''
        summary: shows the oldest car in carList
        parameters: NULL
        returns: NULL
        '''
        # get the youngest year to compare to
        youngestYear = 0
        for car in self.carList:
            if car.year > youngestYear:
                youngestYear = car.year
        # compare to the youngest year to get the oldest
        oldestYear = youngestYear
        for car in self.carList:
            if car.year < oldestYear:
                oldestYear = car.year
        print("Oldest car(s):")
        for car in self.carList:
            yearToInt = int(car.year)
            if yearToInt == oldestYear:
                print(f"{car.make.title() } {car.model.title() } - {car.year}" )
    def get_average_year(self):
        '''
        summary: gets the average year from carYears
        parameters: NULL
        returns: NULL
        '''
        yearAvg = 0
        for year in self.carYears:
            yearAvg += year
        yearAvg /= 50
        return int(yearAvg)

newCatalog = CarCatalog()
newCatalog.load_cars()
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
        carList = sorted(newCatalog.carList, key=lambda car: car.make )
        for car in carList:
            print(f"{car.make.title() } {car.model.title() } - {car.year}" )
        print()
    elif userChoice == 2:
        # prompt user for a car make and print cars that match
        make = input("Enter the make: ").lower()
        make.replace(" ", "")
        newCatalog.get_cars_by_make(make)
        print()
    elif userChoice == 3:
        newCatalog.show_oldest_cars()
        print()
    elif userChoice == 4:
        print(f"The average car year is {int(newCatalog.get_average_year()) }")
        print()
    elif userChoice == 5:
        userQuit = True
    else:
        continue
