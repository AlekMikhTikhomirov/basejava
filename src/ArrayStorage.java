import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    public int numberOfResume = 0;

    public int size() {
        return numberOfResume;
    }

    void clear() {
        Arrays.fill(storage, 0, numberOfResume, null);
    }

    public void save(Resume r) {
        storage[numberOfResume] = r;
        System.out.println("Resume was saved in storage with index " + (numberOfResume));
        numberOfResume++;
    }

    Resume get(String uuid) {
        int index = 0;
        for (int i = 0; i <= numberOfResume - 1; i++) {
            if (storage[i].equals(uuid)) {
                System.out.println("This resume found in storage at index " + i);
                index = i;
            } else {
                System.out.println("Resume with this uuid is not found");
            }
        }
        return storage[index];
    }

    void delete(String uuid) {
        int index = 0;
        for (int i = 0; i <= numberOfResume - 1; i++) {
            if (storage[i].equals(uuid)) {
                storage[i] = null;
                System.out.println("Resume with this uuid was deleted from storage");
                index = i;
                break;
            } else {
                System.out.println("Resume with this uuid is not found");
            }
        }
        while (index < numberOfResume) {
            storage[index] = storage[index + 1];
            index++;
        }
        numberOfResume--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, numberOfResume);
    }
}