CREATE TABLE contacts(
    id SERIAL PRIMARY KEY,
    name TEXT,
    email TEXT
);

INSERT INTO contacts (name, email) VALUES ('john','john@example.com');
