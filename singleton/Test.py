string = input("Enter a string: ")
#Essa
#essa1
#12345
list = ["0","1","2","3","4","5","6","7","8","9"]
try:
    for character in string:
        if character in list:
            raise ValueError("Error")
    print("continue your work")
        
except:
    print("invalid input")
