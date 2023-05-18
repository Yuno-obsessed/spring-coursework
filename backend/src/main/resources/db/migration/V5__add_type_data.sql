INSERT INTO public."type" (id, "name", description) VALUES (1, 'Dog', null);
INSERT INTO public."type" (id, "name", description) VALUES (2, 'Cat', null);
INSERT INTO public."type" (id, "name", description) VALUES (3, 'Bird', null);
INSERT INTO public."type" (id, "name", description) VALUES (4, 'Frog', null);
INSERT INTO public."type" (id, "name", description) VALUES (5, 'Snake', null);
INSERT INTO public."type" (id, "name", description) VALUES (6, 'Pig', null);
INSERT INTO public."type" (id, "name", description) VALUES (7, 'Fish', null);
INSERT INTO public."type" (id, "name", description) VALUES (8, 'Spider', null);

SELECT setval('sequence_type', max(id)) FROM public."type";