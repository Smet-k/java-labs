/**Пакет до лабораторної 2 */
package KI305.Kozak.Lab2;

/**
 * Клас драйвер який демонструє роботу класу Building
 */
public class App {

    /**
    * Статичний метод main є точкою входу в програму
    *
    * @param args
    *
    */
    public static void main(String[] args) {
        Building building1 = new Building("Building st. 1", 5, 225.5f, true);
        Building building2 = new Building();

        building2.setAddress("Building st. 12");
        building2.setArea(250.5f);
        building2.setFloors(2);

        Building office = new Building("Office st. 15", 3, 551);

        office.setLogFile("OfficeLog.txt");
        
        System.out.printf("All building area sum is: %f\n", building1.getArea() + building2.getArea() + office.getArea());
        
        building1.displayInfo();
        building2.displayInfo();
        office.displayInfo();
    }
}
