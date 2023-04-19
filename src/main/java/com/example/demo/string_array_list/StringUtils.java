package com.example.demo.string_array_list;

import java.text.Normalizer;
import java.util.regex.Pattern;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public class StringUtils {

    private static final Pattern STRIP_ACCENTS_PATTERN = Pattern.compile("\\p{InCombiningDiacriticalMarks}+"); //$NON-NLS-1$

    static final String uniChars = "àáảãạâầấẩẫậăằắẳẵặèéẻẽẹêềếểễệđ" + "ìíỉĩịòóỏõọôồốổỗộơờớởỡợùúủũụưừứửữựỳýỷỹỵÀÁẢÃẠÂẦẤẨẪẬĂẰẮẲ"
            + "ẴẶÈÉẺẼẸÊỀẾỂỄỆĐÌÍỈĨỊÒÓỎÕỌÔỒỐỔỖỘƠỜỚỞỠỢÙÚỦŨỤƯỪỨỬỮỰỲÝỶỸỴÂĂĐÔƠƯ";
    static final String noneChars = "aaaaaaaaaaaaaaaaaeeeeeeeeeeediiiiio" + "oooooooooooooooouuuuuuuuuuuyyyyyAAAAAAAAAAAAAA"
            + "AAAEEEEEEEEEEEDIIIIIOOOOOOOOOOOOOOOOOUUUUUUUUUUUYYYYYAADOOU";

    public static String stripAccents(final String input) {
        if (input == null) {
            return null;
        }
        final StringBuilder decomposed = new StringBuilder(Normalizer.normalize(input, Normalizer.Form.NFD));
        convertRemainingAccentCharacters(decomposed);
        // Note that this doesn't correctly remove ligatures...
        return STRIP_ACCENTS_PATTERN.matcher(decomposed).replaceAll(EMPTY);
    }

    private static void convertRemainingAccentCharacters(final StringBuilder decomposed) {
        for (int i = 0; i < decomposed.length(); i++) {
            if (decomposed.charAt(i) == '\u0141') {
                decomposed.deleteCharAt(i);
                decomposed.insert(i, 'L');
            } else if (decomposed.charAt(i) == '\u0142') {
                decomposed.deleteCharAt(i);
                decomposed.insert(i, 'l');
            }
        }
    }

    public static String unicode2ASII(String s) {
        StringBuilder ret = new StringBuilder();
        int pos;
        for (int i = 0; i < s.length(); i++) {
            pos = uniChars.indexOf(s.charAt(i));
            if (pos >= 0) {
                ret.append(noneChars.charAt(pos));
            } else {
                ret.append(s.charAt(i));
            }
        }
        return ret.toString();
    }

}
