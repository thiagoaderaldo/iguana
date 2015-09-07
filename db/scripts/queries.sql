#SELETCs

select * from assuntos;
select * from dispositivos;
select * from unidade_organizacional;
select * from sub_unidade_organizacional;
select * from estatus;
select * from solicitante;

#INSERTs

INSERT INTO `iguana`.`grupos`
(`grupoId`,
`descricao`)
VALUES
('admin',
'Grupo de Administradores');

insert into usuarios values ('xxxxx','Iguana','(85)3222-8585','(85)8585-8585','iguana','iguana@codigof.com.br','avatar5.png',MD5('1'),1);
insert into grupoDoUsuario values('iguana','admin');