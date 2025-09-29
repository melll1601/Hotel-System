# Adicionada dependência do driver JDBC para conexão com o banco de dados 🐬

Criada camada de acesso a dados (DAO) para manipulação de hóspedes, quartos e reservas.

Preparação para testes de persistência e operações de CRUD.

### Status: Versão em fase de testes ⚠️


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
