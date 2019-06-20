package cracking_coding_interview.Moderate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _16_2_freqs {
  private Map<String, Integer> freq = new HashMap<>();

  public _16_2_freqs(String source) {
    String[] words = source.split("[,. ]");
    System.out.println(Arrays.toString(words));
    for (String word : words) {
      if (word == null || word.isEmpty()) continue;
      if (freq.containsKey(word)) {
        freq.put(word, freq.get(word) + 1);
      } else {
        freq.put(word, 1);
      }
    }
  }

  public int frequency(String word) {
    if (!freq.containsKey(word)) return -1;
    return freq.get(word);
  }

  public static void main(String[] args) {
    String source = "it is my sample text, over here, right text.";
    var freqs = new _16_2_freqs(source);
    System.out.println(freqs.frequency("text"));
    System.out.println(freqs.frequency("it"));
    System.out.println(freqs.frequency("qwe"));
  }
}
