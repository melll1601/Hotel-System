# 🏨 Sistema de Gestão de Hotel

**📌 Projeto Avaliativo – Prova Prática de Programação Orientada a Objetos (Java)**

Este sistema foi desenvolvido para gerenciar um hotel, permitindo o **cadastro de hóspedes, quartos, reservas e serviços**, utilizando os conceitos aprendidos em sala de aula.

---

## 📖 Funcionalidades

O sistema oferece as seguintes opções no **menu principal**:

### **Cadastro**
- ➕ **Cadastrar Hóspede** (nome, documento, telefone)
- ➕ **Cadastrar Quarto** (número, tipo, preço)
- ➕ **Cadastrar Reserva** (hóspede, quarto, data de entrada e saída)

### **Listagem**
- 📋 **Listar todos os hóspedes**
- 📋 **Listar todos os quartos**
- 📋 **Listar todas as reservas**

### **Pesquisa**
- 🔍 Pesquisar hóspede por **nome**
- 🔍 Pesquisar quarto por **tipo**
- 🔍 Pesquisar reserva por **nome do hóspede**

### **Edição e Exclusão**
- ✏ **Editar dados de um hóspede**
- ❌ **Cancelar uma reserva**

### **Sistema**
- 🚪 Sair do sistema

---

## 🛠 Estrutura do Projeto

O código foi organizado em **pacotes** para facilitar a manutenção:

```

src/
├── model/       # Classes de modelo (Hóspede, Quarto, Reserva, Serviço, Pessoa)
├── service/     # Lógica de negócio (manipulação de listas, pesquisas, etc.)
├── view/        # Interface de interação com o usuário (menus)
└── Main.java    # Ponto de entrada do sistema

````

---

## 📂 Classes Principais

- **Pessoa** *(classe abstrata)* → atributos e métodos comuns para classes derivadas.
- **Hóspede** → herda de `Pessoa` e representa o cliente.
- **Quarto** → dados sobre cada quarto disponível no hotel.
- **Reserva** → ligação entre `Hóspede`, `Quarto` e `Serviço`.
- **Serviço** → serviços adicionais (café da manhã, lavanderia, etc.).

---

## 💡 Conceitos Aplicados

- **POO**: Classes, Objetos, Encapsulamento, Herança e Polimorfismo.
- **List\<T\>**: Armazenamento de hóspedes, quartos e reservas.
- **Construtores**: Com e sem parâmetros.
- **toString()**: Exibição formatada de objetos.
- **instanceof**: Identificação de tipos em tempo de execução.
- **Tratamento de Erros**: `try/catch` para entradas inválidas.
- **Submenus**: Menus específicos para cada operação.
- **Agregação**: `Reserva` contendo `Serviço`.

---

## 🖼 Exemplo de Uso

```
===== MENU PRINCIPAL =====
1. Cadastrar Hóspede
2. Cadastrar Quarto
3. Cadastrar Reserva
4. Listar Hóspedes
5. Listar Quartos
6. Listar Reservas
7. Pesquisar Hóspede
8. Pesquisar Quarto
9. Pesquisar Reserva
10. Editar Hóspede
11. Cancelar Reserva
0. Sair
Escolha: 
```
