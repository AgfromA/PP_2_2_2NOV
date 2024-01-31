package web.Service;

import java.util.List;

import web.model.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CarServiceImpl implements CarService {
    private List<Car> carList;

    public CarServiceImpl() {
        carList = new ArrayList<>();
        carList.add(new Car("Toyota", "Camry", 2018));
        carList.add(new Car("Audi", "A4", 2020));
        carList.add(new Car("BMW", "X5", 2019));
        carList.add(new Car("Mercedes-Benz", "E-Class", 2021));
        carList.add(new Car("Volkswagen", "Golf", 2022));
    }

    public List<Car> getCars(int count) {
        if (count >= 5) {
            return carList;
        } else if (count <= 0) {
            return new ArrayList<>();
        } else {
            return carList.subList(0, count);
        }
    }
}

