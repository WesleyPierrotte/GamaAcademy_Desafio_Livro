INSERT INTO USUARIO(nome, email, telefone,cpf,rg,endereco) VALUES('Fulano', 'fulano@test.com', '55-xx-xxxxxxxxx','111111111-11','1010101010','Av.Sucesso 88- Bairro Vitoria - SP-SP/BR');
INSERT INTO USUARIO(nome, email, telefone,cpf,rg,endereco) VALUES('Beltrano', 'beltrano@test.com', '55-xx-xxxxxxxxx','222222222-22','20202020', 'Rua.Bom Gosto 99- Bairro Legal - POA-RS/BR');

INSERT INTO AUTOR(nome) VALUES('Rodrigo Turini');
INSERT INTO AUTOR(nome) VALUES('Mauricio Aniche');
INSERT INTO AUTOR(nome) VALUES('Hugo Baraúna');
INSERT INTO AUTOR(nome) VALUES('Julia Naomi Boeira');

INSERT INTO LIVRO(titulo, autor_id,edicao,editora,isbn,status) VALUES('Orientação a Objeto',1,10, 'Casa do Codigo',123, 'DISPONIVEL');
INSERT INTO LIVRO(titulo, autor_id,edicao,editora,isbn,status) VALUES('TDD',2,11, 'Casa do Codigo',123, 'VENDIDO');

