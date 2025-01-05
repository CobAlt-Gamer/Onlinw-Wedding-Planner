package com.wedding.planner.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.wedding.planner.entity.Variation;
import com.wedding.planner.entity.VariationOption;

public interface VariationOptionService {

	/**
	 * gets All the Available Variation Options irrespective of the variation
	 *
	 * @return {@link ResponseEntity<List<VariationOptions>>}
	 */
	ResponseEntity<List<VariationOption>> getVariationOptions();

	/**
	 * returns All the Available variation Options related to @param variation
	 *
	 * @param variation
	 * @return {@link ResponseEntity<List<VariationOption>>}
	 */
	ResponseEntity<List<VariationOption>> getVariationOptions(Variation variation);

	/**
	 * returns Variation Entity related to @param optionId
	 *
	 * @param optionId
	 * @return {@link ResponseEntity<VariationOption>}
	 */
	ResponseEntity<VariationOption> getVariationOption(Integer optionId);

	/**
	 * adds the {@link VariationOption} to database
	 *
	 * @param variation
	 * @param variationOption
	 * @return {@link ResponseEntity<VariationOption>} latest added
	 *         {@link VariationOption} Entity
	 */
	ResponseEntity<VariationOption> addVariationOption(Variation variation, String variationOption);

	/**
	 * deletes {@link VariationOption} related to @param optionId
	 *
	 * @param optionId
	 * @return {@link ResponseEntity<String>}
	 */
	ResponseEntity<String> deleteVariationOption(Integer optionId);

	/**
	 * deletes variation option by {@link Variation}
	 *
	 * @param variation
	 * @return {@link ResponseEntity<Boolean>} whether the {@link VariationOption}
	 *         are deleted or not
	 */
	ResponseEntity<Boolean> deleteVariationOptionsBy(Variation variation);
}