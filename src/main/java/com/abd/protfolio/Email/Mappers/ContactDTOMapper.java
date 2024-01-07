package com.abd.protfolio.Email.Mappers;

import com.abd.protfolio.Email.DTO.ContactDTO;
import com.abd.protfolio.Email.Entities.ContactEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ContactDTOMapper implements Function<ContactDTO,ContactEntity> {


    @Override
    public ContactEntity apply(ContactDTO contactDTO) {
        ContactEntity contact =new ContactEntity();
        contact.setEmail(contactDTO.getEmail());
        contact.setName(contactDTO.getName());
        contact.setMessage(contactDTO.getMessage());

        return contact;
    }

}
