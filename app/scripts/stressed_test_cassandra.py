from cassandra.cluster import Cluster
from cassandra import ConsistencyLevel
from uuid import uuid4
from random import choice, randint
import time

# Konfiguracja połączenia
cluster = Cluster(['127.0.0.1'])  # Adresy IP węzłów Cassandra

session = cluster.connect()
keyspace = 'userkeyspace'
session.default_consistency_level = ConsistencyLevel.ALL

# Tworzenie tabeli, jeśli nie istnieje
session.execute(f'''
    CREATE KEYSPACE IF NOT EXISTS {keyspace}
    WITH replication = {{'class': 'SimpleStrategy', 'replication_factor': '3'}};
''')

session.set_keyspace(keyspace)

session.execute('''
CREATE TABLE IF NOT EXISTS users (
    id UUID PRIMARY KEY,
    name TEXT,
    age text,
    height text,
    birthDate text,
    isAvailable text
);
''')

# Generowanie losowych danych
def generate_random_data():
    names = ['Alice', 'Bob', 'Carol', 'Dave', 'Eve']
    is_available = ['true', 'false']
    return {
        'id': uuid4(),
        'name': choice(names),
        'age': str(randint(18, 100)),
        'height': str(randint(150, 200)),
        'birthDate': f'19{randint(50, 99)}-{randint(1, 12):02d}-{randint(1, 28):02d}',
        'isAvailable': choice(is_available)
    }

# Operacje zapisu
def write_data():
    for _ in range(1000):  # Liczba rekordów do zapisania
        data = generate_random_data()
        session.execute(
            '''
            INSERT INTO users (id, name, age, height, birthDate, isAvailable)
            VALUES (%s, %s, %s, %s, %s, %s)
            ''',
            (data['id'], data['name'], data['age'], data['height'], data['birthDate'], data['isAvailable']),
        )

# Operacje odczytu
def read_data():
    for _ in range(10000):
        session.execute(
            'SELECT * FROM users LIMIT 1;',
        )

# Operacje aktualizacji
def update_data():
    for _ in range(1000):  # Liczba rekordów do zaktualizowania
        data = generate_random_data()
        session.execute(
            '''
            UPDATE users SET name = %s, age = %s, height = %s, birthDate = %s, isAvailable = %s
            WHERE id = %s
            ''',
            (data['name'], data['age'], data['height'], data['birthDate'], data['isAvailable'], data['id']),
        )

# Uruchamianie operacji
for _ in range(10):
    write_data()
    read_data()
    update_data()
    time.sleep(5)


# Zamykanie połączenia
cluster.shutdown()
