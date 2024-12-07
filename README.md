# E-commerce🛒
Uma api de e-commerce que permite gerenciar usuários, cadatrar seus pedidos, listar todos os seus pedidos e mostrar um pedido com todo o detalhamento.


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

![projeto](https://github.com/Jeff-bt/ecommerce_buildrun/blob/main/images/projeto.png)

## Como iniciar o projeto

### Pré-requisitos
  - Java 17
  - Git
  - Docker
  - Postman

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

- Abra o Postman
- Clique em import:    
  ![projeto](https://github.com/Jeff-bt/ecommerce_buildrun/blob/main/images/import_collection_parte_1.png)
- E coloque o arquivo `E-commerce.postman_collection.json` que se encontra dentro da pasta raiz do projeto.
- Agora basta testar as APIs na pasta E-commerce do postman.

