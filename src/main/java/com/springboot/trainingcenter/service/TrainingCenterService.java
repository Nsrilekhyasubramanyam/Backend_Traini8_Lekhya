package com.springboot.trainingcenter.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.trainingcenter.entity.Address;
import com.springboot.trainingcenter.entity.TrainingCenter;
import com.springboot.trainingcenter.exceptionhandeler.CenterAlreadyExistException;
import com.springboot.trainingcenter.exceptionhandeler.ProperValidationsExceptions;
import com.springboot.trainingcenter.repository.AddressRepository;
import com.springboot.trainingcenter.repository.TrainingCenterRepository;
import com.springboot.trainingcenter.util.CommonUtils;

@Service
public class TrainingCenterService {

    // Autowired repository for TrainingCenter
    @Autowired
    TrainingCenterRepository trainingCenterRepository;
    
    // Autowired repository for Address
    @Autowired
    AddressRepository addressRepository;
    
    // Autowired utility class for common operations
    @Autowired
    CommonUtils utils;
    
    /**
     * Save details of a training center.
     * 
     * @param center The TrainingCenter object to be saved
     * @return The saved TrainingCenter object
     * @throws ProperValidationsExceptions If validation of center code, email, or phone number fails
     * @throws CenterAlreadyExistException If the training center already exists
     */
    public TrainingCenter saveDetails(TrainingCenter center) throws ProperValidationsExceptions, CenterAlreadyExistException {
        // Save the address associated with the center
        Address address = addressRepository.save(center.getAddress());
        
        // Check if the training center already exists
        List<TrainingCenter> alreadyExist = trainingCenterRepository.findAll();
        for (TrainingCenter c : alreadyExist) {
            if (c.getCenterName().equals(center.getCenterName()))
                throw new CenterAlreadyExistException("This Training center already Exists");
        }
        
        // Validate center code
        if (!CommonUtils.isValidCenterCode(center.getCenterCode()))
            throw new ProperValidationsExceptions("Enter proper center code, which consists of alphanumeric");

        // Set creation date and address for the center
        center.setCreatedOn(new Date());
        center.setAddress(address);
    

        // Validate email
        if (!CommonUtils.isValidEmail(center.getEmail()))
            throw new ProperValidationsExceptions("Enter Valid Email ");

        // Validate phone number
        if (!CommonUtils.isValidPhoneNum(center.getPhone()))
            throw new ProperValidationsExceptions("Enter proper phone number");

        // Save the center details
        TrainingCenter savedDetails = trainingCenterRepository.save(center);
        return savedDetails;
    }
    
    /**
     * Retrieve all training center details.
     * 
     * @return A list of TrainingCenter objects containing all center details
     */
    public List<TrainingCenter> getAllTrainingCenterDetails() {
        return trainingCenterRepository.findAll();
    }

}
