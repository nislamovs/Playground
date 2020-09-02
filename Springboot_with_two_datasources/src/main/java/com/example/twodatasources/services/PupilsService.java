package com.example.twodatasources.services;


import com.example.twodatasources.converters.PupilDataObjectMapper;
import com.example.twodatasources.domain.AbstractDTO;
import com.example.twodatasources.domain.PupilDTO;
import com.example.twodatasources.repository.datasource2.PupilRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Long.parseLong;

@Service
@Slf4j
@RequiredArgsConstructor
public class PupilsService {

    private final PupilRepository pupilRepository;
    private final PupilDataObjectMapper pupilDataObjectMapper;

    public List<PupilDTO> getAllPupils() {
        return pupilRepository.findAll().stream()
                .map(pupilDataObjectMapper::toDTO).collect(Collectors.toList());
    }

    public PupilDTO getPupilById(String pupilId) {
        return pupilDataObjectMapper.toDTO(pupilRepository.findById(parseLong(pupilId)).get());
    }

    public AbstractDTO addNewPupil(PupilDTO newPupil) {
        pupilRepository.save(pupilDataObjectMapper.toDAO(newPupil));

        return AbstractDTO.builder()
                .dateTime(LocalDateTime.now()).build();
    }

    public AbstractDTO editPupilData(PupilDTO pupil) {
        pupilRepository.save(pupilDataObjectMapper.toDAO(pupil));

        return AbstractDTO.builder()
                .id(String.valueOf(pupil.getId()))
                .dateTime(LocalDateTime.now()).build();
    }

    public AbstractDTO deletePupil(String pupilId) {
        pupilRepository.deleteById(parseLong(pupilId));

        return AbstractDTO.builder().dateTime(LocalDateTime.now()).build();
    }
}
