INSERT INTO ad (ad_id, name, price, description, creation_date) VALUES (1, 'first', 21.42, 'hello', CURRENT_TIMESTAMP);
INSERT INTO ad (ad_id, name, price) VALUES (2, 'second', 42.21);
INSERT INTO ad (ad_id, name, price) VALUES (3, 'third', 0.69);
INSERT INTO photos (photo_id, ad_id, photos) VALUES (1, 3, 'hello');
INSERT INTO photos (photo_id, ad_id, photos) VALUES (2, 3, 'world');