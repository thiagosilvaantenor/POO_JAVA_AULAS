# Aula 10
## Solução para problemas de BCE (Adaptado):

- Conhecer a informação e não o elemento(Ex: a controller conhecer o conteudo do TextField em Boundary, em vez de conhecer o TextField)
- Dessa forma evita dependências siciclas, oq geraria muitas dificuldades para manutenção
- Poderia ser usado o padrão de projeto Observer, mas ...
### A solução é usar as propriedades do JavaFX
- pacote javafx.beans.property.