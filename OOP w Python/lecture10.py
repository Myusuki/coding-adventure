class Car:
    total_cars = 0
    car_years = []
    def __init__(self, year = 2000):
        Car.total_cars += 1
        Car.car_years.append(int(year))

    @classmethod
    def get_total_cars(cls):
        print(f"There have been {cls.total_cars} cars created.")

