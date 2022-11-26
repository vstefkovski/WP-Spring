package mk.ukim.finki.vp.repository;

import mk.ukim.finki.vp.bootstrap.DataHolder;
import mk.ukim.finki.vp.model.Manufacturer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryManufacturerRepository {

    public List<Manufacturer> findAll(){
        return DataHolder.manufacturers;
    }

    public Optional<Manufacturer> findById(long id){
        return DataHolder.manufacturers.stream().filter(r -> r.getId().equals(id)).findFirst();
    }
}
