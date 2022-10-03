package com.example.locoweb.Repository;

import com.example.locoweb.entity.Richiesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RichiestaRepository extends JpaRepository <Richiesta, Long> {
}
