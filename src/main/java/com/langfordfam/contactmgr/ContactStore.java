package com.langfordfam.contactmgr;

import org.springframework.data.jpa.repository.JpaRepository;
public interface ContactStore extends JpaRepository<Contact, Long> {
}
