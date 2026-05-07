package com.virtualcard.vcm.controller;

import com.virtualcard.vcm.entity.VirtualCard;
import com.virtualcard.vcm.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CardController {

    @Autowired
    private CardService service;

    // for add new card in database, Post
    @PostMapping("/issue")
    public VirtualCard issue(@RequestBody VirtualCard card) {
        return service.issueCard(card);
    }

    // for see card , Get
    @GetMapping("/list")
    public List<VirtualCard> listAll() {
        return service.getAllCards();
    }

    // for lock and unlock card, Patch
    @PatchMapping("/toggle/{id}")
    public VirtualCard toggle(@PathVariable Long id) {
        return service.toggleLockStatus(id);
    }

    // for delet card, delete
    @DeleteMapping("/remove/{id}")
    public String remove(@PathVariable Long id) {
        service.deleteCard(id);
        return "Card " + id + " has been permanently deleted.";
    }
}