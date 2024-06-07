CREATE TABLE IF NOT EXISTS client (
    id SERIAL PRIMARY KEY,
    nui VARCHAR(13) UNIQUE NOT NULL,
    fullname VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    email VARCHAR (100)
    );

CREATE TABLE IF NOT EXISTS product (
    id SERIAL PRIMARY KEY,
    description VARCHAR(200) NOT NULL,
    brand VARCHAR(100),
    price DECIMAL(7,2) DEFAULT 0.00,
    stock INT
    );

CREATE TABLE IF NOT EXISTS invoice (
    id SERIAL PRIMARY KEY,
    code VARCHAR(17) UNIQUE,
    create_at DATE,
    total DECIMAL(7,2),
    client_id INT,
    FOREIGN KEY (client_id) REFERENCES client(id),
    UNIQUE (code)
    );

CREATE TABLE IF NOT EXISTS detail (
    id SERIAL PRIMARY KEY,
    quantity INT NOT NULL,
    price DECIMAL(7,2),
    subtotal DECIMAL(7,2) GENERATED ALWAYS AS(price*quantity) STORED,
    invoice_id INT,
    product_id INT,
    FOREIGN KEY (invoice_id) REFERENCES invoice(id),
    FOREIGN KEY (product_id) REFERENCES product(id),
    UNIQUE (invoice_id, product_id)
    );
