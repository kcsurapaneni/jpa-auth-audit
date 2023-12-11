-- authority data

INSERT INTO authority
    (id, name)
VALUES
    (1, 'normal'),
    (2, 'premium');

-- customer table data
-- password (password)
INSERT INTO customer
    (id, name, username, password, authority_id)
VALUES
    (1, 'KC', 'kcsurapaneni', '$2a$10$C6454pQIMqMNW76.M8NjYOzvniTgqdl8unnjnWNnMXmkGqE1M9CSC', 1),
    (2, 'KC', 'krishna', '$2a$10$C6454pQIMqMNW76.M8NjYOzvniTgqdl8unnjnWNnMXmkGqE1M9CSC', 2),
    (3, 'KC', 'chaitanya', '$2a$10$C6454pQIMqMNW76.M8NjYOzvniTgqdl8unnjnWNnMXmkGqE1M9CSC', 1);


-- role table data

INSERT INTO role
    (id, name)
VALUES
    (1, 'ROLE_read'),
    (2, 'ROLE_editor'),
    (3, 'ROLE_admin');


-- client table data
-- password (secured)

INSERT INTO client
    (id, name, username, password, address)
VALUES
    (1, 'kfc', 'kfc', '$2a$10$Gnuih1/NZ36TXu.K3GEc.eseoIVxBgZyd0Xx5rbdP7.c18WwcPbDS', 'USA'),
    (2, 'hyderabad house', 'hhouse', '$2a$10$Gnuih1/NZ36TXu.K3GEc.eseoIVxBgZyd0Xx5rbdP7.c18WwcPbDS', 'India'),
    (3, 'Tim Hortons', 'hortons', '$2a$10$Gnuih1/NZ36TXu.K3GEc.eseoIVxBgZyd0Xx5rbdP7.c18WwcPbDS', 'Canada');


-- client_roles

INSERT INTO client_roles
    (client_id, role_id)
VALUES
    (1, 1),
    (1, 2),
    (2, 1),
    (2, 2),
    (2, 3),
    (3, 2),
    (3, 3);