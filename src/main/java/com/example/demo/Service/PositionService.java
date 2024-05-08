package com.example.demo.Service;

import com.example.demo.model.Position;
import com.example.demo.Repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService {
    private final PositionRepository positionRepository;

    @Autowired
    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public Position findById(Long id){
        return positionRepository.getOne(id);
    }

    public List<Position> findAll(){
        return positionRepository.findAll();
    }

    public Position savePosition(Position position){
        return positionRepository.save(position);
    }

    public void deleteById(Long id){
        positionRepository.deleteById(id);
    }
}
