package com.Prana.Latifi.service.Impl;

import com.Prana.Latifi.entity.Item;
import com.Prana.Latifi.entity.Rate;
import com.Prana.Latifi.exception.ForbiddenForYou;
import com.Prana.Latifi.exception.NoTokenInRequest;
import com.Prana.Latifi.jwt.JwtFactory;
import com.Prana.Latifi.jwt.UserRoleModel;
import com.Prana.Latifi.repository.ItemRepo;
import com.Prana.Latifi.repository.RateRepo;
import com.Prana.Latifi.response.RateResponse;
import com.Prana.Latifi.response.mapper.RateMapper;
import com.Prana.Latifi.service.ItemService;
import com.Prana.Latifi.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RateServiceImpl implements RateService {

    @Autowired
    private RateRepo rateRepo;
    @Autowired
    private JwtFactory jwtFactory;
    @Autowired
    private ItemRepo itemRepo;

    @Override
    public RateResponse rateItem(long itemId, int rate, String token) {
        if (token == null || token.isEmpty()) {
            throw new NoTokenInRequest();
        }
        UserRoleModel userRoleModel = jwtFactory.parseToken(token);

        Rate foundedRate = rateRepo.findByUsernameAndItemId(userRoleModel.getUsername(), itemId);
        Item foundedItem = itemRepo.findById(itemId).get();
        if (foundedRate==null){
            foundedRate = new Rate(userRoleModel.getUsername(), itemId, rate);
            foundedItem.setTotalRate(foundedRate.getRate() + rate);
            foundedItem.setTotalAMountOfRates(foundedItem.getTotalAMountOfRates()+1);
        } else {
            foundedItem.setTotalRate(foundedItem.getTotalRate()-foundedRate.getRate()+rate);
            foundedRate.setRate(rate);
        }
        itemRepo.save(foundedItem);
        return RateMapper.convert(rateRepo.save(foundedRate));
    }

    @Override
    public RateResponse getCurrentRate(long itemId, String token) {
        if (token == null || token.isEmpty()) {
            throw new NoTokenInRequest();
        }
        UserRoleModel userRoleModel = jwtFactory.parseToken(token);

        return RateMapper.convert(rateRepo.findByUsernameAndItemId(userRoleModel.getUsername(), itemId));
    }
}
