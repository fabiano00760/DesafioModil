# language: pt

@TesteLogin

Funcionalidade: Login

  @CadastraUsuario

  Cenario: Cadastro de usuario

    Dado  que estou na página de login
    Quando clico em no campo cadastra usuario
    E  preenchos os campos nome e senha e confirmo a senha
    E clico no campo cadastra
    Entao usuario cadastrado com sucesso

  @usuarioJaCadastrado

  Cenario: Usuario ja Cadastrado

    Dado que estou na página de login
  Quando clico em no campo cadastra usuario
    E  preenchos os campos nome e senha e confirmo a senha
    E clico no campo cadastra
  Entao aparece mensagem Usuario ja Cadastrado



  @loginFalha
  Cenário: Credenciais inválidas

    Dado que estou na página de login
    Quando eu inserir credenciais invalidas E tocar no botao de login
    Então eu devo ver uma mensagem de erro



  @Login
  Cenário: Login bem-sucedido

    Dado  que estou na página de login
    Quando clico em no campo cadastra usuario
    E  preenchos os campos nome e senha e confirmo a senha
    E clico no campo cadastra
    Quando eu inserir credenciais validas E tocar no botao de login
    Então eu devo estar na pagina inicial


