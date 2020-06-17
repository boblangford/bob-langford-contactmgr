package com.langfordfam.contactmgr;

import org.springframework.data.jpa.repository.JpaRepository;
public interface PhoneStore extends JpaRepository<Phone, Long> {
}

