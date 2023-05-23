INSERT INTO public.pet_diagnosis (diagnosis_id, pet_id, description, date) VALUES (1, 22, 'some disease', CURRENT_DATE);
INSERT INTO public.pet_diagnosis (diagnosis_id, pet_id, description, date) VALUES (2, 22, 'some disease', CURRENT_DATE - INTERVAL '1 month');
INSERT INTO public.pet_diagnosis (diagnosis_id, pet_id, description, date) VALUES (3, 22, 'some disease', CURRENT_DATE - INTERVAL '8 days');
INSERT INTO public.pet_diagnosis (diagnosis_id, pet_id, description, date) VALUES (4, 22, 'some disease', CURRENT_DATE - INTERVAL '9 days');
INSERT INTO public.pet_diagnosis (diagnosis_id, pet_id, description, date) VALUES (5, 22, 'some disease', CURRENT_DATE - INTERVAL '14 days');
INSERT INTO public.pet_diagnosis (diagnosis_id, pet_id, description, date) VALUES (6, 23, 'some disease', CURRENT_DATE);
INSERT INTO public.pet_diagnosis (diagnosis_id, pet_id, description, date) VALUES (7, 4, 'some disease', CURRENT_DATE);
INSERT INTO public.pet_diagnosis (diagnosis_id, pet_id, description, date) VALUES (8, 23, 'some disease', CURRENT_DATE);
INSERT INTO public.pet_diagnosis (diagnosis_id, pet_id, description, date) VALUES (9, 23, 'some disease', CURRENT_DATE);
INSERT INTO public.pet_diagnosis (diagnosis_id, pet_id, description, date) VALUES (10, 23, 'some disease', CURRENT_DATE);
INSERT INTO public.pet_diagnosis (diagnosis_id, pet_id, description, date) VALUES (11, 23, 'some disease', CURRENT_DATE);
INSERT INTO public.pet_diagnosis (diagnosis_id, pet_id, description, date) VALUES (12, 9, 'some disease', CURRENT_DATE);

SELECT setval('sequence_diagnosis', max(diagnosis_id)) FROM public.pet_diagnosis;
