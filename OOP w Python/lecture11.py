def square_it(num):
    try:
        result = int(num)
    except ValueError:
        result = "You must enter a integer only."
    else:
        result = int(n ** 2)
    finally:
        print("The result has been calculated.")
    return result

n = input("Enter a number:")

print(square_it(n))
