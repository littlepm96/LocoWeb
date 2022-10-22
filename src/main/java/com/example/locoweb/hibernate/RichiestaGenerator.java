package com.example.locoweb.hibernate;

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

            return ids.max(Long::compareTo).get() + 1;
        }
    }
    
        /* String query = String.format("SELECT %s FROM %s", 
        "id", "Richiesta");

        @SuppressWarnings("unchecked")
        Stream<Long> ids = session.createQuery(query).stream();

        if(ids.iterator().hasNext()) {
            return ids.filter(first -> {
                if(first + 1 != ids.iterator().next()) 
                    return true;
                else
                    return false;
            }).findFirst().get() + 1;
        } else {
            return ids.max(Long::compareTo).get() + 1;
        }
    } */

        // Supplier<Stream<Long>> streamSupplier = () -> ids;

        // if(streamSupplier.get().iterator().hasNext()) {
        /* } else {
            return ids.max(Long::compareTo).get() + 1;
        } */

        // return ids.reduce(0L, (first, second) -> accumulator(ids, first, second));

    /* private Long accumulator (Stream<Long> stream, Long first, Long second) {
        if(stream.iterator().hasNext()) {
            if(first + 1 != second) 
                return first + 1;
            else
                return iterate(stream);
        } else {
            return stream.max(Long::compareTo).get() + 1;
        }
    } */

    /* private Long iterate(Stream<Long> stream) {
        return stream.reduce((first, second) -> {
            if(first + 1 != stream.iterator().next()) 
                return first + 1;
            else
                return stream.iterator().next();
        }).get();
    } */
}
