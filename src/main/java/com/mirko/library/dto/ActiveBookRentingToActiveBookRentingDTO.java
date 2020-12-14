package com.mirko.library.dto;

import com.mirko.library.model.ActiveBookRenting;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ActiveBookRentingToActiveBookRentingDTO implements Converter<ActiveBookRenting, ActiveBookRentingDTO> {
    @Override
    public ActiveBookRentingDTO convert(ActiveBookRenting activeBookRenting) {

        return new ActiveBookRentingDTO.Builder()
                .withUserID(activeBookRenting.getUserId())
                .withBookCopyID(activeBookRenting.getBookCopyId())
                .withBookID(activeBookRenting.getBookId())
                .withDateOfRenting(activeBookRenting.getDateOfRenting())
                .build();
    }

    public List<ActiveBookRentingDTO> convert(List<ActiveBookRenting> activeBookRentings){
        return activeBookRentings.stream().map(activeBookRenting -> convert(activeBookRenting)).collect(Collectors.toList());
    }

}
