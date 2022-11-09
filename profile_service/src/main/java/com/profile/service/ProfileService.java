package com.profile.service;

import java.util.List;

import com.profile.model.Profile;

public interface ProfileService {

	Profile addProfile(Profile profile);

	

	List<Profile> getAllProfiles();

	Profile getProfileById(String profileId);

	Profile updateProfile(Profile profile);

	void deleteProfile(String profileId);

	Profile profileLogin(String username, String password);



	




}
