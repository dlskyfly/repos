/* * * * * * * * * * * * * * * * * * * * * */
/* * * * * * *    初始化滤表              * * * * * * */
/* * * * * * * * * * * * * * * * * * * * * */
CREATE OR REPLACE PROCEDURE POST_FROM_BASE
    AS
BEGIN
    EXECUTE IMMEDIATE 'TRUNCATE TABLE BALL_RED_FILTER';
    INSERT INTO BALL_RED_FILTER (
        RED_1,
        RED_2,
        RED_3,
        RED_4,
        RED_5,
        RED_6
    ) SELECT
        RED_1,
        RED_2,
        RED_3,
        RED_4,
        RED_5,
        RED_6
    FROM
        BALL_RED_BASE;
END POST_FROM_BASE;