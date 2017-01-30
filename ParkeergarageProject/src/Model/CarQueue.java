package Model;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Class for the queue's of cars
 * @author Martijn Bakker, Albert van der Berg, Antonie Groenveld, Arneld van der Veen and Daniel Bouius
 *
 */

public class CarQueue {
    private Queue<Car> queue = new LinkedList<>();

    
    /**
     * Ads a car to the queue and returns if the car has been added
     * @param car
     * @return boolean
     */
    
    public boolean addCar(Car car) {
        return queue.add(car);
    }

    /**
     * removes a car from the queue
     * @return car
     */
    
    public Car removeCar() {
        return queue.poll();
    }

    /**
     * returns carsInQueue 
     * @return carqueue in size
     */
    
    public int carsInQueue(){
    	return queue.size();
    }
}
