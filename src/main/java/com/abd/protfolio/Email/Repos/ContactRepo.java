package com.abd.protfolio.Email.Repos;

import com.abd.protfolio.Email.Entities.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepo extends JpaRepository<ContactEntity,Long> {
}
