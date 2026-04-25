package com.example.chatbot.controller;
import com.example.chatbot.model.MessageRequest;
import com.example.chatbot.model.MessageResponse;
import org.slf4j.Logger; import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class WebhookController {
    private static final Logger logger=LoggerFactory.getLogger(WebhookController.class);
    @PostMapping("/webhook")
    public MessageResponse receive(@RequestBody MessageRequest request){
         logger.info("Received message from {}: {}", request.getSender(), request.getMessage());
         String msg=request.getMessage().trim().toLowerCase();
         String reply=switch(msg){
           case "hi" -> "Hello";
           case "bye" -> "Goodbye";
           default -> "I don't understand.";
         };

         return new MessageResponse(reply);
    }
}