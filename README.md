# Email Service 
Serviço responsável pelo envio de e-mails utilizando **Spring Boot** e **SMTP do Gmail**.

## Tecnologias Utilizadas
- Java 17
- Maven
- Spring Boot
- Spring Mail
- Bean Validation
- Spring Web
- Spring Boot DevTools
- Lombok

## Instalação
1. Clone o repositório
````text
git clone https://github.com/wenderson-fe/email-service.git
````
2. Instale as dependências com Maven
3. Altere o `application.properties` com suas credências
````properties
spring.mail.username:seu_username
spring.mail.password:sua_senha
mail.from:seu_remetente
````

## API Endpoints
API fornece os seguintes endpoints:
### Post Email
````text
POST /emails - Envie um e-mail
````
### Body
````json
{
  "toEmail": "destinatario@gmail.com",
  "subject": "Assunto do email",
  "body": "Conteúdo do email"
}
````
