#encoding: UTF-8
#language: pt

Funcionalidade: Funciona e as informações dados na página do "checkout"

  Cenário: Preenchimento completo e válido
    Dado que o usuário está acessar de login e preencher usuario "standard_user" e senha "secret_sauce"
    E que o usuário já adicionou um produto "Sauce Labs Bike Light" ao carrinho
    E que o usuário está na página do carrinho
    E o usuário clica no botão CHECKOUT
    Quando que o usuário está na página do checkout
    E o usuário preenche o campo First Name com "jeferson"
    E o usuário preenche o campo Last Name com "lopes"
    E o usuário preenche o campo ZipPostal com "98765432"
    E o usuário clica no botão CONTINUE
    Então o sistema deverá redirecionar para a página "Overview"

  Cenário: Campo "First Name" em branco
    Dado que o usuário está acessar de login e preencher usuario "standard_user" e senha "secret_sauce"
    E que o usuário já adicionou um produto "Sauce Labs Bike Light" ao carrinho
    E que o usuário está na página do carrinho
    E o usuário clica no botão CHECKOUT
    Quando que o usuário está na página do checkout
    E o usuário preenche o campo First Name com ""
    E o usuário preenche o campo Last Name com "lopes"
    E o usuário preenche o campo ZipPostal com "98765432"
    E o usuário clica no botão CONTINUE
    Então O sistema exibirá a mensagem: "Error: First Name is required"

  Cenário: Campo "Last Name" em branco
    Dado que o usuário está acessar de login e preencher usuario "standard_user" e senha "secret_sauce"
    E que o usuário já adicionou um produto "Sauce Labs Bike Light" ao carrinho
    E que o usuário está na página do carrinho
    E o usuário clica no botão CHECKOUT
    Quando que o usuário está na página do checkout
    E o usuário preenche o campo First Name com "jeferson"
    E o usuário preenche o campo Last Name com ""
    E o usuário preenche o campo ZipPostal com "98765432"
    E o usuário clica no botão CONTINUE
    Então O sistema exibirá a mensagem: "Error: Last Name is required"

  Cenário: Campo "Zip/Postal" em branco
    Dado que o usuário está acessar de login e preencher usuario "standard_user" e senha "secret_sauce"
    E que o usuário já adicionou um produto "Sauce Labs Bike Light" ao carrinho
    E que o usuário está na página do carrinho
    E o usuário clica no botão CHECKOUT
    Quando que o usuário está na página do checkout
    E o usuário preenche o campo First Name com "jeferson"
    E o usuário preenche o campo Last Name com "lopes"
    E o usuário preenche o campo ZipPostal com ""
    E o usuário clica no botão CONTINUE
    Então O sistema exibirá a mensagem: "Error: Postal Code is required"

  Cenário: Todos os campos em branco
    Dado que o usuário está acessar de login e preencher usuario "standard_user" e senha "secret_sauce"
    E que o usuário já adicionou um produto "Sauce Labs Bike Light" ao carrinho
    E que o usuário está na página do carrinho
    E o usuário clica no botão CHECKOUT
    Quando que o usuário está na página do checkout
    E o usuário preenche o campo First Name com ""
    E o usuário preenche o campo Last Name com ""
    E o usuário preenche o campo ZipPostal com ""
    E o usuário clica no botão CONTINUE
    Então O sistema exibirá a mensagem: "Error: First Name is required"

  Cenário: Cancelar e retornar ao carrinho
    Dado que o usuário está acessar de login e preencher usuario "standard_user" e senha "secret_sauce"
    E que o usuário já adicionou um produto "Sauce Labs Bike Light" ao carrinho
    E que o usuário está na página do carrinho
    E o usuário clica no botão CHECKOUT
    Quando que o usuário está na página do checkout
    E o usuário clica no botão CANCEL
    Então o sistema deverá redirecionar para a tela do "Your Cart"