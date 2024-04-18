## Recursos Aplicados na Implementação:
#### 1- Endpoints REST:
- Foram criados 3 endpoints fundamentais para o projeto Linketinder, seguindo os princípios de APIs REST.

#### 2- Servidor Web:
- Apache Tomcat foi utilizado para subir e hospedar o servidor onde os endpoints estão disponíveis.
- 
#### 3- Criação de Endpoints:
- Servlets foram usados para desenvolver e gerenciar os endpoints do projeto.

## Configurações:
#### Endpoints Criados:
- http://localhost:3000/candidato/cadastrar
- http://localhost:3000/empresa/cadastrar
- http://localhost:3000/vaga/cadastrar

#### Dependências Utilizadas:
- implementation 'com.google.code.gson:gson:2.10.1': Para trabalhar com JSON, possivelmente para serializar e desserializar dados enviados e recebidos pelos endpoints.
- providedCompile 'javax.servlet:javax.servlet-api:4.0.1': Para fornecer as classes e interfaces necessárias para trabalhar com Servlets e APIs de servlets.

#### Ferramenta de Testes:
- Postman foi utilizado para testar e validar os endpoints criados.

## Documentação/Contrato de Utilização dos Endpoints
#### Introdução:
Este documento descreve os endpoints disponíveis no projeto Linketinder, fornecendo detalhes sobre suas funcionalidades, métodos HTTP permitidos, parâmetros necessários e exemplos de solicitações e respostas.

###### 1- http://localhost:3000/candidato/cadastrar
- Método HTTP: POST

###### Descrição:
- Este endpoint é utilizado para cadastrar um novo candidato.

###### Parâmetros:
- nome: String (obrigatório) - Nome do candidato.
- email: String (obrigatório) - Email do candidato.
- cpf: String (obrigatório) - CPF do candidato.
- idade: int (obrigatório) - Idade do candidato.
- estado: String (obrigatório) - Estado do candidato.
- cep: String (obrigatório) - CEP do candidato.
- descricao: String (obrigatório) - Descrição do candidato.

###### Exemplo de Solicitação:
```json
{
    "nome": "Sandubinha",
    "email": "contato@sandubinha.com.br",
    "cpf": "12345678901",
    "idade": "29",
    "estado": "Rio de Janeiro",
    "cep": "12345678",
    "descricao": "Técnico em Desenvolvimento de Sistemas"
}
```
###### Resposta:
- 200 OK: Candidato cadastrado com sucesso.
- 400 Bad Request: Erro nos dados fornecidos ou formato inválido.

###### 2- http://localhost:3000/empresa/cadastrar
- Método HTTP: POST

###### Descrição:
- Este endpoint é utilizado para cadastrar uma nova empresa.

###### Parâmetros:
- nome: String (obrigatório) - Nome da empresa.
- email: String (obrigatório) - Email da empresa.
- cnpj: String (obrigatório) - CNPJ da empresa.
- pais: String (obrigatório) - País da empresa.
- estado: String (obrigatório) - Estado da empresa.
- cep: String (obrigatório) - CEP da empresa.
- descricao: String (obrigatório) - Descrição da empresa.

###### Exemplo de Solicitação:
```json
{
    "nome": "XPTO Software",
    "email": "contato@xpto.com.br",
    "cnpj": "34567890123456",
    "pais": "Brasil",
    "estado": "Rio de Janeiro",
    "cep": "12345678",
    "descricao": "Fábrica de Software"
}
```
###### Resposta:
- 200 OK: Empresa cadastrada com sucesso.
- 400 Bad Request: Erro nos dados fornecidos ou formato inválido.

###### 3- http://localhost:3000/vaga/cadastrar
- Método HTTP: POST

###### Descrição:
- Este endpoint é utilizado para cadastrar uma nova vaga.

###### Parâmetros:
- nome: String (obrigatório) - Nome da vaga.
- estado: String (obrigatório) - Estado da vaga.
- cep: String (obrigatório) - CEP da vaga.
- descricao: String (obrigatório) - Descrição da vaga.

###### Exemplo de Solicitação:
```json
{
  "nome": "Pessoa Desenvolvedora Backend",
  "estado": "Rio de Janeiro",
  "cep": "12345678",
  "descricao": "Fábrica de Softwares"
}
```
###### Resposta:
- 200 OK: Vaga cadastrada com sucesso.
- 400 Bad Request: Erro nos dados fornecidos ou formato inválido.