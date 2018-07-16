# Projeto: Bestiary

## Equipe:
- Nailson Nascimento de Barros: Desenvolvedor


## Objetivo
Desenvolver uma aplicação mobile para ajudar os jogadores de dungeons and dragons 5e a consultar informações sobre monstros de forma facil e rapida.

## Páginas Criadas (Activitys)
- CadastroActivity
- LoginActivity
- MainActivity (tela principal)
- MonsterCreaterActivity
- NewMonsters (tela secundaria)
- ExibiMonstro

## Banco de Dados e Sistema de Autenticação Utilizados
- [Firebase] (https://firebase.google.com/)

A ideia incial era utilizar o Parse + Back4App porem o firebase se mostrou mais rapido de ser configurado e mais facil de ser trabalhado permitindo uso direto com json.

## Funcionalidades Implementadas
- Activitys
- Services
- Broadcast Receiver

## Layouts Utilizados
- ConstraintLayout
- LinearLayout
 - ScrollView
 - Spinner
 - AutoCompleteTextView
 - FloatingActionButton

# Features Implementadas
- Sistema de Login e Cadastro
- Listagem dos Monstros Base Do livro do jogadores
- Criação de monstros personalizados
- Compartilhamento de monstro com os outros usuarios

# Descrição da Implementação

eu iniciei o projeto com criando as activitys básicas que seriam necessárias para o funcionamento como login, cadastro, a MainActivity onde nela fica a Lista com os monstros base do livro de regras. Depois de fazer as activitys base eu fui implementar a lista de monstro e para isso foi necessário criar uma class auxiliar para fazer o get do Json com as informações dos monstros e criei um list_item.xml para adaptar as informações na listview que seria exibida. em seguida foi feito a implementação da tela que exibe todas as informações do monstro.

A próxima etapa foi implementar o login e cadastro que foram feito utilizando a ferramenta firebase.

A etapa seguinte era fazer a implementação do sistema que permite o usuário criar um monstro e compartilhar com todos que possuem o aplicativo e com isso foi feito o uso também a ferramenta firebase que se mostrou ser mais fácil de utilizar.(a ideia inicial era utilizar o Parse+back4app porém se mostrou difícil de ser configurado). Utilizando um service (CreaterMonsterViaService) foi possível fazer a comunicação das informações inserida pelos usuários junto com a class monstro que auxilia na criação do banco de dados no firebase foi possível fazer a  funcionalidade de compartilhamento dos monstro criado entre os usuários

E por fim foi utilizado um broadcast Receiver para avisar aos usuários sempre um um novo monstro for adicionado na lista de novos monstros ou caso ela seja atualizado para corrigir alguma das informações