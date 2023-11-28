

CREATE DATABASE fw_s6;
\c fw_s6

CREATE TABLE syntaxe (
    id_syntaxe SERIAL PRIMARY KEY ,
    language VARCHAR(150),
    extension VARCHAR(150),
    vocabulaire TEXT
);

CREATE  TABLE bdd(
    id_bdd SERIAL PRIMARY KEY ,
    bdd VARCHAR(150),
    driver VARCHAR(255)
);


INSERT INTO syntaxe (language, extension, vocabulaire) VALUES
    ('c#', '.cs', '{"#package": "namespace","#import": "using","#class": "public class"}'),
    ('java', '.java','{"#package": "package","#import": "import","#class": "public class"}');

--le resaka PORT & URL  tsy nataoko tao
INSERT INTO bdd (bdd, driver) VALUES
    ('mysql', 'org.postgresql.Driver'),
    ('postgresql', 'com.mysql.cj.jdbc.Driver');




