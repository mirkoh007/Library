package com.mirko.library.service;

import com.mirko.library.model.ArchiveOfRenting;
import com.mirko.library.repository.ArchiveOfRentingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArchiveOfRentingServiceImpl implements ArchiveOfRentingService {

    private final ArchiveOfRentingRepository archiveOfRentingRepository;

    public ArchiveOfRentingServiceImpl(ArchiveOfRentingRepository archiveOfRentingRepository) {
        this.archiveOfRentingRepository = archiveOfRentingRepository;
    }


    @Override
    public List<ArchiveOfRenting> findAll() {
        return archiveOfRentingRepository.findAll();
    }

    @Override
    public List<ArchiveOfRenting> findByUserId(Long id) {
        return archiveOfRentingRepository.findByUserId(id);
    }

    @Override
    public List<ArchiveOfRenting> findByBookId(Long id) {
        return archiveOfRentingRepository.findByBookId(id);
    }

    @Override
    public List<ArchiveOfRenting> findByBookCopyId(Long id) {
        return archiveOfRentingRepository.findByBookCopyId(id);
    }

    @Override
    public void save(ArchiveOfRenting archive) { archiveOfRentingRepository.save(archive);

    }

    @Override
    public List<ArchiveOfRenting> findSpecificNumberOverdueBooks(int maxDaysForRenting, Long howMany) {
        return archiveOfRentingRepository.findSpecificNumberOverdueBooks(maxDaysForRenting, howMany);
    }

    @Override
    public List<ArchiveOfRenting> findAllOverdueBooks(int maxDaysForRenting) {
        return archiveOfRentingRepository.findAllOverdueBooks(maxDaysForRenting);
    }


}
