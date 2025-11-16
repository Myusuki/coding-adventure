from pathlib import Path
from car import Car
class CarCatalog:
    def __init__(self, catalog = Path.cwd()/"cars.csv"):
        self.catalog = catalog
        self.carList = []
    def load_cars(self):
        with open(self.catalog, mode = 'r') as file:
            carData = file.readlines()
            # self.carList = [Car() for car in carData]
        newList = []
        for data in carData:
            data = data.replace("\n", "")
            cleanedData = data.split(",")
            newCar = Car(cleanedData[0], cleanedData[2], cleanedData[1])
            self.carList.append(newCar)

if __name__ == "__main__":
    newCatalog = CarCatalog()
    newCatalog.load_cars()
    for car in newCatalog.carList:
        print( car.GetCarDebug() )
