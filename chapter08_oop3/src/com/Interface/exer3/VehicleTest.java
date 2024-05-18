package com.Interface.exer3;

/**
 * ClassName:
 * Description:
 *
 * @Author Rin
 * @Create 2024/4/1 下午 05:12
 * @Version 1.0
 */
public class VehicleTest {

    public static void main(String[] args) {
        IPower.method1();
        Developer developer = new Developer();

        Vehicle[] vehicles = new Vehicle[3];
        vehicles[0] = new Bicycle("捷安特","黑色");
        vehicles[1] = new Car("BMW","綠色");
        vehicles[2] = new ElectricVehicle("TESLA","白色");

//        Car car = new Car();
//        IPower ipower = (IPower) car;
//        ipower.power();

        for (int i = 0; i < vehicles.length; i++) {
            developer.takingVehicle(vehicles[i]);

            if (vehicles[i] instanceof IPower){
                ((IPower) vehicles[i]).power();
                //不能寫vehicles[i].power();是因為vechicles[i]中是一個Vehicle類的對象，而Vehicle類中並沒有power()方法。
            }
        }
    }
}
