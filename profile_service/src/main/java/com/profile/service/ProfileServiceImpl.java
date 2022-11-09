package com.profile.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.profile.exception.AuthenticationFailureException;
import com.profile.exception.ProfileNotFoundException;
import com.profile.model.Profile;
import com.profile.repository.ProfileRepository;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	private ProfileRepository profileRepository;

	@Override
	public Profile addProfile(Profile profile) {
		return profileRepository.save(profile);
	}

	@Override
	public Profile profileLogin(String username, String password) {
		Profile profile = profileRepository.findByUsernameAndPassword(username, password);

		if (profile == null) {
			throw new AuthenticationFailureException("Username or password is incorrect");
		}

		return profile;
	}

	@Override
	public List<Profile> getAllProfiles() {
		return profileRepository.findAll();
	}

	@Override
	public Profile getProfileById(String profileId) {
		Optional<Profile> optionalProfile = profileRepository.findById(profileId);

		if (optionalProfile == null) {
			throw new ProfileNotFoundException("Profile not exising with id: " + profileId);
		}

		Profile profile = optionalProfile.get();

		return profile;
	}

	@Override
	public Profile updateProfile(Profile profile) {
		Optional<Profile> optionalProfile = profileRepository.findById(profile.getProfileId());

		if (optionalProfile == null) {
			throw new ProfileNotFoundException("Profile not exising with id: " + profile.getProfileId());
		}

		Profile updatedProfile = profileRepository.save(profile);

		return updatedProfile;
	}

	@Override
	public void deleteProfile(String profileId) {
		Optional<Profile> optionalProfile = profileRepository.findById(profileId);

		if (optionalProfile == null) {
			throw new ProfileNotFoundException("Profile not exising with id: " + profileId);
		}

		Profile profile = optionalProfile.get();

		profileRepository.delete(profile);

	}

	
	

}
