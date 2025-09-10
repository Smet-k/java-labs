/**Пакет до лабораторної 2 */
package KI305.Kozak.Lab2;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
/**
 * Клас Building репрезентує будівлю. Він містить:
 * адресу, кількість поверхів, площу, чи наявний у будівлі ліфт.
 * Також цей клас підтримує логування всіх дій.
 */
public class Building {
    /** Кількість поверхів в будівлі. */
    private int floors = 0;
    /** Адреса будівлі. */
    private String address = "";
    /** Площа будівлі. */
    private float area = 0.0f;
    /** Чи наявний у будівлі ліфт. */
    private boolean hasElevator = false;
    /** Шлях для лог файлу.  */
    private String logFile = "BuildingLog.txt";

    /**
     * Створює будівлю з стандартними значеннями.
     */
    public Building(){}

    /**
     * Створює будівлю з певними адресою, поверхами та площею.
     * @param address адреса будівлі
     * @param floors кількість поверхів в будівлі
     * @param area площа будівлі
     */
    public Building(String address, int floors, float area) {
        this.floors = floors;
        this.address = address;
        this.area = area;
    }

    /**
     * Створює будівлю з певними адресою, поверхами, площею та наявністю ліфта ліфта.
     * @param address адреса будівлі
     * @param floors кількість поверхів в будівлі
     * @param area площа будівлі
     * @param hasElevator наявність ліфта в будівлі
     */
    public Building(String address, int floors, float area, boolean hasElevator) {
        this(address, floors, area);
        this.hasElevator = hasElevator;
    }

    /**
     * Створює будівлю зі всіма параметрами включаючи шлях лог файлу.
     * @param address адреса будівлі
     * @param floors кількість поверхів в будівлі
     * @param area площа будівлі
     * @param hasElevator наявність ліфта в будівлі
     * @param logFile шлях для лог файлу
     */
    public Building(String address, int floors, float area, boolean hasElevator, String logFile) {
        this(address, floors, area, hasElevator);
        this.logFile = logFile;
    }

    /**
     * Повертає чи є в будівлі ліфт.
     * 
     * @return true якщо будівля має ліфт, інакше false.
     */
    public boolean getHasElevator(){
        log("HasElevator requested.");
        return this.hasElevator;
    }

    /**
     * Задає чи має будівля ліфт.
     * 
     * @param hasElevator наявність ліфта.
     */
    public void setHasElevator(boolean hasElevator){
        log("HasElevator changed to: " + hasElevator + ".");
        this.hasElevator = hasElevator;
    }

    /**
     * Дістає кількість поверхів в будівлі.
     * 
     * @return кількість поверхів.
     */
    public int getFloors() {
        log("Floors requested.");
        return this.floors;
    }

    /**
     * Задає кількість поверхів в будівлі.
     * 
     * @param floors кількість поверхів.
     */
    public void setFloors(int floors) {
        log("Floors changed to: " + floors + ".");
        this.floors = floors;
    }

    /**
     * Дістає адресу будівлі.
     * 
     * @return адресу будівлі.
     */
    public String getAddress() {
        log("Address requested.");
        return this.address;
    }

    /**
     * Задає адресу будівлі.
     * 
     * @param address нова адреса будівлі.
     */
    public void setAddress(String address) {
        log("Address changed to: " + address + ".");
        this.address = address;
    }

    /**
     * Дістає площу будівлі.
     * 
     * @return площу будівлі.
     */
    public float getArea() {
        log("Area requested.");
        return this.area;
    }

    /**
     * Задає площу будівлі.
     * 
     * @param area нова площа будівлі.
     */
    public void setArea(float area) {
        log("Area changed to: " + area + ".");
        this.area = area;
    }

    /**
     * Дістає шлях лог файлу.
     * 
     * @return шлях лог файлу.
     */
    public String getLogFile() {
        log("LogFile requested.");
        return this.logFile;
    }

    /**
     * Задає шлях лог файлу.
     * 
     * @param logFile шлях лог файлу.
     */
    public void setLogFile(String logFile) {
        this.logFile = logFile;
        log("LogFile changed to: " + logFile + ".");
    }

    /**
     *  Відображає інформацію про будівлю.
     * 
     */
    public void displayInfo() {
        log("Building info displayed.");
        System.out.printf("Building info: %s, floors: %d, area: %fkm²", address, floors,  area);
        System.out.printf("Has elevator: %s, current log file %s.\n", (hasElevator ? "Yes" : "No"), logFile);
    }

    /**
     * Додає поверх до будівлі.
     * Площа збільшується з додаванням поверхів.
     * Якщо площа дорівнює або менша 0, операція провалюється.
     */
    public void addFloor(){
        if(area <= 0){
            log("Failed to add floor, current area: " + area);
            return;
        }

        area += area / floors;
        floors++;
        log("Added a floor. Total floors: " + floors + ", new area: " + area);
    }

    /**
     * Повертає середню площу на поверх.
     * 
     * @return середня площа на поверх.
     */
    public float getFloorArea(){
        log("FloorArea requested.");
        return area / floors;
    }

    /**
     * Записує лог з часом в лог файл.
     * 
     * @param msg повідомлення в лог.
     */
    private void log(String msg){
        try {
            FileWriter fw = new FileWriter(logFile, true);

            fw.write(LocalDateTime.now() + " - " + msg + "\n");

            fw.close();
        } catch (IOException e) {
            System.err.println("Logging failed: " + e.getMessage());
        }
    }

}
