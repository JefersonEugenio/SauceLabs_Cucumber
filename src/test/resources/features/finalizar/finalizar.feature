#encoding: UTF-8
#language: pt

Funcionalidade: Finalização de compra

  Cenário: Finalizar compra com produto no carrinho
    Dado que o usuário está acessar de login e preencher usuario "standard_user" e senha "secret_sauce"
    E que o usuário já adicionou um produto "Sauce Labs Bike Light" ao carrinho
    E que o usuário está na página do carrinho
    E o usuário clica no botão CHECKOUT
    E que o usuário está na página do checkout
    E o usuário preenche o campo First Name com "jeferson"
    E o usuário preenche o campo Last Name com "lopes"
    E o usuário preenche o campo ZipPostal com "98765432"
    E o usuário clica no botão CONTINUE
    Quando o sistema deverá redirecionar para a página "Overview"
    E o usuário verifica um produto listado na página de Overview
    E o usuário verifica o valor do produto listado na página de Overview
    E o usuário verifica do item total, taxa e total listado na página de Overview
    E o usuário clica no botão FINISH
    Então o sistema deverá redirecionar para a tela de confirmação (Finish) exibindo a mensagem "THANK YOU FOR YOUR ORDER"

  Cenário: Cancelar e retornar a tela principal
    Dado que o usuário está acessar de login e preencher usuario "standard_user" e senha "secret_sauce"
    E que o usuário já adicionou um produto "Sauce Labs Bike Light" ao carrinho
    E que o usuário está na página do carrinho
    E o usuário clica no botão CHECKOUT
    E que o usuário está na página do checkout
    E o usuário preenche o campo First Name com "jeferson"
    E o usuário preenche o campo Last Name com "lopes"
    E o usuário preenche o campo ZipPostal com "98765432"
    E o usuário clica no botão CONTINUE
    Quando o sistema deverá redirecionar para a página "Overview"
    E o usuário clica no botão CANCEL
    Então o sistema deverá redirecionar para a tela principal com a lista de produtos