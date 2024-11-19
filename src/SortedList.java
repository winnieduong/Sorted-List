import java.util.ArrayList;

public class SortedList {
    private ArrayList<String> list;

    public SortedList() {
        list = new ArrayList<>();
    }

    public void add(String element) {
        int index = binarySearchInsertPosition(element);
        list.add(index, element);
    }

    public String search(String element) {
        int index = binarySearch(element);
        if (index >= 0) {
            return "Element found at index: " + index;
        } else {
            return "Element not found. Closest position: " + (-index - 1);
        }
    }

    public ArrayList<String> getList() {
        return list;
    }

    private int binarySearchInsertPosition(String element) {
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).compareTo(element) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private int binarySearch(String element) {
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = list.get(mid).compareTo(element);
            if (comparison == 0) {
                return mid;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -(left + 1);
    }
}
