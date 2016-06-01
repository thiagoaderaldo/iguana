#SELETCs

select * from assuntos;
select * from dispositivos;
select * from unidade_organizacional;
select * from sub_unidade_organizacional;
select * from estatus;
select * from solicitante;

#INSERTs

INSERT INTO `iguana`.`grupos`
(`nome`,
`descricao`)
VALUES
('admin',
'Grupo de Administradores');

insert into usuarios values ('xxxxx','Iguana','(85)3222-8585','(85)8585-8585','iguana','iguana@codigof.com.br','avatar5.png',SHA2('1',256),1);
insert into grupo_do_Usuario values('iguana','admin');