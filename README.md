# Labyrinth of Leaves

**Universidade Católica de Pernambuco**

**Alunos:** 
- Maria Luiza Ribeiro de Lima (**RA:** 00000848982)
- Roberto Regis de Araújo Lima Neto (**RA:** 00000848959)
- Vínicius Martins Galindo Andrade (**RA:** 00000848753)
- Matheus Veríssimo Rodrigues Pinheiro (**RA:** 00000850062)
- Vitor Hugo José Sales da Silva (**RA:** 00000849201)

**Disciplina:** Programação Orientada a Objetos (2024.1)

**Professor:** Lucas Rodolfo

Labyrinth of Leaves é um jogo desenvolvido em Java para a cadeira de Programação Orientada a Objetos. O objetivo do jogo é guiar o personagem Greg na busca pela saída de um labirinto repleto de desafios. Greg deve encontrar chaves espalhadas pelo caminho para destrancar a porta final e, assim, escapar. Durante sua jornada, ele precisa evitar perigos como aranhas e armadilhas mortais que podem acabar com sua aventura.

![gameplay1](https://github.com/Roberto20deluxe/Labirinto_OOP_2024.1/blob/main/img/40s1.gif?raw=true)

![gameplay1](https://github.com/Roberto20deluxe/Labirinto_OOP_2024.1/blob/main/img/40s2.gif?raw=true)

![gameplay1](https://github.com/Roberto20deluxe/Labirinto_OOP_2024.1/blob/main/img/40s4.gif?raw=true)



## Requisitos Minimos

### Classes
Aventureiro : O nosso aventureiro é representado na classe Player, subclasse de Entidade
As principais funcionalidades dessa classe são o estado do jogador (vida, adquirir items, etc), atualizar os sprites do personagem, chamar os estados de final do jogo (0 de vida, fim do labirinto), entre outras, alem de vários parametros como a posição de spawn

Tesouro : Os nossos tesouros são representados por classes do package Objetos, que tambem são uma sublasse de Entidade. Eles podem ser encontrados nos baus espalhados pelo mapa.

Perigo : Temos um package Monstro para representar monstros, perigos vivos do labirinto. Temos lá a classe aranha, que se move em direções aleatorias e tira parte da vida do jogador quando entra em contato.
Tambem temos um Objeto Armadilha que tira a vida do personagem quando ele passa na mesma tile.

Labirinto : A logica principal do labirinto está contido no package Main, des da janela do jogo, a checagem de colisão, o tratamento dos inputs do jogador, a lista de entidades e suas posições, aos graficos e os eventos, entre outros. 
O mapa em si é um .txt (res -> maps -> WorldMap.txt) que é representado pelo TileManager.

### Coleções 
Existe alguns usos de arrays e arraylist, como por exemplo, na classe Gamepanel onde existe um Arraylist para as Entidades, contendo todas as entidades presentes no mapas e suas informações.

### Tratamento de exceções
Existe uma variedade de tratamentos de exceções, como tentando acessar uma imagem de um grafico que não existe

// wip : completar o resto dessas descrições //
