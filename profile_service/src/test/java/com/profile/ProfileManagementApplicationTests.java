package com.profile;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;




import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.when;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.profile.exception.ProfileValidationException;
import com.profile.model.Profile;
import com.profile.repository.ProfileRepository;
import com.profile.service.ProfileService;



@SpringBootTest
class ProductManagementApplicationTests {

  @Test
  void contextLoads() {
  }

  private static final int id = 0;
  @Autowired
  private ProfileService profileService;
  @MockBean
  private ProfileRepository profileRepository;

//  void getAllProfileTest() {
//		when(profileRepository.findAll()).thenReturn(Stream
//				.of(new Profile("11","satya","prattipati","satyaNawab", "satya123","9998887776","2000-06-17","satya@gmail.com","male","customer",("2-12","Haridas","Nidadavolu","AndhraPradesh","India")),
//					new Profile("11","satya","prattipati","satyaNawab", "satya123","9998887776","2000-06-17","satya@gmail.com","male","customer",("2-12","Haridas","Nidadavolu","AndhraPradesh","India"))).collect(Collectors.toList()));
//		assertEquals(2, profileService.getAllProfiles().size());
//	}
//  
// 
//  
//  @Test
//  @DisplayName("Adding Profile Test")
//  public void addProfileTest() throws ProfileValidationException {
//      Profile profile = new Profile("11","satya","prattipati","satyaNawab", "satya123","9998887776","2000-06-17","satya@gmail.com","male","customer",("2-12","Haridas","Nidadavolu","AndhraPradesh","India"));
//      int id = 0;
//      profileService.addProfile(profile);
//  }
//
//  @Test
//  @DisplayName("Update Profile Test")
//  public void updateProfileTest() {
//      Profile profile = new Profile("11","satya","prattipati","satyaNawab", "satya123","9998887776","2000-06-17","satya@gmail.com","male","customer",("2-12","Haridas","Nidadavolu","AndhraPradesh","India"));
//      int id = 0;
//      profileService.updateProfile(profile);
//  }
//  
// 


}