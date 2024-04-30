package com.staic.oslomet_data1700_oblig3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class HomeController {

    @Autowired
    private BestillingRepository rep;

    @PostMapping("/lagre")
    public void kjopBillet(Bestilling billett){

        rep.kjopBillett(billett);

    }

    @GetMapping("/visKvitto")
    public List<Bestilling> visKvitto(){
        return rep.visKvitto();
    }

    @GetMapping("/slettAlle")
    public void slettAlle(){
        rep.slettAlle();
    }
}

