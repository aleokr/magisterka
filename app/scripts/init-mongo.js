db = db.getSiblingDB('test');
db.createCollection("users");
db.users.createIndex({name: 1});

db.runCommand(
    {
        collMod: "users",
        validator: {
            $jsonSchema: {
                bsonType: "object",
                required: ["name", "age", "height", "birthDate", "isAvailable"],
                properties: {
                    name: {
                        bsonType: "string",
                        description: "Name must be a string",
                        minLength: 2,
                        maxLength: 20
                    },
                    age: {
                        bsonType: "int",
                        minimum: 0,
                        maximum: 120,
                        description: "Value must be a positive integer in range 0 - 120"
                    },
                    height: {
                        bsonType: "double",
                        minimum: 0,
                        maximum: 3.0,
                        description: "Height must be a positive double in range 0.0 - 3.0"
                    },
                    birthDate: {
                        bsonType: "date",
                        description: "BirthDate must be a date"
                    },
                    isAvailable: {
                        bsonType: "bool",
                        description: "isAvailable must be a boolean"
                    }
                }
            }
        },
        validationLevel: "strict",
        validationAction: "error"
    }
);
