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
        for (int i = 0; i < numberOfResume; i++) {
            if (storage[i].equals(uuid)) {
                System.out.println("This resume found in storage at index " + i);
                return storage[i];
            } else {
                System.out.println("Resume with this uuid is not found");
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < numberOfResume; i++) {
            if (storage[i].equals(uuid)) {
                for (int j = i; j < numberOfResume - 1; j++) {
                    storage[j] = storage[j + 1];
                    j++;
                }
                System.out.println("Resume with this uuid was deleted from storage");
                numberOfResume--;
                break;
            } else {
                System.out.println("Resume with this uuid is not found");
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, numberOfResume);
    }
}