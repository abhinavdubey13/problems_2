package ZZ_tests;
import java.util.*;



/**
 * 
 * implement an N-level cache
 * 
 * 
 * each level has different number of slots , for example
 * 1st level has 4 slots
 * 2nd level has 3 slots
 * 3rd level has 5 slots
 * 4th level has 10 slots ...
 * 
 * 
 * core functionality expected from cache => getFromCache , setToCache , printCache
 * 
 * for simplicity assume key value pairs to be string
 * 
 * 
 * ==============
 * getFromCache
 * ==============
 * =>if found in cache , return the cached value , also set the k-v pair to the 1st level 
 * =>need to search all levels of cache
 * 
 * 
 * 
 * 
 * =============
 * setToCache
 * =============
 * =>this operation fails of all levels are full , else it succeeds
 * =>this operation sets to the 1st level of cache always
 * =>if 1st level is fully occupied , use eviction policy to evict an element & move it to the next level
 * =>if the next level is also full , evict an element from this level & move it the a level further , do this untill an empty slot is found
 * 
 *  
 * 
 * 
 * 
 *  
 * 
 * ==============
 * printCache
 * ==============
 * =>prints all levels of cache , with values present 
 * 
 * 
 * 
 * 
 * ================
 * eviction policy
 * ================
 * => evict any random k-v pair 
 * => generalize for various Strategies like LRU , LFU , FIFO
 * 
 * 
 * 
 * 
 */

class N_level_cache {
    public static void main(String[] args) {
        N_level_cache_soln myCache = new N_level_cache_soln(3 , 2 , "LRU");

        myCache.setKey("1","1");
        myCache.printCache();

        myCache.setKey("2","2");
        myCache.printCache();


        myCache.setKey("3","3");
        myCache.printCache();

        myCache.setKey("4","4");
        myCache.printCache();

        myCache.setKey("5","5");
        myCache.printCache();

        myCache.setKey("6","6");
        myCache.printCache();

        System.out.println("fetch key=1 ==>" + myCache.getKey("1"));
        myCache.printCache();


        System.out.println("fetch key=7 ==>" + myCache.getKey("7"));
        myCache.printCache();

        myCache.setKey("9","9");
        myCache.printCache();
        System.out.println("fetch key=9 ==>" + myCache.getKey("9"));
        myCache.printCache();

    }
}



class N_level_cache_soln {

    int levels;
    int levelSize;
    List<Map<String , String>> cache ;
    String evictionPolicy ; //this is not used , we are evicting 1st element


    /**
     *
     * @param levels : levels of cache
     * @param levelSize : size/slots in each level , for simiplicity all levels have same number of slots
     * @param evictionPolicy : can be "LRU" , "LFU" etc , but not used in logic for now
     */
    N_level_cache_soln(int levels , int levelSize , String evictionPolicy){
        this.levels = levels;
        this.levelSize = levelSize;
        this.evictionPolicy = evictionPolicy;
        this.cache = new ArrayList<>();
        for(int i = 0 ; i<levels ; i++){
            cache.add(new HashMap<>());
        }
    }


    /**
     *
     * @param key : the key to search for
     * @return cached value if found , else null
     */
    public String getKey(String key){
        try{
            for(int i = 0 ; i < levels ; i++){
                String value = cache.get(i).get(key);

                //if value found in cache
                if(value != null){

                    //write this value to 1st level , if found in non-1st level
                    if(i!=0) {
                        this.setToLevel(key , value , 0);
                    }
                    return value;
                }
            }

            //value not found in any level of cache
            return null;
        }catch(Exception e){
            return null;
        }
    }


    /**
     *
     * @param key K-v pair
     * @param val k-v pair
     * @return true if key was successfully set in cache , else false
     */
    public synchronized boolean setKey(String key , String val){

        try{
            //check if cache is full
            boolean isFull = cache.get(this.levels-1).size() == this.levelSize;
            if(isFull){
                return false;
            }

            //check if 1st level already has this value
            this.setToLevel(key , val , 0);
            return true;
        }catch(Exception e){
            return false;
        }
    }


    /**
     *
     * @param key
     * @param value
     *
     * util method
     */
    private synchronized void setToLevel(String key , String value , int currLevel){



        if(currLevel >= this.levels){
            return;
        }
        boolean currLevelHasEmptySlot = this.cache.get(currLevel).size() < this.levelSize;

        if(currLevelHasEmptySlot){
            this.cache.get(currLevel).put(key,value);
        }else{

            Map.Entry<String,String> entry = cache.get(currLevel).entrySet().iterator().next();
            String removedKey = entry.getKey();
            String removedValue = entry.getValue();

            cache.get(currLevel).remove(removedKey);
            cache.get(currLevel).put(key,value);

            this.setToLevel(removedKey,removedValue,currLevel+1);

        }


    }








    public synchronized void printCache(){
        for(int i = 0 ; i < levels ; i++){
            if(cache.get(i).size() > 0) {
                System.out.println("========= level-" + i + " ===========");
                for (Map.Entry<String, String> entry : cache.get(i).entrySet()) {
                    System.out.println(entry.getKey() + " -> " + entry.getValue());
                }
                System.out.println();
            }
        }
        System.out.println();
    }


}