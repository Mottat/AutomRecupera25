#language: pt

Funcionalidade: Criar renegociação

  Contexto:
    Dado que estou logado recupera

  @CriarReneg
  Cenario: CriarReneg
    Quando consulto codigo de recebimento "CCR"
    E realizo o pagamento do boleto
    E executo a tarefa de geracao de renegociacao
    Então a renegociacao e criada com sucesso

  @CriarRenegManual
  Cenario: CriarRenegManual
    Quando consulto o codigo de recebimento "80343520044"
    E realizo o pagamento do boleto
    E executo a tarefa de geracao de renegociacao
    Então a renegociacao e criada com sucesso

#    Quando consulto cod recebimento
#    E realizo o pagamento do boleto
#    E rodo tarefa reneg
#    Entao reneg criada com sucesso


  @EsqPagarBoleto
  Esquema do Cenario: EsqPagarBoleto
    Quando pago boleto de "<recebimento>"
    Então boleto pago com sucesso

    Exemplos:
      | recebimento |
      | 38190182    |
      | 38190183    |
      | 38190178    |
      | 38190181    |
      | 38190179    |
      | 38190184    |

