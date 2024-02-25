CREATE TABLE item
(
    id    SERIAL PRIMARY KEY,
    nome  VARCHAR(100)   NOT NULL,
    preco NUMERIC(10, 2) NOT NULL
);

CREATE TABLE estoque
(
    id         SERIAL PRIMARY KEY,
    quantidade INTEGER NOT NULL,
    id_item    INTEGER REFERENCES item (id) ON DELETE CASCADE
);