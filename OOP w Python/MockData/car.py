class Car:
    def __init__(self, make:str, year:int, model:str):
        self.make = make
        self.year = year
        self.model = model
    def GetCar(self) -> str:
        return f"{self.make.title()} {self.model.title()} - {int(self.year)}"
    def GetCarDebug(self) -> str:
        return f"Make: {self.make.title()}, Model: {self.model.title()}, Year: {int(self.year)}"

if __name__ == "__main__":
    newCar = Car("Toyota", "2013", "Camry")
    print( newCar.GetCar() )
    print( newCar.GetCarDebug() )
