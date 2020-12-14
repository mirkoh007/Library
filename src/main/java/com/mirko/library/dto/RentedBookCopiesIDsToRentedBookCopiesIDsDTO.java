package com.mirko.library.dto;

import com.mirko.library.model.ActiveBookRenting;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RentedBookCopiesIDsToRentedBookCopiesIDsDTO implements Converter<ActiveBookRenting, RentedBookCopiesIDsDTO> {

    @Override
    public RentedBookCopiesIDsDTO convert(ActiveBookRenting activeBookRenting) {
        return new RentedBookCopiesIDsDTO.Builder()
                .withBookCopyID(activeBookRenting.getBookCopyId())
                .withBookID(activeBookRenting.getBookId())
                .build();
    }

    public List<RentedBookCopiesIDsDTO> convert(List<ActiveBookRenting> activeBookRentings){
        return activeBookRentings.stream().map(activeBookRenting -> convert(activeBookRenting)).collect(Collectors.toList());
    }

}
