package car.shop;

import models.Car;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by root on 13.02.17.
 */
class StoreTest {
    static Store store;

    @BeforeAll
    public static void initStore() {
        store = new Store();
        assertNotNull(store);
    }

    @org.junit.jupiter.api.Test
    void createCar() {
        Store store = new Store();
        Car car = new Car(100, "Lada", "ABC");
        store.createCar(100, "Lada", "ABC");

        assertNotNull(store.getFreeCars());

        assertTrue(store.getFreeCars().size() > 0);
        store.getFreeCars().stream().forEach((car1) -> {
            assertEquals(100, car1.getPrice());
            assertEquals("Lada", car1.getModel());
            assertEquals("ABC", car1.getRegNum());
        });

    }

    @org.junit.jupiter.api.Test
    void save() {

    }

    @org.junit.jupiter.api.Test
    void recover() {

    }

    @org.junit.jupiter.api.Test
    void getFirstOrder() {
        Store store = new Store();
        store.getOrders();

    }

    @org.junit.jupiter.api.Test
    void sellCar() throws CarNotFoundExeption {
        Store store = new Store();

        assertThrows(CarNotFoundExeption.class, () ->
                store.sellCar("GAZ", "A", "B", "911"));

        store.createCar(100, "Lada", "ABC");
        store.sellCar("Lada", "A", "B", "C");


        Car car = new Car(100, "Lada", "ABC");


        assertTrue(store.getFreeCars().size() == 0);
        assertTrue(store.getOrders().stream().filter((order) ->
                order.getCar().getModel().equals("Lada")
                        && order.getCar().getPrice() == 100
                        && order.getCar().getRegNum().equals("ABC")
        ).count() > 0);
        assertTrue(store.getOrders().contains(""));
        assertTrue(store.getContractList().size() == 1);
        assertTrue(store.getContractList().values().stream().filter(
                (client) -> client.getFirstName().equals("A")
                        && client.getLastName().equals("B")
                        && client.getPhoneNumber().equals("C")).count() == 1);


    }

    @Test
    void getContractList() {
        Store store = new Store();
        assertNotNull(store.getContractList());
        assertTrue(store.getContractList().size() == 0);

    }

    @org.junit.jupiter.api.Test
    void getOrders() {

    }

    @org.junit.jupiter.api.Test
    void getFreeCars() {

    }

}