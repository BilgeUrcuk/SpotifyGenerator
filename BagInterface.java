public interface BagInterface<ItemType> {
    public int getCurrentSize();
    public boolean add(ItemType newEntry);
    public boolean isFull();
    public void resize(int newCapacity);
    public int getCapacity();
    public boolean isEmpty();
    public boolean remove(ItemType anItem);
    public void clear();
    public int getFrequencyOf(ItemType anItem);
    public boolean contains(ItemType anItem);

}
