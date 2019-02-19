import json
def jsondata(firstname, lastname):
    name = {}
    name["firstname"] = firstname
    name["lastname"] = lastname
    return json.dumps(name)

if __name__ == "__main__":
    firstname = input("Please Enter your first name.\n")
    lastname = input("Please Enter your last name.\n")
    if len(firstname)>0 and len(lastname)>0:
        print("Json object: ", jsondata(firstname, lastname))
    else:
        print("Incorrect input")
