// Test case for issue #58: https://tinyurl.com/cfissue/58

import org.checkerframework.checker.regex.qual.Regex;

class StringBuilderToStringPolyRegex {

    void createPattern(final @Regex(1) StringBuilder regex) {
        @Regex(1) String s = regex.toString();
    }
}
