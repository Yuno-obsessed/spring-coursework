INSERT INTO public.pet_diagnosis (diagnosis_id, pet_id, description, date) VALUES (1, 12, 'some disease', CURRENT_DATE - INTERVAL '5 months');
INSERT INTO public.pet_diagnosis (diagnosis_id, pet_id, description, date) VALUES (2, 12, 'some disease', CURRENT_DATE - INTERVAL '3 months');
INSERT INTO public.pet_diagnosis (diagnosis_id, pet_id, description, date) VALUES (3, 12, 'some disease', CURRENT_DATE - INTERVAL '2 months');
INSERT INTO public.pet_diagnosis (diagnosis_id, pet_id, description, date) VALUES (4, 13, 'some disease', CURRENT_DATE - INTERVAL '20 days');
INSERT INTO public.pet_diagnosis (diagnosis_id, pet_id, description, date) VALUES (5, 13, 'some disease', CURRENT_DATE - INTERVAL '4 days');
INSERT INTO public.pet_diagnosis (diagnosis_id, pet_id, description, date) VALUES (6, 14, 'some disease', CURRENT_DATE - INTERVAL '1 day');
INSERT INTO public.pet_diagnosis (diagnosis_id, pet_id, description, date) VALUES (7, 14, 'some disease', CURRENT_DATE);
INSERT INTO public.pet_diagnosis (diagnosis_id, pet_id, description, date) VALUES (8, 14, 'some disease', CURRENT_DATE - INTERVAL '1 month');
INSERT INTO public.pet_diagnosis (diagnosis_id, pet_id, description, date) VALUES (9, 14, 'some disease', CURRENT_DATE - INTERVAL '8 days');
INSERT INTO public.pet_diagnosis (diagnosis_id, pet_id, description, date) VALUES (10, 22, 'some disease', CURRENT_DATE - INTERVAL '9 days');
INSERT INTO public.pet_diagnosis (diagnosis_id, pet_id, description, date) VALUES (11, 22, 'some disease', CURRENT_DATE - INTERVAL '14 days');
INSERT INTO public.pet_diagnosis (diagnosis_id, pet_id, description, date) VALUES (12, 23, 'some disease', CURRENT_DATE);
INSERT INTO public.pet_diagnosis (diagnosis_id, pet_id, description, date) VALUES (13, 4, 'some disease', CURRENT_DATE);
INSERT INTO public.pet_diagnosis (diagnosis_id, pet_id, description, date) VALUES (14, 23, 'some disease', CURRENT_DATE);
INSERT INTO public.pet_diagnosis (diagnosis_id, pet_id, description, date) VALUES (15, 23, 'some disease', CURRENT_DATE);
INSERT INTO public.pet_diagnosis (diagnosis_id, pet_id, description, date) VALUES (16, 23, 'some disease', CURRENT_DATE);
INSERT INTO public.pet_diagnosis (diagnosis_id, pet_id, description, date) VALUES (17, 23, 'some disease', CURRENT_DATE);
INSERT INTO public.pet_diagnosis (diagnosis_id, pet_id, description, date) VALUES (18, 9, 'some disease', CURRENT_DATE);

SELECT setval('sequence_diagnosis', max(diagnosis_id)) FROM public.pet_diagnosis;
