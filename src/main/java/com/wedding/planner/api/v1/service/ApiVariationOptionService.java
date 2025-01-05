package com.wedding.planner.api.v1.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.wedding.planner.api.v1.dto.ResponseDTO;
import com.wedding.planner.api.v1.dto.VariationOptionDTO;
import com.wedding.planner.entity.Variation;
import com.wedding.planner.entity.VariationOption;

public interface ApiVariationOptionService {

    /**
     * converts {@link VariationOption} to {@link VariationOptionDTO}
     *
     * @param option
     * @return
     */
    default VariationOptionDTO convertToDTO(VariationOption option) {
        return new VariationOptionDTO(option.getVariationOptionId(), option.getVariationOptionName());
    }

    /**
     * converts {@link VariationOption} list to {@link VariationOptionDTO} list
     *
     * @param options
     * @return
     */
    default List<VariationOptionDTO> convertToDTO(List<VariationOption> options) {
        return options.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    /**
     * returns All the available variation options in {@link VariationOptionDTO}
     *
     * @return
     */
    ResponseEntity<ResponseDTO<List<VariationOptionDTO>>> variationOptions();

    /**
     * returns All the available variation options in {@link VariationOptionDTO}
     * with paging
     *
     * @param page
     * @return
     */
    ResponseEntity<ResponseDTO<List<VariationOptionDTO>>> variationOptions(Pageable page);

    /**
     * returns All the available variation options in {@link VariationOptionDTO} for
     * {@link Variation}
     *
     * @param variation
     * @return
     */
    ResponseEntity<ResponseDTO<List<VariationOptionDTO>>> variationOptions(Variation variation);

    /**
     * returns All the available variation options in {@link VariationOptionDTO} for
     * {@link variation} with paging
     *
     * @param variation
     * @param page
     * @return
     */
    ResponseEntity<ResponseDTO<List<VariationOptionDTO>>> variationOptions(Variation variation, Pageable page);
}
