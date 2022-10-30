package com.example.locoweb.generator;

import java.io.Serializable;
import java.util.stream.Stream;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.example.locoweb.entity.Richiesta;

public class RichiestaGenerator implements IdentifierGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object obj) throws HibernateException {
        if(Richiesta.getDeletedIds().size() > 0) {
            return Richiesta.getDeletedIds().get(0);
        } else {
            String query = String.format("SELECT %s FROM %s", 
            "id", "Richiesta");

            @SuppressWarnings("unchecked")
            Stream<Long> ids = session.createQuery(query).stream();

            return ids.max(Long::compareTo).orElse(0L) + 1;
        }
    }
}