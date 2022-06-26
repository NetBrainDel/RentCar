package com.RentCars.service.impl;


import com.RentCars.converter.CarConverter;
import com.RentCars.dao.Car;
import com.RentCars.dto.CarDto;
import com.RentCars.exception.ValidationException;
import com.RentCars.repository.CarRepository;
import com.RentCars.service.CarService;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository<Long, String> carRepository;
    private final CarConverter carConverter;
    @PersistenceContext
    private EntityManager em;
    @Override
    public CarDto saveCar(CarDto carDto) throws ValidationException {
        validateCarDto(carDto);
        Car savedCar = carRepository.save(carConverter.fromCarDtoToCar(carDto));
        return carConverter.fromCarToCarDto(savedCar);
    }


    private void validateCarDto(CarDto carDto) throws ValidationException {
        if (isNull(carDto)) {
            throw new ValidationException("Object car is null");
        }
        if (isNull(carDto.getPrice_rent()) || carDto.getPrice_rent().isNaN()) {
            throw new ValidationException("PriceRent is empty");
        }
    }

    @Override
    public void deleteCar(Long carId) {
        carRepository.deleteById(carId);
    }


    @Override
    public Optional<Car> findById(@RequestParam Long id) {
        return carRepository.findById(id);
    }


    @Override
    public Optional<Car> findByModel(String model) {
        return em.unwrap(Session.class).createQuery("select Car from Car u where u.model =:model and u.rent=false", Car.class)
                .setParameter("model", model)
                .setFirstResult(0)
                .setMaxResults(1)
                .uniqueResultOptional();
    }

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }
}