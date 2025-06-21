INSERT into enderecos(cep, logradouro, bairro, cidade, estado) VALUES
('12345-678', 'Rua A', 'Bairro Central', 'Cidade Exemplo', 'SP'),
('23456-789', 'Avenida B', 'Bairro Norte', 'Cidade Exemplo', 'RJ'),
('34567-890', 'Travessa C', 'Bairro Sul', 'Cidade Exemplo', 'MG'),
('45678-901', 'Praça D', 'Bairro Leste', 'Cidade Exemplo', 'RS'),
('56789-012', 'Rua E', 'Bairro Oeste', 'Cidade Exemplo', 'BA'),
('67890-123', 'Avenida F', 'Bairro Central', 'Cidade Exemplo', 'PR'),
('78901-234', 'Travessa G', 'Bairro Norte', 'Cidade Exemplo', 'SC'),
('89012-345', 'Praça H', 'Bairro Sul', 'Cidade Exemplo', 'PE'),
('90123-456', 'Rua I', 'Bairro Leste', 'Cidade Exemplo', 'CE'),
('01234-567', 'Avenida J', 'Bairro Oeste', 'Cidade Exemplo', 'GO');

INSERT INTO segurados(cpf, nome, email, telefone, endereco_cep, numero, complemento, data_nascimento) VALUES
('123.456.789-00', 'João Silva', 'joao.silva@gmail.com', '11987654321', '12345-678', '100', 'Apto 1', '1985-01-15'),
('987.654.321-00', 'Maria Oliveira', 'maria.oliveira@gmail.com', '11987654322', '23456-789', '200', 'Casa 2', '1990-02-20'),
('456.789.123-00', 'Carlos Pereira', 'carlos.pereira@gmail.com', '11987654323', '34567-890', '300', 'Sala 3', '1982-03-25'),
('321.654.987-00', 'Ana Costa', 'ana.costa@gmail.com', '11987654324', '45678-901', '400', 'Cobertura 4', '1995-04-30'),
('789.123.456-00', 'Lucas Santos', 'lucas.santos@gmail.com', '11987654325', '56789-012', '500', 'Loja 5', '1988-05-05'),
('654.321.987-00', 'Fernanda Lima', 'fernanda.lima@gmail.com', '11987654326', '67890-123', '600', 'Sala Comercial 6', '1992-06-10'),
('852.963.741-00', 'Roberto Almeida', 'roberto.almeida@gmail.com', '11987654327', '78901-234', '700', 'Apto 7', '1980-07-15'),
('741.852.963-00', 'Patrícia Rocha', 'patricia.rocha@gmail.com', '11987654328', '89012-345', '800', 'Casa 8', '1993-08-20'),
('369.258.147-00', 'Eduardo Martins', 'eduardo.martins@gmail.com', '11987654329', '90123-456', '900', 'Sala 9', '1986-09-25'),
('258.147.369-00', 'Juliana Souza', 'juliana.souza@gmail.com', '11987654330', '01234-567', '1000', 'Cobertura 10', '1991-10-30');



INSERT INTO apolices(tipo_apolice, data_vigencia) VALUES
('AUTOMOVEL', '2026-01-01'),
('RESIDENCIAL', '2023-02-15'),
('VIDA', '2026-03-10'),
('SAUDE', '2026-04-20'),
('VIAGEM', '2023-05-05'),
('EMPRESARIAL', '2026-06-30'),
('OUTROS', '2025-07-15'),
('OUTROS', '2023-08-01'),
('OUTROS', '2025-09-10'),
('OUTROS', '2023-10-25');

INSERT INTO apolices_segurados(numero_apolice, cpf_segurado) VALUES
(1, '123.456.789-00'),
(1, '987.654.321-00'),
(2, '456.789.123-00'),
(2, '321.654.987-00'),
(3, '789.123.456-00'),
(3, '654.321.987-00'),
(4, '852.963.741-00'),
(4, '741.852.963-00'),
(5, '369.258.147-00'),
(5, '258.147.369-00'),
(6, '123.456.789-00'),
(6, '987.654.321-00'),
(7, '456.789.123-00'),
(7, '321.654.987-00'),
(8, '789.123.456-00'),
(8, '654.321.987-00'),
(9, '852.963.741-00'),
(9, '741.852.963-00'),
(10, '369.258.147-00'),
(10, '258.147.369-00');

INSERT INTO servicos(descricao, valor) VALUES
('Cobertura de colisão', 1500.00),
('Proteção contra roubo', 1200.00),
('Assistência residencial', 800.00),
('Seguro de vida básico', 2000.00),
('Plano de saúde completo', 3000.00),
('Seguro de viagem internacional', 1000.00),
('Responsabilidade civil empresarial', 2500.00),
('Proteção contra incêndio residencial', 900.00),
('Cobertura para danos a terceiros', 1100.00),
('Seguro de acidentes pessoais', 700.00);

INSERT INTO apolices_servicos(numero_apolice, codigo_servico) VALUES
(1, 1),
(1, 2),
(2, 3),
(2, 4),
(3, 5),
(3, 6),
(4, 7),
(4, 8),
(5, 9),
(5, 10),
(6, 1),
(6, 2),
(7, 3),
(7, 4),
(8, 5),
(8, 6),
(9, 7),
(9, 8),
(10, 9),
(10, 10);