CREATE KEYSPACE IF NOT EXISTS userKeyspace WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 1};

USE userKeyspace;

-- walidacja schematu - jeśli inne testy to zakomentować
CREATE TABLE IF NOT EXISTS users
(
    id          UUID PRIMARY KEY,
    name        TEXT,
    age         INT,
    height      DOUBLE,
    birthDate   DATE,
    isAvailable BOOLEAN
);

-- pozosałe
CREATE TABLE IF NOT EXISTS users
(
    id          UUID PRIMARY KEY,
    name        TEXT,
    age         text,
    height      text,
    birthDate   text,
    isAvailable text
);