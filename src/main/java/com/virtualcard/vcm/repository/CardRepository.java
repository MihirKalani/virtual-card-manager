package com.virtualcard.vcm.repository;

import com.virtualcard.vcm.entity.VirtualCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<VirtualCard, Long> {
    // Standard CRUD methods are automatically included
}