#encoding: UTF-8
#language: pt

Funcionalidade:  Ordenação de produtos

  Cenário: Ordenar produtos na página produto (Z ao A)
    Dado que o usuário está acessar de login e preencher usuario "standard_user" e senha "secret_sauce"
    Quando o usuário clica no Select Name(A to Z)
    E aparecer a lista de opções Name (A to Z), Name (Z to A), Price (low to high) e Price (high to low)
    E o usuário seleciona Name (Z to A)
    Então os produtos deverão ser reorganizados na página em ordem decrescente de Z para A

  Cenário: Ordenar produtos na página produto (menor ao maior)
    Dado que o usuário está acessar de login e preencher usuario "standard_user" e senha "secret_sauce"
    Quando o usuário clica no Select Name(A to Z)
    E aparecer a lista de opções Name (A to Z), Name (Z to A), Price (low to high) e Price (high to low)
    E o usuário seleciona Price (low to high)
    Então os produtos deverão ser reorganizados na página do menor para o maior preço

  Cenário: Ordenar produtos na página produto (maior ao menor)
    Dado que o usuário está acessar de login e preencher usuario "standard_user" e senha "secret_sauce"
    Quando o usuário clica no Select Name(A to Z)
    E aparecer a lista de opções Name (A to Z), Name (Z to A), Price (low to high) e Price (high to low)
    E o usuário seleciona Price (high to low)
    Então os produtos deverão ser reorganizados na página do maior para o menor preço