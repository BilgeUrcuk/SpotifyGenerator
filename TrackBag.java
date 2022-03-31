import java.util.Arrays;

public class TrackBag<ItemType> implements BagInterface<ItemType>{
    private static final int DEFAULT_CAPACITY = 100;
    private Object[] genre_array ;
    private int numberOfEntries ;
    private int myCapacity ;

    public TrackBag() {this(DEFAULT_CAPACITY);}

    public TrackBag(int capacity){
        myCapacity = capacity;
        numberOfEntries = 0 ;
        genre_array = new Object[capacity];
    }

    public Object[] getGenreArray() {return genre_array;}

    @SuppressWarnings("unchecked")
    public ItemType get(int index ){
        return (ItemType) genre_array[index];
    }


    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }

    @Override
    public boolean add(ItemType newEntry) {
        if (isFull()){
            resize(2*myCapacity);
            genre_array[numberOfEntries] = newEntry;
            numberOfEntries++;
            return true;
        }
        else {
            genre_array[numberOfEntries] = newEntry;
            numberOfEntries ++;
        }
        return true ;
    }

    @Override
    public void resize(int newCapacity)
    {
        if (myCapacity > newCapacity)
        {
            return;
        }
        else
        {
            genre_array = Arrays.copyOf(genre_array, newCapacity);
            myCapacity = newCapacity;
        }
    }

    @Override
    public int getCapacity() {
        return myCapacity;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    public boolean remove(ItemType anItem) {
        int k = 0;
        while (k < numberOfEntries)
        {
            if (genre_array[k].equals(anItem))
            {
                genre_array[k] = genre_array[numberOfEntries-1];
                genre_array[numberOfEntries-1] = null;
                numberOfEntries--;
                return true;

            }
            k++;
        }
        return false;

    }

    @Override
    public void clear() {
        for (int index = 0; index < numberOfEntries; index++)
            genre_array[index] = null;
        numberOfEntries = 0;

    }

    @Override
    public int getFrequencyOf(ItemType anItem) {

        int counter = 0;
        for (int index = 0; index < numberOfEntries; index++)
        {
            if (genre_array[index].equals(anItem))
            {
                counter++;
            }
        }
        return counter;
    };

    @Override
    public boolean contains(ItemType anItem) {
        if (isEmpty()) return false;
        else{
            int item_index= 0;
            while ( item_index < numberOfEntries){
                if (genre_array[item_index] == anItem)
                    return true ;
                    item_index ++ ;
            }
        }
        return false;
    }


    @Override
    public boolean isFull() {
        return numberOfEntries == myCapacity;
    }



}
