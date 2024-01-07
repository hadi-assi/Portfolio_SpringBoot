package com.abd.protfolio.Email.Controllers;

import com.abd.protfolio.Email.DTO.ContactDTO;
import com.abd.protfolio.Email.Entities.ContactEntity;
import com.abd.protfolio.Email.Mappers.ContactDTOMapper;
import com.abd.protfolio.Email.Repos.ContactRepo;
import com.abd.protfolio.Email.Services.Response;
import com.abd.protfolio.Email.Services.EmailService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin("http://localhost:3000/")
public class MyController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private ContactDTOMapper contactDTOMapper;

    @Autowired
    private ContactRepo contactRepo;


    @GetMapping("/home")
    @ResponseBody
    public String home()
    {
        return "home";
    }

    @PostMapping("/send")
    public Response sendMessage(@Valid @RequestBody ContactDTO contactDTO)
    {

        ContactEntity contact = contactDTOMapper.apply(contactDTO);

        contactRepo.save(contact);

        emailService.sendToSelf(contact);

        contactDTO.setMessage("");

        return new Response(200 , "message recieved");
    }
}
