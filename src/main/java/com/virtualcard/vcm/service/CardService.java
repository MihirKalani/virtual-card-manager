package com.virtualcard.vcm.service;

import com.virtualcard.vcm.entity.VirtualCard;
import com.virtualcard.vcm.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CardService {

    @Autowired
    private CardRepository repository;

    public VirtualCard issueCard(VirtualCard card) {
        card.setIsLocked(false);
        if (card.getCurrentBalance() == null) card.setCurrentBalance(0.0);
        return repository.save(card);
    }

    public List<VirtualCard> getAllCards() {
        return repository.findAll();
    }

    public VirtualCard toggleLockStatus(Long id) {
        VirtualCard card = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Card not found with ID: " + id));
        card.setIsLocked(!card.getIsLocked());
        return repository.save(card);
    }

    public void deleteCard(Long id) {
        repository.deleteById(id);
    }
}