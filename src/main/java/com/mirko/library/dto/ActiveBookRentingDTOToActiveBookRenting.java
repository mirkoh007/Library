package com.mirko.library.dto;

import com.mirko.library.model.ActiveBookRenting;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ActiveBookRentingDTOToActiveBookRenting implements Converter<ActiveBookRentingDTO, ActiveBookRenting> {


    @Override
    public ActiveBookRenting convert(ActiveBookRentingDTO activeBookRentingDTO) {
        return new ActiveBookRenting.Builder()
                .withUserID(activeBookRentingDTO.getUserId())
                .withBookID(activeBookRentingDTO.getBookId())
                .withBookCopyID(activeBookRentingDTO.getBookCopyId())
                .withDateOfRenting(activeBookRentingDTO.getDateOfRenting())
                .build();
    }

    public List<ActiveBookRenting> convert(List<ActiveBookRentingDTO> activeBookRentingDTOS){
        return activeBookRentingDTOS.stream().map(activeBookRentingDTO -> convert(activeBookRentingDTO)).collect(Collectors.toList());
    }
}
