# language: pt

Funcionalidade: Login

  @Login
Cenário: Login bem-sucedido

Dado que estou na página de login
Quando eu inserir credenciais válidas E tocar no botão de login
Então eu devo estar na página inicial

@loginFalha
Cenário: Credenciais inválidas

Dado que estou na página de login
Quando eu inserir credenciais inválidas E tocar no botão de login
Então eu devo ver uma mensagem de erro
