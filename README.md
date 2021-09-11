# SistemaDeAlmoxarifado
Um sistema de almoxarifado feito em Java

# Sobre o projeto

Esse projeito foi a proposta do trabalho final de Programação Orientada a Objetos II.

O projeto consiste em um sistema de gerenciamento de um almoxarifado. Para
organização desse sistema foram criadas as seguintes entidades com as seus devidos atributos e
funcionalidades:
- <b>Peça:</b> constituída pelos atributos (ID_Peca, ValorPeca, Local, UPC) e com a função de
descrever as peças a serem movimentadas dentro do Sistema de Almoxarifado;
- <b>Estrado:</b> descrito por (ID_estrado, quantAtual, quantMax) é o esqueleto do estrado, tendo as
Pecas_Estrado referenciadas em seu ID;
- <b>Pecas_Estrado:</b> formadas pelos atributos (ID_pecaEstrado, ID_estrado, quanPeca, ID_peca)
informa quais as peças estão dentro de certo estrado;
- <b>Receptaculo:</b> com os atributos (ID_Receptaculo, ID_peca, posicao, corredor, quantAtual,
quantMax) descreve os receptáculos e as quantias de peças destes;
- <b>Ordem_Compra:</b> atribuída com (ID_OrdemCompra, Status), representa as ordens de compra
realizadas e qual status atual da mesma;
- <b>Itens_Comprados:</b> compostos por (ID_itens_comprados, ID_Peca, Quant_entregue_total,
Quant_compra, Id_OrdemCompra) descreve quais são os itens presentes em cada ordem de
compra;
- <b>Cliente:</b> constituído pelos atributos (ID_cliente, nome, telefone, endereco, CNPJ) tem a função
de cadastrar os clientes da empresa;
- <b>Pedido:</b> é formado por (ID_pedido e ID_cliente), é a tabela que faz o vínculo entre os pedidos
solicitados por um cliente e a lista de peças que ele deseja adquirir;
- <b>Itens_Pedido:</b> é constituída por (ID_itens_pedido, ID_pedido, Quant, ID_Peca), essa tabela
armazena os pedidos realizados por um cliente, essa identificação é realizada através do
ID_pedido, foi definido dessa forma pois um pedido pode ter diferentes peças e em diferentes
quantidades.


# Modelo Conceitual

<img src="https://raw.githubusercontent.com/joaopedrosalcantara/SistemaDeAlmoxarifado/main/ModeloConceitual.png" />


# Tecnologias utilizadas

- Java
- MySQL

# Autores

João Pedro Soares de Alcântara e Felipe Augusto.

https://www.linkedin.com/in/jo%C3%A3o-pedro-soares-de-alc%C3%A2ntara-4b040a165/
