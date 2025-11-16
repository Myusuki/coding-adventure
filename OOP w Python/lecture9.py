class Car:
    tires = 4
    engine = True
    steering_wheel = 1
    doors = 4

    def __init__(self, color = 'blue'):
        self.color = color
    def going(self, speed = 0):
        print(f"This car is going at {speed} mph.")

print(Car.tires)

Car.doors = 2
print(Car.doors)

suzuki = Car('silver')
suzuki.going(65)
toyota = Car('blue')
honda = Car('red')
jeep = Car('black')

print(suzuki.doors)
print(suzuki.color)
