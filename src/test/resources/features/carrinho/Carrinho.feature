#encoding: UTF-8
#language: pt

Funcionalidade: A página do carrinho

  Cenário: Remover produto do carrinho
    Dado que o usuário está acessar de login e preencher usuario "standard_user" e senha "secret_sauce"
    E que o usuário já adicionou um produto "Sauce Labs Bike Light" ao carrinho
    E que o usuário está na página do carrinho
    Quando o usuário clica no botão REMOVE a página do carrinho
    Então a notificação no icone do carrinho desaparece
    E a lista do produto desaparece

  Cenário: Continuar comprando pelo carrinho
    Dado que o usuário está acessar de login e preencher usuario "standard_user" e senha "secret_sauce"
    E que o usuário já adicionou um produto "Sauce Labs Bike Light" ao carrinho
    E que o usuário está na página do carrinho
    Quando o usuário clica no botão CONTINUE SHOPPING
    Então o sistema deverá redirecionar para a tela principal com produtos

  Cenário: Ir para checkout pelo carrinho
    Dado que o usuário está acessar de login e preencher usuario "standard_user" e senha "secret_sauce"
    E que o usuário já adicionou um produto "Sauce Labs Bike Light" ao carrinho
    E que o usuário está na página do carrinho
    Quando o usuário clica no botão CHECKOUT
    Então o sistema deverá redirecionar para a tela	de informações (checkout)