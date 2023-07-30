package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.List;

@Controller
public class CarController {

    private final CarService carService;
    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars")
    public String getCars(ModelMap model){
        List<Car> carList = carService.getAllCars();
        model.addAttribute("cars", carList);
        return "cars";
    }


    @GetMapping(value = "/cars", params = "count")
    public String getCarsCount(@RequestParam int count, ModelMap model){
        List<Car> carList = carService.getCars(count);
        model.addAttribute("cars", carList);
        return "cars";
    }
}
