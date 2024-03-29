package com.sedbproj.Railways.Services;

import com.sedbproj.Railways.Entities.StationEntity;
import com.sedbproj.Railways.Repositories.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StationService {
    @Autowired
    StationRepository stationRepository;

    public Iterable<StationEntity> findAll(){
        return stationRepository.findAll();
    }

    public void updateOrSaveStation (StationEntity station){
        stationRepository.save(station);
    }

    public Optional <StationEntity> getStationById(Integer id) {
        return stationRepository.findById(id);
    }

    public void deleteStationById(Integer id) {
        stationRepository.deleteById(id);
    }
}
