# mongoldb-project

Project 2 Spec
April 3, 2018
 
OUTLINE
The database will contain data about pets available for adoption. Pet types will include (but are not limited to) dogs, cats, birds, and some reptiles. It should contain any information pertaining to the pet (if known) such as name, date of birth, breed(s), registration info, shots, spayed/neutered, appropriate diet, medical conditions, etc. The database should also contain customer/adopter information.
 
 
USE CASES
1.     User would like to see what dogs are available for adoption.
a.     User picks ‘dog’ from pet types and searches DB.
b.     All dogs are returned.
 
2.     User is interested in a certain cat and would like to see what shots it has had.
a.     User picks ‘cat’ from pet types and searches DB (or search by name).
b.     User selects desired cat.
c.     All info pertaining to the cat is displayed.
 
3.     User wants to see if a certain dog is still available for adoption.
a.     User picks ‘dog’ from pet types and searches DB (or search by name).
b.     User selects desired dog.
c.     All info pertaining to the dog is displayed.
 
4.     User would like to see if a certain animal has been adopted before.
a.     User searches DB using the animal’s name.
b.     All info pertaining to the animal is displayed.
 
5.     User would like to see all cats less than a year old.
a.     User selects ‘cat’ from pet types.
b.     User selects age range 0 to 1 year and searches DB.
c.     All cats a year old or younger are displayed.
 
 
DEVELOPER NOTES
Include where the pet came from (i.e. another shelter, rescue, abandoned)
Location of the pet (i.e. foster home, in-shelter)
Boolean?
Keep information about the pet even after it is adopted
Tag pet with owner information
Keep list of past owners/locations
Array of strings?
Ability to return a pet due to complications

NORMALIZATION / DENORMALIZATION
One way we used denormalization is by containing everything in the PetShelter collection. The reason we decided to do this was to provide simplicity to the user, and so that everything regarding a given pet is returned when it is retrieved from the database.
Another instance where we used denormalization is in keeping track of past owners. The user is able to do this with an array and the array is contained within the pet document.

DESIGN DECISIONS
We decided on using a simple text based menu-driven application for the purpose of this project to be able to focus on the logic of our Python program instead of focusing on appearance.
Simplicity and flexibility were probably the biggest factors we had in mind when designing the program as a whole - for example with the search option you can search for any term or value
Searching - decided to search document represented as string (allows easier case insensitivity and searching for multiple fields)
We utilize the existing MongoDB security to separate owners and employees
Lack of formatting because of the flexibility of fields

LANGUAGE
Python
Our group chose Python because it is something new for us to work and be able to read and write in the near future for jobs/experience. The logic was the same but the challenge came to find how the syntax on Python works compared to Java. 

Working with Python
Since we are doing a real-world project , we took considerations such as cost,availability, investment. Python was the best option for the investment our clients had in mind. Why did we chose python ? We all know that python is expected to run slower than Java program, but since our client did not have a high budget, with python takes less money and less time to develop. 

Comparing Python x Java
Python x Java? Yes. Python is 3-5 times shorter than equivalent java programs. Python has built-in high level data types and the dynamic typing. Since we are talking about money and time, an example would be wasting time declaring data types of arguments or variables. Python has its polymorphic list and dictionary types. As mention before python runs slower that Java, because when there's simple operations such as x+y, python will then identify what data types which are not known at compile time, it then python will start the addition and comparing to Java which perform with more efficiency but requires variable declaration without overloading the operator. 

GROUP WORK
Itamar - researched MongoDB security, view all function
Ryan - search_pets, parse_string, insert, search, update, and delete functions, researched case-insensitivity

DIAGRAM

{
    "_id":"5ae8b43ffc43ee9bdbee7aca",
    "name":"itamar",
    "breed":"german shepherd",
    "age":4,
    "siblings":["buster","jack"],
    "origin":"home",
    "past_owners":["Daniels"],
    "description":"Very friendly and protective. Doesn't get along well with other dogs.",
    "adoption_fee": 129.99,
    "available": true
}

DEMO -
Find your favorite Pet
