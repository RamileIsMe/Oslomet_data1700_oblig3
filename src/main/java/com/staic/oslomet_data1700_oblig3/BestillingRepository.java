package com.staic.oslomet_data1700_oblig3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class BestillingRepository {

    @Autowired
    private JdbcTemplate db;

    public void kjopBillett(Bestilling innBillett) {

        String sql = "INSERT INTO Bestilling (film, antall, fornavn, etternavn, tel, mail) VALUES(?,?,?,?,?,?)";
        db.update(sql,innBillett.getFilm(),innBillett.getAntall(), innBillett.getFornavn(), innBillett.getEtternavn(), innBillett.getTel(), innBillett.getMail());

    }

    public List<Bestilling> visKvitto() {

        String sql = "SELECT * FROM BESTILLING";
        List<Bestilling> billeter = db.query(sql,new BeanPropertyRowMapper(Bestilling.class));
        Collections.sort(billeter, new BillettComparator());
        return billeter;
    }

    public void slettAlle () {

        String sql = "DELETE FROM Bestilling";
        db.update(sql);
    }
}


