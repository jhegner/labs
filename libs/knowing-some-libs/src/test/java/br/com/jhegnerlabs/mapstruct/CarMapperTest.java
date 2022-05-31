package br.com.jhegnerlabs.mapstruct;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CarMapperTest {

    @Test
    public void deve_mapear_carro_para_dto() {

        // given
        Car car = new Car("Morris", 5,  CarType.SEDAN);

        // when
        CarDto dto = CarMapper.INSTANCE.carToDto(car);

        // then
        Assertions.assertNotNull(dto);
        Assertions.assertEquals(dto.getMake(), "Morris");
        Assertions.assertEquals(dto.getSeatCount(), 5);
        Assertions.assertEquals(dto.getType(), "SEDAN");

    }

}