Um documento de proposta bem estruturado deve responder às seguintes perguntas:


1. Qual é a sua ideia de aplicativo? Inclua uma breve justificativa.

A ideia é criar um aplicativo que é um Bestiary uma coletânea de informações sobre “monstros” do jogo Dungeons and Dragons quinta edição permitindo uma consulta rápida sobre os dados e estatísticas. Será possível também com que o usuário crie seus próprios monstros para que seja adicionado ao Bestiary e que será visível entre os outros usuário da plataforma. E programa notificações para caso seja adicionado um novo monstro do tipo escolhido pelo usuário. 



2. Quem usará seu aplicativo e por que eles o usarão?
Os usuários serão mestres e jogadores de Dungeons and Dragons quinta edição pelo fato de que será possível encontrar uma diversa variedades de monstros que será inserido pela própria comunidade, além de ser possível programar avisos para caso um novo monstro de um determinado tipo for inserido ele ser notificado.



3. Existe um aplicativo similar? Se sim, como o seu será diferente?
Sim, além de possuir os monstros padrões que também haverá os monstros inseridos pelos próprios usuários, além de ser possível configurar notificações para caso determinado tipos de monstro tenha sido adicionado ao Bestiary.
https://play.google.com/store/apps/details?id=sk.libco.bestiaryfive
https://play.google.com/store/apps/details?id=com.teamphoenixapps.bestiary.release





4. Como sua aplicação será estruturada? Quais telas o usuário irá interagir, e o que elas fazem? Qual é o fluxo de trabalho? 

Tela principal onde haverá uma lista com todos os monstros onde se ele clicar ele irá para uma tela que exibe as informações daquele monstro na tela. na tela principal também haverá um menu onde será possível configurar notificação e criar seu próprio monstro.
Tela de informação dos monstros que exibe as informações dos monstros.
Tela de Criação de monstro onde haverá campos para ser preenchido para se criar um monstro.




5. Quais componentes Android serão utilizados, além de classes, bibliotecas de terceiros, paradigmas de design, etc? Sua aplicação deve usar pelo menos 3 componentes básicos de Android.

Activity 1 (vai possuir uma listview que vai mostrar todos os monstro disponíveis, um filtro por nome e por “nível de desafio(CR)” vai ser a tela inicial do aplicativo vai possuir um menu que vai ter as opções de atualização da lista de monstros, criar um novo monstro e definir um timer para dizer de quanto em quanto tempo a lista deverá ver se tem atualização)
Activity 2 (vai possuir um formulário de criação de monstro, botão de voltar, botão de salvar)
broadcastReceiver (vai ser responsável por emitir um aviso para usuário que a lista de monstros foi atualizada)
Service(vai ser responsável por fazer a sincronização do app do usuário com os novos monstro que foram inseridos por outros usuários através do Parse + back4app e emitindo um broadcast avisando que a tarefa foi terminada)


Parse + back4app (para fazer o compartilhamento dos monstro entre os usuários).
utilizarei também um JSON para preencher os monstros bases fornecida pelo usuário do reddit  droiddruid  no link ( https://dl.dropboxusercontent.com/s/iwz112i0bxp2n4a/5e-SRD-Monsters.json )
fornecendo a base de monstro para a tela inicial.
