package com.wedding.planner.api.v1.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.wedding.planner.api.v1.dto.InspirationDTO;
import com.wedding.planner.api.v1.dto.ResponseDTO;
import com.wedding.planner.entity.Inspiration;

public interface ApiInspirationService {

	/**
	 * Converts {@link Inspiration} to {@link InspirationDTO}
	 *
	 * @param inspiration
	 * @return
	 */
	default InspirationDTO convertToDTO(Inspiration inspiration) {
		return new InspirationDTO(inspiration.getInspirationId(),
				inspiration.getPostedBy().getUserId().toString(),
				inspiration.getImage().getUrl(), inspiration.getDescription(), inspiration.getTags());
	}

	/**
	 * Converts {@link List} of {@link Inspiration} to {@link List}
	 * {@link InspirationDTO}
	 *
	 * @param inspirations
	 * @return
	 */
	default List<InspirationDTO> convertToDTO(List<Inspiration> inspirations) {
		return inspirations.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	/**
	 * Adds {@link Inspiration} To database
	 *
	 * @param file
	 * @param description
	 * @param tags
	 * @return
	 */
	ResponseEntity<InspirationDTO> addInspiration(MultipartFile file, String description, String tags[]);

	/**
	 * updates Old {@link Inspiration}
	 *
	 * @param file
	 * @param description
	 * @param tags
	 * @return
	 */
	ResponseEntity<InspirationDTO> updateInspiration(Long inspiration, MultipartFile file, String description,
			String tags[]);

	/**
	 * Gets Specified inspiration
	 *
	 * @param inspirationId
	 * @return
	 */
	ResponseEntity<InspirationDTO> getInspiration(Long inspirationId);

	/**
	 * Deletes Given Inspiration
	 *
	 * @param inspirationId
	 * @return
	 */
	ResponseEntity<Boolean> deleteInspiration(Long inspirationId);

	/**
	 * gets inspirations with paging
	 * @param page
	 * @param perPage
	 * @return
	 */
	ResponseEntity<ResponseDTO<List<InspirationDTO>>> getAllInspirations(Integer page,Integer perPage);

	/**
	 * Gets inspirations with paging
	 * @return
	 */
	ResponseEntity<ResponseDTO<List<InspirationDTO>>> getAllInspirations();

}
