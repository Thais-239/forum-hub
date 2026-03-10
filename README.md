# 💬 ForumHub API

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3-green)
![MySQL](https://img.shields.io/badge/MySQL-Database-blue)
![Status](https://img.shields.io/badge/status-concluído-brightgreen)

API REST desenvolvida em **Java com Spring Boot** para gerenciamento de tópicos de um fórum.

Este projeto foi desenvolvido como parte de um desafio prático para aplicar conceitos de **API REST**, **Spring Boot**, **JPA**, **DTOs**, **validação de dados** e **integração com banco de dados MySQL**.

---

# 🚀 Funcionalidades

A API permite realizar operações básicas de gerenciamento de tópicos:

✔ Criar um novo tópico  
✔ Listar todos os tópicos  
✔ Buscar um tópico por ID  
✔ Atualizar um tópico existente  
✔ Excluir um tópico  

Também foram implementados:

✔ Validação de dados com Bean Validation  
✔ Paginação na listagem de tópicos  
✔ Verificação de tópicos duplicados  
✔ Integração com banco de dados MySQL  
✔ Configuração básica de segurança com Spring Security  

---

# 🛠 Tecnologias utilizadas

- Java 17  
- Spring Boot  
- Spring Data JPA  
- Spring Security  
- Bean Validation  
- MySQL  
- Flyway  
- Maven  

---

# 📂 Estrutura do projeto

O projeto está organizado em pacotes para facilitar a manutenção:

- controller → endpoints da API  
- dto → objetos de transferência de dados  
- model → entidades do sistema  
- repository → acesso ao banco de dados  
- security → configuração básica de segurança  

---

# 🔗 Endpoints da API

| Método | Endpoint | Descrição |
|------|------|------|
| GET | /topicos | Lista todos os tópicos |
| GET | /topicos/{id} | Busca um tópico por ID |
| POST | /topicos | Cria um novo tópico |
| PUT | /topicos/{id} | Atualiza um tópico |
| DELETE | /topicos/{id} | Remove um tópico |

---

# 🧪 Testes da API

Os testes dos endpoints foram realizados utilizando **Postman**.

Exemplo de requisição para criar um tópico (POST /topicos):

```json
{
  "titulo": "Duvida API",
  "mensagem": "Criando topico teste",
  "autor": "Thais",
  "curso": "Java"
}
```

# 💾 Banco de dados

O projeto utiliza MySQL como banco de dados.

A senha do banco foi configurada utilizando variável de ambiente, evitando exposição de credenciais no repositório.

# 📌 Observação

Este projeto foi desenvolvido com fins educacionais para prática de desenvolvimento de APIs REST utilizando o ecossistema Spring.

👩‍💻 Desenvolvido por Thais Miranda



