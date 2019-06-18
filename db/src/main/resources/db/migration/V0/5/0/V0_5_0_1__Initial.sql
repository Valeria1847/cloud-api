-- Пользователь системы
CREATE TABLE person
(
    id                    SERIAL       NOT NULL PRIMARY KEY,
    active                BOOLEAN      NOT NULL DEFAULT TRUE,
    login                 VARCHAR(128) NOT NULL,
    password_hash         VARCHAR(64)  NOT NULL,

    surname               VARCHAR(128),
    name                  VARCHAR(128),
    patronymic            VARCHAR(128),

    email                 VARCHAR(128),

    incorrect_login_count SMALLINT     NOT NULL DEFAULT 0,

    blocked_password      BOOLEAN      NOT NULL DEFAULT FALSE,
    blocked_admin         BOOLEAN      NOT NULL DEFAULT FALSE,
    date_add              TIMESTAMPTZ  NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE UNIQUE INDEX person_login_active_idx
    ON person (login)
    WHERE active IS TRUE AND COALESCE(login, '') <> '';
