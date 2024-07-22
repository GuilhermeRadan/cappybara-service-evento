INSERT INTO public.tb_evento(
    data_hora_inicio, data_hora_termino, descricao, latitude, preco, titulo, id_categoria, longitude, artistas
) VALUES
-- Dados fictícios
('2024-07-20 18:00:00', '2024-07-20 20:00:00', 'Festival de Música Eletrônica com DJs locais e internacionais.', -23.5501, 80.00, 'Techno Beats Festival', 1, -46.6301, 'DJ X, DJ Y'),
('2024-07-21 15:00:00', '2024-07-21 17:00:00', 'Mostra de Arte Moderna com exposição interativa.', -23.5485, 40.00, 'Arte Futurista', 2, -46.6315, 'Artista A, Artista B'),
('2024-07-22 10:00:00', '2024-07-22 12:00:00', 'Sessão de Yoga ao ar livre com instrutor renomado.', -23.5490, 30.00, 'Yoga no Parque', 3, -46.6325, 'Instrutor C'),
('2024-07-22 20:00:00', '2024-07-22 22:00:00', 'Peça de teatro clássica em um cenário histórico.', -23.5495, 50.00, 'Teatro ao Entardecer', 4, -46.6330, 'Grupo D'),
('2024-07-23 16:00:00', '2024-07-23 18:00:00', 'Feira de Gastronomia com pratos típicos e food trucks.', -23.5500, 60.00, 'Festival Gastronômico', 5, -46.6340, 'Chef E, Chef F'),
('2024-07-24 14:00:00', '2024-07-24 16:00:00', 'Workshop de Fotografia com dicas práticas e técnicas.', -23.5510, 70.00, 'Captura de Momentos', 1, -46.6350, 'Fotógrafo G'),
('2024-07-24 19:00:00', '2024-07-24 21:00:00', 'Show de Stand-up Comedy com comediantes locais.', -23.5520, 45.00, 'Noite de Risadas', 2, -46.6360, 'Comediante H'),
('2024-07-25 11:00:00', '2024-07-25 13:00:00', 'Passeio guiado por pontos históricos e culturais.', -23.5530, 55.00, 'Descubra a História', 3, -46.6370, 'Guia I'),
('2024-07-26 09:00:00', '2024-07-26 11:00:00', 'Encontro de Clube de Leitura com discussão sobre livros recentes.', -23.5505, 35.00, 'Clube do Livro', 4, -46.6380, 'Autor J'),
('2024-07-27 12:00:00', '2024-07-27 14:00:00', 'Competição de Esportes Radicais com atividades ao ar livre.', -23.5495, 85.00, 'Aventura Radical', 5, -46.6390, 'Atleta K'),
('2024-07-28 17:00:00', '2024-07-28 19:00:00', 'Palestra sobre Tecnologia e Inovação com especialistas da área.', -23.5480, 90.00, 'Futuro Digital', 1, -46.6400, 'Especialista L'),
('2024-07-29 20:00:00', '2024-07-29 22:00:00', 'Festival de Cinema Independente com exibição de curtas e longas.', -23.5465, 40.00, 'Cinema Alternativo', 2, -46.6410, 'Diretor M'),
('2024-07-30 10:00:00', '2024-07-30 12:00:00', 'Exposição de Ciências com experimentos interativos e palestras.', -23.5450, 75.00, 'Ciência ao Vivo', 3, -46.6420, 'Cientista N'),
('2024-07-31 18:00:00', '2024-07-31 20:00:00', 'Concerto de Música Clássica com orquestra e solistas.', -23.5445, 65.00, 'Música Clássica', 4, -46.6430, 'Orquestra O'),
('2024-07-01 11:00:00', '2024-07-01 13:00:00', 'Exposição de Fotografia Artística com temas variados.', -23.5430, 55.00, 'Lentes da Arte', 5, -46.6440, 'Fotógrafo P'),
('2024-07-02 14:00:00', '2024-07-02 16:00:00', 'Oficina de Pintura para todas as idades.', -23.5420, 60.00, 'Pintura e Cores', 1, -46.6450, 'Artista Q'),
('2024-07-03 09:00:00', '2024-07-03 11:00:00', 'Caminhada Ecológica com guia especializado.', -23.5410, 70.00, 'Natureza em Movimento', 2, -46.6460, 'Guia R'),
('2024-07-04 16:00:00', '2024-07-04 18:00:00', 'Encontro de Fanáticos por Quadrinhos com exibição de coleções.', -23.5405, 80.00, 'Comic Con', 3, -46.6470, 'Colecionador S'),
('2024-07-05 10:00:00', '2024-07-05 12:00:00', 'Festival de Música ao Vivo com bandas locais.', -23.5395, 85.00, 'Som Local', 4, -46.6480, 'Bandas T'),
('2024-07-06 15:00:00', '2024-07-06 17:00:00', 'Competição de Dança com apresentações e júri.', -23.5380, 95.00, 'Dança em Foco', 5, -46.6490, 'Dançarinos U'),
('2024-07-07 20:00:00', '2024-07-07 22:00:00', 'Noite de Jazz com performance de músicos renomados.', -23.5370, 60.00, 'Jazz ao Vivo', 1, -46.6500, 'Músico V'),
('2024-07-08 13:00:00', '2024-07-08 15:00:00', 'Feira de Artesanato com produtos locais e exclusivos.', -23.5360, 55.00, 'Artesanato e Cultura', 2, -46.6510, 'Artesão W'),
('2024-07-09 09:00:00', '2024-07-09 11:00:00', 'Exibição de Documentários sobre Meio Ambiente.', -23.5350, 75.00, 'Documentários Verdes', 3, -46.6520, 'Documentarista X'),
('2024-07-10 17:00:00', '2024-07-10 19:00:00', 'Concerto de Música Popular com artistas famosos.', -23.5340, 85.00, 'Música Popular', 4, -46.6530, 'Artista Y'),
('2024-07-11 11:00:00', '2024-07-11 13:00:00', 'Encontro de Poesia com leitura e performance.', -23.5330, 90.00, 'Poemas e Versos', 5, -46.6540, 'Poeta Z'),
('2024-07-12 14:00:00', '2024-07-12 16:00:00', 'Workshop de Culinária Internacional com receitas exclusivas.', -23.5320, 70.00, 'Cozinha Global', 1, -46.6550, 'Chef AA')

