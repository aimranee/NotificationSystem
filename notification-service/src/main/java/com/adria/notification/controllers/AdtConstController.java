package com.adria.notification.controllers;

import com.adria.notification.dto.request.adtConsts.SaveADTConstRequestDTO;
import com.adria.notification.dto.request.adtConsts.UpdateADTConstRequestDTO;
import com.adria.notification.dto.response.adtConsts.ADTConstResponseDTO;
import com.adria.notification.services.IADTConstService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/configuration")
public class AdtConstController {

    private final IADTConstService adtConstService;

    @PostMapping(value = "/save")
    public ResponseEntity<ADTConstResponseDTO> save(@RequestBody @Valid SaveADTConstRequestDTO saveADTConstRequestDTO) {
        return ResponseEntity.ok()
                .body(adtConstService.saveADTConst(saveADTConstRequestDTO));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<ADTConstResponseDTO> update(@RequestBody @Valid UpdateADTConstRequestDTO editADTConstRequestDTO) {
        return ResponseEntity.ok()
                .body(adtConstService.updateADTConst(editADTConstRequestDTO));
    }

    @GetMapping(value = "/details")
    public ResponseEntity<ADTConstResponseDTO> getADTConstById(@RequestParam String id) {
        return ResponseEntity.ok()
                .body(adtConstService.getADTConstById(id));
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<ADTConstResponseDTO>> findAll() {
        return ResponseEntity.ok()
                .body(adtConstService.getAllADTConst());
    }

}
