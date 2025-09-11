/**Пакет до лабораторної 3 */
package KI305.Kozak.Lab3;

/**
 *
 */
abstract class Building {
    /** Кількість поверхів в будівлі. */
    int floors = 0;
    /** Адреса будівлі. */
    String address = "";
    /** Площа будівлі. */
    float area = 0.0f;
    /** Чи наявний у будівлі ліфт. */
    boolean hasElevator = false;
    /** Шлях для лог файлу.  */

    /**
     * 
     * @return
     */
    abstract boolean getHasElevator();

    /**
     * 
     * @param hasElevator
     */
    abstract void setHasElevator(boolean hasElevator);

    /**
     * 
     * @return
     */
    abstract int getFloors();
    /**
     * 
     * @param floors
     */
    abstract void setFloors(int floors);

    /**
     * 
     * @return
     */
    abstract String getAddress();

    /**
     * 
     * @param address
     */
    abstract void setAddress(String address);


    /**
     * 
     * @return
     */
    abstract float getArea();

    /**
     * 
     * @param area
     */
    abstract void setArea(float area);

    /**
     * 
     */
    abstract void displayInfo();

    /**
     * 
     */
    abstract void addFloor();

    /**
     * 
     * @return
     */
    abstract float getFloorArea();
}
