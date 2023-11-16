CREATE TABLE IF NOT EXISTS delivery_address
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    street VARCHAR(64) NOT NULL,
    house VARCHAR(32) NOT NULL,
    apartment VARCHAR(32) NOT NULL
);

CREATE TABLE IF NOT EXISTS categories
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(128) NOT NULL
    );

CREATE TABLE IF NOT EXISTS products
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(64) NOT NULL,
    category_id INT REFERENCES categories (id),
    description TEXT(2048),
    price DECIMAL(4,2) NOT NULL
    );

CREATE TABLE IF NOT EXISTS buckets
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT REFERENCES users (id),
    amount DECIMAL(4,2)
    );

CREATE TABLE IF NOT EXISTS orders
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT REFERENCES users (id),
    amount DECIMAL(4,2) NOT NULL,
    delivery_address_id INT REFERENCES delivery_address (id)
    );

CREATE TABLE IF NOT EXISTS users
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(128) NOT NULL,
    password VARCHAR(128) NOT NULL,
    role VARCHAR(128) NOT NULL,
    mobile_number LONG NOT NULL,
    email VARCHAR(128) NOT NULL,
    bucket_id INT REFERENCES buckets (id)
    );

CREATE TABLE IF NOT EXISTS black_list
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT REFERENCES users (id),
    date_added TIMESTAMP NOT NULL,
    reason_added VARCHAR(256) NOT NULL
);

CREATE TABLE IF NOT EXISTS products_orders
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    product_id INT REFERENCES products (id),
    order_id INT REFERENCES orders (id)
);

CREATE TABLE IF NOT EXISTS products_buckets
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    product_id INT REFERENCES products (id),
    bucket_id INT REFERENCES buckets (id)
);