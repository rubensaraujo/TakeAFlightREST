use takeaflight_v2;

select * from permissao;

select * from grupo;

select * from grupo_permissoes;

select * from usuarios_grupos;

select * from usuarios_permissoes;

insert into grupo_permissoes(grupos_id, permissoes_id)
values(4, 3);

insert into usuarios_grupos(usuarios_id, grupos_id)
values(2, 1);

insert into usuarios_permissoes(usuarios_id, permissoes_id)
values(2, 1);
