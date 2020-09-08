CREATE DATABASE IF NOT EXISTS db2 ;
use db2 ;

CREATE TABLE IF NOT EXISTS pupils (
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	firstname VARCHAR(50),
	lastname VARCHAR(50),
	email VARCHAR(50) UNIQUE,
	birthdate DATE

) ENGINE = InnoDB DEFAULT CHARSET = UTF8;


insert into pupils (id, firstname, lastname, email, birthdate) values (1, 'Gert', 'Bilbrook', 'gbilbrook0@mail.ru', STR_TO_DATE('02/16/2019', '%m/%d/%Y')                        );
insert into pupils (id, firstname, lastname, email, birthdate) values (2, 'Jamil', 'Vonasek', 'jvonasek1@howstuffworks.com', STR_TO_DATE('06/04/2004', '%m/%d/%Y')               );
insert into pupils (id, firstname, lastname, email, birthdate) values (3, 'Nevsa', 'Esberger', 'nesberger2@bluehost.com', STR_TO_DATE('08/06/2008', '%m/%d/%Y')                  );
insert into pupils (id, firstname, lastname, email, birthdate) values (4, 'Rorke', 'Valentinuzzi', 'rvalentinuzzi3@google.com.au', STR_TO_DATE('10/24/2018', '%m/%d/%Y')         );
insert into pupils (id, firstname, lastname, email, birthdate) values (5, 'Augie', 'Defew', 'adefew4@blinklist.com', STR_TO_DATE('09/26/2002', '%m/%d/%Y')                       );
insert into pupils (id, firstname, lastname, email, birthdate) values (6, 'Shanta', 'Penkethman', 'spenkethman5@mediafire.com', STR_TO_DATE('12/07/2010', '%m/%d/%Y')            );
insert into pupils (id, firstname, lastname, email, birthdate) values (7, 'Cesare', 'Shelsher', 'cshelsher6@umich.edu', STR_TO_DATE('02/15/2016', '%m/%d/%Y')                    );
insert into pupils (id, firstname, lastname, email, birthdate) values (8, 'Dimitri', 'Borles', 'dborles7@gmail.com', STR_TO_DATE('05/12/2004', '%m/%d/%Y')                       );
insert into pupils (id, firstname, lastname, email, birthdate) values (9, 'Ab', 'Grinsted', 'agrinsted8@nationalgeographic.com', STR_TO_DATE('06/04/2006', '%m/%d/%Y')           );
insert into pupils (id, firstname, lastname, email, birthdate) values (10, 'Hernando', 'Bisp', 'hbisp9@mlb.com', STR_TO_DATE('07/18/2004', '%m/%d/%Y')                           );
insert into pupils (id, firstname, lastname, email, birthdate) values (11, 'Stearne', 'Monument', 'smonumenta@craigslist.org', STR_TO_DATE('02/27/2012', '%m/%d/%Y')             );
insert into pupils (id, firstname, lastname, email, birthdate) values (12, 'Artemis', 'Morriss', 'amorrissb@scientificamerican.com', STR_TO_DATE('10/01/2005', '%m/%d/%Y')       );
insert into pupils (id, firstname, lastname, email, birthdate) values (13, 'Rodolphe', 'Pantin', 'rpantinc@answers.com', STR_TO_DATE('06/16/2019', '%m/%d/%Y')                   );
insert into pupils (id, firstname, lastname, email, birthdate) values (14, 'Mortie', 'Hartless', 'mhartlessd@tinypic.com', STR_TO_DATE('02/28/2018', '%m/%d/%Y')                 );
insert into pupils (id, firstname, lastname, email, birthdate) values (15, 'Yuri', 'Borrows', 'yborrowse@illinois.edu', STR_TO_DATE('04/18/2003', '%m/%d/%Y')                    );
insert into pupils (id, firstname, lastname, email, birthdate) values (16, 'Owen', 'Fidilis', 'ofidilisf@mail.ru', STR_TO_DATE('06/20/2014', '%m/%d/%Y')                         );
insert into pupils (id, firstname, lastname, email, birthdate) values (17, 'Chance', 'Allix', 'callixg@tripod.com', STR_TO_DATE('12/22/2016', '%m/%d/%Y')                        );
insert into pupils (id, firstname, lastname, email, birthdate) values (18, 'Beitris', 'Guymer', 'bguymerh@hugedomains.com', STR_TO_DATE('11/14/2003', '%m/%d/%Y')                );
insert into pupils (id, firstname, lastname, email, birthdate) values (19, 'Rozalin', 'Gobert', 'rgoberti@howstuffworks.com', STR_TO_DATE('11/30/2009', '%m/%d/%Y')              );
insert into pupils (id, firstname, lastname, email, birthdate) values (20, 'Donavon', 'Lovick', 'dlovickj@ovh.net', STR_TO_DATE('07/10/2019', '%m/%d/%Y')                        );
insert into pupils (id, firstname, lastname, email, birthdate) values (21, 'Juline', 'Case', 'jcasek@statcounter.com', STR_TO_DATE('03/17/2005', '%m/%d/%Y')                     );
insert into pupils (id, firstname, lastname, email, birthdate) values (22, 'Ber', 'Spata', 'bspatal@usa.gov', STR_TO_DATE('06/07/2004', '%m/%d/%Y')                              );
insert into pupils (id, firstname, lastname, email, birthdate) values (23, 'Had', 'Wintersgill', 'hwintersgillm@comsenz.com', STR_TO_DATE('07/01/2011', '%m/%d/%Y')              );
insert into pupils (id, firstname, lastname, email, birthdate) values (24, 'Ivory', 'Tidmas', 'itidmasn@nationalgeographic.com', STR_TO_DATE('06/15/2017', '%m/%d/%Y')           );
insert into pupils (id, firstname, lastname, email, birthdate) values (25, 'Max', 'Birchenhead', 'mbirchenheado@gmail.com', STR_TO_DATE('01/16/2006', '%m/%d/%Y')                );
insert into pupils (id, firstname, lastname, email, birthdate) values (26, 'Roderich', 'Litel', 'rlitelp@mail.ru', STR_TO_DATE('03/03/2006', '%m/%d/%Y')                         );
insert into pupils (id, firstname, lastname, email, birthdate) values (27, 'Mehetabel', 'Lyte', 'mlyteq@seesaa.net', STR_TO_DATE('05/05/2011', '%m/%d/%Y')                       );
insert into pupils (id, firstname, lastname, email, birthdate) values (28, 'Louie', 'Tunnow', 'ltunnowr@google.fr', STR_TO_DATE('06/26/2011', '%m/%d/%Y')                        );
insert into pupils (id, firstname, lastname, email, birthdate) values (29, 'Adore', 'Annion', 'aannions@netscape.com', STR_TO_DATE('06/11/2012', '%m/%d/%Y')                     );
insert into pupils (id, firstname, lastname, email, birthdate) values (30, 'Baillie', 'Casaro', 'bcasarot@bbb.org', STR_TO_DATE('09/15/2004', '%m/%d/%Y')                        );
insert into pupils (id, firstname, lastname, email, birthdate) values (31, 'Elias', 'Speaks', 'espeaksu@yahoo.com', STR_TO_DATE('10/08/2017', '%m/%d/%Y')                        );
insert into pupils (id, firstname, lastname, email, birthdate) values (32, 'Brande', 'Schoenfisch', 'bschoenfischv@yahoo.com', STR_TO_DATE('11/29/2013', '%m/%d/%Y')             );
insert into pupils (id, firstname, lastname, email, birthdate) values (33, 'Abramo', 'Curmi', 'acurmiw@yahoo.com', STR_TO_DATE('05/24/2011', '%m/%d/%Y')                         );
insert into pupils (id, firstname, lastname, email, birthdate) values (34, 'Tracey', 'Joseph', 'tjosephx@hp.com', STR_TO_DATE('06/24/2017', '%m/%d/%Y')                          );
insert into pupils (id, firstname, lastname, email, birthdate) values (35, 'Derwin', 'Marder', 'dmardery@skype.com', STR_TO_DATE('02/05/2007', '%m/%d/%Y')                       );
insert into pupils (id, firstname, lastname, email, birthdate) values (36, 'Budd', 'Fumagalli', 'bfumagalliz@cyberchimps.com', STR_TO_DATE('05/22/2002', '%m/%d/%Y')             );
insert into pupils (id, firstname, lastname, email, birthdate) values (37, 'Annie', 'Mazella', 'amazella10@omniture.com', STR_TO_DATE('08/11/2013', '%m/%d/%Y')                  );
insert into pupils (id, firstname, lastname, email, birthdate) values (38, 'Mareah', 'Darlington', 'mdarlington11@mapy.cz', STR_TO_DATE('11/19/2014', '%m/%d/%Y')                );
insert into pupils (id, firstname, lastname, email, birthdate) values (39, 'Bevon', 'Eilles', 'beilles12@bandcamp.com', STR_TO_DATE('10/01/2005', '%m/%d/%Y')                    );
insert into pupils (id, firstname, lastname, email, birthdate) values (40, 'Dukey', 'Camilleri', 'dcamilleri13@tmall.com', STR_TO_DATE('11/05/2018', '%m/%d/%Y')                 );
insert into pupils (id, firstname, lastname, email, birthdate) values (41, 'Randell', 'Waldron', 'rwaldron14@ameblo.jp', STR_TO_DATE('04/02/2010', '%m/%d/%Y')                   );
insert into pupils (id, firstname, lastname, email, birthdate) values (42, 'Garik', 'Annesley', 'gannesley15@mail.ru', STR_TO_DATE('04/17/2012', '%m/%d/%Y')                     );
insert into pupils (id, firstname, lastname, email, birthdate) values (43, 'Kristin', 'Bessant', 'kbessant16@mail.ru', STR_TO_DATE('11/01/2006', '%m/%d/%Y')                     );
insert into pupils (id, firstname, lastname, email, birthdate) values (44, 'Dodi', 'Creegan', 'dcreegan17@squarespace.com', STR_TO_DATE('04/12/2007', '%m/%d/%Y')                );
insert into pupils (id, firstname, lastname, email, birthdate) values (45, 'Aurthur', 'Skurm', 'askurm18@baidu.com', STR_TO_DATE('06/28/2007', '%m/%d/%Y')                       );
insert into pupils (id, firstname, lastname, email, birthdate) values (46, 'Christophe', 'Tansley', 'ctansley19@mail.ru', STR_TO_DATE('11/22/2005', '%m/%d/%Y')                  );
insert into pupils (id, firstname, lastname, email, birthdate) values (47, 'Bartolomeo', 'Brotherheed', 'bbrotherheed1a@is.gd', STR_TO_DATE('06/17/2013', '%m/%d/%Y')            );
insert into pupils (id, firstname, lastname, email, birthdate) values (48, 'Zulema', 'Rugieri', 'zrugieri1b@epa.gov', STR_TO_DATE('06/02/2011', '%m/%d/%Y')                      );
insert into pupils (id, firstname, lastname, email, birthdate) values (49, 'Codie', 'Ive', 'cive1c@wikispaces.com', STR_TO_DATE('01/20/2007', '%m/%d/%Y')                        );
insert into pupils (id, firstname, lastname, email, birthdate) values (50, 'Caddric', 'Scrivens', 'cscrivens1d@un.org', STR_TO_DATE('01/21/2009', '%m/%d/%Y')                    );
insert into pupils (id, firstname, lastname, email, birthdate) values (51, 'Byram', 'Filon', 'bfilon1e@inbox.lv', STR_TO_DATE('02/27/2006', '%m/%d/%Y')                          );
insert into pupils (id, firstname, lastname, email, birthdate) values (52, 'Estevan', 'Leyshon', 'eleyshon1f@howstuffworks.com', STR_TO_DATE('01/06/2016', '%m/%d/%Y')           );
insert into pupils (id, firstname, lastname, email, birthdate) values (53, 'Cyril', 'Belson', 'cbelson1g@bloglines.com', STR_TO_DATE('06/26/2017', '%m/%d/%Y')                   );
insert into pupils (id, firstname, lastname, email, birthdate) values (54, 'Frederica', 'Missington', 'fmissington1h@tamu.edu', STR_TO_DATE('05/21/2014', '%m/%d/%Y')            );
insert into pupils (id, firstname, lastname, email, birthdate) values (55, 'Rosita', 'Divine', 'rdivine1i@abc.net.au', STR_TO_DATE('11/07/2019', '%m/%d/%Y')                     );
insert into pupils (id, firstname, lastname, email, birthdate) values (56, 'Rabi', 'Crudge', 'rcrudge1j@yahoo.com', STR_TO_DATE('05/30/2007', '%m/%d/%Y')                        );
insert into pupils (id, firstname, lastname, email, birthdate) values (57, 'Georgena', 'Graves', 'ggraves1k@smh.com.au', STR_TO_DATE('12/25/2004', '%m/%d/%Y')                   );
insert into pupils (id, firstname, lastname, email, birthdate) values (58, 'Vladimir', 'Orrum', 'vorrum1l@abc.net.au', STR_TO_DATE('03/16/2019', '%m/%d/%Y')                     );
insert into pupils (id, firstname, lastname, email, birthdate) values (59, 'Kelby', 'Blasl', 'kblasl1m@ibm.com', STR_TO_DATE('09/03/2016', '%m/%d/%Y')                           );
insert into pupils (id, firstname, lastname, email, birthdate) values (60, 'Dodie', 'Gadd', 'dgadd1n@whitehouse.gov', STR_TO_DATE('10/04/2016', '%m/%d/%Y')                      );
insert into pupils (id, firstname, lastname, email, birthdate) values (61, 'Anestassia', 'Conkling', 'aconkling1o@eventbrite.com', STR_TO_DATE('05/25/2003', '%m/%d/%Y')         );
insert into pupils (id, firstname, lastname, email, birthdate) values (62, 'Lawton', 'Dalzell', 'ldalzell1p@bbb.org', STR_TO_DATE('03/08/2008', '%m/%d/%Y')                      );
insert into pupils (id, firstname, lastname, email, birthdate) values (63, 'Kym', 'Cowp', 'kcowp1q@gmail.com', STR_TO_DATE('07/04/2003', '%m/%d/%Y')                             );
insert into pupils (id, firstname, lastname, email, birthdate) values (64, 'Sharia', 'Roberti', 'sroberti1r@slashdot.org', STR_TO_DATE('02/08/2016', '%m/%d/%Y')                 );
insert into pupils (id, firstname, lastname, email, birthdate) values (65, 'Heinrick', 'Caunter', 'hcaunter1s@mail.ru', STR_TO_DATE('11/24/2002', '%m/%d/%Y')                    );
insert into pupils (id, firstname, lastname, email, birthdate) values (66, 'Hunter', 'Chappelow', 'hchappelow1t@unicef.org', STR_TO_DATE('09/19/2018', '%m/%d/%Y')               );
insert into pupils (id, firstname, lastname, email, birthdate) values (67, 'Clarke', 'Poveleye', 'cpoveleye1u@mozilla.org', STR_TO_DATE('08/12/2018', '%m/%d/%Y')                );
insert into pupils (id, firstname, lastname, email, birthdate) values (68, 'Eleanore', 'Sears', 'esears1v@wsj.com', STR_TO_DATE('07/31/2016', '%m/%d/%Y')                        );
insert into pupils (id, firstname, lastname, email, birthdate) values (69, 'Jeramey', 'Ravens', 'jravens1w@dailymail.co.uk', STR_TO_DATE('10/26/2007', '%m/%d/%Y')               );
insert into pupils (id, firstname, lastname, email, birthdate) values (70, 'Kelvin', 'Arndtsen', 'karndtsen1x@inbox.lv', STR_TO_DATE('11/24/2011', '%m/%d/%Y')                   );
insert into pupils (id, firstname, lastname, email, birthdate) values (71, 'Gena', 'Tankard', 'gtankard1y@linkedin.com', STR_TO_DATE('01/18/2016', '%m/%d/%Y')                   );
insert into pupils (id, firstname, lastname, email, birthdate) values (72, 'Teddi', 'Martell', 'tmartell1z@alibaba.com', STR_TO_DATE('03/25/2017', '%m/%d/%Y')                   );
insert into pupils (id, firstname, lastname, email, birthdate) values (73, 'Piper', 'Delves', 'pdelves20@prweb.com', STR_TO_DATE('02/05/2010', '%m/%d/%Y')                       );
insert into pupils (id, firstname, lastname, email, birthdate) values (74, 'Lea', 'Matthiae', 'lmatthiae21@sitemeter.com', STR_TO_DATE('12/07/2007', '%m/%d/%Y')                 );
insert into pupils (id, firstname, lastname, email, birthdate) values (75, 'Helli', 'Mardee', 'hmardee22@princeton.edu', STR_TO_DATE('02/11/2013', '%m/%d/%Y')                   );
insert into pupils (id, firstname, lastname, email, birthdate) values (76, 'Nancee', 'Haysom', 'nhaysom23@wsj.com', STR_TO_DATE('11/20/2006', '%m/%d/%Y')                        );
insert into pupils (id, firstname, lastname, email, birthdate) values (77, 'Hershel', 'Howlett', 'hhowlett24@istockphoto.com', STR_TO_DATE('06/15/2009', '%m/%d/%Y')             );
insert into pupils (id, firstname, lastname, email, birthdate) values (78, 'Mina', 'Adanet', 'madanet25@webnode.com', STR_TO_DATE('06/25/2014', '%m/%d/%Y')                      );
insert into pupils (id, firstname, lastname, email, birthdate) values (79, 'Dar', 'Alesbrook', 'dalesbrook26@sina.com.cn', STR_TO_DATE('07/20/2011', '%m/%d/%Y')                 );
insert into pupils (id, firstname, lastname, email, birthdate) values (80, 'Octavia', 'Venmore', 'ovenmore27@yolasite.com', STR_TO_DATE('08/21/2015', '%m/%d/%Y')                );
insert into pupils (id, firstname, lastname, email, birthdate) values (81, 'Brynna', 'Delgado', 'bdelgado28@posterous.com', STR_TO_DATE('08/06/2009', '%m/%d/%Y')                );
insert into pupils (id, firstname, lastname, email, birthdate) values (82, 'Mia', 'Tatters', 'mtatters29@yahoo.com', STR_TO_DATE('08/31/2010', '%m/%d/%Y')                       );
insert into pupils (id, firstname, lastname, email, birthdate) values (83, 'Cherilynn', 'Kuschek', 'ckuschek2a@shinystat.com', STR_TO_DATE('09/04/2018', '%m/%d/%Y')             );
insert into pupils (id, firstname, lastname, email, birthdate) values (84, 'Isabelle', 'Biever', 'ibiever2b@tinypic.com', STR_TO_DATE('07/22/2016', '%m/%d/%Y')                  );
insert into pupils (id, firstname, lastname, email, birthdate) values (85, 'Basia', 'Giacomini', 'bgiacomini2c@amazonaws.com', STR_TO_DATE('04/29/2019', '%m/%d/%Y')             );
insert into pupils (id, firstname, lastname, email, birthdate) values (86, 'Sherman', 'Pawel', 'spawel2d@weebly.com', STR_TO_DATE('08/06/2016', '%m/%d/%Y')                      );
insert into pupils (id, firstname, lastname, email, birthdate) values (87, 'Arlee', 'Geggie', 'ageggie2e@mac.com', STR_TO_DATE('05/20/2002', '%m/%d/%Y')                         );
insert into pupils (id, firstname, lastname, email, birthdate) values (88, 'Rozamond', 'Caze', 'rcaze2f@europa.eu', STR_TO_DATE('03/28/2008', '%m/%d/%Y')                        );
insert into pupils (id, firstname, lastname, email, birthdate) values (89, 'Angy', 'Faulds', 'afaulds2g@pinterest.com', STR_TO_DATE('07/08/2002', '%m/%d/%Y')                    );
insert into pupils (id, firstname, lastname, email, birthdate) values (90, 'Austina', 'Stead', 'astead2h@washingtonpost.com', STR_TO_DATE('07/24/2015', '%m/%d/%Y')              );
insert into pupils (id, firstname, lastname, email, birthdate) values (91, 'Elijah', 'Josovich', 'ejosovich2i@google.cn', STR_TO_DATE('06/15/2004', '%m/%d/%Y')                  );
insert into pupils (id, firstname, lastname, email, birthdate) values (92, 'Fredric', 'Winterborne', 'fwinterborne2j@globo.com', STR_TO_DATE('09/12/2014', '%m/%d/%Y')           );
insert into pupils (id, firstname, lastname, email, birthdate) values (93, 'Cleopatra', 'Nisby', 'cnisby2k@angelfire.com', STR_TO_DATE('03/14/2013', '%m/%d/%Y')                 );
insert into pupils (id, firstname, lastname, email, birthdate) values (94, 'Erick', 'O''Hoolahan', 'eohoolahan2l@cnet.com', STR_TO_DATE('07/11/2008', '%m/%d/%Y')                );
insert into pupils (id, firstname, lastname, email, birthdate) values (95, 'Frazer', 'Ximenez', 'fximenez2m@timesonline.co.uk', STR_TO_DATE('03/18/2006', '%m/%d/%Y')            );
insert into pupils (id, firstname, lastname, email, birthdate) values (96, 'Wallie', 'MacKnight', 'wmacknight2n@jugem.jp', STR_TO_DATE('01/20/2004', '%m/%d/%Y')                 );
insert into pupils (id, firstname, lastname, email, birthdate) values (97, 'Erick', 'Edling', 'eedling2o@yellowpages.com', STR_TO_DATE('12/11/2016', '%m/%d/%Y')                 );
insert into pupils (id, firstname, lastname, email, birthdate) values (98, 'Flor', 'Benedito', 'fbenedito2p@sogou.com', STR_TO_DATE('09/21/2009', '%m/%d/%Y')                    );
insert into pupils (id, firstname, lastname, email, birthdate) values (99, 'Katherina', 'Biglin', 'kbiglin2q@wsj.com', STR_TO_DATE('08/01/2013', '%m/%d/%Y')                     );
insert into pupils (id, firstname, lastname, email, birthdate) values (100, 'Gwendolen', 'Fann', 'gfann2r@gmail.com', STR_TO_DATE('05/12/2008', '%m/%d/%Y')                      );