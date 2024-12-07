# E-commerce🛒
Uma api de e-commerce que permite gerenciar usuários, cadatrar seus pedidos, lista todos os seus pedidos e mostra um pedido com todo o detalhamento.


### Propósito (Estudo)
No projeto, implementei funcionalidades como cadastro de pedidos, listagem com paginação, detalhamento completo dos pedidos e aprendi a utilizar melhor as annotations:

- @OneToOne, @OneToMany, @ManyToOne e @ManyToMany 
- @Embeddable e @EmbeddedId
- @JoinColumn e @JoinTable
- @UniqueConstraint

Também apliquei diferentes estratégias de Cascade e otimização de carregamento com Eager e Lazy loading.

## Tecnologias
- Spring Boot
- Spring Data JPA
- Docker
- Postgres

## Template

![testes](https://github.com/Jeff-bt/livechatms/blob/main/weebSocket_layout.png)

## Como iniciar o projeto

### Pré-requisitos
  - Java 17
  - Git
  - Docker

### Clona

- Clone o projeto, no terminal do gitbash, com o comando:
  
  ```
    git clone https://github.com/Jeff-bt/ecommerce_buildrun.git
  ```

### Configura

 - Navegue para pasta `ecommerce_buildrun`:

   ```
      cd ecommerce_buildrun
   ```

- Crie o banco de dados no docker:

  ```
      docker-compose up -d
  ```

- Faça o build do projeto:

  ```
      mvn clean install
  ```


### Executa

- Inicie a aplicação:

  ```
      java -jar target/ecommerce-0.0.1-SNAPSHOT.jar  
  ```

## Testando aplicação

- Abra o navegador com a url: `http://localhost:5000/`

