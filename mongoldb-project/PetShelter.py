from pymongo import MongoClient
from pprint import pprint
from bson.json_util import dumps
import urllib.parse

# Gather username and password input from user
username = urllib.parse.quote_plus(input('User: '))
password = urllib.parse.quote_plus(input('Password: '))

# Connect to MongoDB using username and password with database specified
client = MongoClient('mongodb://%s:%s@localhost:27017/PetShelter' % (username, password))

# Variable for database
db = client['PetShelter']

def admin_main():

    while(1):
    # chossing option to do CRUD operations
        print('\nPet Shelter Main Menu - Admin')
 
        selection = input('\t1: Add a pet\n\t2: Update a pet\n\t3: View all pets\n\t4: Delete a pet\n\t5: Search for a pet\n\t0: Exit\n')
        
        if selection == '1':
            insert()
        elif selection == '2':
            update()
        elif selection == '3':
            read()
        elif selection == '4':
            delete()
        elif selection == '5':
            search()
        elif selection == '0':
            print('Goodbye!')
            break
        else:
            print ('\n INVALID SELECTION \n')
            
def user_main():
    while(1):
    # chossing option to do CRUD operations
        print('\nPet Shelter Main Menu - User')
 
        selection = input('\t1: View all pets\n\t2: Search for a pet\n\t0: Exit\n')
        
        if selection == '1':
            read()
        elif selection == '2':
            search()
        elif selection == '0':
            print('Goodbye!')
            break
        else:
            print ('\n INVALID SELECTION \n')
            
def search_pets(keywords):
    matching_pets = []
    pets = db.Pets.find({})
    # print(keywords)
    for pet in pets:
        pet_string = dumps(pet).lower().replace('"', '')
        # print('pet_string: ' + pet_string)
        for keyword in keywords:
            if keyword in pet_string:
                matching_pets.append(pet)
    return matching_pets

def parse_string(type, value):
    type = type.lower().strip()
    if type == 's':
        return str(value)
    elif type == 'n':
        return float(value)
    elif type == 'b':
        value = value.lower().strip()
        if value == 't' or value == 'true' or value == 'yes' or value == 'y':
            return True
        elif value == 'f' or value == 'false' or value == 'no' or value == 'n':
            return False
    elif type == 'a-s':
        results = []
        for e in value.split(','):
            results.append(e.strip())
        return results
    elif type == 'a-n':
        result = []
        for e in value.split(','):
            result.append(float(e))
        return result
    return None
        

# Function to insert data into mongo db

def insert():
    print('### NEW PET ###')
    print('Enter \\done for field to finish.\nType can be: s (default), n, b, a-s, a-n')
    pet = {}
    done = False
    while (not done):
        field = input('field: ').lower() # Field is always lowercase
        if (field == '\\done'):
            done = True
        else:
            type = input('type: ')
            type = 's' if type == '' else type
            # print('type = ' + type)
            value = parse_string(type, input('value: '))
            pet[field] = value
    if (bool(pet)): # Check if dictionary is empty
        db.Pets.insert_one(pet)
        print('Created a new pet')
    else:
        print('No data to insert')

def search():
    print('### SEARCH PETS ###')
    pets = search_pets(input('Matching keywords (,): ').lower().split(','))
    for pet in pets:
        pprint(pet)
        
def update():
    print('### UPDATE PET ###')
    pets = search_pets(input('Matching keywords (,): ').lower().split(','))
    if (len(pets)) > 0:
        pet = pets[0]
        pprint(pet)
        if input('Update this pet? (y/*): ').lower().strip() == 'y':
            print('Enter \\done for field to finish.\nType can be: s (default), n, b, a-s, a-n')
            done = False
            pet_id = pet['_id']
            pet_update = {}
            while (not done):
                field = input('field: ').lower() # Field is always lowercase
                if (field == '\\done'):
                    done = True
                else:
                    type = input('type: ')
                    type = 's' if type == '' else type
                    # print('type = ' + type)
                    value = parse_string(type, input('value: '))
                    pet_update[field] = value
            if (bool(pet)): # Check if dictionary is empty
                db.Pets.update_one({'_id': pet_id}, {"$set": pet_update}, upsert=False)
                print('Updated the pet')
            else:
                print('No data to update')
    else:
        print('Search returned no results.')
    
def read():
    try:
        petCol = db.Pets.find({})
        print('All Available Pets from Shelter Database \n')
        for pet in petCol:
            pprint(pet)

    except Exception as e:
        print("Error {0}".format(str(e.args[0])).encode("utf-8"))

def delete():
    # Implement search and delete
    print('### DELETE PETS ###')
    pets = search_pets(input('Matching keywords (,): ').lower().split(','))
    for pet in pets:
        print(str(pet))
        confirm = (input('Are you sure you want to delete this pet? (y/*): ').lower() == 'y')
        print()
        if confirm:
            db.Pets.delete_one({'_id': pet['_id']})
            

# Authentication
try:
    usersInfo = db.command({'usersInfo': 1})
    for user in usersInfo['users']:
        # pprint(user)
        if user['user'] == username:
            if user['roles'][0]['role'] == 'read':
                user_main()
            elif user['roles'][0]['role'] == 'readWrite':
                admin_main()
except:
    print('Invalid user credentials.')
    

use admin
db.createUser(
  {
    user: "admin",
    pwd: "abc123",
    roles: [ { role: "readWrite", db: "PetShelter" } ]
  }
)
  
