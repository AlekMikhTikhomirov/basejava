import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    public int indexOfResume = 0;

    public int sizeOfArray = 0;

    public int size() {
        while (storage[indexOfResume] != null) {
            sizeOfArray++;
        }
        return sizeOfArray;
    }

    void clear() {
        Arrays.fill(storage, 0, sizeOfArray - 1, null);
    }

    public void save(Resume r) {
        storage[sizeOfArray] = r;
        System.out.println("Resume was saved in storage with index " + (sizeOfArray - 1));
        sizeOfArray++;
    }

    String get(String uuid) {
        for (int i = 0; i < sizeOfArray; i++) {
            if (storage[i].equals(uuid)) {
                System.out.println("This resume found in storage");
                indexOfResume = i;
            } else {
                System.out.println("Resume with this uuid is not found");
            }
        }
        return String.valueOf(storage[indexOfResume]);
    }

    void delete(String uuid) {
        for (int i = 0; i < sizeOfArray; i++) {
            if (storage[i].equals(uuid)) {
                storage[i] = null;
                indexOfResume = i;
                System.out.println("Resume with this uuid was deleted from storage");
                break;
            } else {
                System.out.println("Resume with this uuid is not found");
            }
        }
        while ((indexOfResume + 1) < sizeOfArray) {
            storage[indexOfResume] = storage[indexOfResume + 1];
            indexOfResume++;
        }
        sizeOfArray--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] fullStorage = Arrays.copyOf(storage, sizeOfArray);
        return fullStorage;
    }
}