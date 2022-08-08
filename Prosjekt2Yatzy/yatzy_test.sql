DROP SCHEMA IF EXISTS yatzy CASCADE;
CREATE SCHEMA yatzy;
SET search_path = yatzy;
-- An overview of all registered players
CREATE TABLE player
(
   playerId SERIAL,
   username VARCHAR (20),
   password CHAR (64),
   name VARCHAR (10),
   email VARCHAR (20),
   lobbyId INTEGER,
   warnings INTEGER,
   PRIMARY KEY (playerId)
);
-- A single lobby that consists of all the players in the lobby
CREATE TABLE lobby
(
   lobbyId SERIAL,
   playerId INTEGER,
   PRIMARY KEY (lobbyId),
   FOREIGN KEY (playerId) REFERENCES player (playerId)
);
-- A single players scoreCard, When a player joins a lobby, the scorecard is generated
CREATE TABLE scoreCard
(
   playerId INTEGER,
   ones INTEGER,
   --enere
   twos INTEGER,
   --toere
   threes INTEGER,
   --treere
   fours INTEGER,
   --firere
   fives INTEGER,
   --femere
   sixes INTEGER,
   --seksere
   bonus INTEGER,
   --bonus
   one_pair INTEGER,
   --ett par
   two_pairs INTEGER,
   --to par
   three_of_a_kind INTEGER,
   --tre like
   four_of_a_kind INTEGER,
   --fire like
   small_straight INTEGER,
   --liten straight
   big_straight INTEGER,
   --stor straight
   full_house INTEGER,
   --hus
   chance INTEGER,
   --sjanse
   yatzy INTEGER,
   --yatzy
   PRIMARY KEY (playerId),
   FOREIGN KEY (playerId) REFERENCES player (playerId)
);

ALTER TABLE player
ADD FOREIGN KEY (lobbyId) REFERENCES lobby(lobbyId)


-- INSERT INTO lobbyOverview (admin) VALUES ('jonbac');
INSERT INTO player VALUES
(
	DEFAULT,
   'jonbac',
   'and723c79r9h9c725h7h2759cg25gc792g57gc77cy25g7cg752gc725gc7g25c',
   'Jonas Bach',
   'jonasabach@gmail.com',
   0,
   0
);