INSERT INTO roles (name) VALUES ('ROLE_USER');
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');
INSERT INTO roles (name) VALUES ('ROLE_MODERATOR');



INSERT INTO users (firstname, lastname, email, password)
VALUES ('John', 'Doe', 'johndoe@example.com', 'encrypted_password');

-- Aggiungi un ruolo per l'utente nella tabella di join (user_roles)
INSERT INTO user_roles (user_id, role_id)
VALUES (1, 1);  -- Assumendo che l'utente con id 1 ha il ruolo con id 1 (ROLE_USER)


INSERT INTO users (firstname, lastname, email, password)
VALUES ('John', 'Doe', 'johndoe@example.com', 'password123');

INSERT INTO user_roles (user_id, role_id)
VALUES (2, 2);  -- Assumendo che l'utente con id 1 ha il ruolo con id 1 (ROLE_USER)