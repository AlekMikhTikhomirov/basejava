import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    public int indexOfResume = 0;

    public int size() {
        int sizeOfArray = 0;
        while(storage[indexOfResume] != null) {
            sizeOfArray++;
        }
        return sizeOfArray;
    }

    void clear() {
        Arrays.fill(storage, null);
    }

    public void save(Resume r) {
        while(indexOfResume < 10000) {
            if(storage[indexOfResume] == null) {
                storage[indexOfResume] = r;
                System.out.println("Resume was saved in storage with index " + indexOfResume);
                break;
            } else {
                indexOfResume++;
            }
            }
    }

    String get(String uuid) {
        for(int i = 0; i < 10000; i++) {
            if(storage[i].equals(uuid)) {
                System.out.println(storage[i].toString());
                indexOfResume = i;
                break;
            } else {
                System.out.println("Resume with this uuid is not found");
            }
        }
        return storage[indexOfResume].toString();
    }

    void delete(String uuid) {
        for(indexOfResume = 0; indexOfResume < 10000; indexOfResume++) {
            if(storage[indexOfResume].equals(uuid)) {
                storage[indexOfResume] = null;
                System.out.println("Resume with this uuid was deleted from storage");
            } else {
                System.out.println("Resume with this uuid is not found");
            }
        }
        while(storage[indexOfResume + 1] != null) {
            storage[indexOfResume] = storage[indexOfResume + 1];
            indexOfResume++;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int newArraySize = 0;
        while(storage[indexOfResume] != null) {
            newArraySize++;
        }
        Resume[] fullStorage = Arrays.copyOf(storage, newArraySize);
        return fullStorage;
    }
}
