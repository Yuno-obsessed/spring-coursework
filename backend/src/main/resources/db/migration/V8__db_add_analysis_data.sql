INSERT INTO public.pet_analysis (analysis_id, pet_id, blood_rate, urine_rate, date) VALUES (1, 22, 0.50, 0.60, CURRENT_DATE);
INSERT INTO public.pet_analysis (analysis_id, pet_id, blood_rate, urine_rate, date) VALUES (2, 22, 0.30, 0.20, CURRENT_DATE - INTERVAL '7 days');
INSERT INTO public.pet_analysis (analysis_id, pet_id, blood_rate, urine_rate, date) VALUES (3, 23, 0.53, 0.47, CURRENT_DATE - INTERVAL '1 month');
INSERT INTO public.pet_analysis (analysis_id, pet_id, blood_rate, urine_rate, date) VALUES (4, 23, 0.24, 0.84, CURRENT_DATE - INTERVAL '2 days');
INSERT INTO public.pet_analysis (analysis_id, pet_id, blood_rate, urine_rate, date) VALUES (5, 23, 0.70, 0.80, CURRENT_DATE - INTERVAL '3 months');
INSERT INTO public.pet_analysis (analysis_id, pet_id, blood_rate, urine_rate, date) VALUES (6, 23, 0.71, 0.29, CURRENT_DATE - INTERVAL '9 days');

SELECT setval('sequence_analysis', max(analysis_id)) FROM public.pet_analysis;
