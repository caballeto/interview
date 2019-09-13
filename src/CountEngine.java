import java.util.*;

public class CountEngine {
  static String[][] wordCountEngine(String document) {
      if (document == null || document.length() == 0) return null;
      HashMap<String, Integer> map = new LinkedHashMap<>();
      String[] words = document.toLowerCase().replaceAll("[^a-z ]", "").split(" ");

      for (String s : words) {
        if (s.length() < 1) continue;
        if(map.containsKey(s))  {
          map.put(s, map.get(s) + 1);
        } else {
          map.put(s, 1);
        }
      }

      List<String[]> list = new ArrayList<>();
      for (Map.Entry<String, Integer> entry : map.entrySet()) {
        list.add(new String[]{ entry.getKey(), "" + entry.getValue() });
      }

      String[][] counts = list.toArray(new String[0][0]);
      Arrays.sort(counts, (a, b) -> Integer.parseInt(b[1]) - Integer.parseInt(a[1]));
      return counts;
  }

/*
  static String[][] wordCountEngine(String doc) {
    String[] allWords = doc.toLowerCase().split("[^a-zA-Z']+");
    LinkedHashMap<String, Integer> counter = new LinkedHashMap<>();

    Arrays.stream(allWords).forEach(w -> {
      counter.compute(w, (key, value) -> value == null ? 1 : value + 1);
    });
    System.out.println(counter);


    TreeMap<Integer, HashSet<String>> sortedMap = new TreeMap<>(Collections.reverseOrder());
    Arrays.stream(allWords).forEach(w -> {
      int i = counter.get(w);
      if (sortedMap.containsKey(i)) {
        HashSet<String> set = sortedMap.get(i);
        set.add(w);
        sortedMap.put(i, set);
      } else {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add(w);
        sortedMap.put(i, hashSet);
      }

    });

    System.out.println(sortedMap);
    String[][] result=new String[counter.size()][2];
    int iterator=0;
    for(Map.Entry<Integer,HashSet<String>> entry:sortedMap.entrySet()){
      int count=entry.getKey();

      for(Map.Entry<String,Integer> e:counter.entrySet()){
        if(e.getValue()==count){
          String[] res=new String[2];
          res[0]=e.getKey();
          res[1]=String.valueOf(count);
          result[iterator]=res;
          iterator++;
        }

      }
    }

    return result;
  }
*/
  public static void main(String[] args) {
    String[][] strings = wordCountEngine("docs I'll make it very happy and easy to use, so get I it very nice nice nice!");
    for (String[] x : strings) {
      System.out.println(Arrays.toString(x));
    }
  }
}
