package ninechapter_system_design.chapter3_ood_design.parkinglot;

import java.util.ArrayList;

/**
 * Author: blueaken
 * Date: 3/22/16 3:17 PM
 */

// enum type for Vehicle
enum VehicleSize {
    Motorcycle,
    Compact,
    Large,
}

abstract class Vehicle {
    // Write your code here
    protected int spotsNeeded;
    protected VehicleSize size;
    protected String licensePlate;  // id for a vehicle

    protected ArrayList<ParkingSpot> occupiedParkingSpots = new ArrayList<>(); // spot for parking where may occupy multi

    public int getSpotsNeeded() {
        return spotsNeeded;
    }

    public VehicleSize getSize() {
        return size;
    }

    /* Park vehicle in this spot*/
    public void parkInSpot(ParkingSpot spot) {
        occupiedParkingSpots.add(spot);
    }

    /* Remove car from spot, and notify spot that it's gone */
    public void clearSpots() {
        for (int i = 0; i < occupiedParkingSpots.size(); i++) {
            occupiedParkingSpots.get(i).removeVehicle();
        }
        occupiedParkingSpots.clear();
    }

    //this need to be implement in subclass
    public abstract boolean canFitInSpot(ParkingSpot spot);
}

class Motorcycle extends Vehicle {
    // Write your code here
    public Motorcycle() {
        spotsNeeded = 1;
        size = VehicleSize.Motorcycle;
    }

    public boolean canFitInSpot(ParkingSpot spot) {
        return true;
    }
}

class Car extends Vehicle {
    // Write your code here
    public Car() {
        spotsNeeded = 1;
        size = VehicleSize.Compact;
    }

    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSize() == VehicleSize.Large
                || spot.getSize() == VehicleSize.Compact;
    }
}

class Bus extends Vehicle {
    // Write your code here
    public Bus() {
        spotsNeeded = 5;
        size = VehicleSize.Large;
    }

    /*********only check whether size fit***********************************/
    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSize() == VehicleSize.Large;
    }
}

class Location {
    int rowInx = -1;
    int spotInx = -1;
}

/*
Parking Spot-
no need to have classes for LargeSpot, CompactSpot and MotorcycleSpot inheriting from Parking Spot, cause they do not have different behavior, only different size
*/
class ParkingSpot{
    private Vehicle vehicle;
    private VehicleSize spotSize;
    private int rowNum;
    private int spotNumber;
    private Level level;

    public ParkingSpot(Level lvl, int r, int n, VehicleSize sz) {
        level = lvl;
        rowNum = r;
        spotNumber = n;
        spotSize = sz;
    }

    public VehicleSize getSize() {
        return this.spotSize;
    }

    public boolean isAvailable() {
        return vehicle == null;
    }

    /* Checks if the spot is big enough for the vehicle (and is available). This compares
     * the SIZE only. It does not check if it has enough spots. */
    public boolean canFitVehicle(Vehicle vehicle) {
        return isAvailable() && vehicle.canFitInSpot(this);
    }

    /* Park vehicle in this spot. */
    public boolean park(Vehicle v) {
        if (!canFitVehicle(v)) {
            return false;
        }
        vehicle = v;
        vehicle.parkInSpot(this);
        return true;
    }

    /* Remove vehicle from spot, and notify level that a new spot is available */
    public void removeVehicle() {
        this.vehicle = null;
        level.spotFreed();
    }

}

/* Represents a level in a parking garage */
class Level {
    // Write your code here
    private int floor;
    private int rowNum;
    private int rowSpots;

    private ParkingSpot[][] spots;
    private int availableSpots = 0; // number of free spots

    public Level(int flr, int rowNum, int rowSpots){
        this.floor = flr;
        this.rowNum = rowNum;
        this.rowSpots = rowSpots;
        this.spots = new ParkingSpot[rowNum][rowSpots];
        this.availableSpots = rowNum * rowSpots;

        //for each row divid all spots for 3 type
        int motorcycleSpots = rowSpots / 4;
        int compactSpots = rowSpots / 2;
        int largeSpots = rowSpots - motorcycleSpots - compactSpots;
        //init size for each spot in array spots
        //for each row
        for (int row = 0; row < rowNum; row ++) {
            for(int i = 0; i < rowSpots; i++){
                VehicleSize sz = VehicleSize.Large;

                if(i < motorcycleSpots){//1/4
                    sz = VehicleSize.Motorcycle;
                } else if (i < motorcycleSpots + compactSpots) {//3/4
                    sz = VehicleSize.Compact;
                }

                spots[row][i] = new ParkingSpot(this, row, i, sz);
            }
        }
    }

    public int getAvailableSpots() {
        return this.availableSpots;
    }

    /* Try to find a place to park this vehicle. Return false if failed. */
    public boolean parkVehicle(Vehicle vehicle) {
        if(getAvailableSpots() < vehicle.getSpotsNeeded()){
            return false; // no enough spots
        }
        Location spotLocation = findAvaliableSpot(vehicle);
        if(spotLocation.rowInx < 0){
            return false;
        }
        return parkStartingAtSpot(spotLocation, vehicle);
    }

    /* find a spot to park this vehicle. Return index of row, or -1 on failure. */
    private Location findAvaliableSpot(Vehicle vehicle) {
        int spotsNeeded = vehicle.getSpotsNeeded();
        int spotsFound = 0;

        Location location = new Location();

        for (int row = 0; row < this.rowNum; row++) {
            for(int i = 0; i < rowSpots; i++){
                ParkingSpot spot = spots[row][i];
                if(spot.canFitVehicle(vehicle)){
                    spotsFound++;
                }else{
                    spotsFound = 0;
                }
                if(spotsFound == spotsNeeded){
                    location.rowInx = row;
                    location.spotInx = i;
                    return location;
                }
            }
        }
        return location;
    }

    /* Park a vehicle starting at the row rowNumber, and continuing until vehicle.spotsNeeded. */
    private boolean parkStartingAtSpot(Location spotLocation, Vehicle vehicle) {

        //vehicle.clearSpots();

        boolean isSuccess = true;
        //need handling Bus logic
        for (int i = spotLocation.spotInx; i < spotLocation.spotInx + vehicle.spotsNeeded; i++) {
            isSuccess &= spots[spotLocation.rowInx][i].park(vehicle);
        }

        availableSpots -= vehicle.spotsNeeded;
        return isSuccess;
    }

    /* When a car was removed from the spot, increment availableSpots */
    public void spotFreed() {
        availableSpots++;
    }

}

/*
最后完成整个parking Lot
可以看做是wrapper class for an array of levels
*/
public class ParkingLot {
    private Level[] levels;

    // @param n number of leves
    // @param num_rows  each level has num_rows rows of spots
    // @param spots_per_row each row has spots_per_row spots
    public ParkingLot(int n, int num_rows, int spots_per_row) {
        // Write your code here
        this.levels = new Level[n];
        for (int i = 0; i < n; i++) {
            levels[i] = new Level(i, num_rows, spots_per_row);
        }
    }

    // Park the vehicle in a spot (or multiple spots)
    // Return false if failed
    public boolean parkVehicle(Vehicle vehicle) {
        // Write your code here
        for (int i = 0; i < levels.length; i++) {
            if (levels[i].parkVehicle(vehicle)) {
                return true;
            }
        }
        return false;
    }

    // unPark the vehicle
    public void unParkVehicle(Vehicle vehicle) {
        // Write your code here
        vehicle.clearSpots();
    }

    public static void main(String[] args) {
        int level=1, num_rows=1, spots_per_row=11;

        ParkingLot parkingLot = new ParkingLot(level, num_rows, spots_per_row);

        Vehicle motorcycle1 = new Motorcycle();
        System.out.println(parkingLot.parkVehicle(motorcycle1)); // return true

        Vehicle car1 = new Car();
        System.out.println(parkingLot.parkVehicle(car1)); // return true

        Vehicle car2 = new Car();
        System.out.println(parkingLot.parkVehicle(car2)); // return true

        Vehicle car3 = new Car();
        System.out.println(parkingLot.parkVehicle(car3)); // return true

        Vehicle car4 = new Car();
        System.out.println(parkingLot.parkVehicle(car4)); // return true

        Vehicle car5 = new Car();
        System.out.println(parkingLot.parkVehicle(car5)); // return true

        Vehicle bus1 = new Bus();
        System.out.println(parkingLot.parkVehicle(bus1)); // return false

        parkingLot.unParkVehicle(car5);
        System.out.println(parkingLot.parkVehicle(bus1)); // return true
    }
}
