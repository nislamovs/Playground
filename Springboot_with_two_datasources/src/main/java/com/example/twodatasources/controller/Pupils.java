package com.example.twodatasources.controller;

import com.example.twodatasources.domain.AbstractDTO;
import com.example.twodatasources.domain.PupilDTO;
import com.example.twodatasources.services.PupilsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class Pupils {

    private final PupilsService pupilsService;

    @GetMapping("/pupil/all")
    public List<PupilDTO> getPupils() {
        return pupilsService.getAllPupils();
    }

    @GetMapping("/pupil/{id}")
    public PupilDTO getPupilById(@PathVariable("id") String id) {
        return pupilsService.getPupilById(id);
    }

    @PostMapping("/pupil")
    public AbstractDTO newPupil(@Valid @RequestBody PupilDTO newPupil) {
        return pupilsService.addNewPupil(newPupil);
    }

    @PutMapping("/pupil")
    public AbstractDTO editPupil(@Valid @RequestBody PupilDTO pupil) {
        return pupilsService.editPupilData(pupil);
    }

    @DeleteMapping("/pupil/{id}")
    public AbstractDTO deletePupil(@PathVariable("id") String id) {
        return pupilsService.deletePupil(id);
    }

}
