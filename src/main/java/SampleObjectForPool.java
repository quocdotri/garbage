public class SampleObjectForPool {

    // very costly for object creation
    public SampleObjectForPool () {
        System.out.println("start Initiating object. thread =  " + Thread.currentThread());
        for (int i = 0; i <= 1000000000; i++ ) {
            int j =i ;
            j++;
        }
        System.out.println("finish Initiating object. thread =  " + Thread.currentThread());
    }


    public void processTask() {
       System.out.println("processing Task. Thread = " + Thread.currentThread());
       try {
           Thread.sleep(5000);
       } catch(Exception e) {
          // do nothing
       }
    }
}
