CREATE DATABASE IF NOT EXISTS school ;
use school ;

DELIMITER ;;

DROP PROCEDURE IF EXISTS CREATE_TEACHER;
CREATE PROCEDURE CREATE_TEACHER(IN count INTEGER, OUT created INTEGER)
BEGIN

    SET @cnt = 0;

    WHILE @cnt < count DO

       SET @id = (select id from teachers ORDER BY id DESC LIMIT 1) + 1;
       SET @firstname = GET_RANDOM_FIRSTNAME();
       SET @lastname = GET_RANDOM_LASTNAME();
       SET @email = GET_EMAIL(@firstname, @lastname);
       SET @birthdate = GET_RANDOM_BIRTHDATE(28, 56);

       INSERT INTO teachers (id, firstname, lastname, email, birthdate)
       VALUES (@id, @firstname, @lastname, @email, @birthdate);

       SET @cnt = @cnt + 1;

    END WHILE;

    SELECT @cnt INTO created;

END;
;;

DELIMITER ;