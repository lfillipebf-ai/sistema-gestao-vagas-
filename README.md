# Sistema de Gestão de Vagas

Sistema web para gerenciamento de vagas de estágio e candidaturas, desenvolvido como projeto de portfólio acadêmico.

## Autor

**Luis Fillipe Backer Faria**  
GitHub: [lfillipebf-ai](https://github.com/lfillipebf-ai)

> Projeto desenvolvido para estudos de desenvolvimento de software, APIs REST, banco de dados relacionais e desenvolvimento web.

## Tecnologias

- Java
- Spring Boot
- Spring Data JPA
- PostgreSQL
- React.js
- Vite
- REST API
- Docker / Docker Compose
- HTML5 / CSS3
- Git / GitHub

## Funcionalidades

- Cadastro, edição, consulta e exclusão de vagas
- Cadastro e gerenciamento de candidatos
- Registro de candidaturas
- Alteração do status da candidatura
- Filtros de vagas por tecnologia e modalidade
- Persistência em PostgreSQL
- API REST documentada no código
- Interface web responsiva
- Ambiente de desenvolvimento com Docker Compose

## Estrutura

```text
sistema-gestao-vagas/
├── backend/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/br/com/luisfillipe/vagas/
│   │   │   └── resources/
│   ├── pom.xml
│   └── Dockerfile
├── frontend/
│   ├── src/
│   ├── package.json
│   ├── vite.config.js
│   └── Dockerfile
├── docker-compose.yml
└── README.md
```

## Como executar

### Pré-requisitos

- Docker Desktop
- Docker Compose

### 1. Clone o repositório

```bash
git clone https://github.com/lfillipebf-ai/sistema-gestao-vagas.git
cd sistema-gestao-vagas
```

### 2. Suba os serviços

```bash
docker compose up --build
```

### 3. Acesse

Frontend:

```text
http://localhost:5173
```

API:

```text
http://localhost:8080/api
```

PostgreSQL:

```text
localhost:5432
```

## Endpoints principais

### Vagas

- `GET /api/vagas`
- `GET /api/vagas/{id}`
- `POST /api/vagas`
- `PUT /api/vagas/{id}`
- `DELETE /api/vagas/{id}`

### Candidatos

- `GET /api/candidatos`
- `POST /api/candidatos`

### Candidaturas

- `GET /api/candidaturas`
- `POST /api/candidaturas`
- `PATCH /api/candidaturas/{id}/status`

## Próximas evoluções

- Autenticação e autorização com Spring Security
- Paginação
- Testes automatizados
- Upload de currículo
- Perfil de empresa
- Notificações
- Deploy em nuvem

## Licença

Projeto acadêmico e de portfólio.
