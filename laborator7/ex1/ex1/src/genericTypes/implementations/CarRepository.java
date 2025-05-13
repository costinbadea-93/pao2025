package genericTypes.implementations;

import genericTypes.contracts.CrudRepository;
import genericTypes.model.Car;

public class CarRepository implements CrudRepository<Car>{
    @Override
    public void save(Car car) {

    }

    @Override
    public void delete(Car car) {

    }

    @Override
    public Car getById(int id) {
        return null;
    }
}
