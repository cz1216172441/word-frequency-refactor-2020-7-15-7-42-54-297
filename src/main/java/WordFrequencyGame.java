import java.util.*;

public class WordFrequencyGame {

    public String wordStatistic(String sentence) {
        String[] words = sentence.split("\\s+");
        try {
            Map<String, Integer> wordMap = getWordFrequencyMap(words);

            List<Input> list = sortWordsFrequencyDesc(wordMap);

            StringJoiner joiner = new StringJoiner("\n");
            for (Input w : list) {
                String s = w.getValue() + " " + w.getWordCount();
                joiner.add(s);
            }
            return joiner.toString();
        } catch (Exception e) {
            return "Calculate Error";
        }

    }

    private List<Input> sortWordsFrequencyDesc(Map<String, Integer> wordMap) {
        List<Input> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            Input input = new Input(entry.getKey(), entry.getValue());
            list.add(input);
        }

        list.sort((w1, w2) -> w2.getWordCount() - w1.getWordCount());
        return list;
    }

    private Map<String, Integer> getWordFrequencyMap(String[] words) {
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            if (!wordMap.containsKey(word)) {
                wordMap.put(word, 1);
            } else {
                wordMap.put(word, wordMap.get(word) + 1);
            }
        }
        return wordMap;
    }

}
