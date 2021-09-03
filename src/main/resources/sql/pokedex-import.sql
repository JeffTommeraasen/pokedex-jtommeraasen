--create table if not exists `pokedex` as select * from CSVREAD('classpath:pokedex.csv');
drop table if exists `pokedex`;
create table if not exists `pokedex` as select * from CSVREAD('/Users/jefftommeraasen/workspace/pokedex-jtommeraasen/src/main/resources/pokedex.csv');