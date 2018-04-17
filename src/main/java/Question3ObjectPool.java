import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Question3ObjectPool <T> {
    private ConcurrentLinkedQueue<T> pool;
    private ConcurrentHashMap<T, Integer> borrowedObjects;
    private int poolSize ;
    private Class<T> clazz;
    public static String NO_OBJECT_AVAILABLE = "NO OBJECT AVAILABLE FOR LENDING. PLS TRY LATER ";


    // should be abstract but for the interview, just simple
    public T createObject() {
        try {
            return this.clazz.newInstance();
        } catch (Exception e) {
            return null;
        }

    }
    private boolean validateObject(T t) {
       // should have some criteria, but for now, always true
        if (t != null) return true;
        return false;

    };

    public Question3ObjectPool(int poolSize, Class<T> clazz){
        this.poolSize = poolSize;
        this.clazz = clazz;
        this.pool = new ConcurrentLinkedQueue<T>();
        this.borrowedObjects = new ConcurrentHashMap<T, Integer>();
    }

    public synchronized T borrowObject() throws Exception{
        if (borrowedObjects.size() >= poolSize ) {
            throw new Exception (NO_OBJECT_AVAILABLE);
        }
        T object;
        do {
            object = pool.poll();
            // valid object
            if (validateObject(object)) {
               borrowedObjects.put(object,1) ;
               return object;
            } else {
                // invalid object, ignore
                object = null;
            }
        } while (object != null);

        // if there is no available object in pool -> create new
        object = createObject();
        borrowedObjects.put(object, 1);
        return object;
    }

    public synchronized  void returnObject (T object) {
        this.pool.offer(object);
        this.borrowedObjects.remove(object);
    }
}
