INSERT INTO measurement (name, desciption) VALUES ('m', 'Duzni metar');
INSERT INTO measurement (name, desciption) VALUES ('m²', 'Kvadratni metar');
INSERT INTO measurement (name, desciption) VALUES ('m³', 'Kubni metar');
INSERT INTO measurement (name, desciption) VALUES ('kg', '');
INSERT INTO measurement (name, desciption) VALUES ('l', '');
INSERT INTO measurement (name, desciption) VALUES ('Paušalno', '');

INSERT INTO client (name, zip_code, city, street, house_number, status) VALUES ('Ivan Krstic', '12000', 'Požarevac', 'Čede Vasovića', '45/12', 1);

INSERT INTO service (name, price, measurement_id, status) VALUES ('Fugovanje pločica', 10.15, 2, 1);
INSERT INTO service (name, price, measurement_id, status) VALUES ('Postavljanje pločica', 9.95, 2, 1);

INSERT INTO invoice (number, status, CLIENT_ID) VALUES ('01/2017', 1, 1);
INSERT INTO invoice (number, status, CLIENT_ID) VALUES ('02/2017', 1, 1);

INSERT INTO invoice_item (INVOICE_ID, ID, SERVICE_ID, quantity) VALUES (1, 1, 1, 2);
INSERT INTO invoice_item (INVOICE_ID, ID, SERVICE_ID, quantity) VALUES (1, 2, 2, 4);
INSERT INTO invoice_item (INVOICE_ID, ID, SERVICE_ID, quantity) VALUES (2, 1, 2, 5);