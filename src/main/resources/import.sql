insert into cozinha (ID, nome) valores ( 1 , ' Tailandesa ' );
insert into cozinha (ID, nome) valores ( 2 , ' Indiana ' );

insert into restaurante (id, nome, taxa_frete, cozinha_id) valores ( 1 , ' Thai Gourmet ' , 10 , 1 );
insert into restaurante (ID, nome, taxa_frete, cozinha_id) valores ( 2 , ' Thai Entrega ' , 9 . 50 , 1 );
insert into restaurante (id, nome, taxa_frete, cozinha_id) valores ( 3 , ' Tuk Tuk Comida Indiana ' , 15 , 2 );

insert into estado (ID, nome) valores ( 1 , ' mineiro ' );
insert into estado (ID, nome) valores ( 2 , ' SP ' );
insert into estado (ID, nome) valores ( 3 , ' Ceará ' );

insert into Cidade (ID, nome, estado_id) valores ( 1 , ' Uberlândia ' , 1 );
insert into Cidade (ID, nome, estado_id) valores ( 2 , ' Belo Horizonte ' , 1 );
insert into Cidade (ID, nome, estado_id) valores ( 3 , ' SP ' , 2 );
insert into Cidade (ID, nome, estado_id) valores ( 4 , ' Campinas ' , 2 );
insert into Cidade (ID, nome, estado_id) valores ( 5 , ' Fortaleza ' , 3 );

insert into forma_pagamento (id, Descrição) valores ( 1 , ' Cartão de Crédito ' );
insert into forma_pagamento (id, Descrição) valores ( 2 , ' Cartão de Débito ' );
insert into forma_pagamento (id, descricao) valores ( 3 , ' Dinheiro ' );

insert into permissao (id, nome, descricao) valores ( 1 , ' CONSULTAR_COZINHAS ' , ' Permite consultar cozinhas ' );
insert into permissao (id, nome, descricao) valores ( 2 , ' EDITAR_COZINHAS ' , ' Permite editar cozinhas ' );

insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) valores ( 1 , 1 ), ( 1 , 2 ), ( 1 , 3 ), ( 2 , 3 ), ( 3 , 2 ), ( 3 , 3 );