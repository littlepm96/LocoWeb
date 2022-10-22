package com.example.locoweb.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Richieste")
@AllArgsConstructor
@NoArgsConstructor
public class Richiesta {

        @Id
        @GeneratedValue(generator = "richiesta-generator")
        @GenericGenerator(
                name = "richiesta-generator",
                strategy = "com.example.locoweb.hibernate.RichiestaGenerator"
        )
        private Long id;
        
        private String nome;
        private String cognome;
        private String email;
        private long cellulare;
        private String descrizione;

        @Getter
        @Setter
        @Transient
        private static List<Long> deletedIds = new ArrayList<>();
        
        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getNome() {
                return nome;
        }

        public void setNome(String nome) {
                this.nome = nome;
        }

        public String getCognome() {
                return cognome;
        }

        public void setCognome(String cognome) {
                this.cognome = cognome;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public long getCellulare() {
                return cellulare;
        }

        public void setCellulare(long cellulare) {
                this.cellulare = cellulare;
        }

        public String getDescrizione() {
                return descrizione;
        }

        public void setDescrizione(String descrizione) {
                this.descrizione = descrizione;
        }
}
