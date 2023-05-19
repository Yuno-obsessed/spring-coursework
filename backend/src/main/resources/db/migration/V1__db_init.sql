CREATE SEQUENCE IF NOT EXISTS sequence_pet START WITH 1 INCREMENT BY 5;

CREATE SEQUENCE IF NOT EXISTS sequence_role START WITH 1 INCREMENT BY 5;

CREATE SEQUENCE IF NOT EXISTS sequence_type START WITH 1 INCREMENT BY 5;

CREATE SEQUENCE IF NOT EXISTS public.sequence_user START WITH 1 INCREMENT BY 5;

CREATE SEQUENCE IF NOT EXISTS sequence_diagnosis START WITH 1 INCREMENT BY 5;

CREATE SEQUENCE IF NOT EXISTS sequence_analysis START WITH 1 INCREMENT BY 5;

CREATE SEQUENCE IF NOT EXISTS sequence_surgery START WITH 1 INCREMENT BY 5;

CREATE TABLE pet
(
    id      BIGINT      NOT NULL,
    name    VARCHAR(50) NOT NULL,
    type_id BIGINT      NOT NULL,
    user_id BIGINT      NOT NULL,
    CONSTRAINT pk_pet PRIMARY KEY (id)
);

CREATE TABLE role
(
    id   BIGINT      NOT NULL,
    type VARCHAR(20) NOT NULL,
    CONSTRAINT pk_role PRIMARY KEY (id)
);

CREATE TABLE type
(
    id          BIGINT      NOT NULL,
    name        VARCHAR(50) NOT NULL,
    description VARCHAR(50),
    CONSTRAINT pk_type PRIMARY KEY (id)
);

CREATE TABLE public."user"
(
    id         BIGINT       NOT NULL,
    first_name VARCHAR(50)  NOT NULL,
    last_name  VARCHAR(50)  NOT NULL,
    username   VARCHAR(20)  NOT NULL,
    password   VARCHAR(100) NOT NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);

CREATE TABLE public.user_role
(
    role_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    CONSTRAINT pk_user_role PRIMARY KEY (role_id, user_id)
);

CREATE TABLE public.pet_diagnosis
(
    diagnosis_id BIGINT NOT NULL,
    pet_id BIGINT NOT NULL,
    description VARCHAR(75) NOT NULL,
    "date" DATE NOT NULL,
    CONSTRAINT pk_pet_diagnosis PRIMARY KEY (diagnosis_id)
);

CREATE TABLE public.pet_analysis
(
    analysis_id BIGINT NOT NULL,
    pet_id BIGINT NOT NULL,
    blood_rate NUMERIC(4,2) DEFAULT 0,
    urine_rate NUMERIC(4,2) DEFAULT 0,
    "date" DATE NOT NULL,
    CONSTRAINT pk_pet_analysis PRIMARY KEY (analysis_id)
);

CREATE TABLE public.surgery
(
    surgery_id BIGINT NOT NULL,
    pet_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    description VARCHAR(100) NOT NULL,
    difficulty SMALLINT DEFAULT 1,
    "date" DATE NOT NULL,
    CONSTRAINT pk_surgery PRIMARY KEY (surgery_id)
);

ALTER TABLE role
    ADD CONSTRAINT uc_role_type UNIQUE (type);

ALTER TABLE type
    ADD CONSTRAINT uc_type_name UNIQUE (name);

ALTER TABLE public."user"
    ADD CONSTRAINT uc_user_username UNIQUE (username);

ALTER TABLE pet
    ADD CONSTRAINT FK_PET_ON_TYPE FOREIGN KEY (type_id) REFERENCES type (id);

ALTER TABLE pet
    ADD CONSTRAINT FK_PET_ON_USER FOREIGN KEY (user_id) REFERENCES public."user" (id);

ALTER TABLE public.user_role
    ADD CONSTRAINT fk_user_role_on_role FOREIGN KEY (role_id) REFERENCES role (id);

ALTER TABLE public.user_role
    ADD CONSTRAINT fk_user_role_on_user FOREIGN KEY (user_id) REFERENCES public."user" (id);

ALTER TABLE pet_diagnosis
    ADD CONSTRAINT fk_pet_diagnosis_on_pet FOREIGN KEY (diagnosis_id) REFERENCES pet (id) ON DELETE CASCADE;

ALTER TABLE pet_analysis
    ADD CONSTRAINT fk_pet_analysis_on_pet FOREIGN KEY (analysis_id) REFERENCES pet (id) ON DELETE CASCADE;

ALTER TABLE surgery
    ADD CONSTRAINT fk_surgery_on_pet FOREIGN KEY (pet_id) REFERENCES pet (id) ON DELETE CASCADE;

ALTER TABLE surgery
    ADD CONSTRAINT fk_surgery_on_user FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE CASCADE;