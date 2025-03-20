#language: pt

@Login
Funcionalidade: Login valido

  Contexto:
    Dado que estou na pagina de login

  @CenarioComum
  Cenario: Login com usuario valido
    Quando faço login com dados validos
    Entao realizo login com sucesso
