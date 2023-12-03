import redis
import random
import string
import time

# Konfiguracja połączenia z Redis
redis_host = "localhost"
redis_port = 6379
redis_password = ""

def random_string(length=10):
    letters = string.ascii_lowercase
    return ''.join(random.choice(letters) for i in range(length))

def perform_redis_operations(redis_conn, iterations=10000):
    keys = [f"key_{random_string()}" for _ in range(iterations)]

    # Zapis
    for key in keys:
        redis_conn.set(key, random_string())

    # Odczyt
    for key in keys:
        value = redis_conn.get(key)

    # Aktualizacja
    for key in keys:
        redis_conn.set(key, random_string())

if __name__ == "__main__":
    # Połączenie z Redis
    r = redis.StrictRedis(host=redis_host, port=redis_port, password=redis_password, decode_responses=True)

    for _ in range(1000):
        perform_redis_operations(r)
        time.sleep(1)
