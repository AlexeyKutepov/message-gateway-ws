# message-gateway-ws
The SOAP-service for JBoss Fuse 6.1 
This service send email-messages from your smtp-server.

How to use:

1. #####Clone this repositry and open the project folder: 
   git clone https://github.com/AlexeyKutepov/message-gateway-ws.git

   cd message-gateway-ws

2. #####Install this project:
   $ mvn install

3. #####Create file message.gateway.ws.cfg in {path to JBoss Fuse}/etc/ and add the following propertys:
   mail.host=your smtp server host
   mail.port=your smtp server port
   mail.username=your username
   mail.password=your password
   mail.protocol=smpt
   mail.from=your email address

4. #####Install message-gateway-ws on JBoss Fuse 6.1 and run it:
   install mvn:com.tz/message-gateway-ws/1.0.0
   start {number of message-gateway-ws}
