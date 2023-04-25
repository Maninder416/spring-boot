package io.reactivestax.record;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import javax.validation.constraints.NotEmpty;
import java.util.Objects;


@Entity
public record CustomerRecord(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,
        @NotEmpty(message = "Name may not be null")
        String name,
        @NotEmpty(message = "Address may not be null")
        String address) {


    public CustomerRecord() {
        this(null, "", "");
    }

//    public CustomerRecord(Long id, String name, String address){
//        Objects.requireNonNull(id, "id cannot be null");
//        Objects.requireNonNull(name, "Name cannot be null");
//        Objects.requireNonNull(address, "Address cannot be null");
//        this.id= id;
//        this.name= name;
//        this.address= address;
//    }

//    public CustomerRecord(Long id, String name, String address) {
//        Objects.requireNonNull(id, "id cannot be null");
//        Objects.requireNonNull(name, "Name cannot be null");
//        Objects.requireNonNull(address, "Address cannot be null");
//    }

}
