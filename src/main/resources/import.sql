--sample director data
INSERT INTO DIRECTOR(DIRECTORID, FIRSTNAME, LASTNAME, AGE, EMAIL) VALUES (DIRECTOR_SEQ.NEXTVAL, 'Sam', 'Raimi', 62, 'spidermansam@movies.org');
INSERT INTO DIRECTOR(DIRECTORID, FIRSTNAME, LASTNAME, AGE, EMAIL) VALUES (DIRECTOR_SEQ.NEXTVAL, 'Martin', 'Scorsese', 79, 'martys@movies.org');
INSERT INTO DIRECTOR(DIRECTORID, FIRSTNAME, LASTNAME, AGE, EMAIL) VALUES (DIRECTOR_SEQ.NEXTVAL, 'Edgar', 'Wright', 47, 'edgarwrong@movies.org');
INSERT INTO DIRECTOR(DIRECTORID, FIRSTNAME, LASTNAME, AGE, EMAIL) VALUES (DIRECTOR_SEQ.NEXTVAL, 'Quentin', 'Tarantino', 58, 'quenten@movies.org');


--sample actor data
INSERT INTO ACTOR(ACTORID, FIRSTNAME, LASTNAME, AGE, EMAIL) VALUES (ACTOR_SEQ.NEXTVAL, 'Leonardo', 'DiCaprio', 47, 'leodc@movies.org');
INSERT INTO ACTOR(ACTORID, FIRSTNAME, LASTNAME, AGE, EMAIL) VALUES (ACTOR_SEQ.NEXTVAL, 'Margot', 'Robbie', 31, 'margot@movies.org');
INSERT INTO ACTOR(ACTORID, FIRSTNAME, LASTNAME, AGE, EMAIL) VALUES (ACTOR_SEQ.NEXTVAL, 'Toby', 'Maguire', 46, 'toebee@movies.org');
INSERT INTO ACTOR(ACTORID, FIRSTNAME, LASTNAME, AGE, EMAIL) VALUES (ACTOR_SEQ.NEXTVAL, 'Ansel', 'Elgort', 27, 'anselel@movies.org');


--sample movie data
insert into MOVIE(MOVIEID, NAME, DIRECTORID, RUNNING_TIME, GENRE, RELEASEDATE) VALUES  (MOVIE_SEQ.NEXTVAL, 'Spider-Man: Homecoming', '1', 133, 'ACTION', TO_DATE('2017/07/07', 'yyyy/mm/dd'));

insert into MOVIE_CAST(MOVIE_MOVIEID, CAST_ACTORID) VALUES (1, 1); 
insert into MOVIE_CAST(MOVIE_MOVIEID, CAST_ACTORID) VALUES (1, 2);

-- sample user data
INSERT INTO USER(USERID, USERNAME, PASSWORD) VALUES (USER_SEQ.NEXTVAL, 'test', 'password');
