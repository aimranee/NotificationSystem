package com.adria.notification.dao;

import com.adria.notification.models.entities.PreferenceToken;

public interface IPreferenceTokenDao {

    PreferenceToken findByToken(String token);
}
