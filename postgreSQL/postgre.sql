CREATE TABLE candidatos (
	id INT,
	nome VARCHAR(100) NOT NULL,
	sobrenome VARCHAR(100) NOT NULL,
	data_de_nascimento DATE NOT NULL,
	email VARCHAR(255) UNIQUE NOT NULL,
	cpf VARCHAR(15) PRIMARY KEY,
	pais VARCHAR(100) NOT NULL,
	cep VARCHAR(15) NOT NULL,
	descricao TEXT NOT NULL,
	senha VARCHAR(255) NOT NULL,
	stack_id INT,
	Foreign Key (stack_id) REFERENCES stacks (id)
);

CREATE TABLE empresas (
	id INT,
	nome VARCHAR(100) NOT NULL,
	cnpj VARCHAR(50) PRIMARY KEY,
	email VARCHAR(255) UNIQUE NOT NULL,	
	pais VARCHAR(100) NOT NULL,
	cep VARCHAR(15) NOT NULL,
	descricao TEXT NOT NULL,
	senha VARCHAR(255) NOT NULL
);

CREATE TABLE stacks (
	id INT PRIMARY KEY,
	stack varchar(100) UNIQUE NOT NULL
);

CREATE TABLE vagas (
	id INT PRIMARY KEY,	
	nome VARCHAR(100) NOT NULL,
	descricao TEXT NOT NULL,
	local VARCHAR(255) NOT NULL,
	empresa_id INT,
	Foreign Key (empresa_id) REFERENCES empresas (cnpj)
);

CREATE TABLE curtidas(
	candidato_id INT,
	empresa_id INT,
	Foreign Key (candidato_id) REFERENCES candidatos (id),
	Foreign Key (empresa_id) REFERENCES empresas (id)
);

CREATE TABLE matchs (
	candidato_id INT,
	empresa_id INT,
	Foreign Key (candidato_id) REFERENCES candidatos (id),
	Foreign Key (empresa_id) REFERENCES empresas (id)
);

INSERT INTO candidatos (nome, sobrenome, data_de_nascimento, email, cpf, pais, cep, descricao, senha) VALUES 
  ('Yuji', 'Itadori', '1999-07-04', 'yuji.itadori@example.com', '123.456.789-00', 'Japão', '12345-678', 'Estudante do ensino médio que possui uma força física excepcional', 'senha123'),
  ('Megumi', 'Fushiguro', '2000-03-17', 'megumi.fushiguro@example.com', '987.654.321-00', 'Japão', '54321-876', 'Estudante do ensino médio, usuário de maldição com habilidades poderosas', 'senha456'),
  ('Nobara', 'Kugisaki', '2000-11-25', 'nobara.kugisaki@example.com', '456.789.123-00', 'Japão', '98765-432', 'Estudante do ensino médio, usuária de maldição com técnica única de manipulação de bonecos', 'senha789'),
  ('Satoru', 'Gojo', '1989-10-23', 'satoru.gojo@example.com', '321.654.987-00', 'Japão', '56789-012', 'Professor da Escola Técnica de Feiticeiros de Tóquio, um dos feiticeiros mais poderosos', 'senhaabc'),
  ('Maki', 'Zenin', '1998-12-07', 'maki.zenin@example.com', '654.321.987-00', 'Japão', '10987-654', 'Estudante do ensino médio, membro da família Zenin com habilidades de combate excepcionais', 'senhaxyz');

INSERT INTO empresas (nome, cnpj, email, pais, cep, descricao, senha) VALUES
	('Kyoto Tech Solutions', '12345678901234', 'kyoto.tech@example.com', 'Japão', '12345-678', 'Empresa especializada em desenvolvimento de software baseado em tecnologias avançadas de Jujutsu Kaisen.', 'senha123'),
	('Shibuya Innovations', '98765432109876', 'shibuya.innov@example.com', 'Japão', '54321-876', 'Empresa líder em inovação tecnológica inspirada no mundo de Jujutsu Kaisen, oferecendo soluções de IA e realidade aumentada.', 'senha456'),
	('Tokyo Magic Solutions', '65432109876543', 'tokyo.magic@example.com', 'Japão', '98765-432', 'Empresa que utiliza técnicas de feitiçaria moderna para desenvolver softwares de alta qualidade inspirados em Jujutsu Kaisen.', 'senha789'),
	('Kyoto Curse Computing', '32109876543210', 'kyoto.curse@example.com', 'Japão', '67890-123', 'Empresa especializada em segurança da informação e proteção contra maldições digitais, inspirada pelo mundo de Jujutsu Kaisen.', 'senhaabc'),
	('Tokyo Sorcery Systems', '56789012345678', 'tokyo.sorcery@example.com', 'Japão', '01234-567', 'Empresa pioneira em sistemas de computação mágica e tecnologia espiritual, com base no universo de Jujutsu Kaisen.', 'senhaxyz');


INSERT INTO stacks (stack) VALUES
	('Java'),
	('Groovy'),
	('JavaScript'),
	('TypeScript'),
	('Teste Unitários'),
	('PostgreSQL');									

INSERT INTO vagas (empresa_id, nome, local, descricao) VALUES
	(1, 'Desenvolvedor Front-end Jujutsu Kaisen', 'Tóquio, Japão', 'Estamos procurando um desenvolvedor Front-end apaixonado por Jujutsu Kaisen para se juntar à nossa equipe e ajudar a criar experiências web incríveis inspiradas no anime.'),
	(2, 'Engenheiro de Software Jujutsu Kaisen', 'Kyoto, Japão', 'Estamos buscando um engenheiro de software talentoso e entusiasta de Jujutsu Kaisen para desenvolver aplicativos e sistemas inovadores que refletem os temas e conceitos do anime.'),
	(3, 'Designer de Interface de Usuário (UI) Jujutsu Kaisen', 'Osaka, Japão', 'Procuramos um designer de UI apaixonado por Jujutsu Kaisen para criar interfaces de usuário esteticamente agradáveis e funcionais, incorporando elementos visuais e conceitos do anime.'),
	(4, 'Analista de Segurança de Informação Jujutsu Kaisen', 'Nagoya, Japão', 'Estamos à procura de um analista de segurança de informação especializado em Jujutsu Kaisen para proteger nossos sistemas e dados contra maldições e ameaças cibernéticas.'),
	(5, 'Desenvolvedor Full-stack Jujutsu Kaisen', 'Fukuoka, Japão', 'Procuramos um desenvolvedor Full-stack com habilidades em todas as áreas do desenvolvimento web e interesse em Jujutsu Kaisen para liderar projetos de ponta e criar soluções técnicas inspiradas no anime.');


INSERT INTO curtidas (candidato_id, empresa_id) VALUES
	(1, 4),
	(1, 2),
	(1, 3),
	(2, 6),
	(2, 1),
	(3, 2),
	(3, 3),
	(3, 1),
	(4, 4),
	(4, 7),
	(4, 5),
	(5, 4),
	(5, 7),
	(5, 2);

INSERT INTO matchs (candidato_id, empresa_id) VALUES
	(2, 2), 
	(5, 5),
	(5, 1),
	(5, 5);