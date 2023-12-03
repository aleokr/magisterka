from pymongo import MongoClient
import random
import string
import time

# Konfiguracja połączenia
client = MongoClient('mongodb://localhost:27017/')
db = client['test']
collection = db['users']

# Funkcje pomocnicze
def random_string(length=10):
    return ''.join(random.choice(string.ascii_lowercase) for _ in range(length))

def random_birthdate():
    year = random.randint(1940, 2010)
    month = random.randint(1, 12)
    day = random.randint(1, 28)
    return f"{year}-{month:02d}-{day:02d}"

# Testy obciążeniowe
def write_data():
    for _ in range(1000):
        user = {
            "name": random_string(),
            "age": str(random.randint(18, 100)),
            "height": str(random.randint(150, 200)),
            "birthDate": random_birthdate(),
            "isAvailable": random.choice(['true', 'false'])
        }
        collection.insert_one(user)

def read_data():
    for _ in range(1000):
        user_id = collection.find_one({}, {"_id": 1})["_id"]
        user = collection.find_one({"_id": user_id})

def update_data():
    for _ in range(1000):
        user_id = collection.find_one({}, {"_id": 1})["_id"]
        new_age = str(random.randint(18, 100))
        collection.update_one({"_id": user_id}, {"$set": {"age": new_age}})

# Wykonanie testów obciążeniowych
for _ in range(1000):
    write_data()
    read_data()
    update_data()
    # time.sleep(5)
# Zamykanie połączenia z bazą danych
client.close()
