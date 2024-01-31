package Service;

import model.Car;

import java.util.List;

public class CarServiceImpl implements CarService {

        private List<Car> carList;

        public CarServiceImpl(List<Car> carList) {
            this.carList = carList;
        }
        @Override
        public List<Car> getCars(int count) {
            if (count <= carList.size()) {
                return carList.subList(0, count);
            } else {
                return carList;
            }
        }
    }

