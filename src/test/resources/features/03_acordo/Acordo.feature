#language: pt

@Acordo
Funcionalidade: Fazer acordo
  Como um usuário do sistema
  Quero poder realizar acordos para clientes
  Para que eles possam regularizar suas pendências
  
  Contexto:
    Dado que estou na pagina inicial do recupera

  @EsqAcordoCliente
  Esquema do Cenario: EsqAcordoCliente
    Quando clico no menu operacao
    E faço um acordo "<cliente>" e "<quantidade>" e "<desconto>"
    Entao acordo criado com sucesso

    Exemplos:
      | cliente         | quantidade | desconto |
#      | 99492874563     | 0          | 0        |
#      | 99298113625     | 0          | 88       |
#      | 99480332302     | 1          | 0        |
      | 98964856074     | 5          | 0        |
#      | 10269737758     | 3          | 88       |
#      | 02705747516     | 3          | 88       |

#      | 99301433940     | 1          | 0        |
#      | 99298113625     | 1          | 0        |
#      | 99480332302     | 1          | 0        |
#      | 10269737758     | 1          | 0        |
#      | 98964856074     | 1          | 0        |


#    Cenários CCR
  @AVistaSemDescontoCCR
  Cenario: AVistaSemDescontoCCR
    Quando clico no menu operacao
    E faço um acordo "CCR" e "0" e "0"
    Entao acordo criado com sucesso

  @AVistaComDescontoCCR
  Cenario: AVistaComDescontoCCR
    Quando clico no menu operacao
    E faço um acordo "CCR" e "0" e "50"
    Entao acordo criado com sucesso

  @ParceladoSemDescontoCCR
  Cenario: ParceladoSemDescontoCCR
    Quando clico no menu operacao
    E faço um acordo "CCR" e "2" e "0"
    Entao acordo criado com sucesso

  @ParceladoComDescontoCCR
  Cenario: ParceladoComDescontoCCR
    Quando clico no menu operacao
    E faço um acordo "CCR" e "3" e "50"
    Entao acordo criado com sucesso



#    Cenários CBR
  @AVistaSemDescontoCBR
  Cenario: AVistaSemDescontoCBR
    Quando clico no menu operacao
    E faço um acordo "CBR" e "0" e "0"
    Entao acordo criado com sucesso

  @AVistaComDescontoCBR
  Cenario: AVistaComDescontoCBR
    Quando clico no menu operacao
    E faço um acordo "CBR" e "0" e "50"
    Entao acordo criado com sucesso

  @ParceladoSemDescontoCBR
  Cenario: ParceladoSemDescontoCBR
    Quando clico no menu operacao
    E faço um acordo "CBR" e "4" e "0"
    Entao acordo criado com sucesso

  @ParceladoComDescontoCBR
  Cenario: ParceladoComDescontoCBR
    Quando clico no menu operacao
    E faço um acordo "CBR" e "5" e "50"
    Entao acordo criado com sucesso


#  @ParceladoComDescontoCBR
#  Cenario: ParceladoComDescontoCBR
#    Quando clico no menu operacao
#    E faço um acordo "CBR" e "3" e "66"
#    Entao acordo criado com sucesso


