package com.mirko.library.dto;

import com.mirko.library.model.ActiveBookRenting;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

@Component
public class ActiveOverdueRentingDTOToActiveOverdueRenting implements Converter<ActiveBookRenting, ActiveOverdueRentingDTO> {
    @Override
    public ActiveOverdueRentingDTO convert(ActiveBookRenting activeBookRenting) {
        return new ActiveOverdueRentingDTO.Builder()
                .withBookID(activeBookRenting.getBookId())
                .withBookCopyID(activeBookRenting.getBookCopyId())
                .withUserID(activeBookRenting.getUserId())
                .withDays(DAYS.between(activeBookRenting.getDateOfRenting(), LocalDate.now()))
                .build();
    }

    public List<ActiveOverdueRentingDTO> convert(List<ActiveBookRenting> activeBookRentings){
        return activeBookRentings.stream().map(activeBookRenting -> convert(activeBookRenting)).collect(Collectors.toList());
    }
}
