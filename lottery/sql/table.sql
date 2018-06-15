CREATE TABLE ball_red_base (
    red_1   NUMBER(2,0) NOT NULL,
    red_2   NUMBER(2,0) NOT NULL,
    red_3   NUMBER(2,0) NOT NULL,
    red_4   NUMBER(2,0) NOT NULL,
    red_5   NUMBER(2,0) NOT NULL,
    red_6   NUMBER(2,0) NOT NULL
);

CREATE TABLE ball_red_filter (
    red_1        NUMBER(2,0) NOT NULL,
    red_2        NUMBER(2,0) NOT NULL,
    red_3        NUMBER(2,0) NOT NULL,
    red_4        NUMBER(2,0) NOT NULL,
    red_5        NUMBER(2,0) NOT NULL,
    red_6        NUMBER(2,0) NOT NULL,
    interval_3   CHAR(3),
    interval_4   CHAR(4)
);

CREATE TABLE ball_history (
    red_1        NUMBER(2,0) NOT NULL,
    red_2        NUMBER(2,0) NOT NULL,
    red_3        NUMBER(2,0) NOT NULL,
    red_4        NUMBER(2,0) NOT NULL,
    red_5        NUMBER(2,0) NOT NULL,
    red_6        NUMBER(2,0) NOT NULL,
    blue         NUMBER(2,0) NOT NULL,
    interval_3   CHAR(3),
    interval_4   CHAR(4),
    date_no      NUMBER(7,0) NOT NULL,
    CONSTRAINT ball_history_pk PRIMARY KEY ( date_no )
);