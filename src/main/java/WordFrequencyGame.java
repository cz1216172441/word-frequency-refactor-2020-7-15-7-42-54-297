import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class WordFrequencyGame {

    public String wordStatistic(String sentence) {
        String[] words = sentence.split("\\s+");
        try {
            Map<String, Integer> wordMap = getWordFrequencyMap(words);

            List<Input> list = sortWordsFrequencyDesc(wordMap);

            return formatWordsFrequency(list);
        } catch (Exception e) {
            return "Calculate Error";
        }

    }

    private String formatWordsFrequency(List<Input> list) {
        return list.stream()
                .map(input -> String.format("%s %d", input.getValue(), input.getWordCount()))
                .collect(Collectors.joining("\n"));
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
