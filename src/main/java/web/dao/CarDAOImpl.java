package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarDAOImpl implements CarDAO {

    @Override
    public List<Car> getCarList(List<Car> carList, Integer count) {
        if (count == null) {
            count = 5;
        }
        return carList.stream().limit(count).collect(Collectors.toList());
    }
}
