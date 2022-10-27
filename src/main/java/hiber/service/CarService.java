package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface CarService {

    void add(Car car);

    User findByCar(String model,int series);

    List<Car> listCars();

}
