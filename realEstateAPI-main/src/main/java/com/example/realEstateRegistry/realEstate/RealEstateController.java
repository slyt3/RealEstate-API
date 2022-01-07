package com.example.realEstateRegistry.realEstate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/realestate")
public class RealEstateController {


    private final RealEstateService realEstateService;

    @Autowired
    public RealEstateController(RealEstateService realEstateService) {
        this.realEstateService = realEstateService;
    }

    @GetMapping
    public List<RealEstate> getRealEstate() {
        return realEstateService.getRealEstate();

    }

    @PostMapping
    public void registerNewRealEstate(@RequestBody RealEstate realEstate) {
        realEstateService.addNewRealEstate(realEstate);
    }

    @DeleteMapping(path = "{realestateId}")
    public void deleteRealEstate(@PathVariable("realestateId") Long realEstateId) {
        realEstateService.deleteRealEstate(realEstateId);
    }

    @PutMapping(path = "{realestateId}")
    public void updateRealEstate(
            @PathVariable("realestateId") Long realEstateId,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String street,
            @RequestParam(required = false) Integer number,
            @RequestParam(required = false) String owner,
            @RequestParam(required = false) Long size,
            @RequestParam(required = false) Double marketValue,
            @RequestParam(required = false) String propertyType,
            @RequestParam(required = false) Double tax){
        realEstateService.updateRealEstate(realEstateId, city, street, number, owner, size, marketValue, propertyType, tax);
        }
}
