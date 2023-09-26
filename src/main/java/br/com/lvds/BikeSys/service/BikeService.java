package br.com.lvds.BikeSys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lvds.BikeSys.domain.dto.BikeDTO;
import br.com.lvds.BikeSys.domain.mapper.BikeMapper;
import br.com.lvds.BikeSys.domain.model.Bike;
import br.com.lvds.BikeSys.repository.BikeRepository;

@Service
public class BikeService {
    
    @Autowired
    private BikeRepository bikeRepository;

    public BikeDTO saveBike(Bike bike) throws Exception {
        return BikeMapper.fromEntity(bikeRepository.save(bike));
    }

}
