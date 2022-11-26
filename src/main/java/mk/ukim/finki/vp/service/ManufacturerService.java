package mk.ukim.finki.vp.service;

import mk.ukim.finki.vp.model.Manufacturer;

import java.util.List;
import java.util.Optional;

public interface ManufacturerService {

    List<Manufacturer> findAll();

    Optional<Manufacturer> findById(Long id);
}
