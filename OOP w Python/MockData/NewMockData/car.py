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

# print a simple friendly string and a debug string on a car object
if __name__ == "__main__":
    newCar = Car("Toyota", "2013", "Camry")
    print( newCar.__str__() )
    print( newCar.__repr__() )
