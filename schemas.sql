-- DROP DATABASE IF EXISTS projeto_semana_06;

CREATE DATABASE projeto_semana_06;

DROP TABLE IF EXISTS tb_clientes;

CREATE TABLE tb_clientes(
  	id serial not null primary key,
	nome varchar(100) not null,
	cpf varchar(11) not null unique,
	email varchar(50) not null unique,
	telefone varchar(11) not null unique
);

INSERT INTO tb_clientes (nome, cpf, email, telefone) VALUES
('A', '12345678901', 'a@hotmail.com', '71999999999'),
('B', '12345678902', 'b@hotmail.com', '71999999998'),
('C', '12345678903', 'c@hotmail.com', '71999999997'),
('D', '12345678904', 'd@hotmail.com', '71999999996'),
('E', '12345678905', 'e@hotmail.com', '71999999995'),
('F', '12345678906', 'f@hotmail.com', '71999999994'),
('G', '12345678907', 'g@hotmail.com', '71999999993'),
('H', '12345678908', 'h@hotmail.com', '71999999992'),
('I', '12345678909', 'i@hotmail.com', '71999999991');
