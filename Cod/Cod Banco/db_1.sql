use empresadeeventos;
set foreign_key_checks=0;
drop database empresadeeventos;
set foreign_key_checks=1;
create database empresaDeEventos;
use empresaDeEventos;


CREATE TABLE localdeevento(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome varchar(50),
    logradouro VARCHAR(80),
    cep VARCHAR(9),
    numero VARCHAR(12),
    capacidade INT,
    fileiras int,
    colunas int
);


CREATE TABLE evento(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome varchar(40) NOT NULL,
    idadeMin INT NOT NULL,
    duracao varchar(20) NOT NULL,
    dataInicio varchar(10) NOT NULL,
    dataFim varchar(10) NOT NULL,
    horaInicio varchar(10) NOT NULL,
    horaFim varchar(10) NOT NULL,
    valorIngresso DECIMAL(10,2) NOT NULL,
    id_localdeevento INT NOT NULL,
    FOREIGN KEY (id_localdeevento) REFERENCES localdeevento(id) ON DELETE CASCADE
);


CREATE TABLE assento(
    id INT AUTO_INCREMENT PRIMARY KEY,
    numero INT NOT NULL,
    coluna int not null,
    fileira int not null,
    especial BIT NOT NULL,
    id_localdeevento INT NOT NULL,
    FOREIGN KEY (id_localdeevento) REFERENCES localdeevento(id) ON DELETE CASCADE
);

CREATE TABLE ingresso(
    id INT AUTO_INCREMENT PRIMARY KEY,
    comprado BIT NOT NULL,
    id_evento INT NOT NULL,
    id_assento INT,
    FOREIGN KEY (id_evento) REFERENCES evento(id) ON DELETE CASCADE,
    FOREIGN KEY (id_assento) REFERENCES assento(id) ON DELETE CASCADE
);


CREATE TABLE usuario(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(60) NOT NULL,
    email VARCHAR(70) UNIQUE NOT NULL,
    senha VARCHAR(20) NOT NULL
);


CREATE TABLE cliente(
    id INT AUTO_INCREMENT PRIMARY KEY,
    dataNascimento varchar(10) NOT NULL,
    id_usuario INT NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id) ON DELETE CASCADE
);

-- Tabela: Organizador
CREATE TABLE organizador(
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id) ON DELETE CASCADE
);


-- Tabela: Venda
CREATE TABLE venda(
    id INT AUTO_INCREMENT PRIMARY KEY,
    valor DECIMAL(10,2) NOT NULL,
    dataCompra varchar(10) NOT NULL,
    dataPagamento varchar(10),
    id_evento INT NOT NULL,
    id_cliente INT NOT NULL,
    id_ingresso INT NOT NULL,
    FOREIGN KEY (id_evento) REFERENCES evento(id) ON DELETE CASCADE,
    FOREIGN KEY (id_cliente) REFERENCES cliente(id) ON DELETE CASCADE,
    FOREIGN KEY (id_ingresso) REFERENCES ingresso(id) ON DELETE CASCADE
);

-- Cadastro de local de evento
insert into localdeevento (nome, logradouro, cep, numero, capacidade, fileiras, colunas) values 
    ("Teatro Lopes", "R. São Pedro", "09320-890", "129",  16, 4, 4),
    ("Parque Anhembi", "Av. Olavo Fontoura", "02012-021", "1209", 4000, 0, 0);
    

-- Cadastro de assento
insert into assento (numero, coluna, fileira, especial, id_localdeevento) values
    (1,1,1,0,1),
    (2,1,2,0,1),
    (3,1,3,0,1),
    (4,1,4,0,1),
    (5,2,1,0,1),
    (6,2,2,0,1),
    (7,2,3,0,1),
    (8,2,4,0,1),
    (9,3,1,0,1),
    (10,3,2,0,1),
    (11,3,3,0,1),
    (12,3,4,0,1),
    (13,4,1,0,1),
    (14,4,2,0,1),
    (15,4,3,0,1),
    (16,4,4,0,1);

-- Cadastro de usuário

insert into usuario (email, nome, senha) values 
    ("administrador@gmail.com", "Rafael Carrenho", "admin123"),
    ("client@gmail.com", "Charlie", "client12");

-- Cadastro de organizador 
insert into organizador (id_usuario) values (1);

-- Cadastro de cliente
insert into cliente (dataNascimento, id_usuario) values ("2001-03-20", 2);
select usuario.id as 'Id', usuario.nome as 'Nome', usuario.email as 'Email', cliente.id_usuario as 'Id Cli', organizador.id_usuario as 'Id Org' from usuario 
left join cliente on cliente.id_usuario = usuario.id 
left join organizador on organizador.id_usuario = usuario.id  
where usuario.email = 'client@gmail.com' and usuario.senha = 'client12';
-- Cadastro de evento
insert into evento (nome, idadeMin, duracao, dataInicio, dataFim, horaInicio, horaFim, valorIngresso, id_localdeevento) values
    ("Expo Arte Moderna", 14, "10 horas", "2024-05-20","2024-05-20", "09:00", "19:00", 40.00, 2),
    ("Apresentação de Balé", 0, "4 horas", "2024-05-18","2024-05-18", "10:00", "14:00", 5.00, 1);
-- cadastro de ingressos
insert into ingresso (comprado, id_evento) values (0, 1);
insert into ingresso (comprado, id_evento, id_assento) values 
(0, 2, 5),
(0, 2, 6),
(0, 2, 7),
(0, 2, 8);

-- cadastro de venda
insert into venda (valor, dataCompra, dataPagamento, id_evento, id_cliente, id_ingresso) values
    (5.00, "2024-05-15", "2024-05-15",1, 1, 2);
update ingresso set comprado = 1 where id = 2;
    
select * from localdeevento;
select * from evento;