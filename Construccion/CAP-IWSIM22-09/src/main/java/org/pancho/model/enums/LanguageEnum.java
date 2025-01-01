package org.pancho.model.enums;

public enum LanguageEnum {
    SPANISH(new String[]{"es", "spanish", "SPANISH", "ES"}),
    ENGLISH(new String[]{"en", "english", "ENGLISH", "EN"}),
    CATALAN(new String[]{"ca", "catalan", "CATALAN", "CA"}),
    VALENCIAN(new String[]{"va", "valencian", "VALENCIAN", "VA"}),
    BASQUE(new String[]{"eu", "basque", "BASQUE", "EU"}),
    GALICIAN(new String[]{"gl", "galician", "GALICIAN", "GL"});

    private final String[] languages;

    LanguageEnum(String[] languages) {
        this.languages = languages;
    }

    public static LanguageEnum fromValue(String value) {
        for (LanguageEnum languageEnum : LanguageEnum.values()) {
            for (String language : languageEnum.getLanguages()) {
                if (language.equalsIgnoreCase(value)) {
                    return languageEnum;
                }
            }
        }
        return null;
    }

    public String[] getLanguages() {
        return languages;
    }
}