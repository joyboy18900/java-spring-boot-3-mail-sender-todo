# Java Spring Boot 3 Mail Sender Example

This project demonstrates how to send emails using Java Spring Boot 3. It provides examples of sending emails with both `SimpleMailMessage` and `MimeMessage`.

## Features

- Send simple text emails using `SimpleMailMessage`.
- Send rich content emails (e.g., HTML) using `MimeMessage`.

## Technologies Used

- Java 17
- Spring Boot 3
- Spring Boot Starter Mail

## Getting Started

### Prerequisites

- JDK 17 or higher
- Maven 3.6 or higher
- An SMTP server (e.g., Gmail SMTP)

### Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/joyboy18900/java-spring-boot-3-mail-sender-todo.git
    cd java-spring-boot-3-mail-sender-todo
    ```

2. Configure SMTP settings:
    - Open `src/main/resources/application.properties`.
    - Set your SMTP server details:
      ```properties
      spring.mail.host=smtp.gmail.com
      spring.mail.port=587
      spring.mail.username=your-email@gmail.com
      spring.mail.password=your-email-password
      spring.mail.properties.mail.smtp.auth=true
      spring.mail.properties.mail.smtp.starttls.enable=true
      ```

3. Build the project:
    ```bash
    mvn clean install
    ```

4. Run the application:
    ```bash
    mvn spring-boot:run
    ```

5. Access the application:
    - Open your web browser and navigate to `http://localhost:8080`.

## Usage

### Sending Simple Email

To send a simple text email using `SimpleMailMessage`:

1. Use the following code snippet in your service:
    ```java
    @Autowired
    private JavaMailSender emailSender;

    public void sendSimpleMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }
    ```

### Sending Rich Content Email

To send an email with rich content (e.g., HTML) using `MimeMessage`:

1. Use the following code snippet in your service:
    ```java
    @Autowired
    private JavaMailSender emailSender;

    public void sendRichContentMessage(String to, String subject, String htmlBody) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(htmlBody, true);
        emailSender.send(message);
    }
    ```
