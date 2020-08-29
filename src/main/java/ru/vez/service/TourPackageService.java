package ru.vez.service;

import ru.vez.domain.TourPackage;
import ru.vez.repo.TourPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Tour Package Service
 */
@Service
public class TourPackageService {
    private TourPackageRepository tourPackageRepository;

    @Autowired
    public TourPackageService(TourPackageRepository tourPackageRepository) {
        this.tourPackageRepository = tourPackageRepository;
    }

    public TourPackage createTourPackage(String code, String name) {
        return !tourPackageRepository.existsById(code) ?
                tourPackageRepository.save(new TourPackage(code, name)) :
                null;

    }
    public Iterable<TourPackage> lookup(){
        return tourPackageRepository.findAll();
    }
    public long total() {
        return tourPackageRepository.count();
    }
}

