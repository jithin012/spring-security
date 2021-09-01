package com.mclabs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mclabs.model.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {

}
