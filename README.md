# Desafio Básico
Nesse desafio, a ideia era elaborar um projeto onde o usuário possa apresentar seus dados inicialmente (Nome, Tipo de Conta e Saldo),
a partir disso, realizar um menu de opções onde o mesmo poderia escolher entre 4 opções (Consultar dados, Depósito, Transferência e Sair), 
e cada uma delas teria sua lógica envolvida. Já no inicio, algumas ideias já foram posta, onde o usuário não pode adicionar valores negativos no saldo inicial 
e nem colocar tipos de contas que não sejam as padrões(corrente ou poupança).

## Consultar dados
Basicamente, nesta opção, era retornado ao usuário seus dados apresentados no inicio e caso houvesse alguma mudança no saldo, automaticamente ja era atualizado.

## Depósito
Nesta opção, foi implementada a lógica do usuário poder apresentar o valor que gostaria de depositar, com isso,
ao realizar o depósito corretamente, o sistema indicava que foi um sucesso e retornava o saldo com o valor atualizado.

## Transferência
Na transferência, a lógica era parecida com a de cima, porém um fator adicional é apresentado, já que dependendo do valor que fosse transferido, 
o sistema verifica se o valor é compativel com o saldo atual, caso for, a transferência é realizada com sucesso, se não, uma mensagem é apresentada, 
alertando o usuário que não foi possível completar pela fato de saldo.

## Sair
Por ultimo, o sistema, ao receber o valor da operação de saída, é finalizado e assim o programa é encerrado.

### Linguagem utilizada: Java 21
