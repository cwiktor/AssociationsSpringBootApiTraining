package com.asbt.AssociationsSpringBootApiTraining.repository;

import com.asbt.AssociationsSpringBootApiTraining.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    Optional<Address> getAddressById(Long addressId);
}
