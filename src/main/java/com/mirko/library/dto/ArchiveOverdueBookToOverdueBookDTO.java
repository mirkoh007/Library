package com.mirko.library.dto;

import com.mirko.library.model.ArchiveOfRenting;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

@Component
public class ArchiveOverdueBookToOverdueBookDTO implements Converter<ArchiveOfRenting, ArchiveOverdueBookDTO> {
    @Override
    public ArchiveOverdueBookDTO convert(ArchiveOfRenting archive) {
        return new ArchiveOverdueBookDTO.Builder()
                .withBookID(archive.getBookId())
                .withBookCopyID(archive.getBookCopyId())
                .withUserID(archive.getUserId())
                .withDays(DAYS.between(archive.getDateOfRenting(),archive.getDateOfReturning()))
                .build();
    }

    public List<ArchiveOverdueBookDTO> convert(List<ArchiveOfRenting> archive){
        return archive.stream().map(archive1 -> convert(archive1)).collect(Collectors.toList());
    }


}
