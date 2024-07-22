
INSERT INTO public.tb_categoria_evento(
    nome)
VALUES ('Teatro');
INSERT INTO public.tb_categoria_evento(
    nome)
VALUES ('Caridade');
INSERT INTO public.tb_categoria_evento(
    nome)
VALUES ('Concerto');
INSERT INTO public.tb_categoria_evento(
    nome)
VALUES ('Webinar');
INSERT INTO public.tb_categoria_evento(
    nome)
VALUES ('Dança');

INSERT INTO public.tb_evento(
    data_hora_inicio, data_hora_termino, descricao, latitude, preco, titulo, id_categoria, longitude, artistas
) VALUES
-- Dados fictícios
('2024-08-01 10:00:00', '2024-08-01 12:00:00', 'Experimente a magia de um show musical ao ar livre com bandas locais.', -23.5500, 50.00, 'Concertos no Parque', 1, -46.6300, 'Grupo Harmonia'),
('2024-08-01 14:00:00', '2024-08-01 16:00:00', 'Sessão de arte e criatividade: exposição de artistas emergentes.', -23.5495, 55.00, 'Exposição Vibrante', 2, -46.6310, 'Artistas Locais'),
('2024-08-02 10:00:00', '2024-08-02 12:00:00', 'Uma manhã de jazz no centro cultural. Venha relaxar com boa música.', -23.5480, 60.00, 'Jazz no Centro', 3, -46.6320, 'Quarteto Jazz'),
('2024-08-02 15:00:00', '2024-08-02 17:00:00', 'Aventura gastronômica com degustações de pratos exóticos e pratos tradicionais.', -23.5475, 65.00, 'Festival Gastronômico', 4, -46.6330, 'Chefs Renomados'),
('2024-08-03 10:00:00', '2024-08-03 12:00:00', 'Show de stand-up comedy com os melhores comediantes da cidade.', -23.5470, 70.00, 'Noites de Comédia', 5, -46.6340, 'Comediantes Diversos'),
('2024-08-03 18:00:00', '2024-08-03 20:00:00', 'Dança e música eletrônica em uma festa incrível ao pôr do sol.', -23.5465, 75.00, 'Pôr do Sol Eletrônico', 1, -46.6350, 'DJ Solar'),
('2024-08-04 10:00:00', '2024-08-04 12:00:00', 'Descubra novos talentos da música em um festival de bandas independentes.', -23.5460, 80.00, 'Festival Indie', 2, -46.6360, 'Bandas Independentes'),
('2024-08-04 19:00:00', '2024-08-04 21:00:00', 'Teatro ao ar livre com uma adaptação moderna de clássicos.', -23.5455, 85.00, 'Teatro ao Ar Livre', 3, -46.6370, 'Trupe Teatral'),
('2024-08-05 10:00:00', '2024-08-05 12:00:00', 'Corrida de rua para todas as idades com várias categorias.', -23.5450, 90.00, 'Corrida de Rua', 4, -46.6380, 'Equipe de Corrida'),
('2024-08-05 20:00:00', '2024-08-05 22:00:00', 'Concerto acústico noturno com artistas locais em um ambiente intimista.', -23.5445, 95.00, 'Noite Acústica', 5, -46.6390, 'Artistas Acústicos'),
('2024-08-06 11:00:00', '2024-08-06 13:00:00', 'Encontro de livros e autores com sessões de autógrafos e discussões.', -23.5440, 100.00, 'Feira Literária', 1, -46.6400, 'Autores Famosos'),
('2024-08-06 17:00:00', '2024-08-06 19:00:00', 'Música ao vivo e comida de rua em um festival noturno.', -23.5435, 105.00, 'Festival Noturno', 2, -46.6410, 'Bandas Locais'),
('2024-08-07 10:00:00', '2024-08-07 12:00:00', 'Workshop de fotografia com dicas de profissionais renomados.', -23.5430, 110.00, 'Workshop de Fotografia', 3, -46.6420, 'Fotógrafos Expertos'),
('2024-08-07 14:00:00', '2024-08-07 16:00:00', 'Competição de dança com grupos de diferentes estilos e origens.', -23.5425, 115.00, 'Competição de Dança', 4, -46.6430, 'Grupos de Dança'),
('2024-08-08 10:00:00', '2024-08-08 12:00:00', 'Feira de artesanato local com produtos únicos e exclusivos.', -23.5420, 120.00, 'Feira de Artesanato', 5, -46.6440, 'Artesãos Locais'),
('2024-08-08 16:00:00', '2024-08-08 18:00:00', 'Evento de culinária com workshops e degustações de pratos internacionais.', -23.5415, 125.00, 'Aventuras Gastronômicas', 1, -46.6450, 'Chefs Internacionais'),
('2024-08-09 11:00:00', '2024-08-09 13:00:00', 'Palestras inspiradoras e networking em um seminário sobre inovação.', -23.5410, 130.00, 'Seminário de Inovação', 2, -46.6460, 'Palestrantes Renomados'),
('2024-08-09 19:00:00', '2024-08-09 21:00:00', 'Festival de filmes independentes com exibições e debates.', -23.5405, 135.00, 'Festival de Cinema', 3, -46.6470, 'Cineastas Independentes'),
('2024-08-10 10:00:00', '2024-08-10 12:00:00', 'Workshop de música eletrônica com DJs e produtores locais.', -23.5400, 140.00, 'Workshop Eletrônico', 4, -46.6480, 'DJs e Produtores'),
('2024-08-10 15:00:00', '2024-08-10 17:00:00', 'Palestra sobre tendências de tecnologia e o futuro das inovações.', -23.5395, 145.00, 'Palestra Tecnológica', 5, -46.6490, 'Especialistas em Tecnologia'),
('2024-08-11 10:00:00', '2024-08-11 12:00:00', 'Passeio cultural com visitas guiadas a pontos históricos.', -23.5390, 150.00, 'Passeio Cultural', 1, -46.6500, 'Guias Culturais'),
('2024-08-11 13:00:00', '2024-08-11 15:00:00', 'Evento de cosplay com competições e apresentações de personagens.', -23.5385, 155.00, 'Cosplay Festival', 2, -46.6510, 'Cosplayers Criativos'),
('2024-08-12 10:00:00', '2024-08-12 12:00:00', 'Festival de street art com artistas grafiteiros e exposições ao vivo.', -23.5380, 160.00, 'Festival de Street Art', 3, -46.6520, 'Artistas de Rua'),
('2024-08-12 16:00:00', '2024-08-12 18:00:00', 'Concerto de orquestra com peças clássicas e modernas.', -23.5375, 165.00, 'Concerto Orquestral', 4, -46.6530, 'Orquestra Sinfônica'),
('2024-08-13 10:00:00', '2024-08-13 12:00:00', 'Exibição de arte contemporânea em um museu local.', -23.5370, 170.00, 'Exibição Contemporânea', 5, -46.6540, 'Artistas Contemporâneos')


