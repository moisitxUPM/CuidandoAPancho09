package org.pancho.model;

import org.pancho.model.enums.LanguageEnum;
import org.pancho.model.enums.ProviderType;

import java.util.ArrayList;

public interface IUser {
    String getId();
    String getEmail();
    ProviderType getOauthProvider();
    String getOauthId();
    String getName();
    String getAddress();
    LanguageEnum getLanguage();
    String getPhoto();
    String getDescription();
    Double getRate();
    Double getMaxDistance();
    String getIBAN();
    String getAccreditingDocument();
}
