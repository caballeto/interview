package interviewbit.Maps;

import java.util.LinkedHashMap;

public class _lru_cache {
  LinkedHashMap<Integer, Integer> map;
  int size = 0;

  _lru_cache(int capacity) {
    map = new LinkedHashMap<>(capacity);
  }

  int get(int key) {
    return map.get(key);
  }

  void put(int key, int value) {
    if (size < map.size()) {

    } else {

    }
  }
}
