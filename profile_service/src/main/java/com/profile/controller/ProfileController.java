package com.profile.controller;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.profile.model.Profile;
import com.profile.service.ProfileService;

@RestController
@CrossOrigin(value = "http://localhost:3000/")
@RequestMapping("/profile")
public class ProfileController {

	@Autowired
	private ProfileService profileService;

	@PostMapping("/profile-login")
	public ResponseEntity<Profile> doProfileLogin(@RequestParam("username") String username,
			@RequestParam("password") final String password) {

		Profile profile = profileService.profileLogin(username, password);

		ResponseEntity<Profile> responseEntity = new ResponseEntity<>(profile, HttpStatus.OK);

		return responseEntity;

	}

	@GetMapping("/allProfiles")
	public List<Profile> fetchAllProfiles() {

		List<Profile> profiles = profileService.getAllProfiles();
		return profiles;
	}

	@PostMapping("/save")
	public ResponseEntity<Profile> addProfile(@RequestBody Profile profile) {

		Profile newProfile = profileService.addProfile(profile);
		ResponseEntity<Profile> responseEntity = new ResponseEntity<>(newProfile, HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<?> fetchProfileById(@PathVariable("id") String profileId) {

		ResponseEntity<?> responseEntity = null;
		Profile profile = profileService.getProfileById(profileId);
		responseEntity = new ResponseEntity<>(profile, HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProfileById(@PathVariable("id") String profileId) {

		ResponseEntity<String> responseEntity = null;
		profileService.deleteProfile(profileId);
		responseEntity = new ResponseEntity<>("Profile deleted successfully", HttpStatus.OK);
		return responseEntity;
	}

	@PutMapping("/update")
	public ResponseEntity<Object> updateProfile(@RequestBody Profile profile) {

		ResponseEntity<Object> responseEntity = null;
		Profile updatedProfile = profileService.updateProfile(profile);
		responseEntity = new ResponseEntity<>(updatedProfile, HttpStatus.OK);
		return responseEntity;
	}

}
