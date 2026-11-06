CREATE TABLE supplies (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          item_name VARCHAR(100) UNIQUE NOT NULL,
                          quantity INT NOT NULL CHECK (quantity >= 0)
);

CREATE TABLE requests (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          item_name VARCHAR(100) NOT NULL,
                          quantity INT NOT NULL,
                          status VARCHAR(20) NOT NULL,
                          requested_by VARCHAR(100) NOT NULL
);