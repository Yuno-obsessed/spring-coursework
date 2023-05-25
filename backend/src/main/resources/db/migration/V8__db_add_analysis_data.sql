INSERT INTO public.pet_analysis (analysis_id, pet_id, blood_rate, urine_rate, date) VALUES (1, 12, 0.20, 0.82, CURRENT_DATE - INTERVAL '5 months');
INSERT INTO public.pet_analysis (analysis_id, pet_id, blood_rate, urine_rate, date) VALUES (2, 12, 0.10, 0.55, CURRENT_DATE - INTERVAL '3 months');
INSERT INTO public.pet_analysis (analysis_id, pet_id, blood_rate, urine_rate, date) VALUES (3, 12, 0.28, 0.40, CURRENT_DATE - INTERVAL '2 months');
INSERT INTO public.pet_analysis (analysis_id, pet_id, blood_rate, urine_rate, date) VALUES (4, 13, 0.41, 0.67, CURRENT_DATE - INTERVAL '20 days');
INSERT INTO public.pet_analysis (analysis_id, pet_id, blood_rate, urine_rate, date) VALUES (5, 13, 0.59, 0.52, CURRENT_DATE - INTERVAL '4 days');
INSERT INTO public.pet_analysis (analysis_id, pet_id, blood_rate, urine_rate, date) VALUES (6, 14, 0.26, 0.51, CURRENT_DATE - INTERVAL '1 day');
INSERT INTO public.pet_analysis (analysis_id, pet_id, blood_rate, urine_rate, date) VALUES (7, 14, 0.45, 0.93, CURRENT_DATE);
INSERT INTO public.pet_analysis (analysis_id, pet_id, blood_rate, urine_rate, date) VALUES (8, 14, 0.90, 0.53, CURRENT_DATE - INTERVAL '1 month');
INSERT INTO public.pet_analysis (analysis_id, pet_id, blood_rate, urine_rate, date) VALUES (9, 14, 0.37, 0.47, CURRENT_DATE - INTERVAL '8 days');
INSERT INTO public.pet_analysis (analysis_id, pet_id, blood_rate, urine_rate, date) VALUES (10, 22, 0.25, 0.40, CURRENT_DATE);
INSERT INTO public.pet_analysis (analysis_id, pet_id, blood_rate, urine_rate, date) VALUES (11, 22, 0.30, 0.20, CURRENT_DATE - INTERVAL '7 days');
INSERT INTO public.pet_analysis (analysis_id, pet_id, blood_rate, urine_rate, date) VALUES (12, 23, 0.53, 0.47, CURRENT_DATE - INTERVAL '1 month');
INSERT INTO public.pet_analysis (analysis_id, pet_id, blood_rate, urine_rate, date) VALUES (13, 23, 0.24, 0.84, CURRENT_DATE - INTERVAL '2 days');
INSERT INTO public.pet_analysis (analysis_id, pet_id, blood_rate, urine_rate, date) VALUES (14, 23, 0.70, 0.80, CURRENT_DATE - INTERVAL '3 months');
INSERT INTO public.pet_analysis (analysis_id, pet_id, blood_rate, urine_rate, date) VALUES (15, 23, 0.71, 0.29, CURRENT_DATE - INTERVAL '9 days');

SELECT setval('sequence_analysis', max(analysis_id)) FROM public.pet_analysis;
