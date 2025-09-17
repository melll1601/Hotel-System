# 🏨 Sistema de Gestão de Hotel

**Projeto Avaliativo – Prova Prática de Programação Orientada a Objetos (Java, JDBC e MySQL)**

Este sistema foi desenvolvido para gerenciar um hotel, permitindo o cadastro de hóspedes, quartos, reservas e serviços, utilizando Java com JDBC para integração ao banco de dados MySQL.

---

## 📖 Funcionalidades

### Cadastro
- ➕ Cadastrar Hóspede (nome, documento, telefone)  
- ➕ Cadastrar Quarto (número, tipo, preço)  
- ➕ Cadastrar Reserva (hóspede, quarto, data de entrada e saída)  

### Listagem
- 📋 Listar todos os hóspedes  
- 📋 Listar todos os quartos  
- 📋 Listar todas as reservas  

### Pesquisa
- 🔍 Pesquisar hóspede por nome  
- 🔍 Pesquisar quarto por tipo  
- 🔍 Pesquisar reserva por nome do hóspede  

### Edição e Exclusão
- ✏ Editar dados de um hóspede  
- ❌ Cancelar uma reserva  

### Sistema
- 🚪 Sair do sistema  

---

## 🛠 Estrutura do Projeto

```text
src/
├── model/       # Classes de modelo (Hóspede, Quarto, Reserva, Serviço, Pessoa)
├── dao/         # Classes de acesso ao banco (JDBC: CRUD com SQL)
├── service/     # Regras de negócio (validações, lógica)
├── view/        # Interface de interação com o usuário (menus)
└── Main.java    # Ponto de entrada do sistema
```

## 📂 Classes Principais

- **Pessoa** (classe abstrata) → atributos e métodos comuns  
- **Hóspede** → herda de Pessoa e representa o cliente  
- **Quarto** → dados sobre cada quarto disponível no hotel  
- **Reserva** → ligação entre Hóspede, Quarto e Serviço  
- **Serviço** → serviços adicionais (café da manhã, lavanderia, etc.)  
- **DAO** → classes responsáveis pelo CRUD no banco de dados via JDBC  

---

## 💡 Conceitos Aplicados

- **POO**: Classes, Objetos, Encapsulamento, Herança e Polimorfismo  
- **JDBC**: Conexão Java ↔ MySQL com PreparedStatements  
- **DAO**: Organização do acesso ao banco  
- **List<T>**: Armazenamento temporário de objetos  
- **Construtores**: Com e sem parâmetros  
- **toString()**: Exibição formatada de objetos  
- **Tratamento de Erros**: try/catch para SQL e entradas inválidas  
- **Submenus**: Menus específicos para cada operação  
- **Agregação**: Reserva contendo Serviço  

---

## ⚙️ Configuração do Banco de Dados (Docker + MySQL)

- Certifique-se de que o **Docker esteja rodando** antes de subir o container do MySQL.  
- A senha do usuário root do banco é: `mysqlPW`.  
- O banco criado automaticamente pelo Docker é `mysqlDB`, mas o script SQL do projeto cria `SistemaHotel`.  
- Para que o Java consiga se conectar corretamente:  
  - O container MySQL deve estar ativo.  
  - A porta `3306` deve estar liberada e não estar sendo usada por outro serviço.  
  - Conexões externas ao banco são liberadas pelo comando:  
    ```sql
    UPDATE mysql.user SET host='%' WHERE user='root';
    FLUSH PRIVILEGES;
    ```
- Caso haja problemas de conexão, verifique:  
  - Se o container está rodando (`docker ps`)  
  - Se a URL do JDBC está correta (`jdbc:mysql://localhost:3306/SistemaHotel`)  
  - Se o usuário e senha batem com o especificado (`root` / `mysqlPW`)  

---

### 1. Criar pasta para o MySQL
```bash
mkdir mysql
```

```bash
cd mysql
```

### 2. Criar arquivo `docker-compose.yml`
```yaml
version: '3.8'

services:
  db:
    image: mysql/mysql-server:latest
    container_name: my-mysql
    restart: always
    environment:
      - MYSQL_DATABASE=mysqlDB
      - MYSQL_ROOT_PASSWORD=mysqlPW
    ports:
      - '3306:3306'
    volumes:
      - mysql-volume:/var/lib/mysql

volumes:
  mysql-volume:
    driver: local
```

### Explicação dos parâmetros do Docker

- `image` → imagem do MySQL usada  
- `container_name` → nome do container  
- `MYSQL_DATABASE` → banco criado automaticamente  
- `MYSQL_ROOT_PASSWORD` → senha do usuário root  
- `ports` → porta de acesso (3306)  
- `volumes` → persistência dos dados  

---

### 3. Subir o container
```bash
docker-compose up -d
```

---

### 4. Acessar o container
```bash 
docker exec -it my-mysql bash
```

### 5. Entrar no MySQL
```bash
mysql -u root -p
```

### 6. Liberar conexões externas
```bash
UPDATE mysql.user SET host='%' WHERE user='root';
```

```bash
FLUSH PRIVILEGES;
```

## 📂 Script do Banco de Dados (MySQL Workbench)

```sql
CREATE DATABASE SistemaHotel;
USE SistemaHotel;

CREATE TABLE hospede (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    documento VARCHAR(50) UNIQUE,
    telefone VARCHAR(21)
);

CREATE TABLE quarto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    numero INT NOT NULL,
    tipo ENUM('simples', 'duplo', 'suite'),
    preco DECIMAL(10,2) NOT NULL
);

CREATE TABLE reserva (
    id INT AUTO_INCREMENT PRIMARY KEY,
    quarto_id INT NOT NULL,
    hospede_id INT NOT NULL,
    data_entrada DATE NOT NULL,
    data_saida DATE NOT NULL,
    FOREIGN KEY (quarto_id) REFERENCES quarto(id),
    FOREIGN KEY (hospede_id) REFERENCES hospede(id)
);

CREATE TABLE servico (
    id INT AUTO_INCREMENT PRIMARY KEY,
    reserva_id INT NOT NULL,
    tipo ENUM('cafe_da_manha', 'lavanderia', 'spa', 'academia'),
    preco DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (reserva_id) REFERENCES reserva(id)
);
```
