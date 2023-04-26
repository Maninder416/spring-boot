package io.reactivestax.record;

public record CustomerRecord(

        Long id,
        String name,
        String address) {


    public CustomerRecord() {
        this(null, "", "");
    }

}
