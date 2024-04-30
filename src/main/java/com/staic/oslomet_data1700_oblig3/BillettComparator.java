package com.staic.oslomet_data1700_oblig3;

import java.util.Comparator;

public class BillettComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {

        Bestilling b1 = (Bestilling) o1;
        Bestilling b2 = (Bestilling) o2;

        return b1.getEtternavn().compareTo(b2.getEtternavn());
    }
}
