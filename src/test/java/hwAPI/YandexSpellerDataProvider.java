package hwAPI;

import hwAPI.entity.data.ErrorDescription;
import hwAPI.entity.data.InputTextData;
import hwAPI.enums.ErrorCode;
import hwAPI.enums.Lang;
import hwAPI.enums.Options;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;

public class YandexSpellerDataProvider {

    @DataProvider
    public Object[][] syntaxErrorCase() {
        return new Object[][]{
                {InputTextData.builder()
                        .text("ашыбка")  //wordWithSyntaxError
                        .lang(Lang.RU)
                        .errors(new ArrayList<ErrorDescription>() {{
                            add(ErrorDescription.builder()
                                    .code(ErrorCode.ERROR_UNKNOWN_WORD)
                                    .expectedMistakes("ашыбка")
                                    .suggestedWord("ошибка")
                                    .build());
                        }})
                        .build()
                },
                {InputTextData.builder()
                        .text("Жил был у бабушки серенький козлек") //sentenceWithSyntaxError
                        .lang(Lang.RU)
                        .errors(new ArrayList<ErrorDescription>() {{
                            add(ErrorDescription.builder()
                                    .code(ErrorCode.ERROR_UNKNOWN_WORD)
                                    .expectedMistakes("козлек")
                                    .suggestedWord("козлик")
                                    .build());
                        }})
                        .build()
                },
                {InputTextData.builder()
                        .text("Suint-Potersburg")  //ProperNameInEnglish
                        .lang(Lang.EN)
                        .errors(new ArrayList<ErrorDescription>() {{
                            add(ErrorDescription.builder()
                                    .code(ErrorCode.ERROR_UNKNOWN_WORD)
                                    .expectedMistakes("Suint-Potersburg")
                                    .suggestedWord("Saint-Petersburg")
                                    .build());
                        }})
                        .build()
                },
                {InputTextData.builder()
                        .text("Зеноида Петровна")
                        .lang(Lang.RU)
                        .errors(new ArrayList<ErrorDescription>() {{
                            add(ErrorDescription.builder()
                                    .code(ErrorCode.ERROR_UNKNOWN_WORD)
                                    .expectedMistakes("Зеноида")
                                    .suggestedWord("Зинаида")
                                    .build());
                        }})
                        .build()
                },
                {InputTextData.builder()
                        .text("cacumber")
                        .lang(Lang.EN)
                        .errors(new ArrayList<ErrorDescription>() {{
                            add(ErrorDescription.builder()
                                    .code(ErrorCode.ERROR_UNKNOWN_WORD)
                                    .expectedMistakes("cacumber")
                                    .suggestedWord("cucumber")
                                    .build());
                        }})
                        .build()
                }
        };
    }

    @DataProvider
    public Object[][] repeatedWordErrorCase() {
        return new Object[][]{
                {InputTextData.builder()
                        .text("бора бора")
                        .lang(Lang.RU)
                        .options(Options.FIND_REPEAT_WORDS)
                        .errors(new ArrayList<ErrorDescription>() {{
                            add(ErrorDescription.builder()
                                    .code(ErrorCode.ERROR_REPEAT_WORD)
                                    .expectedMistakes("бора")
                                    .build());
                        }})
                        .build()
                },
                {InputTextData.builder()
                        .text("дед дед")
                        .lang(Lang.RU)
                        .options(Options.FIND_REPEAT_WORDS)
                        .errors(new ArrayList<ErrorDescription>() {{
                            add(ErrorDescription.builder()
                                    .code(ErrorCode.ERROR_REPEAT_WORD)
                                    .expectedMistakes("дед")
                                    .build());
                        }})
                        .build()
                },
                {InputTextData.builder()
                        .text("группа на на")
                        .lang(Lang.RU)
                        .options(Options.FIND_REPEAT_WORDS)
                        .errors(new ArrayList<ErrorDescription>() {{
                            add(ErrorDescription.builder()
                                    .code(ErrorCode.ERROR_REPEAT_WORD)
                                    .expectedMistakes("на")
                                    .build());
                        }})
                        .build()
                }
        };
    }

    @DataProvider
    public Object[][] capitalizationErrorCase() {
        return new Object[][]{
                {InputTextData.builder()
                        .text("СОбАКА")
                        .lang(Lang.RU)
                        .errors(new ArrayList<ErrorDescription>() {{
                            add(ErrorDescription.builder()
                                    .code(ErrorCode.ERROR_CAPITALIZATION)
                                    .expectedMistakes("СОбАКА")
                                    .suggestedWord("Собака")
                                    .build());
                        }})
                        .build()
                },
                {InputTextData.builder()
                        .text("КрЕвЕтКа")
                        .lang(Lang.RU)
                        .errors(new ArrayList<ErrorDescription>() {{
                            add(ErrorDescription.builder()
                                    .code(ErrorCode.ERROR_CAPITALIZATION)
                                    .expectedMistakes("КрЕвЕтКа")
                                    .suggestedWord("Креветка")
                                    .build());
                        }})
                        .build()
                },
                {InputTextData.builder()
                        .text("СамарА")
                        .lang(Lang.RU)
                        .errors(new ArrayList<ErrorDescription>() {{
                            add(ErrorDescription.builder()
                                    .code(ErrorCode.ERROR_CAPITALIZATION)
                                    .expectedMistakes("СамарА")
                                    .suggestedWord("Самара")
                                    .build());
                        }})
                        .build()
                }
        };
    }

    @DataProvider
    public Object[][] noErrorsCase() {
        return new Object[][]{
                {InputTextData.builder()
                        .text("текст из четырех слов")
                        .build()
                },
                {InputTextData.builder()
                        .text("корова")
                        .build()
                },
                {InputTextData.builder()
                        .text("Saint-Petersburg")
                        .build()
                }
        };
    }

    @DataProvider
    public Object[][] syntaxErrorInTextsCase() {
        return new Object[][]{
                {Lang.RU, Options.DEFAULT,
                        new ArrayList<InputTextData>() {
                            {
                                add(InputTextData.builder()
                                        .text("ашыбка")
                                        .errors(new ArrayList<ErrorDescription>() {{
                                            add(ErrorDescription.builder()
                                                    .code(ErrorCode.ERROR_UNKNOWN_WORD)
                                                    .expectedMistakes("ашыбка")
                                                    .suggestedWord("ошибка")
                                                    .build());
                                        }})
                                        .build());
                                add(InputTextData.builder()
                                        .text("Жил был у бабушки серенький козлек") //sentenceWithSyntaxError
                                        .errors(new ArrayList<ErrorDescription>() {{
                                            add(ErrorDescription.builder()
                                                    .code(ErrorCode.ERROR_UNKNOWN_WORD)
                                                    .expectedMistakes("козлек")
                                                    .suggestedWord("козлик")
                                                    .build());
                                        }})
                                        .build());
                                add(InputTextData.builder()
                                        .text("Suint-Potersburg")  //ProperNameInEnglish
                                        .errors(new ArrayList<ErrorDescription>() {{
                                            add(ErrorDescription.builder()
                                                    .code(ErrorCode.ERROR_UNKNOWN_WORD)
                                                    .expectedMistakes("Suint-Potersburg")
                                                    .suggestedWord("Saint-Petersburg")
                                                    .build());
                                        }})
                                        .build());
                                add(InputTextData.builder()
                                        .text("Зеноида Петровна")
                                        .errors(new ArrayList<ErrorDescription>() {{
                                            add(ErrorDescription.builder()
                                                    .code(ErrorCode.ERROR_UNKNOWN_WORD)
                                                    .expectedMistakes("Зеноида")
                                                    .suggestedWord("Зинаида")
                                                    .build());
                                        }})
                                        .build());
                                add(InputTextData.builder()
                                        .text("cacumber")
                                        .lang(Lang.EN)
                                        .errors(new ArrayList<ErrorDescription>() {{
                                            add(ErrorDescription.builder()
                                                    .code(ErrorCode.ERROR_UNKNOWN_WORD)
                                                    .expectedMistakes("cacumber")
                                                    .suggestedWord("cucumber")
                                                    .build());
                                        }})
                                        .build());
                            }
                        }
                }
        };
    }

    @DataProvider
    public Object[][] repeatedWordErrorInTextsCase() {
        return new Object[][]{
                {Lang.RU, Options.FIND_REPEAT_WORDS,
                        new ArrayList<InputTextData>() {
                            {
                                add(InputTextData.builder()
                                        .text("бора бора")
                                        .errors(new ArrayList<ErrorDescription>() {{
                                            add(ErrorDescription.builder()
                                                    .code(ErrorCode.ERROR_REPEAT_WORD)
                                                    .expectedMistakes("бора")
                                                    .build());
                                        }})
                                        .build());
                                add(InputTextData.builder()
                                        .text("дед дед")
                                        .errors(new ArrayList<ErrorDescription>() {{
                                            add(ErrorDescription.builder()
                                                    .code(ErrorCode.ERROR_REPEAT_WORD)
                                                    .expectedMistakes("дед")
                                                    .build());
                                        }})
                                        .build());
                                add(InputTextData.builder()
                                        .text("группа на на")
                                        .errors(new ArrayList<ErrorDescription>() {{
                                            add(ErrorDescription.builder()
                                                    .code(ErrorCode.ERROR_REPEAT_WORD)
                                                    .expectedMistakes("на")
                                                    .build());
                                        }})
                                        .build());
                            }
                        }
                }
        };
    }

    @DataProvider
    public Object[][] capitalizationErrorInTextsCase() {
        return new Object[][]{
                {Lang.RU, Options.DEFAULT,
                        new ArrayList<InputTextData>() {{
                            add(InputTextData.builder()
                                    .text("СОбАКА")
                                    .errors(new ArrayList<ErrorDescription>() {{
                                        add(ErrorDescription.builder()
                                                .code(ErrorCode.ERROR_CAPITALIZATION)
                                                .expectedMistakes("СОбАКА")
                                                .suggestedWord("Собака")
                                                .build());
                                    }})
                                    .build());
                            add(InputTextData.builder()
                                    .text("КрЕвЕтКа")
                                    .errors(new ArrayList<ErrorDescription>() {{
                                        add(ErrorDescription.builder()
                                                .code(ErrorCode.ERROR_CAPITALIZATION)
                                                .expectedMistakes("КрЕвЕтКа")
                                                .suggestedWord("Креветка")
                                                .build());
                                    }})
                                    .build());
                            add(InputTextData.builder()
                                    .text("СамарА")
                                    .errors(new ArrayList<ErrorDescription>() {{
                                        add(ErrorDescription.builder()
                                                .code(ErrorCode.ERROR_CAPITALIZATION)
                                                .expectedMistakes("СамарА")
                                                .suggestedWord("Самара")
                                                .build());
                                    }})
                                    .build());
                        }}
                }
        };
    }

    @DataProvider
    public Object[][] noErrorsInTextsCase() {
        return new Object[][]{
                {Lang.RU, Options.DEFAULT,
                        new ArrayList<InputTextData>() {{
                            add(InputTextData.builder()
                                    .text("текст из четырех слов")
                                    .build());
                            add(InputTextData.builder()
                                    .text("корова")
                                    .build());
                            add(InputTextData.builder()
                                    .text("Saint-Petersburg")
                                    .build());
                        }}
                }
        };
    }
}