package com.example.realEstateRegistry.realEstate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class RealEstateService {

    private final RealEstateRepository realEstateRepository;

    @Autowired
    public RealEstateService(RealEstateRepository realEstateRepository) {
        this.realEstateRepository = realEstateRepository;
    }

    public List<RealEstate> getRealEstate() {
        return realEstateRepository.findAll();
    }

    public void addNewRealEstate(RealEstate realEstate) {

        Optional<RealEstate> city = realEstateRepository
                .findRealEstateByCity(realEstate.getCity());

        Optional<RealEstate> street = realEstateRepository
                .findRealEstateByStreet(realEstate.getStreet());

        Optional<RealEstate> number = realEstateRepository
                .findRealEstateByNumber(realEstate.getNumber());

        if (city.isPresent() && street.isPresent() && number.isPresent()) {
            throw new IllegalStateException("registered");
        }
        realEstateRepository.save(realEstate);
    }

    public void deleteRealEstate(Long realEstateId) {
        boolean exists = realEstateRepository.existsById(realEstateId);
        if (!exists) {
            throw new IllegalStateException("realEstate with id " + realEstateId + " does not exists");
        }
        realEstateRepository.deleteById(realEstateId);
    }

    @Transactional
    public void updateRealEstate(Long realEstateId, String city, String street, Integer number, String owner, Long size, Double marketValue, String propertyType, Double tax) {
        RealEstate realEstate = realEstateRepository.findById(realEstateId)
                .orElseThrow(() -> new IllegalStateException("realEstate with id" + realEstateId + " doesn't exist"));

        if (city != null && city.length() > 0 && !Objects.equals(realEstate.getCity(), city)) {
            realEstate.setCity(city);
        }

        if (street != null && street.length() > 0 && !Objects.equals(realEstate.getStreet(), street)) {
            realEstate.setStreet(street);
        }

        if (number != null && number.toString().length() > 0 && !Objects.equals(realEstate.getStreet(), street)) {
            realEstate.setNumber(number);
        }

        if (owner != null && owner.length() > 0 && !Objects.equals(realEstate.getOwner(), owner)) {
            realEstate.setOwner(owner);
        }

        if (size != null && size.toString().length() > 0 && !Objects.equals(realEstate.getSize(), size)) {
            realEstate.setSize(size);
        }

        if (marketValue != null && marketValue.toString().length() > 0 && !Objects.equals(realEstate.getMarketValue(), marketValue)) {
            realEstate.setMarketValue(marketValue);
        }

        if (propertyType != null && propertyType.length() > 0 && !Objects.equals(realEstate.getPropertyType(), propertyType)) {
            realEstate.setPropertyType(propertyType);
        }

        if (tax != null && tax.toString().length() > 0 && !Objects.equals(realEstate.getTax(), tax)) {
            realEstate.setTax(tax);
        }


    }
}
