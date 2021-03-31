class OrdArray {
    private long[] a;
    private int nElems;

    public OrdArray(int max) {
        a = new long[max];
        nElems = 0;
    }

    public int size() {
        return nElems;
    }

    public int find(long searchKey) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;

        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (a[curIn] == searchKey)
                return curIn;
            else if(lowerBound > upperBound)
                return nElems;
            else {
                if(a[curIn] < searchKey)
                    lowerBound = curIn + 1;
                else
                    upperBound = curIn - 1;
            }
        }
    }
    // Решение задачи вставки элемента в сортированный массив с помощью двоичного поиска
    //-----------------------------------------------------------
    public void insert(long value) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;

        while (true) {
            curIn = (lowerBound + upperBound) / 2;

            if (lowerBound > upperBound)
                break;
            else {
                if(a[curIn] < value)
                    lowerBound = curIn + 1;
                else
                    upperBound = curIn - 1;
            }
        }

        for(int k = nElems; k > lowerBound; k--)
            a[k] = a[k - 1];

        a[lowerBound] = value;
        nElems++;
    }
    //-----------------------------------------------------------

    public boolean delete(long value) {
        int j = find(value);
        if(j == nElems)
            return false;
        else {
            for(int k = j; k < nElems; k++)
                a[k] = a[k + 1];
            nElems--;
            return true;
        }
    }

    public void display() {
        for(int j = 0; j < nElems; j++)
            System.out.print(a[j] + " ");
        System.out.println("");
    }
}

class OrderedApp {
    public static void main(String[] args) {
        int maxSize = 100;
        OrdArray arr;
        arr = new OrdArray(maxSize);

        arr.insert(11);
        arr.insert(33);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(00);
        arr.insert(50);
        arr.insert(102);
        arr.insert(10);

        int searchKey = 51;
        if(arr.find(searchKey) != arr.size())
            System.out.println("Found " + searchKey);
        else
            System.out.println("Can't find " + searchKey);

        arr.delete(22);

        arr.display();
    }
}