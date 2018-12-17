# Rede

O aplicativo quando o usuário não estava interagindo com ele, não estava consumido nada de rede, o que era pra acontecer pois o aplicativo não estava executando nada em background. Agora quando o usuário estava navegando entre as telas que fazia alguma requisição ao servidor o consumo da rede subia para até 4MB/s, só que isso durava pouco tempo. Isto aconteceu porque o aplicativo além de pegar as informações do produto do servidor ele também carrega as imagens que são exibidas na tela, assim o consumo de rede era pra aumentar mesmo nesse caso, e como o servidor não tem um sistema de carregamento de imagem de baixa qualidade para locais que a imagem é exibida em um tamanho pequeno, o aplicativo tem de fazer a requisição da imagem completa toda vez que precisa mostrar ela, assim consumido mais da rede.
Abaixo é possível ver que o consumo de rede só acontece nas telas que carrega as informações do servidor, e no caso que carrega as imagens também, no caso da tela de galeria que carrega as imagens da memoria interna do celular o consumo de rede é 0.

![uso de CPU](https://github.com/jailson-dias/projeto-android/blob/master/Rede.png)