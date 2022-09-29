package com.example.locoweb.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name="Richieste")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Richiesta {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nome;
        private String cognome;
        private String email;
        private int cellulare;
        private String descrizione;


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

        public int getCellulare() {
                return cellulare;
        }

        public void setCellulare(int cellulare) {
                this.cellulare = cellulare;
        }

        public String getDescrizione() {
                return descrizione;
        }

        public void setDescrizione(String descrizione) {
                this.descrizione = descrizione;
        }
}
