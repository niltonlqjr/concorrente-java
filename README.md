# Exemplo em java da implementação de um buffer compartilhado por meio de monitores

## Instruções de compilação:
Para executar utilize o comando make run

Para gerar os arquivos de classe, utilize o comando make build

Para gerar o .jar utilize o comando make jar

## Como utilizar:
Com os arquivos de classe gerados, utilize o comando:

```java aula/concorrente/Concorrente \<fator multiplicador\> \<tamanho do buffer\>```

Com o .jar gerado, utilize o comando:

```java -jar Concorrente.jar \<fator multiplicador\> \<tamanho do buffer\>```

Em ambos os casos, os valores gerados serão inteiros de 100 a 5000, e o tempo que o thread do consumidor irá passar "dormindo" será dado pelo produto do fator multiplicador com o número que estava no buffer.
