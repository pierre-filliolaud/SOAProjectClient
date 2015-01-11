package com.myCompany.restWebService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.myCompany.dto.CarDTO;
import com.myCompany.model.Car;
import com.myCompany.soapWebService.CarWebService;

@Component
@Controller
@RequestMapping("/carRest")
public class CarController {
	
	CarWebService carWebService;
	
	public CarWebService getCarWebService() {
		return carWebService;
	}

	public void setCarWebService(CarWebService carWebService) {
		this.carWebService = carWebService;
	}

	@RequestMapping(value = "/cars", method = RequestMethod.GET) 
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<CarDTO> allCars() {
		List<CarDTO> dtoCars = new ArrayList<CarDTO>();
		List<Car> cars = carWebService.findAllCars();
		for(Car car:cars) {
			dtoCars.add(new CarDTO(car.getPlateNumber()));
		}
		return dtoCars;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.GET) 
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void save(String plateNumber) {
		Car car = new Car();
		car.setPlateNumber(plateNumber);
		long id = carWebService.save(car);
	}
}
