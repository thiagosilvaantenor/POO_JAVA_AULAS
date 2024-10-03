# Aula 09 - CRUD

## BCE - Boundary Entity Control (Adaptação)
- Boundary recebe um contato e passa para o control, control gera um entity
- Camada Entity será conhecida por Boundary e Control

- Boundary só se preocupa com a tela
    - gera e consome entidades de e para o control
    - `entityToBoundary(Entidade e) => pega as informações da entidade`
    - `boundarytoEntity():entity => gera a entidade`
    - Toda comunicação com o usuário é informada por ele
- Control
    - Métodos da entidade


