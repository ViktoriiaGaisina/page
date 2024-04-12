package com.eazybytes.page.commentmat;
import org.apache.lucene.analysis.en.EnglishAnalyzer;
import org.tartarus.snowball.ext.EnglishStemmer;

public class CommentCensor {
    public static final String[] badWords = {"mazafaka", "bicth"};
    private static final String mask = "****";
    private static EnglishStemmer stemmer = new EnglishStemmer();
    public static String censorComment(String comment) {
        for (String badWord: badWords) {
            if (comment.contains(badWord)) {
                comment = comment.replaceAll(badWord, mask);
            }
        }
        return comment;
    }
}