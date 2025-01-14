#encoding: UTF-8
#language: pt

Funcionalidade:  Ações do menu

  Cenário: Opção do menu "All Items"
    Dado que o usuário está acessar de login e preencher usuario "standard_user" e senha "secret_sauce"
    Quando o usuário clica no ícone ou símbolo de três linhas
    E aparece uma lista de opções: All Items, About, Logout, Reset App State e X
    E o usuário clica "All Items"
    Então o sistema deverá redirecionar para a tela principal com a lista de produtos

  Cenário: Opção do menu "About"
    Dado que o usuário está acessar de login e preencher usuario "standard_user" e senha "secret_sauce"
    Quando o usuário clica no ícone ou símbolo de três linhas
    E aparece uma lista de opções: All Items, About, Logout, Reset App State e X
    E o usuário clica "About"
    Então o sistema deverá redirecionar para site de SauceLabs

  Cenário: Opção do menu "Logout"
    Dado que o usuário está acessar de login e preencher usuario "standard_user" e senha "secret_sauce"
    Quando o usuário clica no ícone ou símbolo de três linhas
    E aparece uma lista de opções: All Items, About, Logout, Reset App State e X
    E o usuário clica "Logout"
    Então o sistema deverá redirecionar para a tela de login, deslogando o usuário

  Cenário: Opção do menu "Reset App State"
    Dado que o usuário está acessar de login e preencher usuario "standard_user" e senha "secret_sauce"
    Quando o usuário escolhe um produto "Sauce Labs Bike Light"
    E o usuário clica no botão ADD TO CART
    E o botão deverá mudar para REMOVE com cor de borda preta e o texto 'REMOVE'.
    E o sistema deve exibir uma notificação no carrinho
    E o usuário clica no ícone ou símbolo de três linhas
    E aparece uma lista de opções: All Items, About, Logout, Reset App State e X
    E o usuário clica "Reset App State"
    Então O sistema deverá remover a notificação do carrinho
    E o botão deverá mudar para "ADD TO CART"

  Cenário: Opção do menu "X"
    Dado que o usuário está acessar de login e preencher usuario "standard_user" e senha "secret_sauce"
    Quando o usuário clica no ícone ou símbolo de três linhas
    E aparece uma lista de opções: All Items, About, Logout, Reset App State e X
    E o usuário clica "X"
    Então o menu deverá fechar