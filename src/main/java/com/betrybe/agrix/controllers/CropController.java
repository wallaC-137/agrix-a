package com.betrybe.agrix.controllers;

import com.betrybe.agrix.controllers.dto.CropDto;
import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.services.FarmService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Crop controller.
 */
@RestController
@RequestMapping(value = "/crops")
public class CropController {

  private final FarmService farmService;


  /**
   * Instantiates a new Crop controller.
   *
   * @param farmService the farm service
   */
  @Autowired
  public CropController(FarmService farmService) {
    this.farmService = farmService;
  }

  /**
   * Gets all crop.
   *
   * @return the all crop
   */
  @GetMapping()
  public ResponseEntity<List<CropDto>> getAllCrop() {
    List<Crop> crops = farmService.getAllCrop();

    List<CropDto> cropDtos = crops.stream()
        .map((crop) -> new CropDto(crop.getId(), crop.getName(), crop.getPlantedArea(),
            crop.getFarmId().getId()))
        .collect(Collectors.toList());

    return ResponseEntity.ok(cropDtos);
  }
}
