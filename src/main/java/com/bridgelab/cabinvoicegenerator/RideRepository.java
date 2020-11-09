package com.bridgelab.cabinvoicegenerator;

import java.util.*;

public class RideRepository {

    private Map<Integer, List<Ride>> ridesRepository;

    public RideRepository() {
        this.ridesRepository = new HashMap<>();
    }

    public void addRide(int userId, List<Ride> rides) {
        List<Ride> userRideList = this.ridesRepository.get(userId);
        if(userRideList == null) userRideList =new ArrayList<>(rides);
        else userRideList.addAll(rides);
        this.ridesRepository.put(userId, userRideList);
    }

    public List<Ride> getUserRideList(int userId){
        return this.ridesRepository.get(userId);
    }

    public Map<Integer, List<Ride>> getRideRepositoryMap(){
        return this.ridesRepository;
    }

}
