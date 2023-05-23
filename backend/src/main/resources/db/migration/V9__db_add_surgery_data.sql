INSERT INTO public.surgery (surgery_id, pet_id, description, difficulty, date) VALUES (1, 22, 'surgery_1', 4, CURRENT_DATE - INTERVAL  '2 months');
INSERT INTO public.surgery (surgery_id, pet_id, description, difficulty, date) VALUES (2, 22, 'surgery_2', 3, CURRENT_DATE - INTERVAL '7 days');
INSERT INTO public.surgery (surgery_id, pet_id, description, difficulty, date) VALUES (3, 22, 'surgery_3', 6, CURRENT_DATE - INTERVAL '5 days');
INSERT INTO public.surgery (surgery_id, pet_id, description, difficulty, date) VALUES (4, 22, 'surgery_4', 9, CURRENT_DATE - INTERVAL '3 days');
INSERT INTO public.surgery (surgery_id, pet_id, description, difficulty, date) VALUES (5, 22, 'surgery_5', 2, CURRENT_DATE + INTERVAL '2 days');
INSERT INTO public.surgery (surgery_id, pet_id, description, difficulty, date) VALUES (6, 23, 'surgery_6', 1, CURRENT_DATE + INTERVAL '1 day');
INSERT INTO public.surgery (surgery_id, pet_id, description, difficulty, date) VALUES (7, 23, 'surgery_6', 6, CURRENT_DATE + INTERVAL '4 days');
INSERT INTO public.surgery (surgery_id, pet_id, description, difficulty, date) VALUES (8, 23, 'surgery_6', 3, CURRENT_DATE + INTERVAL '7 days');
INSERT INTO public.surgery (surgery_id, pet_id, description, difficulty, date) VALUES (9, 23, 'surgery_6', 1, CURRENT_DATE + INTERVAL '15 days');

SELECT setval('sequence_surgery', max(surgery_id)) FROM public.surgery;
