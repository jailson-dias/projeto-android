### Projeto final de Android

##### Mockup do projeto

-   Invision: https://invis.io/QKOZO7VJ9PG#/329966047_Produtos


# Projeto final de android

O Projeto desenvolvido foi a versão em android nativo do aplicativo da startup Prepi para varejistas.

## Telas Feitas

#### Home
A home é a tela onde fica os produtos que o varejista postou no prepi, esta tela foi feita utilizando CardView e RecycleView, onde foi utilizado duas colunas de Cards para exibir os produtos postados. Esta tela foi desenvolvida e integrada com o back-end do Prepi, a loja que foi integrada com o aplicativo é a loja DStore o qual o site dela no Prepi é https://dstore.prepi.com.br.

#### Pedidos
A tela de pedidos é onde fica os pedidos que os clientes fizeram para a loja, nela tem uma lista de pedidos e a opção de o varejista dizer se aquele produto ainda está disponível ou se ele já foi vendido. Essa tela não foi desenvolvida totalmente, ela foi integrada com o back-end, mas ainda não está salvando as respostas ao pedido, no caso quando o varejista responde que aquela peça está disponível ou não tem mais em estoque, está resposta não está sendo enviada para o servidor.

#### Editar produto
A tela de editar produto é a tela de quando o usuário deseja fazer alguma alteração naquele produto, assim ele precisa ir na tela Home, procurar o pedido dele e clicar no card do produto, fazendo isso ele vai ser redirecionado para a tela de editar o produto selecionado.
Esta tela não foi completamente desenvolvida, ela não foi integrada com o back-end, assim o varejista não consegue editar o produto.

#### Criar produto
Esta parte de criar produto é dividida em duas telas e elas são acessiveis a partir do botão de '+'na tela Home.
A primeira tela é a galeria, nessa tela é exibido as fotos do usuário em um lista para ele escolher qual vai postar no Prepi e a segunda é apenas a tela onde ele vai colocar as informações do produto para ser postado no Prepi.
Depois dessas duas telas o varejista é redirecionado para o instagram, onde ele pode postar a foto no Stories do instagram dele.

Na tela da galeria é utilizado SharedPreferences para exibir a imagem selecionada no topo da tela, assim é possível que quando o varejista altere a foto selecionada na listagem automaticamente ela á alterada no topo da tela.
O SharedPreferences também é utilizado para passar a imagem para a tela de colocar as informações do produto.

Na tela de colocar as informações do produto é utilizado o FileProvider para converter o endereço da imagem para o formato que pode ser compartilhado com outros aplicativos, para assim ser possível compartilha-la no stories do instagram automaticamente.

