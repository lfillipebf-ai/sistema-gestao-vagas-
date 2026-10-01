INSERT INTO vagas (titulo, empresa, tecnologia, modalidade, localizacao, descricao)
VALUES
('Estágio em Desenvolvimento Java', 'Tech Solutions', 'Java', 'Híbrido', 'Niterói - RJ', 'Desenvolvimento e manutenção de aplicações web.'),
('Estágio em Desenvolvimento Web', 'WebLab', 'JavaScript', 'Remoto', 'Brasil', 'Apoio no desenvolvimento de interfaces e APIs.'),
('Estágio em Dados', 'DataLab', 'Python', 'Híbrido', 'Rio de Janeiro - RJ', 'Apoio em análise e tratamento de dados.')
ON CONFLICT DO NOTHING;