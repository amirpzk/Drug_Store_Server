package com.Prana.Latifi.service.Impl;

import com.Prana.Latifi.entity.Item;
import com.Prana.Latifi.entity.Profile;
import com.Prana.Latifi.entity.User;
import com.Prana.Latifi.exception.NoTokenInRequest;
import com.Prana.Latifi.exception.UserWithThisIdDoesNotExist;
import com.Prana.Latifi.jwt.JwtFactory;
import com.Prana.Latifi.jwt.UserRoleModel;
import com.Prana.Latifi.repository.ItemRepo;
import com.Prana.Latifi.repository.ProfileRepo;
import com.Prana.Latifi.repository.UserRepo;
import com.Prana.Latifi.response.ProfileResponse;
import com.Prana.Latifi.response.mapper.ProfileMapper;
import com.Prana.Latifi.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ProfileRepo profileRepo;
    @Autowired
    private ItemRepo itemRepo;
    @Autowired
    private JwtFactory jwtFactory;

    @Override
    public ProfileResponse update(String avatar, String firstName, String lastName, String token) {

        if (token == null || token.isEmpty()) {
            throw new NoTokenInRequest();
        }
        UserRoleModel userRoleModel = jwtFactory.parseToken(token);


        String username = userRoleModel.getUsername();

        if (!userRepo.existsByUsername(username)){
            throw new UserWithThisIdDoesNotExist();
        }
        User foundedUser = userRepo.findByUsername(username);
        Profile foundedProfile = foundedUser.getProfile();

        foundedProfile.setAvatar(avatar);
        foundedProfile.setFirstName(firstName);
        foundedProfile.setLastName(lastName);

        return ProfileMapper.convert(profileRepo.save(foundedProfile));
    }

    @Override
    public boolean addRemoveFavourtie(long itemId, String token) {
        if (token == null || token.isEmpty()) {
            throw new NoTokenInRequest();
        }
        UserRoleModel userRoleModel = jwtFactory.parseToken(token);

        String username = userRoleModel.getUsername();

        if (!userRepo.existsByUsername(username)){
            throw new UserWithThisIdDoesNotExist();
        }

        User user = userRepo.findByUsername(username);
        if (user.getProfile().getFavourites().contains(itemId)){
            user.getProfile().getFavourites().remove(itemId);
        } else {
            user.getProfile().getFavourites().add(itemId);
        }

        return true;
    }

    @Override
    public List<Long> getFavourites(String token) {
        if (token == null || token.isEmpty()) {
            throw new NoTokenInRequest();
        }
        UserRoleModel userRoleModel = jwtFactory.parseToken(token);

        String username = userRoleModel.getUsername();

        if (!userRepo.existsByUsername(username)){
            throw new UserWithThisIdDoesNotExist();
        }

        User user = userRepo.findByUsername(username);
        return user.getProfile().getFavourites();
    }
}
