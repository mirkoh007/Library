package com.mirko.library.dto;

import com.mirko.library.model.ArchiveOfRenting;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ArchiveOfRentingToArchiveOfRentingDTO implements Converter<ArchiveOfRenting, ArchiveOfRentingDTO> {
    @Override
    public ArchiveOfRentingDTO convert(ArchiveOfRenting archiveOfRenting) {
        return new ArchiveOfRentingDTO.Builder()
                .withId(archiveOfRenting.getId())
                .withUserId(archiveOfRenting.getUserId())
                .withBookCopyId(archiveOfRenting.getBookCopyId())
                .withBookId(archiveOfRenting.getBookId())
                .withDateOfRenting(archiveOfRenting.getDateOfRenting())
                .withDateOfReturning(archiveOfRenting.getDateOfReturning())
                .build();
    }

    public List<ArchiveOfRentingDTO> converter(List<ArchiveOfRenting> archiveOfRentings){
        return archiveOfRentings.stream().map(archiveOfRenting -> convert(archiveOfRenting)).collect(Collectors.toList());
    }
}
