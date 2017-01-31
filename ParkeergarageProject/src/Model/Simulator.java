package Model;

import java.util.Random;

import Controller.Controller;
import View.*;

/**
 * Class for the "Main" model of Simulator
 * @author Martijn Bakker, Albert van der Berg, Antonie Groenveld, Arneld van der Veen and Daniel Bouius
 *
 */

public class Simulator extends AbstractModel {
	private static final String AD_HOC = "1";
	private static final String PASS = "2";
	private static final String SUB = "3";
	
	
	private static CarQueue entranceCarQueue;
    private static CarQueue entrancePassQueue;
    private static CarQueue paymentCarQueue;
    private static CarQueue exitCarQueue;
    private static SimulatorView simulatorView;
    private static int PayingCars;
    private static TextOverview textOverview;
    private Controller controller;
    private static PieView pieview;
    private static int day = 0;
    private static int hour = 0;
    private static int minute = 0;

    private static int tickPause = 100;
    private static boolean run = true;

    static int weekDayArrivals= 100; // average number of arriving cars per hour
    static int weekendArrivals = 200; // average number of arriving cars per hour
    static int weekDayPassArrivals= 50; // average number of arriving cars per hour
    static int weekendPassArrivals = 5; // average number of arriving cars per hour

    static int enterSpeed = 3; // number of cars that can enter per minute
    static int paymentSpeed = 7; // number of cars that can pay per minute
    static int exitSpeed = 5; // number of cars that can leave per minute
    
    /**
	 * Constructs a new instance of the Simulator
	 * Creates a new entranceCarQueue, entrancePassQueue, paymentCarQueue, exitCarQueue
	 * and textOverview
	 */
    
    public Simulator() {
        entranceCarQueue = new CarQueue();
        entrancePassQueue = new CarQueue();
        paymentCarQueue = new CarQueue();
        exitCarQueue = new CarQueue();
        textOverview = new TextOverview(this);
        pieview = new PieView(this);
        simulatorView = new SimulatorView(3, 6, 30, textOverview, pieview);
    }
    
    public static void Stop(){
    	run = false;
    }
    
    /**
	 * Runs the simulation for the given amount of ticks
	 * @param getal = runCommand
	 */
    
    public static void runCommand(int getal) {
    	int i = getal;
    	while(i > 0 && run == true){
    		tick();
    		i--; }
    	}
    
    /**
	 * Forwards the simulation by advanceTime();, cars exit by handleExit(); 
	 * and updatesview with updateViews();
	 */
    
    public static void tick() {
    	advanceTime();
    	handleExit();
    	updateViews();
    	// Pause.
        try {
            Thread.sleep(tickPause);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    	handleEntrance();
    }

    private static void advanceTime(){
        // Advance the time by one minute.
        minute++;
        while (minute > 59) {
            minute -= 60;
            hour++;
        }
        while (hour > 23) {
            hour -= 24;
            day++;
        }
        while (day > 6) {
            day -= 7;
        }

    }

    private static void handleEntrance(){
    	carsArriving();
    	carsEntering(entrancePassQueue);
    	carsEntering(entranceCarQueue);  	
    }
    
    private static void handleExit(){
        carsReadyToLeave();
        carsPaying();
        carsLeaving();
    }
    
    private static void updateViews(){
    	simulatorView.tick();
        // Update the car park view.
        simulatorView.updateView();	
    }
    
    private static void carsArriving(){
    	int numberOfCars=getNumberOfCars(weekDayArrivals, weekendArrivals);
        addArrivingCars(numberOfCars, AD_HOC);    	
    	numberOfCars=getNumberOfCars(weekDayPassArrivals, weekendPassArrivals);
        addArrivingCars(numberOfCars, PASS);    	
        numberOfCars=getNumberOfCars(weekDayPassArrivals, weekendPassArrivals);
        addArrivingCars(numberOfCars, SUB);  
    }

    private static void carsEntering(CarQueue queue){
        int i=0;
        // Remove car from the front of the queue and assign to a parking space.
    	while (queue.carsInQueue()>0 && 
    			simulatorView.getNumberOfOpenSpots()>0 && 
    			i<enterSpeed) {
            Car car = queue.removeCar();
            Location freeLocation = simulatorView.getFirstFreeLocation();
            simulatorView.setCarAt(freeLocation, car);
            i++;
        }
    }
    
    private static void carsReadyToLeave(){
        // Add leaving cars to the payment queue.
        Car car = simulatorView.getFirstLeavingCar();
        while (car!=null) {
        	if (car.getHasToPay()){
	            car.setIsPaying(true);
	            paymentCarQueue.addCar(car);
        	}
        	else {
        		carLeavesSpot(car);
        	}
            car = simulatorView.getFirstLeavingCar();
        }
    }

    private static void carsPaying(){
        // Let cars pay.
    	for (int i = 0; i < paymentSpeed; i++) {
            Car car = paymentCarQueue.removeCar();
            if (car != null){
            	PayingCars++;
            	
            }
            if (car == null) {
                break;
            }
            simulatorView.removeCarAt(car.getLocation());
            exitCarQueue.addCar(car);
            textOverview.updateView();
    	
    	}
    }
        private static void carsLeaving(){
        // Let cars leave.
    	int i=0;
    	while (exitCarQueue.carsInQueue()>0 && i < exitSpeed){
            exitCarQueue.removeCar();
            i++;
    	}	
    }
    
    private static int getNumberOfCars(int weekDay, int weekend){
        Random random = new Random();

        // Get the average number of cars that arrive per hour.
        int averageNumberOfCarsPerHour = day < 5
                ? weekDay
                : weekend;

        // Calculate the number of cars that arrive this minute.
        double standardDeviation = averageNumberOfCarsPerHour * 0.3;
        double numberOfCarsPerHour = averageNumberOfCarsPerHour + random.nextGaussian() * standardDeviation;
        return (int)Math.round(numberOfCarsPerHour / 60);	
    }
    /*
     * returns the amount of cars that will pay 
     * @return PayingCars
     */
    public int getPayingCars() {
    	return PayingCars;
    }
    
    public int getAdHoc(){
    	int amount = 0;
    	if (amount == 0){
    		amount++;
    		return amount;
    	}
    	else{
    	int amountnotzero = simulatorView.getAdHocAmount() -1;
    	return amountnotzero;
    	}
    }
    
    public int getPassCar(){
    	int amount = 0;
    	if (amount == 0){
    		amount++;
    		return amount;
    	}
    	else{
    	int amountnotzero = simulatorView.getPassCarAmount() -1;
    	return amountnotzero;
    	}
    }
    
    public int getSubCar(){
    	int amount = 0;
    	if (amount == 0){
    		amount++;
    		return amount;
    	}
    	else{
    	int amountnotzero = simulatorView.getSubCar() -1;
    	return amountnotzero;
    	}
    }
    
    private static void addArrivingCars(int numberOfCars, String type){
        // Add the cars to the back of the queue.
    	switch(type) {
    	case AD_HOC: 
            for (int i = 0; i < numberOfCars; i++) {
            	entranceCarQueue.addCar(new AdHocCar());
            }
            break;
    	case PASS:
            for (int i = 0; i < numberOfCars; i++) {
            	entrancePassQueue.addCar(new ParkingPassCar());
            }
    	    break;
    	case SUB:
    		for (int i = 0; i < numberOfCars; i++) {
    			entrancePassQueue.addCar(new SubscriberPassCar());
    		}
    		break;
    	}
    }
    
    private static void carLeavesSpot(Car car){
    	simulatorView.removeCarAt(car.getLocation());
        exitCarQueue.addCar(car);
    }
    
}
