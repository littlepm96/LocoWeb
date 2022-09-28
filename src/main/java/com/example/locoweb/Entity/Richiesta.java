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

        private String descrizione;


        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getName() {
                return nome;
        }

        public void setName(String name) {
                this.nome = name;
        }

        public String getCognome() {
                return cognome;
        }

        public void setCognome(String cognome) {
                this.cognome = cognome;
        }

        public String getRichiesta() {
                return descrizione;
        }

        public void setRichiesta(String richiesta) {
                this.descrizione = richiesta;
        }
}
