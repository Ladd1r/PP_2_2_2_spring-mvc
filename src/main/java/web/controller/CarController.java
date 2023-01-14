package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.Arrays;
import java.util.List;

@Controller
public class CarController {
    @Autowired
    private CarService carService;


    @GetMapping("/cars")
    public String getCars(@RequestParam(value = "count", required = false) Integer count, Model model) {
        Car car1 = new Car("BMW", 253, "black");
        Car car2 = new Car("Mazda", 459, "red");
        Car car3 = new Car("Lada", 687, "white");
        Car car4 = new Car("Audi", 123, "yellow");
        Car car5 = new Car("Renault", 634, "green");
        List<Car> carList = Arrays.asList(car1, car2, car3, car4, car5);
        model.addAttribute("list", carService.getCarList(carList, count));

        return "car";
    }
}
