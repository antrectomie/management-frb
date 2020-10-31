package com.frb.management.model;

import javax.persistence.*;

@Entity
public class PlayerDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Player player;
    @ManyToOne
    @JoinColumn(name="document_id", unique = true)
    private Document document;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    @Override
    public String toString() {
        return "PlayerDocument{" +
                "id=" + id +
                ", player=" + player.getFirstName() +
                ", document=" + document.getName() +
                '}';
    }
}
