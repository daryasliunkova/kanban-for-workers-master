INSERT INTO User(id, surname, name, role, created_date, link_google, login, password) VALUES(1, 'Ivanov', 'Ivan', 'CUSTOMER', '2018-11-25', 'http://link', 'testuser', '123');
INSERT INTO User(id, surname, name, role, created_date, link_google, login, password) VALUES(2, 'Petrov', 'Petr', 'MASTER', '2018-11-25', 'http://link', 'testuser1', '123');

INSERT INTO Car(id, owner_id, make, car_number, model, color, year, vin)
VALUES(1, 2, 'BMW', '3355 EB-3', 'X5', 'black', 2017, 'jk45j323');

INSERT INTo repair_case(id, case_id, car_id, user_id, name, description, start_date, end_date, case_status)
VALUES(1, null, 1, 1, 'Main problem', 'Problem with accumulator', '2018-11-26', null, 'BROKEN');

INSERT INTO history_item(id, issue_id, user_id, status, change_date, description, old_value, new_value)
VALUES(1, 1, 1, 'ADDED', '2018-11-28', 'Case added', null, null);

INSERT INTO flow(id, next_steps, role)
VALUES('BROKEN', 'IN_PROGRESS;PAUSE;REJECTED', 'MASTER');

INSERT INTO flow(id, next_steps, role)
VALUES('IN_PROGRESS', 'READY;PAUSE;REJECTED', 'MASTER');

INSERT INTO flow(id, next_steps, role)
VALUES('READY', 'OK', 'CUSTOMER');

INSERT INTO flow(id, next_steps, role)
VALUES('PAUSE', 'IN_PROGRESS;REJECTED', 'MASTER');

INSERT INTO flow(id, next_steps, role)
VALUES('REJECTED', 'BROKEN;OK', 'CUSTOMER');

INSERT INTO flow(id, next_steps, role)
VALUES('OK', 'BROKEN', 'CUSTOMER');
