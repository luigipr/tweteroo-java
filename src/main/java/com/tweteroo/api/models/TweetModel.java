package com.tweteroo.api.models;

import com.tweteroo.api.dtos.TweetDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data                     // Getters e setters
@NoArgsConstructor        // Construtor sem argumentos
@AllArgsConstructor       // Construtor com todos os argumentos
@Entity                   // Representa que é uma entidade a ser mapeada no BD
@Table(name = "tweets")  // Nome da tabela que representa esses dados
public class TweetModel {
    
    public TweetModel(TweetDTO dto) {
        this.text = dto.getText();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 280, nullable = false)
    private String text;

   @ManyToOne 
   @JoinColumn(name = "userId")
   private UserModel user;
}
