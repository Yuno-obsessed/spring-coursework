INSERT INTO public.user (id, first_name, last_name, username, "password")
VALUES (1, 'John', 'Doe', 'johndoe', '$2a$10$MMOkMuO8zVcXl8YH2GrZSOYf/9zeC/sznGHRVzAq0T8.tzet7QJWq');
INSERT INTO public.user (id, first_name, last_name, username, "password")
VALUES (2, 'Linda', 'Calvin', 'lindacalvin', '$2a$10$I5hOscIFqw73AU2/my0H0.vHAjI/rxXGcI49PB/jl8krTcM7VqkCy');
INSERT INTO public.user (id, first_name, last_name, username, "password")
VALUES (3, 'Jeffrey', 'Taylor', 'jeffreytaylor', '$2a$10$0grDMvQ7mSRLDAS6zuGOp.0ycwhgAzyE2FgLHzCV8KaXXP2TtGJ/W');
INSERT INTO public.user (id, first_name, last_name, username, "password")
VALUES (4, 'Daniel', 'Strutynskyi', 'danielstru', '$2a$10$wanL/JJOF3BEIndrFxlGremc52jwhCMKzkHDtZwvrm3pQyvIdkJla');
INSERT INTO public.user (id, first_name, last_name, username, "password")
VALUES (5, 'Vanya', 'Vityuk', 'vanyavityuk', '$2a$10$q/62Sc3FO2.2ZuxU/8VjLecgXIvHlCbk0mFcKqNWqTLOngy8y/8hK');
INSERT INTO public.user (id, first_name, last_name, username, "password")
VALUES (6, 'Valerii', 'Kornach', 'valerakornach', '$2a$10$NgpZjLJ4gVOTydNEMi97leEKx1m3YSqoY8csBmbmzv4XKEnf12UJ2');
INSERT INTO public.user (id, first_name, last_name, username, "password")
VALUES (7, 'Salvatore', 'Colangelo', 'salvocola', '$2a$10$bCX.rp9p71Tv9OD7DHZq3.uD4PMtw1OJTH1rksOifxywwVD.oKFuO');
INSERT INTO public.user (id, first_name, last_name, username, "password")
VALUES (8, 'Vladislav', 'Tihiy', 'vladtihiy', '$2a$10$Ese9O.6iwiIzs/WEkvx/HuWs4hCTVdwESzbaZQ5sBMB8bkYyjESe.');
INSERT INTO public.user (id, first_name, last_name, username, "password")
VALUES (9, 'Travis', 'Fimmel', 'travisfimmel', '$2a$10$jFHWmF/8BhbmtDWglOCoM.aY/7Y9g2OtylL.Rv4nkrzRVyeTWYUcC');
INSERT INTO public.user (id, first_name, last_name, username, "password")
VALUES (10, 'Katerin', 'Vinnyk', 'katerinvinnyk', '$2a$10$JkTfpfxNwrEAucO9KP0Cf.bERas.qRNjmBV4YS9DoB/CG6Uo6UYhW');
INSERT INTO public.user (id, first_name, last_name, username, "password")
VALUES (11, 'Ragnar', 'Lothbrock', 'ragnarlothbrock', '$2a$10$iLRsyDl5b389jiHbpey1tOzOVAyXlRvVuojm5GTXV.ZFu7TFeQBki');
INSERT INTO public.user (id, first_name, last_name, username, "password")
VALUES (12, 'Uthred', 'Ragnarsson', 'uthredragnarsson', '$2a$10$C8EnhzYRqyx3fjopYvn.MestLMSx/xb.8IBQK6VMQR0rr97WA8Duq');
SELECT setval('sequence_user', max(id)) FROM public.user;