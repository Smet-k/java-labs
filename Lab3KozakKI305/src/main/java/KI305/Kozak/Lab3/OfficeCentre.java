/** */
package KI305.Kozak.Lab3;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * 
 */
interface Loggable {
    void log(String message);

    String logPath = "Log.txt";
}

/**
 * 
 */
interface Workplace{
    void isWorking(LocalTime time);

    LocalTime closingHour = LocalTime.of(19, 0);
    LocalTime openingHour = LocalTime.of(9, 0);
}

/**
 * 
 */
public class OfficeCentre extends Building implements Workplace, Loggable{
    private String companyName = "";
    private int employeeCount = 0;

    /**
     * 
     */
    public OfficeCentre(){ }

    /**
     * 
     * @param address
     * @param floors
     * @param area
     * @param companyName
     */
    public OfficeCentre(String address, int floors, float area, String companyName) {
        this.address = address;
        this.floors = floors;
        this.area = area;
        this.companyName = companyName;
    }

    /**
     * 
     * @param address
     * @param floors
     * @param area
     * @param companyName
     * @param hasElevator
     */
    public OfficeCentre(String address, int floors, float area, String companyName, boolean hasElevator) {
        this(address, floors, area, companyName);
        hasElevator = true;
    }

    /**
     * 
     * @param address
     * @param floors
     * @param area
     * @param companyName
     * @param hasElevator
     * @param employeeCount
     */
    public OfficeCentre(String address, int floors, float area, String companyName, boolean hasElevator, int employeeCount) {
        this(address, floors, area, companyName, hasElevator);
        this.employeeCount = employeeCount;
    }

    /**
     * 
     * @return
     */
    public String getCompanyName(){
        log("CompanyName requested.");
        return this.companyName;
    }

    /**
     * 
     * @param companyName
     */
    public void setCompanyName(String companyName){
        log("CompanyName changed to: " + companyName + ".");
        this.companyName = companyName;
    }

    /**
     * 
     * @return
     */
    public int getEmployeeCount(){
        log("EmployeeCount requested.");
        return this.employeeCount;
    }

    /**
     * 
     * @param employeeCount
     */
    public void setEmployeeCount(int employeeCount){
        log("EmployeeCount changed to: " + employeeCount + ".");
        this.employeeCount = employeeCount;
    }

    /**
     * 
     * @return
     */
    @Override
    public boolean getHasElevator() {
        log("Elevator status requested.");
        return this.hasElevator;
    }

    /**
     * 
     * @param hasElevator
     */
    @Override
    public void setHasElevator(boolean hasElevator) {
        log("HasElevator changed to: " + hasElevator + ".");
        this.hasElevator = hasElevator;
    }

    /**
     * 
     * @return
     */
    @Override
    public int getFloors() {
        log("Floors requested.");
        return this.floors;
    }

    /**
     * 
     * @param floors
     */
    @Override
    public void setFloors(int floors) {
        log("Floors changed to: " + floors + ".");
        this.floors = floors;
    }

    /**
     * 
     * @return
     */
    @Override
    public String getAddress() {
        log("Address requested.");
        return this.address;
    }

    /**
     * 
     * @param address
     */
    @Override
    public void setAddress(String address) {
        log("Address changed to: " + address + ".");
        this.address = address;
    }

    /**
     * 
     * @return
     */
    @Override
    public float getArea() {
        log("Area requested.");
        return this.area;
    }

    /**
     * 
     * @param area
     */
    @Override
    public void setArea(float area) {
        log("Area changed to: " + area + ".");
        this.area = area;
    }

    /**
     * 
     */
    @Override
    public void displayInfo() {
        log("Building info displayed.");
        System.out.printf("Building info: %s, floors: %d, area: %.2fkm² ", address, floors,  area);
        System.out.printf("Has elevator: %s, company: %s, employees: %d.\n", (hasElevator ? "Yes" : "No"), companyName, employeeCount);
    }

    /**
     * 
     */
    @Override
    public void addFloor() {
        if(area <= 0){
            log("Failed to add floor, current area: " + area);
            return;
        }

        area += area / floors;
        floors++;
        log("Added a floor. Total floors: " + floors + ", new area: " + area);
    }

    /**
     * 
     * @return
     */
    @Override
    public float getFloorArea() {
        log("FloorArea requested.");
        return area / floors;
    }

    /**
     * 
     * @param time
     */
    @Override
    public void isWorking(LocalTime time){
        if(time.isBefore(openingHour)){
            System.out.println("The office hasn't opened yet.");
        }
        else if(time.isAfter(closingHour)){
            System.out.println("The office is closed already.");
        }
    }
    
    /**
     * 
     * @param msg
     */
    @Override
    public void log(String msg){
        try {
            FileWriter fw = new FileWriter(logPath, true);

            fw.write(LocalDateTime.now() + " - " + msg + "\n");

            fw.close();
        } catch (IOException e) {
            System.err.println("Logging failed: " + e.getMessage());
        }
    }
}
