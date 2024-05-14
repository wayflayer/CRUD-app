package com.example.demo.Service;

import com.example.demo.Repository.PositionRepository;
import com.example.demo.model.Allow;
import com.example.demo.Repository.AllowRepository;
import com.example.demo.model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllowService{
    private final AllowRepository allowRepository;

    @Autowired
    public AllowService(AllowRepository allowRepository) {
        this.allowRepository = allowRepository;
    }

    public List<Allow> findAll(){
        return allowRepository.findAll();
    }
    public Allow findById(Long id){
        return  allowRepository.getById(id);
    }
    public Allow saveAllow(Allow allow){
        return allowRepository.save(allow);
    }
    public void deletebyId(Long id){
        allowRepository.deleteById(id);
    }
}
