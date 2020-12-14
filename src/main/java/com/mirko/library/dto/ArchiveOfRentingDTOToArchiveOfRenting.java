package com.mirko.library.dto;

import com.mirko.library.model.ArchiveOfRenting;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ArchiveOfRentingDTOToArchiveOfRenting implements Converter<ArchiveOfRentingDTO, ArchiveOfRenting> {
    @Override
    public ArchiveOfRenting convert(ArchiveOfRentingDTO archiveOfRentingDTO) {
        return new ArchiveOfRenting.Builder()
                .withId(archiveOfRentingDTO.getId())
                .withUserId(archiveOfRentingDTO.getUserId())
                .withBookCopyId(archiveOfRentingDTO.getBookCopyId())
                .withBookId(archiveOfRentingDTO.getBookId())
                .withDateOfRenting(archiveOfRentingDTO.getDateOfRenting())
                .withDateOfReturning(archiveOfRentingDTO.getDateOfReturning())
                .build();
    }

    public List<ArchiveOfRenting> convert(List<ArchiveOfRentingDTO> archiveOfRentingDTOS){
        return archiveOfRentingDTOS.stream().map(archiveOfRentingDTO -> convert(archiveOfRentingDTO)).collect(Collectors.toList());
    }
}
