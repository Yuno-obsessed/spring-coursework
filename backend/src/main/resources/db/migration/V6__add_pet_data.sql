INSERT INTO public.pet (id, "name", type_id, user_id) VALUES (1, 'Lassie', 1, 1);
INSERT INTO public.pet (id, "name", type_id, user_id) VALUES (2, 'Kitty', 2, 1);
INSERT INTO public.pet (id, "name", type_id, user_id) VALUES (3, 'Tweety', 3, 1);
INSERT INTO public.pet (id, "name", type_id, user_id) VALUES (4, 'Charlie', 5, 1);
INSERT INTO public.pet (id, "name", type_id, user_id) VALUES (5, 'Lucy', 7, 1);
INSERT INTO public.pet (id, "name", type_id, user_id) VALUES (6, 'Angel', 5, 2);
INSERT INTO public.pet (id, "name", type_id, user_id) VALUES (7, 'Odie', 8, 2);
INSERT INTO public.pet (id, "name", type_id, user_id) VALUES (8, 'Garfield', 4, 2);
INSERT INTO public.pet (id, "name", type_id, user_id) VALUES (9, 'Jack', 5, 3);
INSERT INTO public.pet (id, "name", type_id, user_id) VALUES (10, 'Tom', 6, 3);
INSERT INTO public.pet (id, "name", type_id, user_id) VALUES (11, 'Felix', 7, 3);
INSERT INTO public.pet (id, "name", type_id, user_id) VALUES (12, 'Kong', 3, 4);
INSERT INTO public.pet (id, "name", type_id, user_id) VALUES (13, 'Aldous', 2, 4);
INSERT INTO public.pet (id, "name", type_id, user_id) VALUES (14, 'Seraphima', 6, 4);
INSERT INTO public.pet (id, "name", type_id, user_id) VALUES (15, 'Rafaela', 4, 4);
INSERT INTO public.pet (id, "name", type_id, user_id) VALUES (16, 'Roger', 3, 5);
INSERT INTO public.pet (id, "name", type_id, user_id) VALUES (17, 'Lamey', 5, 5);
INSERT INTO public.pet (id, "name", type_id, user_id) VALUES (18, 'Duke', 2, 5);
INSERT INTO public.pet (id, "name", type_id, user_id) VALUES (19, 'Puck', 1, 6);
INSERT INTO public.pet (id, "name", type_id, user_id) VALUES (20, 'Fiend', 4, 6);
INSERT INTO public.pet (id, "name", type_id, user_id) VALUES (21, 'Nemo', 7, 7);
INSERT INTO public.pet (id, "name", type_id, user_id) VALUES (22, 'Helcurt', 8, 7);
INSERT INTO public.pet (id, "name", type_id, user_id) VALUES (23, 'Jersey', 6, 7);
INSERT INTO public.pet (id, "name", type_id, user_id) VALUES (24, 'Sunder', 8, 8);
INSERT INTO public.pet (id, "name", type_id, user_id) VALUES (25, 'Tommy', 2, 8);
INSERT INTO public.pet (id, "name", type_id, user_id) VALUES (26, 'Beatrix', 4, 8);
INSERT INTO public.pet (id, "name", type_id, user_id) VALUES (27, 'Melissa', 4, 8);
INSERT INTO public.pet (id, "name", type_id, user_id) VALUES (28, 'Ling', 2, 8);
INSERT INTO public.pet (id, "name", type_id, user_id) VALUES (29, 'Polpy', 3, 8);
INSERT INTO public.pet (id, "name", type_id, user_id) VALUES (30, 'Umir', 1, 9);
INSERT INTO public.pet (id, "name", type_id, user_id) VALUES (31, 'Medusa', 5, 9);
INSERT INTO public.pet (id, "name", type_id, user_id) VALUES (32, 'Fenrir', 1, 9);
INSERT INTO public.pet (id, "name", type_id, user_id) VALUES (33, 'George', 3, 9);
INSERT INTO public.pet (id, "name", type_id, user_id) VALUES (34, 'Baldr', 6, 9);
INSERT INTO public.pet (id, "name", type_id, user_id) VALUES (35, 'Soppy', 4, 10);
INSERT INTO public.pet (id, "name", type_id, user_id) VALUES (36, 'Angrboda', 2, 10);
INSERT INTO public.pet (id, "name", type_id, user_id) VALUES (37, 'Dazzle', 2, 10);
INSERT INTO public.pet (id, "name", type_id, user_id) VALUES (38, 'Juxy', 4, 10);
INSERT INTO public.pet (id, "name", type_id, user_id) VALUES (39, 'Ruby', 5, 10);
INSERT INTO public.pet (id, "name", type_id, user_id) VALUES (40, 'Willy', 7, 10);
INSERT INTO public.pet (id, "name", type_id, user_id) VALUES (41, 'Russel', 2, 10);
INSERT INTO public.pet (id, "name", type_id, user_id) VALUES (42, 'Blade', 8, 10);
INSERT INTO public.pet (id, "name", type_id, user_id) VALUES (43, 'Lord', 2, 11);
INSERT INTO public.pet (id, "name", type_id, user_id) VALUES (44, 'Diddo', 3, 11);
INSERT INTO public.pet (id, "name", type_id, user_id) VALUES (45, 'Spooky', 6, 11);
INSERT INTO public.pet (id, "name", type_id, user_id) VALUES (46, 'Luxos', 7, 11);
INSERT INTO public.pet (id, "name", type_id, user_id) VALUES (47, 'Aamon', 7, 11);
INSERT INTO public.pet (id, "name", type_id, user_id) VALUES (48, 'Argus', 3, 11);
INSERT INTO public.pet (id, "name", type_id, user_id) VALUES (49, 'Qwinke', 1, 12);
INSERT INTO public.pet (id, "name", type_id, user_id) VALUES (50, 'Desole', 3, 12);
INSERT INTO public.pet (id, "name", type_id, user_id) VALUES (51, 'Korney', 2, 12);
INSERT INTO public.pet (id, "name", type_id, user_id) VALUES (52, 'Nimbus', 1, 12);

SELECT setval('sequence_pet', max(id)) FROM public."pet";