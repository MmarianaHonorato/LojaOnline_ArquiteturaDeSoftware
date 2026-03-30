# LojaOnline_ArquiteturaDeSoftware

Este projeto é uma simulação de um sistema para uma lojinha online. O objetivo principal é aplicar conceitos de Arquitetura de Software utilizando um modelo Cliente-Servidor Monolítico e Padrões de Projeto (Design Patterns).

## 🗂️ Estrutura do Projeto
O projeto foi organizado em pacotes para manter o código limpo e separar bem as responsabilidades:
* **`model`**: Contém as entidades principais do domínio do sistema, como `Cliente`, `Produto`, `Pedido`, `ItemPedido` e `Pagamento`.
* **`repository`**: Finge ser o nosso banco de dados. Utilizamos listas em memória (List) para armazenar, buscar e simular a persistência das informações.
* **`service`**: Onde fica o "cérebro" da aplicação. Aqui estão as regras de negócio (`LojaService`) e a integração de pagamentos (`PagamentoExternoService`).
* **`view`**: Contém a classe principal (`teste.java`) que simula a interface com o usuário interagindo com o sistema no console.

## 🏗️ Principais Decisões Arquiteturais
* **Arquitetura Cliente-Servidor Monolítica:** Optamos por manter todas as camadas da aplicação (dados, regras de negócio e "interface" do terminal) rodando juntas em uma mesma base de código. 
* **Interatividade via Console:** Diferente de uma execução estática, o fluxo de compras permite que o usuário interaja com o sistema escolhendo produtos dinamicamente, demonstrando de forma mais clara a transição de estados do Pedido para o Pagamento.
* **Separação de Preocupações:** Os serviços não guardam dados (isso é papel dos repositórios) e os repositórios não calculam descontos ou criam regras (isso é papel dos serviços).

## 💳 Onde e como o Singleton foi aplicado
O padrão de projeto **Singleton** foi aplicado exclusivamente na classe **`PagamentoExternoService`**.

**Como foi feito?**
Implementamos o Singleton criando um construtor `private` (impedindo o uso do `new` em outras classes), uma variável estática interna e um método `public static getInstancia()` que retorna essa única conexão ativa.

**Justificativa (Por que fizemos isso?):**
Conectar nosso sistema com APIs de fora (como gateways de bancos ou operadoras de cartão) é um processo pesado e que consome muitos recursos. Por isso, escolhemos usar o padrão Singleton na classe de Pagamento. Com ele, a gente garante que a aplicação inteira use sempre a mesma conexão compartilhada, economizando memória e evitando sobrecarregar o servidor do banco com várias instâncias de conexão desnecessárias criadas a cada compra.
