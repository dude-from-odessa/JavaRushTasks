package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Кроссворд
*/

public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword, "home", "same");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {

        List<Word> detectedWords = new ArrayList<>();

        for(String word : words) {

            char[] wordChars = word.toCharArray();

            for (int y = 0; y < crossword.length; y++) {
                for (int x = 0; x < crossword[y].length; x++) {
                    if (wordChars[0] == crossword[y][x]) {

                        // вправо

                        int counter = 1;

                        for (int num = x + 1; num < crossword[y].length; num++) {
                            if (wordChars[counter] != crossword[y][num]) {
                                counter = 1;
                                break;
                            } else if (counter == word.length() - 1) {
                                Word wordObject = new Word(word);
                                wordObject.setStartPoint(x, y);
                                wordObject.setEndPoint(num, y);
                                detectedWords.add(wordObject);
                                counter = 1;
                                break;
                            }
                            counter++;
                        }

                        // влево

                        for (int num = x - 1; num >= 0; num--) {
                            if (wordChars[counter] != crossword[y][num]) {
                                counter = 1;
                                break;
                            } else if (counter == word.length() - 1) {
                                Word wordObject = new Word(word);
                                wordObject.setStartPoint(x, y);
                                wordObject.setEndPoint(num, y);
                                detectedWords.add(wordObject);
                                counter = 1;
                                break;
                            }
                            counter++;
                        }

                        // вниз

                        for (int num = y + 1; num < crossword.length; num++) {
                            if (wordChars[counter] != crossword[num][x]) {
                                counter = 1;
                                break;
                            } else if (counter == word.length() - 1) {
                                Word wordObject = new Word(word);
                                wordObject.setStartPoint(x, y);
                                wordObject.setEndPoint(x, num);
                                detectedWords.add(wordObject);
                                counter = 1;
                                break;
                            }
                            counter++;
                        }

                        // вверх

                        for (int num = y - 1; num >= 0; num--) {
                            if (wordChars[counter] != crossword[num][x]) {
                                counter = 1;
                                break;
                            } else if (counter == word.length() - 1) {
                                Word wordObject = new Word(word);
                                wordObject.setStartPoint(x, y);
                                wordObject.setEndPoint(x, num);
                                detectedWords.add(wordObject);
                                counter = 1;
                                break;
                            }
                            counter++;
                        }

                        // диагональ вверх влево

                        int diagonal = x - 1;

                        for (int num = y - 1; num >= 0 && diagonal >= 0; num--, diagonal--) {
                            if (wordChars[counter] != crossword[num][diagonal]) {
                                counter = 1;
                                break;
                            } else if (counter == word.length() - 1) {
                                Word wordObject = new Word(word);
                                wordObject.setStartPoint(x, y);
                                wordObject.setEndPoint(diagonal, num);
                                detectedWords.add(wordObject);
                                counter = 1;
                                break;
                            }
                            counter++;
                        }

                        // диагональ вверх вправо

                        diagonal = x + 1;

                        for (int num = y - 1; num >= 0 && diagonal < crossword[y].length; num--, diagonal++) {
                            if (wordChars[counter] != crossword[num][diagonal]) {
                                counter = 1;
                                break;
                            } else if (counter == word.length() - 1) {
                                Word wordObject = new Word(word);
                                wordObject.setStartPoint(x, y);
                                wordObject.setEndPoint(diagonal, num);
                                detectedWords.add(wordObject);
                                counter = 1;
                                break;
                            }
                            counter++;
                        }

                        // диагональ вниз вправо

                        diagonal = x + 1;

                        for (int num = y + 1; num < crossword.length && diagonal < crossword[y].length; num++, diagonal++) {
                            if (wordChars[counter] != crossword[num][diagonal]) {
                                counter = 1;
                                break;
                            } else if (counter == word.length() - 1) {
                                Word wordObject = new Word(word);
                                wordObject.setStartPoint(x, y);
                                wordObject.setEndPoint(diagonal, num);
                                detectedWords.add(wordObject);
                                counter = 1;
                                break;
                            }
                            counter++;
                        }

                        // диагональ вниз влево

                        diagonal = x - 1;

                        for (int num = y + 1; num < crossword.length && diagonal >= 0; num++, diagonal--) {
                            if (wordChars[counter] != crossword[num][diagonal]) {
                                counter = 1;
                                break;
                            } else if (counter == word.length() - 1) {
                                Word wordObject = new Word(word);
                                wordObject.setStartPoint(x, y);
                                wordObject.setEndPoint(diagonal, num);
                                detectedWords.add(wordObject);
                                counter = 1;
                                break;
                            }
                            counter++;
                        }
                    }
                }
            }
        }
        return detectedWords;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
