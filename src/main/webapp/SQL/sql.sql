--https://pastebin.com/bFLqsicu
CREATE DATABASE unionview1
GO
USE unionview1
GO

CREATE TABLE cliente(
	id_cliente			INT				NOT NULL,
	nome_cliente		VARCHAR(40)		NOT NULL,
	email_cliente		VARCHAR(50)		NOT NULL,
	telefone_cliente	CHAR(11)		NOT NULL
	PRIMARY KEY (id_cliente)
)
GO

CREATE TABLE fornecedor(
	id_fornecedor		INT				NOT NULL,
	nome_fornecedor		VARCHAR(40)		NOT NULL,
	email_fornecedor	VARCHAR(50)		NOT NULL,
	telefone_fornecedor CHAR(11)		NOT NULL
	PRIMARY KEY (id_fornecedor)
)
GO

CREATE TABLE funcionario(
	id_func				INT				NOT NULL,
	nome_func			VARCHAR(100)	NOT NULL,
	salario_func		DECIMAL(7, 2)	NULL,
	login_func			CHAR(8)			NULL		CHECK  ((LEN(login_func)=(8))),
	senha_func			CHAR(8)			NULL		CHECK  ((LEN(senha_func)=(8)))
	PRIMARY KEY (id_func)
)
GO

INSERT INTO fornecedor VALUES
(1001,	'Fornecedor 1',	'forn1@email.com',	'11977889966'),
(1002,	'Fornecedor 2',	'forn2@email.com',	'11933669988'),
(1003,	'Fornecedor 3',	'forn3@email.com',	'11911220044'),
(1004,	'Fornecedor 4',	'forn4@email.com',	'11933654477'),
(1005,	'Fornecedor 5',	'forn5@email.com',	'11933001177')
GO

INSERT INTO cliente VALUES
(1001,	'Cliente 1',	'cli1@email.com',	'11987654321'),
(1002,	'Cliente 2',	'cli2@email.com',	'11912837465'),
(1003,	'Cliente 3',	'cli3@email.com',	'11932569874'),
(1004,	'Cliente 4',	'cli4@email.com',	'11912458632'),
(1005,	'Cliente 5',	'cli5@email.com',	'11902365400')

SELECT * FROM cliente
SELECT * FROM fornecedor
SELECT * FROM funcionario