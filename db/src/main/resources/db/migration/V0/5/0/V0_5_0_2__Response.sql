CREATE TABLE response
(
    id                    SERIAL        NOT NULL PRIMARY KEY,
    active                BOOLEAN       NOT NULL DEFAULT TRUE,
    person                INT           REFERENCES person (id),
    type                  VARCHAR(8)    NOT NULL,
    url                   VARCHAR(512)  NOT NULL,
    code                  INT           NOT NULL,
    body                  TEXT,
    date_add              TIMESTAMPTZ   NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE response_header
(
    id                    SERIAL         NOT NULL PRIMARY KEY,
    response              INT            REFERENCES response (id) ON DELETE CASCADE,
    key                   VARCHAR(128)   NOT NULL,
    value                 VARCHAR(1024)  NOT NULL
);
