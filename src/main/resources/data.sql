INSERT INTO user (username, password, name, role, status) VALUES ('ice', 'ice', 'Ivan Krstic', 'ROLE_ADMIN', 1);

INSERT INTO invoice_counter (value) VALUES (2);

INSERT INTO measurement (name, desciption, status) VALUES ('m', 'Duzni metar', 1);
INSERT INTO measurement (name, desciption, status) VALUES ('m²', 'Kvadratni metar', 1);
INSERT INTO measurement (name, desciption, status) VALUES ('m³', 'Kubni metar', 1);
INSERT INTO measurement (name, desciption, status) VALUES ('kg', '', 1);
INSERT INTO measurement (name, desciption, status) VALUES ('l', '', 1);
INSERT INTO measurement (name, desciption, status) VALUES ('Paušalno', '', 1);

INSERT INTO client (name, zip_code, city, street, house_number, email, phone, status) VALUES ('Ivan Krstić', '11000', 'Beograd', 'Vojvode Stepe', '79/7', 'krstic.d.ivan@gmail.com', '+381638339062', 1);
INSERT INTO client (name, zip_code, city, street, house_number, status) VALUES ('Draža Krstić', '12000', 'Požarevac', 'Čede Vasovića', '45/12', 1);
INSERT INTO client (name, zip_code, city, street, house_number, status) VALUES ('Bojan Krstić', '74613', 'Öhringen', 'Rathausstraße', '10', 1);

INSERT INTO company (name, zip_code, city, street, house_number, email, phone, status) VALUES ('Bojan Krstić', '74613', 'Öhringen', 'Rathausstraße', '10', 'fliesenleger.sitic@gmail.com', '+49 (0) 162-95-449-252', 1);

INSERT INTO service (name, price, measurement_id, status) VALUES ('Fugovanje pločica', 10.15, 2, 1);
INSERT INTO service (name, price, measurement_id, status) VALUES ('Postavljanje pločica', 9.95, 2, 1);

INSERT INTO invoice (number, status, CLIENT_ID) VALUES ('01/2017', 1, 1);
INSERT INTO invoice (number, status, CLIENT_ID) VALUES ('02/2017', 1, 1);

INSERT INTO invoice_item (INVOICE_ID, SERVICE_ID, quantity) VALUES (1, 1, 2);
INSERT INTO invoice_item (INVOICE_ID, SERVICE_ID, quantity) VALUES (1, 2, 4);
INSERT INTO invoice_item (INVOICE_ID, SERVICE_ID, quantity) VALUES (2, 2, 5);